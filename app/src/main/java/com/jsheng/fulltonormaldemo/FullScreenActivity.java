package com.jsheng.fulltonormaldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import me.zhanghai.android.systemuihelper.SystemUiHelper;

public class FullScreenActivity extends AppCompatActivity {

    SystemUiHelper mSystemUiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        ButterKnife.bind(this);

        mSystemUiHelper = new SystemUiHelper(this,
                SystemUiHelper.LEVEL_IMMERSIVE, SystemUiHelper.FLAG_IMMERSIVE_STICKY);
        mSystemUiHelper.hide();

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                toNormalActivity(Normal0Activity.class);
//            }
//        }, 3000);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mSystemUiHelper.hide();
    }

    private void toNormalActivity(Class<?> targetActivity) {
        Intent intent = new Intent(FullScreenActivity.this, targetActivity);
        startActivity(intent);
    }

    @OnClick({R.id.btn0, R.id.btn1, R.id.btn2})
    public void onClick(View v) {
        Class<?> targetActivity = Normal0Activity.class;
        switch (v.getId()) {
            case R.id.btn0 :
                targetActivity = Normal0Activity.class;
                break;
            case R.id.btn1 :
                targetActivity = Normal1Activity.class;
                break;
            case R.id.btn2 :
                targetActivity = Normal2Activity.class;
                break;

        }
        toNormalActivity(targetActivity);
    }
}
