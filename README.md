# modularization

模块化项目
1.主模块--app

2.base模块--base-library
==1、utils下的工具类使用的是：https://github.com/Blankj/AndroidUtilCode框架代码
     后期可自己扩展
==2、helper下的工具类使用的是：https://github.com/Blankj/AndroidUtilCode框架代码
     后期可自己扩展
==3、圆形头像使用示例：
        <de.hdodenhof.circleimageview.CircleImageView
                 xmlns:app="http://schemas.android.com/apk/res-auto"
                 android:id="@+id/profile_image"
                 android:layout_width="96dp"
                 android:layout_height="96dp"
                 android:src="@drawable/profile"
                 app:civ_border_width="2dp"
                 app:civ_border_color="#FF000000"/>
==4、Glide工具类封装，使用示例：
        GlideLoader.load(this, GlideLoader.URL, profileImage, RequestOptionFactory.CROP_TYPE_CIRCLE_CROP);
==5、网络框架使用：Retrofit2.0+RxJava2.0+OkHttp3.0(后期还会加入Dagger2.0和生命周期绑定)

