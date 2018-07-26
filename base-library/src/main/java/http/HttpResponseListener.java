package http;


/**
 * 网络响应接口
 * Created by zhangxuehui on 2018/2/8.
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
