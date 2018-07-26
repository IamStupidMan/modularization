package http;

import android.content.Context;
import android.text.TextUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by SummerDear on 2018/7/26.
 */

public class BaseObserver<T> implements Observer<BaseEntity<T>>, HttpResponseListener {

    /**
     * 唯一标识
     */
    private String mTag;
    private Disposable mDisposable;
    private ProgressDialogHandler mProgressDialogHandler;

    public BaseObserver(Context context, String mTag) {
        this.mTag = mTag;
        mProgressDialogHandler = new ProgressDialogHandler(context);
    }

    public BaseObserver(Context context, String mTag, Boolean isShowLoading) {
        this.mTag = mTag;
        mProgressDialogHandler = new ProgressDialogHandler(context);
        if (isShowLoading) {
            showProgressDialog();
        }
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        this.mDisposable = disposable;
        addObserver();
    }

    @Override
    public void onNext(BaseEntity<T> tBaseEntity) {
        onSuccess(tBaseEntity.getData());
    }

    @Override
    public void onError(Throwable throwable) {
        removeObserver();
        ApiException e;
        if (throwable instanceof ApiException) {
            e = (ApiException) throwable;
        } else {
            e = new ApiException(throwable, 1);
        }
        //todo 错误处理
        onFail(e);
    }

    @Override
    public void onComplete() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    /**
     * 添加observer
     */
    private void addObserver() {
        if (!TextUtils.isEmpty(mTag)) {
            ObserverManagerImpl.getInstance().add(mTag, mDisposable);
        }
    }

    /**
     * 移除observer
     */
    private void removeObserver() {
        if (!TextUtils.isEmpty(mTag)) {
            ObserverManagerImpl.getInstance().remove(mTag);
        }
    }

    /**
     * 取消observer
     */
    private void cancelObserver() {
        if (!TextUtils.isEmpty(mTag)) {
            ObserverManagerImpl.getInstance().cancel(mTag);
        }
    }

    @Override
    public void onFail(ApiException e) {
        dismissProgressDialog();
    }

    @Override
    public void onSuccess(Object o) {
        onComplete();
    }

    /**
     * 网络请求tag
     *
     * @return
     */
    protected String getTag() {
        return mTag;
    }

    /**
     * 显示loading
     */
    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    /**
     * 关闭loading
     */
    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG)
                    .sendToTarget();
            mProgressDialogHandler = null;
        }
    }
}
