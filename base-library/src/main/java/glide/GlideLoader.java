package glide;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import base.BaseActivity;
import base.BaseFragment;

/**
 * Created by SummerDear on 2018/7/24.
 */

public class GlideLoader<A extends BaseActivity, F extends BaseFragment> {


    public static final String URL = "https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=4a51c9cd7e8b4710d12ffbccf3ccc3b2/b64543a98226cffceee78e5eb5014a90f703ea09.jpg";
    public static final String TAG = "GlideLoader";
    /**
     * 默认的placeHolder资源
     */
    public static final String DEFAULT_PLACE_HOLDER = "";
    /**
     * 默认的error资源
     */
    public static final String DEFAULT_ERROR = "";
    /**
     * 默认的fallBack资源
     */
    public static final String DEFAULT_FALL_BACK = "";

    public static void load(BaseActivity activity, String url, ImageView imageView, Drawable placeHolder,Drawable error,Drawable fallBack) {
        if(placeHolder == null){

        }
        if(error == null){

        }
        if(fallBack == null){

        }
        Glide.with(activity)
                .load(URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(RequestOptions.centerCropTransform())
                .into(imageView);
    }
}
