package http;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : 处理Rx线程
 * </pre>
 */
class RxSchedulersHelper {

    static <T> ObservableTransformer<T, T> io_main() {
        return upstream -> upstream .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}