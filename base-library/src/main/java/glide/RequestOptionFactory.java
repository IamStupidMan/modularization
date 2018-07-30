package glide;

import android.support.annotation.DrawableRes;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.networklibrary.R;

/**
 * <pre>
 *     author: Summer
 *     time  : 2018/06/13
 *     desc  : Glide初始化的RequestOptions工厂
 * </pre>
 */

public class RequestOptionFactory {

    public static final String TAG = "RequestOptionFactory";
    public static final int CROP_TYPE_CENTER_CROP = 0x11;
    public static final int CROP_TYPE_CENTER_INSIDE = 0x12;
    public static final int CROP_TYPE_CIRCLE_CROP = 0x13;
    public static final int CROP_TYPE_FIT_CENTER = 0x14;

    /**
     * 默认的placeHolder资源
     */
    private static final int DEFAULT_PLACE_HOLDER = R.mipmap.icon_loading;
    /**
     * 默认的error资源
     */
    private static final int DEFAULT_ERROR = R.mipmap.icon_load_fail;

    public static RequestOptions getRequestOption(@DrawableRes int placeHolderResId, @DrawableRes int errorResId, int cropType) {

        RequestOptions requestOptions = new RequestOptions();
        //裁剪方式
        switch (cropType) {
            case CROP_TYPE_CENTER_CROP:
            default:
                requestOptions.centerCrop();
                break;
            case CROP_TYPE_CENTER_INSIDE:
                requestOptions.centerInside();
                break;
            case CROP_TYPE_CIRCLE_CROP:
                requestOptions.circleCrop();
                break;
            case CROP_TYPE_FIT_CENTER:
                requestOptions.fitCenter();
                break;
        }

        return requestOptions
                .placeholder(placeHolderResId)
                .error(errorResId)
                .diskCacheStrategy(DiskCacheStrategy.ALL);

    }


    public static RequestOptions getRequestOption(int cropType) {

        RequestOptions requestOptions = new RequestOptions();
        //裁剪方式
        switch (cropType) {
            case 0x11:
            default:
                requestOptions.centerCrop();
                break;
            case 0x12:
                requestOptions.centerInside();
                break;
            case 0x13:
                requestOptions.circleCrop();
                break;
            case 0x14:
                requestOptions.fitCenter();
                break;
        }

        return requestOptions
                .placeholder(DEFAULT_PLACE_HOLDER)
                .error(DEFAULT_ERROR)
                .diskCacheStrategy(DiskCacheStrategy.ALL);

    }

}
