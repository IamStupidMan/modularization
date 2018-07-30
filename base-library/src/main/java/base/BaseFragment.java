package base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.networklibrary.R;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.Unbinder;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : Fragment的基类
 * </pre>
 */

public abstract class BaseFragment extends RxFragment {

    protected TextView leftTv;
    protected ImageView leftIv;
    protected RelativeLayout leftContainer;
    protected TextView titleTv;
    protected TextView subTitleTv;
    protected TextView rightTv;
    protected ImageView rightIv;
    protected RelativeLayout rightContainer;
    protected RelativeLayout baseTitleRootViewRl;

    protected Activity mContext;
    protected LayoutInflater layoutInflater;
    private ViewGroup rootView;
    private BaseActivity.OnBackClickListener mBackListener;

    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.mContext = (BaseActivity) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutInflater = inflater;

        //加载基础布局
        rootView = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.base_layout, null);
        initTitleBar();
        if (getLayoutId() > 0) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
            //各个子Fragment的布局
            View customView = LayoutInflater.from(mContext).inflate(getLayoutId(), null);
            //将基础布局中的FrameLayout中添加各个子Fragment的布局
            FrameLayout frameLayout = rootView.findViewById(R.id.content_view);
            frameLayout.addView(customView);
            //绑定UI
            bindUI(rootView);
            //绑定事件
            bindEvent();
            useEventBus();
        } else {
            ViewGroup viewGroup = (ViewGroup) rootView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(rootView);
            }
        }
        return rootView;
    }

    /**
     * 获取布局ID
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化titleBar
     */
    private void initTitleBar() {
        leftTv = rootView.findViewById(R.id.left_tv);
        leftIv = rootView.findViewById(R.id.left_iv);
        leftContainer = rootView.findViewById(R.id.left_container);
        titleTv = rootView.findViewById(R.id.title_tv);
        subTitleTv = rootView.findViewById(R.id.sub_title_tv);
        rightTv = rootView.findViewById(R.id.right_tv);
        rightIv = rootView.findViewById(R.id.right_iv);
        rightContainer = rootView.findViewById(R.id.right_container);
        baseTitleRootViewRl = rootView.findViewById(R.id.base_title_rootview_rl);
        leftIv.setOnClickListener(v -> {
            if (mBackListener == null) {
                mContext.finish();
            } else {
                mBackListener.onBack();
            }
        });
        leftTv.setOnClickListener(v -> {
            if (mBackListener == null) {
                mContext.finish();
            } else {
                mBackListener.onBack();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindEvent();
        bindUI();
        initData(savedInstanceState);
    }

    /**
     * 绑定数据
     *
     * @param savedInstanceState
     */
    protected abstract void initData(Bundle savedInstanceState);

    public void bindUI(View rootView) {
        unbinder = KnifeKit.bind(this, rootView);
    }


    public boolean useEventBus() {
        return true;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        KnifeKit.unbind(unbinder);
    }


    /**
     * 绑定UI
     */
    public abstract void bindUI();

    /**
     * 绑定事件
     */
    public abstract void bindEvent();

    //设置titleBar左边文字
    public void setLeftText(String text) {
        leftTv.setText(text);
    }

    //设置titleBar左边文字颜色
    public void setLeftTextColor(int color) {
        leftTv.setTextColor(color);
    }

    //设置titleBar左边文字是否可见
    public void setLeftTextVisible(int visible) {
        leftTv.setVisibility(visible);
    }

    //设置titleBar左边图片
    public void setLeftImageSrc(int resID) {
        leftIv.setImageResource(resID);
    }

    //设置titleBar左边图片是否可见
    public void setLeftImageVisible(int visible) {
        leftIv.setVisibility(visible);
    }

    //设置titleBar   title文字
    public void setTitle(String text) {
        titleTv.setText(text);
    }

    //设置titleBar   title文字颜色
    public void setTitleColor(int color) {
        titleTv.setTextColor(color);
    }

    //设置titleBar   subtitle文字
    public void setSubTitle(String text) {
        subTitleTv.setText(text);
    }

    //设置titleBar   subtitle文字颜色
    public void setSubTitleColor(int color) {
        subTitleTv.setTextColor(color);
    }

    //设置titleBar   subtitle文字是否可见
    public void setSubTitleVisible(int visible) {
        subTitleTv.setVisibility(visible);
    }

    //设置titleBar右边文字
    public void setRightText(String text) {
        rightTv.setText(text);
    }

    //设置titleBar右边文字颜色
    public void setRightTextColor(int color) {
        rightTv.setTextColor(color);
    }

    //设置titleBar右边文字是否可见
    public void setRightTextVisible(int visible) {
        rightTv.setVisibility(visible);
    }

    //设置titleBar右边图片
    public void setRightImageSrc(int resID) {
        rightIv.setImageResource(resID);
    }

    //设置titleBar右边图片是否可见
    public void setRightImageVisible(int visible) {
        rightIv.setVisibility(visible);
    }

    //设置整个titleBar颜色
    public void setTitleBarColor(int color) {
        baseTitleRootViewRl.setBackgroundColor(color);
    }

    //设置整个titleBar背景资源
    public void setTitleBarRes(int resID) {
        baseTitleRootViewRl.setBackgroundResource(resID);
    }

    //设置整个titleBar是否可见
    public void setTitleBarVisible(int visible) {
        baseTitleRootViewRl.setVisibility(visible);
    }

    /**
     * 返回按钮点击监听事件
     */
    public interface OnBackClickListener {
        void onBack();
    }

    /**
     * @param listener
     */
    public void setOnBackClickListener(BaseActivity.OnBackClickListener listener) {
        this.mBackListener = listener;
    }

}
