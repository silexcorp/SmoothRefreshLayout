package me.dkzwm.widget.srl;

import android.content.Context;
import android.util.AttributeSet;

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

    protected void notifyUIRefreshComplete(boolean useScroll, boolean notifyViews) {
        super.notifyUIRefreshComplete(false, notifyViews);
        if (useScroll) {
            if (mScrollChecker.isFlingBack()) {
                mScrollChecker.stop();
            }
            tryScrollBackToTopByPercentDuration();
        }
    }
}
