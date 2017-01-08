package com.jsheng.fulltonormaldemo;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

public class Normal1Activity extends NormalBaseActivity {

    @Override
    protected void doSomethingBefore() {
        smoothSwitchScreen();
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_normal1;
    }

    private void smoothSwitchScreen() {
        // 5.0以上修复了此bug, 但是有个Bug，状态的颜色为透明，会直接看到content背景色
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            ViewGroup rootView = ((ViewGroup) this.findViewById(android.R.id.content));
            rootView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
    }

}
