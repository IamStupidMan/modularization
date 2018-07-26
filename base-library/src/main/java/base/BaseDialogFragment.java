package base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.trello.rxlifecycle2.components.support.RxDialogFragment;

import butterknife.Unbinder;

/**
 * dialogfragment的基类
 */
public abstract class BaseDialogFragment extends RxDialogFragment {


    private Unbinder unbinder;
    protected View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //配置dialog
        if (isFullScreen()) {
            final Window window = getDialog().getWindow();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0 全透明实现
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            } else {//4.4 全透明状态栏
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//注意此处
            //各个子Fragment的布局
            view = inflater.inflate(getLayoutId(), null);
            //绑定UI
            bindUI(view);
            //绑定事件
            bindEvent();
            window.setLayout(-1, -2);//这2行,和上面的一样,注意顺序就行;
        } else {
            //各个子Fragment的布局
            view = inflater.inflate(getLayoutId(), null);
            //绑定UI
            bindUI(view);
            //绑定事件
            bindEvent();
        }
        return view;
    }

    /**
     * 设置是否全屏
     */
    protected abstract boolean isFullScreen();

    /**
     * 获取布局ID
     *
     * @return
     */
    protected abstract int getLayoutId();


    public void bindUI(View rootView) {
        unbinder = KnifeKit.bind(this, rootView);
        bindUI();
    }


    /**
     * 绑定UI
     */
    public abstract void bindUI();

    /**
     * 绑定事件
     */
    public abstract void bindEvent();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public Context getContext() {
        return view.getContext();
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            onCurrentAttach(context);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            onCurrentAttach(activity);
        }
    }

    /**
     * 重写此方法替代onAttach()高低版本不兼容
     *
     * @param mContext
     */
    protected void onCurrentAttach(Context mContext) {

    }

    /**
     * 判断弹窗是否显示
     *
     * @return
     */
    public boolean isShowing() {
        return getDialog() != null && getDialog().isShowing();
    }

    /**
     * 显示DialogFragment(注此方法会衍生出状态值问题(本人在正常使用时并未出现过))
     *
     * @param manager
     * @param tag
     * @param isResume 在Fragment中使用可直接传入isResumed()
     *                 在FragmentActivity中使用可自定义全局变量 boolean isResumed 在onResume()和onPause()中分别传人判断为true和false
     */
    public void show(FragmentManager manager, String tag, boolean isResume) {
        if (!isShowing()) {
            if (isResume) {
                //正常显示
                if (!isAdded()) {
                    show(manager, tag);
                } else {
                    FragmentTransaction ft = manager.beginTransaction();
                    ft.show(this);
                    ft.commit();
                }
            } else {
                //注 此方法会衍生出一些状态问题,慎用（在原代码中 需要设置  mDismissed = false 和 mShownByMe = true 并未在此引用到,如果需要用到相关判断值,此方法不可用）
                FragmentTransaction ft = manager.beginTransaction();
                if (!isAdded()) {
                    ft.add(this, tag);
                } else {
                    ft.show(this);
                }
                ft.commitAllowingStateLoss();
            }
        }
    }

    /**
     * 显示DialogFragment(注此方法会衍生出状态值问题(本人在正常使用时并未出现过))
     *
     * @param manager
     * @param tag
     */
    public void show(FragmentManager manager, String tag) {
        if (!isShowing()) {
            //正常显示
            if (!isAdded()) {
                super.show(manager, tag);
            } else {
                FragmentTransaction ft = manager.beginTransaction();
                ft.show(this);
                ft.commit();
            }
        }
    }

    /**
     * 关闭DialogFragment
     *
     * @param isResume 在Fragment中使用可直接传入isResumed()
     *                 在FragmentActivity中使用可自定义全局变量 boolean isResumed 在onResume()和onPause()中分别传人判断为true和false
     */
    public void dismiss(boolean isResume) {
        if (isResume) {
            dismiss();
        } else {
            dismissAllowingStateLoss();
        }
    }

    @Override
    public void dismiss() {
        if (isShowing()) {
            super.dismiss();
        }
    }

    @Override
    public void dismissAllowingStateLoss() {
        if (isShowing()) {
            super.dismissAllowingStateLoss();
        }
    }
}
