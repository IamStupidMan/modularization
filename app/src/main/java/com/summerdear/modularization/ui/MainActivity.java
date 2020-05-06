package com.summerdear.modularization.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.summerdear.modularization.R;


public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState, persistentState);

    }
    //@BindView(R.id.app_hello_tv)
//    TextView appHelloTv;
//    @BindView(R.id.radio1)
//    RadioButton radio1;
//    @BindView(R.id.radio2)
//    RadioButton radio2;
//    @BindView(R.id.radio3)
//    RadioButton radio3;
//    @BindView(R.id.checkbox)
//    CheckBox checkbox;


//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_main;
//    }
//
//    @Override
//    protected void initData(Bundle savedInstanceState, Intent intent) {
//    }

//    @Override
//    public void bindEvent() {
//
//    }

//    @Override
//    public void bindUI() {
//        setTitle("主APP的页面标题");
//    }

//    @OnClick(R.id.app_hello_tv)
//    public void onViewClicked(View v) {
//        switch (v.getId()) {
//            case R.id.app_hello_tv:
//                Intent intent = new Intent(this, LibActivity.class);
//                startActivity(intent);
//                break;
//        }
//    }
}
