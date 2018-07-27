package http.interceptor;

import android.os.Build;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 请求头添加公共参数
 */
public class HeaderInterceptor implements Interceptor {

    private Map<String, String> mHeaders = new HashMap<>();

    public HeaderInterceptor() {
        mHeaders.put("User-Agent", "android");
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder request = chain.request().newBuilder();
        if (mHeaders != null && mHeaders.size() > 0) {
            Set<String> keys = mHeaders.keySet();
            for (String key : keys) {
                request.addHeader(key, mHeaders.get(key));
            }
        }
        if (Build.VERSION.SDK != null) {
            request.addHeader("Connection", "close");
        }
        return chain.proceed(request.build());
    }
}
