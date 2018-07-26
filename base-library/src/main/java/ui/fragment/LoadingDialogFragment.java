package ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.networklibrary.R;
import com.example.networklibrary.R2;

import base.BaseDialogFragment;
import butterknife.BindView;

/**
 * 加载数据的DialogFragment
 */
public class LoadingDialogFragment extends BaseDialogFragment {
    private static final String PARAM_SHOW_MSG = "massage";
    @BindView(R2.id.iv_loading)
    ImageView mIvLoading;
    @BindView(R2.id.tv_desc)
    TextView mTvDesc;

    private String msg = "加载中...";
    private Animation animation;

    public static LoadingDialogFragment newInstance(String msg) {
        LoadingDialogFragment fragment = new LoadingDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_SHOW_MSG, msg);
        fragment.setArguments(bundle);
        return fragment;
    }

    public static LoadingDialogFragment newInstance(Context mContext, FragmentManager fm, String msg) {
        LoadingDialogFragment fragment = newInstance(mContext, fm);
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_SHOW_MSG, msg);
        fragment.setArguments(bundle);
        return fragment;
    }

    public static LoadingDialogFragment newInstance(Context mContext, FragmentManager fm) {
        String tag = LoadingDialogFragment.class.getName();
        Fragment fragment = fm.findFragmentByTag(tag);
        if (fragment == null) {
            fragment = Fragment.instantiate(mContext, tag);
            LoadingDialogFragment dialogFragment = (LoadingDialogFragment) fragment;
            return dialogFragment;
        } else {
            return (LoadingDialogFragment) fragment;
        }
    }

    @Override
    protected boolean isFullScreen() {
        return true;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_lodding_dialog;
    }


    @Override
    public void bindUI() {
        initAnimation();
        setStyle(R.style.login_dialog, R.style.Theme_AppCompat);
        if (getArguments() != null) {
            msg = getArguments().getString(PARAM_SHOW_MSG);
        } else {
            msg = "加载中...";
        }
        mIvLoading.startAnimation(animation);
    }

    private void initAnimation() {
        animation  = new RotateAnimation(0f, 359f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        LinearInterpolator lin = new LinearInterpolator();
        animation.setInterpolator(lin);
        animation.setStartTime(0);
        animation.setDuration(800);//设置动画持续时间
        animation.setRepeatCount(-1);//设置重复次数
        animation.setFillAfter(false);//动画执行完后是否停留在执行完的状态
        animation.setStartOffset(10);//执行前的等待时间
        mIvLoading.setAnimation(animation);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        if (animation != null) {
            animation.cancel();
            animation = null;
        }
        super.onDismiss(dialog);
    }


    @Override
    public void bindEvent() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
