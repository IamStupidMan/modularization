package http;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : http结果处理函数
 * </pre>
 */
public class HttpResultFunction<T> implements Function<Throwable, Observable<T>> {
    @Override
    public Observable<T> apply(@NonNull Throwable throwable) throws Exception {
        //打印具体错误
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}
