package http;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;

import base.BaseActivity;
import ui.fragment.LoadingDialogFragment;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : 加载进度条
 * </pre>
 */

public class ProgressDialogHandler extends Handler {
    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private LoadingDialogFragment loadingDialogFragment;

    private Context mContext;

    public ProgressDialogHandler(Context context) {
        super();
        this.mContext = context;
    }

    private void initProgressDialog() {
        if (!getLoading().isShowing()) {
            getLoading().show(getFragmentManager(), "LoadingDialogFragment", false);
        }
    }

    /**
     * 初始化Loading
     *
     * @return
     */
    private LoadingDialogFragment getLoading() {
        if (loadingDialogFragment == null) {
            loadingDialogFragment = (LoadingDialogFragment) getFragmentManager().findFragmentByTag("LoadingDialogFragment");
            if (loadingDialogFragment == null) {
                loadingDialogFragment = LoadingDialogFragment.newInstance(mContext, getFragmentManager());
            }
        }
        return loadingDialogFragment;
    }


    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismiss();
                break;
        }
    }

    /**
     * 关闭Loading
     */
    private void dismiss() {
        if (getLoading().isShowing()) {
            getLoading().dismiss(false);
        }
    }

    private FragmentManager getFragmentManager() {
        if (mContext instanceof BaseActivity) {
            return ((BaseActivity) mContext).getSupportFragmentManager();
        } else {
            throw new ClassCastException("context is not activity");
        }
    }
}
