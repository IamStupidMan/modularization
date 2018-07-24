package glide;

import com.bumptech.glide.annotation.GlideModule;

import java.lang.annotation.Annotation;

/**
 * Created by SummerDear on 2018/7/24.
 */

public class MyGlideModule implements GlideModule {
    @Override
    public String glideName() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
