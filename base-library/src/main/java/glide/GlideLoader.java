package glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import base.BaseActivity;
import base.BaseFragment;

/**
 * Created by SummerDear on 2018/7/24.
 */

public class GlideLoader {


    public static final String URL = "https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=4a51c9cd7e8b4710d12ffbccf3ccc3b2/b64543a98226cffceee78e5eb5014a90f703ea09.jpg";
    public static final String TAG = "GlideLoader";

    /**
     * 使用默认的占位图
     *
     * @param activity  绑定生命周期的activity
     * @param url       加载的url
     * @param imageView ImageView容器
     * @param cropType  裁剪类型
     */
    public static void load(BaseActivity activity, String url, ImageView imageView, int cropType) {
        Glide.with(activity)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(RequestOptionFactory.getRequestOption(cropType))
                .into(imageView);

    }

    /**
     * 使用默认的占位图
     *
     * @param fragment  绑定生命周期的fragment
     * @param url       加载的url
     * @param imageView ImageView容器
     * @param cropType  裁剪类型
     */
    public static void load(BaseFragment fragment, String url, ImageView imageView, int cropType) {
        Glide.with(fragment)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(RequestOptionFactory.getRequestOption(cropType))
                .into(imageView);

    }

    /**
     * 清理内存缓存
     *
     * @param context 上下文
     */
    public static void clearMemoryCache(@NonNull Context context) {
        Glide.get(context).clearMemory();
    }

    /**
     * 清理磁盘缓存
     *
     * @param context 上下文
     */
    public static void clearDiskCache(@NonNull final Context context) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                /* This method must be called on a background thread. */
                Glide.get(context).clearDiskCache();
            }
        }).start();
    }
}
