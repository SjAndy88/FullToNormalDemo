package com.jsheng.fulltonormaldemo;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

public class Normal1Activity extends NormalBaseActivity {

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_normal_framelayout;
    }

    @Override
    protected void doSomethingAfter() {
        smoothSwitchToNormal();
    }

    private void smoothSwitchToNormal() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ViewGroup normalContent = ((ViewGroup) findViewById(R.id.normal_content));
            normalContent.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            normalContent.setFitsSystemWindows(true);
        }
    }

}
