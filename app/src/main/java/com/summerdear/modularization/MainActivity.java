package com.summerdear.modularization;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.networklibrary.LibActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.app_hello_tv)
    TextView appHelloTv;
    @BindView(R.id.radio1)
    RadioButton radio1;
    @BindView(R.id.radio2)
    RadioButton radio2;
    @BindView(R.id.radio3)
    RadioButton radio3;
    @BindView(R.id.checkbox)
    CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }


    @Override
    @OnClick({R.id.app_hello_tv})
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.app_hello_tv:
                Intent intent = new Intent(this, LibActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
