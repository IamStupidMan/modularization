/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package http.interceptor;

import android.text.TextUtils;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;
import utils.LogUtils;


/**
 * An OkHttp interceptor which logs request and response information. Can be applied as an
 * {@linkplain OkHttpClient#interceptors() application interceptor} or as a {@linkplain
 * OkHttpClient#networkInterceptors() network interceptor}. <p> The format of the logs created by
 * this class should not be considered stable and may change slightly between releases. If you need
 * a stable logging format, use your own interceptor.
 */
public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    public enum Level {
        /**
         * No logs.
         */
        NONE,
        /**
         * Logs request and response lines.
         * <p>
         * <p>Example:
         * <pre>{@code
         * --> POST /greeting http/1.1 (3-byte body)
         *
         * <-- 200 OK (22ms, 6-byte body)
         * }</pre>
         */
        BASIC,
        /**
         * Logs request and response lines and their respective headers.
         * <p>
         * <p>Example:
         * <pre>{@code
         * --> POST /greeting http/1.1
         * Host: example.com
         * Content-Type: plain/text
         * Content-Length: 3
         * --> END POST
         *
         * <-- 200 OK (22ms)
         * Content-Type: plain/text
         * Content-Length: 6
         * <-- END HTTP
         * }</pre>
         */
        HEADERS,
        /**
         * Logs request and response lines and their respective headers and bodies (if present).
         * <p>
         * <p>Example:
         * <pre>{@code
         * --> POST /greeting http/1.1
         * Host: example.com
         * Content-Type: plain/text
         * Content-Length: 3
         *
         * Hi?
         * --> END GET
         *
         * <-- 200 OK (22ms)
         * Content-Type: plain/text
         * Content-Length: 6
         *
         * Hello!
         * <-- END HTTP
         * }</pre>
         */
        BODY
    }

    public interface Logger {
        void log(String message);

        /**
         * A {@link Logger} defaults output appropriate for the current platform.
         */
        Logger DEFAULT = new Logger() {
            @Override
            public synchronized void log(String message) {
                if (!TextUtils.isEmpty(message)) {
                    LogUtils.d(message);
                }
            }
        };
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.logger = logger;
    }

    private final Logger logger;

    private volatile Level level = Level.NONE;

    /**
     * Change the level at which this interceptor logs.
     */
    public HttpLoggingInterceptor setLevel(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.level = level;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();  //获取request
        Response response;
        long t1 = System.nanoTime();
        response = chain.proceed(request); //OkHttp链式调用
        boolean isHeaders = getLevel() == Level.HEADERS || getLevel() == Level.BODY;
        boolean isBody = getLevel() == Level.BODY;
//        LogUtils.e("url地址--->"+request.url());
        if (getLevel() != Level.NONE) {
            try {
                long t2 = System.nanoTime();
                double time = (t2 - t1) / 1e6d;   //用请求后的时间减去请求前的时间得到耗时
                BufferedSource source = response.body().source();
                source.request(Long.MAX_VALUE); // Buffer the entire body.
                StringBuilder logStr = new StringBuilder();
                logStr.append("请求方式---->").append(request.method())
                        .append("\n响应码---->").append(response.code() + "")
                        .append("\nurl地址--->").append(request.url() + "")
                        .append("\n请求耗时--->").append(time + "");

                if (isHeaders) {
                    logStr.append("\n请求头---->");
                    Headers headers = request.headers();
                    for (int i = 0, count = headers.size(); i < count; i++) {
                        String name = headers.name(i);
                        // Skip headers from the request body as they are explicitly logged above.
                        if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                            logStr.append("{" + name + ": " + headers.value(i) + "}\n");
                        }
                    }
                }
//                if (isBody) {
//                    logStr.append("\n请求体---->\n");
////                    ResponseBody responseBody = response.body();//获取完body之后，必须重新获取response
////                   String responseStr = responseBody.string();
////                    response = chain.proceed(request); //OkHttp链式调用
////                    if (TextUtils.isEmpty(responseStr)) {
////                        logStr.append("返回数据为null");
////                    } else {
////                        logStr.append(JsonFormatUtils.formatJson(responseStr));
////                    }
//                }
                logger.log(logStr.toString());
            } catch (Exception e) {
                logger.log("http error" + e.getClass().toString());  //网络出错，log 出错的acid
                throw e; //不拦截exception，由上层处理网络错误
            }
        }
        return response;
    }

    /**
     * 请求体转String
     *
     * @param request
     * @return
     */
    private static String bodyToString(final RequestBody request) {

        try {
            final Buffer buffer = new Buffer();
            request.writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    /**
     * Returns true if the body in question probably contains human readable text. Uses a small sample
     * of code points to detect unicode control characters commonly used in binary file signatures.
     */
    static boolean isPlaintext(Buffer buffer) throws EOFException {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                if (Character.isISOControl(prefix.readUtf8CodePoint())) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false; // Truncated UTF-8 sequence.
        }
    }

    private boolean bodyHasUnknownEncoding(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return contentEncoding != null
                && !contentEncoding.equalsIgnoreCase("identity")
                && !contentEncoding.equalsIgnoreCase("gzip");
    }
}
