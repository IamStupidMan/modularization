package http.api;


import com.example.networklibrary.BuildConfig;

import http.RetrofitFactory;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : Api provider
 * </pre>
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
