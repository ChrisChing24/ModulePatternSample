package com.lilyround.chris.module_cart;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import android.widget.TextView;

import com.lilyround.chris.lib_common.utils.DisplayUtil;

/**
 * 向上滑动显示顶部,向下滑动隐藏顶部view
 *
 * @author bluceshang
 */
public class FloatHeadListView extends ListView {
    private View floatView;//顶部筛选view
    private int mTouchSlop;
    private float mMotionY;
    private View mFlActivityFilter;//顶部活动显示的view，在筛选view和listView中间
    private boolean isShow = true;//筛选栏是否已经显示，显示了则不能再执行动画
    private boolean isAnimatorEnd;
    private View mViewRoot;
    public static final String TAG = FloatHeadListView.class.getSimpleName();


    public FloatHeadListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);

    }

    public FloatHeadListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatHeadListView(Context context) {
        this(context, null);
    }


    private void init(Context context) {
        mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();


    }

    /**
     * 設置浮動頂部控件.
     *
     * @param floatView
     * @param flActivityFilter
     */
    public void setFloatView(View floatView, View flActivityFilter) {
        this.floatView = floatView;
        this.mFlActivityFilter = flActivityFilter;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mMotionY = ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (mMotionY == 0) {
                    mMotionY = ev.getRawY();
                }
                float moveY = ev.getRawY() - mMotionY;
                if (Math.abs(moveY) > mTouchSlop) {
                    if (moveY > 0) {
                        showFloatView();

                    } else {
                        hideFloatView();
                    }
                }
//                mDirectProcesser.start(0,(int)moveY);
                mMotionY = ev.getRawY();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mMotionY = 0;
                break;
            default:
                break;
        }
        return super.onTouchEvent(ev);
    }

    private void hideFloatView() {
        if (floatView == null || mFlActivityFilter == null)
            return;
        if (floatView.getVisibility() == View.VISIBLE) {
            if (isCanAnim() && isShow) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(floatView,
                        "translationY",
                        0f, DisplayUtil.dp2px(getContext(), -floatView.getHeight()));
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        isAnimatorEnd = true;
                    }
                });
                animator.setDuration(300)
                        .start();

                if (mFlActivityFilter.getVisibility() == VISIBLE) {
//                    ObjectAnimator.ofFloat(mFlActivityFilter,
//                            "translationY",
//                            0f, 0f)
//                            .setDuration(300)
//                            .start();
                    ObjectAnimator.ofFloat(mFlActivityFilter,
                            "translationY",
                            0f, DisplayUtil.dp2px(getContext(), -mFlActivityFilter.getHeight()))
                            .setDuration(300)
                            .start();

                }


                isShow = false;
            }
//            Log.d(TAG, "getTop = " + getTop());
//            Log.d(TAG, "getVisibility = " + getVisibility());
//            mViewRoot.setVisibility(VISIBLE);
//            if (isAnimatorEnd) {
//                floatView.setVisibility(GONE);
//            }

        }
    }

    private void showFloatView() {
        if (floatView == null)
            return;

        if (isCanAnim() && !isShow) {

            floatView.setVisibility(VISIBLE);
            ObjectAnimator animator = ObjectAnimator.ofFloat(floatView,
                    "translationY",
                    DisplayUtil.dp2px(getContext(), -floatView.getHeight()), 0f);
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    isAnimatorEnd = true;
                }
            });
            animator.setDuration(300)
                    .start();

            if (mFlActivityFilter.getVisibility() == VISIBLE) {
//                ObjectAnimator.ofFloat(mFlActivityFilter,
//                        "translationY",
//                        0f, 0f)
//                        .setDuration(300)
//                        .start();
                ObjectAnimator.ofFloat(mFlActivityFilter,
                        "translationY",
                        DisplayUtil.dp2px(getContext(), -mFlActivityFilter.getHeight()), 0f)
                        .setDuration(300)
                        .start();
            }

            isShow = true;
        }


    }

    private boolean isCanAnim() {
        return true;
    }


    public void setFloatView(TextView tvFirst, TextView tvSecond, View emptyView) {
        this.floatView = tvFirst;
        this.mFlActivityFilter = tvSecond;
        this.mViewRoot = emptyView;


    }
}

