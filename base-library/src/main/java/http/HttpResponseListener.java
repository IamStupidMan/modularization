package http;


import http.exception.ApiException;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : 响应接口
 * </pre>
 */
public interface HttpResponseListener<T> {
    /**
     * 网络请求失败
     *
     * @param e
     */
    void onFail(ApiException e);

    /**
     * 网络请求成功
     *
     * @param t
     */
    void onSuccess(T t);
}
