package http.observer;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import base.BaseActivity;
import http.basemodel.BaseEntity;
import io.reactivex.disposables.Disposable;
import ui.fragment.LoadingDialogFragment;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : 带loading框的Observer
 * </pre>
 */
public class LoadingObserver<T> extends BaseObserver<T> {
    private Context mContext;
    private LoadingDialogFragment loading;

    public LoadingObserver(Context context, String mTag) {
        super(context, mTag);
        this.mContext = context;
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        getLoading().show(getFragmentManager(), getTag() + "_LoddingDialogFragment", false);
        super.onSubscribe(disposable);
    }

    private LoadingDialogFragment getLoading() {
        if (loading == null) {
            loading = (LoadingDialogFragment) getFragmentManager().findFragmentByTag(getTag() + "_LoddingDialogFragment");
            if (loading == null) {
                loading = LoadingDialogFragment.newInstance(mContext, getFragmentManager());
            }
        }
        return loading;
    }

    @Override
    public void onError(Throwable throwable) {
        dismiss();
        mContext = null;
        super.onError(throwable);
    }

    @Override
    public void onComplete() {
        mContext = null;
        dismiss();
        super.onComplete();
    }

    @Override
    public void onNext(BaseEntity<T> tBaseEntity) {
        dismiss();
        super.onNext(tBaseEntity);
        mContext = null;
    }

    private void dismiss() {
        if (getLoading().isShowing()) {
            getLoading().dismiss(false);
        }
    }

    private FragmentManager getFragmentManager() {
        if (mContext instanceof BaseActivity) {
            return ((BaseActivity) mContext).getSupportFragmentManager();
        } else {
            throw new ClassCastException("context is not activity:不要在view中显示进度条");
        }
    }
}
