package http;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * 适用Retrofit网络请求Observable(被监听者)
 *
 * @author ZhongDaFeng
 */
public class HttpUtils {


    /**
     * 不绑定Actvity的生命周期
     *
     * @param observable
     * @param observer
     */
    public static void getData(Observable<?> observable, BaseObserver observer) {
        getObservable(observable).subscribe(observer);
    }

    /**
     * 默认在activity处于stop状态是解绑生命周期
     *
     * @param lifecycle
     * @param observable
     * @param observer
     */
    public static void getData(LifecycleProvider<ActivityEvent> lifecycle, Observable<?> observable, BaseObserver observer) {
        getObservable(observable, lifecycle).subscribe(observer);
    }

    /**
     * 自定义在activty的某一个生命周期解绑。
     *
     * @param lifecycle
     * @param observable
     * @param observer
     */
    public static void getData(LifecycleProvider<ActivityEvent> lifecycle, ActivityEvent event, Observable<?> observable, BaseObserver observer) {
        getObservable(observable, lifecycle, event)
                .subscribe(observer);
    }

    /**
     * 获取被监听者
     * 备注:网络请求Observable构建
     * data:网络请求参数
     * <h1>补充说明</h1>
     * 无管理生命周期,容易导致内存溢出
     *
     * @author ZhongDaFeng
     */
    public static Observable<?> getObservable(Observable<?> apiObservable) {
        Observable<?> observable = apiObservable
                .throttleFirst(1, TimeUnit.SECONDS)
                .onErrorResumeNext(new HttpResultFunction<>())
                .compose(RxSchedulersHelper.io_main());
        return observable;
    }

    /**
     * 获取被监听者
     * 备注:网络请求Observable构建
     * data:网络请求参数
     * <h1>补充说明</h1>
     * 传入LifecycleProvider自动管理生命周期,避免内存溢出
     * 备注:需要继承RxActivity.../RxFragment...
     *
     * @author ZhongDaFeng
     */
    public static Observable getObservable(Observable<?> apiObservable, LifecycleProvider lifecycle) {
        Observable observable;

        if (lifecycle != null) {
            //随生命周期自动管理.eg:onCreate(start)->onStop(end)
            observable = apiObservable
                    .throttleFirst(1, TimeUnit.SECONDS)
                    .compose(lifecycle.bindToLifecycle())//需要在这个位置添加
                    .onErrorResumeNext(new HttpResultFunction<>())
                    .compose(RxSchedulersHelper.io_main());
        } else {
            observable = getObservable(apiObservable);
        }
        return observable;
    }

    /**
     * 获取被监听者
     * 备注:网络请求Observable构建
     * data:网络请求参数
     * <h1>补充说明</h1>
     * 传入LifecycleProvider<ActivityEvent>手动管理生命周期,避免内存溢出
     * 备注:需要继承RxActivity,RxAppCompatActivity,RxFragmentActivity
     *
     * @author ZhongDaFeng
     */
    public static Observable getObservable(Observable<?> apiObservable, LifecycleProvider<ActivityEvent> lifecycle, ActivityEvent event) {
        // showLog(request);
        Observable observable;
        if (lifecycle != null) {
            //手动管理移除监听生命周期.eg:ActivityEvent.STOP
            observable = apiObservable
                    .throttleFirst(1, TimeUnit.SECONDS)
                    .compose(lifecycle.bindUntilEvent(event))//需要在这个位置添加
                    .onErrorResumeNext(new HttpResultFunction<>())
                    .compose(RxSchedulersHelper.io_main());
        } else {
            observable = getObservable(apiObservable);
        }
        return observable;
    }


    /**
     * 获取被监听者
     * 备注:网络请求Observable构建
     * data:网络请求参数
     * <h1>补充说明</h1>
     * 传入LifecycleProvider<FragmentEvent>手动管理生命周期,避免内存溢出
     * 备注:需要继承RxFragment,RxDialogFragment
     *
     * @author ZhongDaFeng
     */
    public static Observable getObservable(Observable<?> apiObservable, LifecycleProvider<FragmentEvent> lifecycle, FragmentEvent event) {
        Observable observable;
        if (lifecycle != null) {
            //手动管理移除监听生命周期.eg:FragmentEvent.STOP
            observable = apiObservable
                    .throttleFirst(1, TimeUnit.SECONDS)
                    .compose(lifecycle.bindUntilEvent(event))//需要在这个位置添加
                    .onErrorResumeNext(new HttpResultFunction<>())
                    .compose(RxSchedulersHelper.io_main());
        } else {
            observable = getObservable(apiObservable);
        }
        return observable;
    }

}
