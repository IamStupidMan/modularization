package ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.networklibrary.R;
import com.example.networklibrary.R2;

import java.util.Map;

import base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;
import glide.GlideLoader;
import glide.RequestOptionFactory;
import http.Api;
import http.ApiException;
import http.HttpRequestMap;
import http.HttpUtils;
import http.LoadingObserver;
import model.FundDetailModel;
import utils.LogUtils;
import utils.ToastUtils;

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
    public int getLayoutId() {
        return R.layout.activity_lib;
    }

    @Override
    protected void initData(Bundle savedInstanceState, Intent intent) {
        Map<String, String> request = HttpRequestMap.getRequest();
        request.put("fundCode", "002068");
        HttpUtils.getData(Api.getApiService().fetchSingleFundBasic(request), new LoadingObserver<FundDetailModel>(this, "main") {
            @Override
            public void onFail(ApiException e) {
                ToastUtils.showShort("onFail");
                super.onFail(e);
            }

            @Override
            public void onSuccess(FundDetailModel fundDetailModel) {
                ToastUtils.showShort("onSuccess");
                libHelloTv.setText(fundDetailModel.toString());
                super.onSuccess(fundDetailModel);
            }
        });
    }

    @Override
    public void bindEvent() {

    }

    @Override
    public void bindUI() {
        GlideLoader.load(this, GlideLoader.URL, ivPic, RequestOptionFactory.CROP_TYPE_CIRCLE_CROP);
        GlideLoader.load(this, GlideLoader.URL, profileImage, RequestOptionFactory.CROP_TYPE_FIT_CENTER);

        setTitle("子Lib的页面标题");
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
