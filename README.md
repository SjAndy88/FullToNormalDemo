# FullToNormalDemo
AndroidDemo，全屏Activity跳到非全屏Activity


App一般都有一个启动界面，称为Splash界面。
一般这个界面都是做成全屏的，即隐藏掉系统状态栏，然后再跳转到主界面。
由于主界面是非全屏的，保留着状态栏，这个过程就发生了从全屏界面切换到非全屏界面。
但是在页面切换过程中，会出现先显示页面内容，然后由于状态栏的出现，整个界面下移一个状态栏高度的问题。

可参考 http://blog.csdn.net/u013011318/article/details/48296869
参考了博客的思路


Problem 是复现界面下移问题的

Normal0 使用了CoordinatorLayout+fitsSystemWindows(true)的方法，只支持21以上

Normal1 使用了FrameLayout+setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)+fitsSystemWindows(true)的方法，支持19以上

Normal2 使用了FrameLayout+setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)+setPadding(0, statusBarHeight, 0, 0)的方法，支持19以上

推荐使用Normal1的方法