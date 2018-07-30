package base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.networklibrary.R;
import com.example.networklibrary.R2;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.BindView;
import butterknife.Unbinder;
import utils.StatusBarUtil;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : Activity的基类
 * </pre>
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    @BindView(R2.id.left_tv)
    TextView leftTv;
    @BindView(R2.id.left_iv)
    ImageView leftIv;
    @BindView(R2.id.left_container)
    RelativeLayout leftContainer;
    @BindView(R2.id.title_tv)
    TextView titleTv;
    @BindView(R2.id.sub_title_tv)
    TextView subTitleTv;
    @BindView(R2.id.right_tv)
    TextView rightTv;
    @BindView(R2.id.right_iv)
    ImageView rightIv;
    @BindView(R2.id.right_container)
    RelativeLayout rightContainer;
    @BindView(R2.id.base_title_rootview_rl)
    RelativeLayout baseTitleRootviewRl;
    @BindView(R2.id.content_view)
    FrameLayout contentView;
    @BindView(R2.id.base_root_ll)
    LinearLayout baseRootLl;


    private ViewGroup rootView;
    private Unbinder unbinder;
    private OnBackClickListener mBackListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StatusBarUtil.setTranslucentForImageViewInFragment(this, 255, null);
        //加载基础布局
        rootView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.base_layout, null);
        initTitleBar();

        if (getLayoutId() > 0) {
            //各个子activity的布局
            View customView = LayoutInflater.from(this).inflate(getLayoutId(), rootView, true);
            //将基础布局中的FrameLayout替换成各个子activity的布局
            FrameLayout frameLayout = rootView.findViewById(R.id.content_view);
            ViewGroup parent = (ViewGroup) frameLayout.getParent();
            if (null != parent) {
                parent.removeView(frameLayout);
            }
            frameLayout.addView(customView);
            //设置组合好的布局
            setContentView(frameLayout);
            //绑定UI
            bindUI(customView);
            //绑定事件
            bindEvent();
            useEventBus();
        }
        initData(savedInstanceState, getIntent());
        bindUI();
    }

    private void initTitleBar() {
        leftTv = rootView.findViewById(R.id.left_tv);
        leftIv = rootView.findViewById(R.id.left_iv);
        leftContainer = rootView.findViewById(R.id.left_container);
        titleTv = rootView.findViewById(R.id.title_tv);
        subTitleTv = rootView.findViewById(R.id.sub_title_tv);
        rightTv = rootView.findViewById(R.id.right_tv);
        rightIv = rootView.findViewById(R.id.right_iv);
        rightContainer = rootView.findViewById(R.id.right_container);
        baseTitleRootviewRl = rootView.findViewById(R.id.base_title_rootview_rl);
        leftIv.setOnClickListener(v -> {
            if (mBackListener == null) {
                this.finish();
            } else {
                mBackListener.onBack();
            }
        });
        leftTv.setOnClickListener(v -> {
            if (mBackListener == null) {
                this.finish();
            } else {
                mBackListener.onBack();
            }
        });
    }

    /**
     * 获取布局Id
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化数据
     *
     * @param savedInstanceState
     */
    protected abstract void initData(Bundle savedInstanceState, Intent intent);

    /**
     * 绑定事件
     */
    public abstract void bindEvent();

    /**
     * 初始化View
     */
    public abstract void bindUI();

    /**
     * 绑定View
     *
     * @param rootView
     */
    public void bindUI(View rootView) {
        unbinder = KnifeKit.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        KnifeKit.unbind(unbinder);

    }

    public boolean useEventBus() {
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getOptionsMenuId() > 0) {
            getMenuInflater().inflate(getOptionsMenuId(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public int getOptionsMenuId() {
        return 0;
    }

    //设置titleBar左边文字
    public void setLeftText(String text) {
        leftTv.setText(text);
    }

    //设置titleBar左边文字颜色
    public void setLeftTextColor(int color) {
        leftTv.setTextColor(color);
    }

    //设置titleBar左边文字是否可见
    public void setLeftTextVisiable(int visible) {
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
    public void setRightImageVisiable(int visible) {
        rightIv.setVisibility(visible);
    }

    //设置整个titleBar颜色
    public void setTitleBarColor(int color) {
        baseTitleRootviewRl.setBackgroundColor(color);
    }

    //设置整个titleBar背景资源
    public void setTitleBarRes(int resID) {
        baseTitleRootviewRl.setBackgroundResource(resID);
    }

    //设置整个titleBar是否可见
    public void setTitleBarVisible(int visible) {
        baseTitleRootviewRl.setVisibility(visible);
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
    public void setOnBackClickListener(OnBackClickListener listener) {
        this.mBackListener = listener;
    }

}
