package http.observer;

import io.reactivex.disposables.Disposable;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : RxJavaAction管理接口
 * </pre>
 */

public interface ObserverManager<T> {
    /**
     * 添加
     *
     * @param tag
     * @param disposable
     */
    void add(T tag, Disposable disposable);

    /**
     * 移除
     *
     * @param tag
     */
    void remove(T tag);

    /**
     * 取消
     *
     * @param tag
     */
    void cancel(T tag);

}