package me.dkzwm.widget.srl.sample.widget;

import android.content.Context;
import android.util.AttributeSet;

import me.dkzwm.widget.srl.MaterialSmoothRefreshLayout;

public class SyncScrollingRefreshLayout extends MaterialSmoothRefreshLayout {
    public SyncScrollingRefreshLayout(Context context) {
        super(context);
    }

    public SyncScrollingRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SyncScrollingRefreshLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void moveHeaderPos(float delta) {
        super.moveHeaderPos(delta);
        if (delta < 0) {
            compatLoadMoreScroll(getScrollTargetView(), delta);
        }
    }
}