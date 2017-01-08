package com.jsheng.fulltonormaldemo;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

public class Normal2Activity extends NormalBaseActivity {

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_normal2;
    }

    @Override
    protected void doSomethingAfter() {
        smoothSwitchScreenWithPadding();
    }

    private void smoothSwitchScreenWithPadding() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ViewGroup normalContent = ((ViewGroup) findViewById(R.id.normal_content));
            normalContent.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
            int statusBarHeight = getResources().getDimensionPixelSize(resourceId);
            normalContent.setPadding(0, statusBarHeight, 0, 0);
        }
    }

}
