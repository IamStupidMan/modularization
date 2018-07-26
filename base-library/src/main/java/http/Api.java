package http;


import com.example.networklibrary.BuildConfig;

/**
 * Created by wanglei on 2016/12/31.
 */

public class Api {
    public static final String API_BASE_URL = BuildConfig.API_HOST;

    private static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService == null) {
            synchronized (Api.class) {
                if (apiService == null) {
                    apiService = RetrofitFactory.getInstance().getRetrofit(API_BASE_URL).create(ApiService.class);
                }
            }
        }
        return apiService;
    }
}
