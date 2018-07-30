package http;

import com.example.networklibrary.BuildConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import http.convert.GsonConverterFactory;
import http.interceptor.AuthInterceptor;
import http.interceptor.HeaderInterceptor;
import http.interceptor.HttpLoggingInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import utils.StringUtils;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : RetrofitFactory
 * </pre>
 */

public class RetrofitFactory {

    private static RetrofitFactory instance;

    private Map<String, Retrofit> retrofitMap = new HashMap<>();
    private Map<String, OkHttpClient> clientMap = new HashMap<>();

    public static final long connectTimeoutMills = 10 * 1000L;
    public static final long readTimeoutMills = 10 * 1000L;
    public static final long writeTimeoutMills = 10 * 1000L;


    private RetrofitFactory() {

    }

    /**
     * 将接口转化为实例
     *
     * @param baseUrl 基础的域名
     * @param service 接口
     * @param <S>     泛型接口
     * @return 泛型实例对象
     */
    public static <S> S get(String baseUrl, Class<S> service) {
        return getInstance().getRetrofit(baseUrl).create(service);
    }

    /**
     * 单利模式提供该类实例对象
     *
     * @return RetrofitFactory
     */
    public static RetrofitFactory getInstance() {
        if (instance == null) {
            synchronized (RetrofitFactory.class) {
                if (instance == null) {
                    instance = new RetrofitFactory();
                }
            }
        }
        return instance;
    }

    /**
     * 获取Retrofit对象
     *
     * @param baseUrl 访问的基础域名
     * @return Retrofit对象
     */
    public Retrofit getRetrofit(String baseUrl) {
        if (StringUtils.isEmpty(baseUrl)) {
            throw new IllegalArgumentException("baseUrl can not be null");
        }

        if (retrofitMap.get(baseUrl) != null) {
            return retrofitMap.get(baseUrl);
        }

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpClient(baseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());


        Retrofit retrofit = builder.build();
        retrofitMap.put(baseUrl, retrofit);
        return retrofit;
    }


    /**
     * 获取OKHttpclient实例对象
     *
     * @param baseUrl 基础的域名
     * @return OKHttpclient实例对象
     */
    private OkHttpClient getOkHttpClient(String baseUrl) {
        if (StringUtils.isEmpty(baseUrl)) {
            throw new IllegalArgumentException("baseUrl can not be null");
        }

        if (clientMap.get(baseUrl) != null) {
            return clientMap.get(baseUrl);
        }

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(connectTimeoutMills, TimeUnit.MILLISECONDS);
        builder.readTimeout(readTimeoutMills, TimeUnit.MILLISECONDS);
        builder.writeTimeout(writeTimeoutMills, TimeUnit.MILLISECONDS);
        builder.retryOnConnectionFailure(false);
        builder.addInterceptor(new AuthInterceptor());
        builder.addInterceptor(new HeaderInterceptor());
        builder.addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE));
        OkHttpClient client = builder.build();
        clientMap.put(baseUrl, client);
        return client;
    }
}
