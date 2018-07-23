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

