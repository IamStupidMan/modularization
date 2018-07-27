package http.interceptor;

import java.io.IOException;

import constant.AppConstants;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import utils.AppUtils;
import utils.SPUtils;

/**
 * 请求体添加参数
 */
public class AuthInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        HttpUrl newUrl = originalRequest.url().newBuilder()
                .scheme(originalRequest.url().scheme())
                .host(originalRequest.url().host())
                .addQueryParameter("token", SPUtils.getInstance().getString(AppConstants.Token))
                .addQueryParameter("app_version", AppUtils.getAppVersionName())
                .build();
        Request newRequest = originalRequest.newBuilder()
                .method(originalRequest.method(), originalRequest.body())
                .url(newUrl)
                .build();
        return chain.proceed(newRequest);
    }

}