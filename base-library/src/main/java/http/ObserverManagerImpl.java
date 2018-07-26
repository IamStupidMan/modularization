package http;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.util.ArrayMap;

import io.reactivex.disposables.Disposable;

/**
 * RxJavaAction管理实现类
 */
public class ObserverManagerImpl implements ObserverManager<Object> {

    private static volatile ObserverManagerImpl mInstance;
    private ArrayMap<Object, Disposable> mMaps;//处理,请求列表

    public static ObserverManagerImpl getInstance() {
        if (mInstance == null) {
            synchronized (ObserverManagerImpl.class) {
                if (mInstance == null) {
                    mInstance = new ObserverManagerImpl();
                }
            }
        }
        return mInstance;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private ObserverManagerImpl() {
        mMaps = new ArrayMap<>();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void add(Object tag, Disposable disposable) {
        mMaps.put(tag, disposable);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void remove(Object tag) {
        if (!mMaps.isEmpty()) {
            mMaps.remove(tag);
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void cancel(Object tag) {
        if (mMaps.isEmpty()) {
            return;
        }
        if (mMaps.get(tag) == null) {
            return;
        }
        if (!mMaps.get(tag).isDisposed()) {
            mMaps.get(tag).dispose();
        }
        mMaps.remove(tag);
    }

    /**
     * 判断是否取消了请求
     *
     * @param tag
     * @return
     */
    public boolean isDisposed(Object tag) {
        if (mMaps.isEmpty() || mMaps.get(tag) == null) {
            return true;
        }
        return mMaps.get(tag).isDisposed();
    }
}
