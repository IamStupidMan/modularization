package ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.networklibrary.R;
import com.example.networklibrary.R2;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import glide.GlideLoader;
import glide.RequestOptionFactory;
import utils.LogUtils;

public class LibActivity extends BaseActivity {


    @BindView(R2.id.lib_hello_tv)
    TextView libHelloTv;
    @BindView(R2.id.lib_hello_tv1)
    TextView libHelloTv1;
    @BindView(R2.id.lib_hello_tv2)
    TextView libHelloTv2;
    @BindView(R2.id.iv_pic)
    ImageView ivPic;
    @BindView(R2.id.profile_image)
    ImageView profileImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib);
        ButterKnife.bind(this);

        GlideLoader.load(this, GlideLoader.URL, ivPic, RequestOptionFactory.CROP_TYPE_CIRCLE_CROP);
        GlideLoader.load(this, GlideLoader.URL, profileImage, RequestOptionFactory.CROP_TYPE_CIRCLE_CROP);
    }


    @OnClick({R2.id.lib_hello_tv, R2.id.lib_hello_tv1, R2.id.lib_hello_tv2})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.lib_hello_tv) {
            Toast.makeText(this, "lib_hello_tv", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.lib_hello_tv1) {
            Toast.makeText(this, "lib_hello_tv1", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.lib_hello_tv2) {
//            Toast.makeText(this,"lib_hello_tv2",Toast.LENGTH_SHORT).show();
            LogUtils.d("woshi a ");
        }

    }
}
