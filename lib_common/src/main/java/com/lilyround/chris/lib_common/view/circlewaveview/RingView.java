package com.lilyround.chris.lib_common.view.circlewaveview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.lilyround.chris.lib_common.R;

/**
 * description：
 *
 * @author guo_hx
 * create date：2018/7/12 13:53
 */
public class RingView extends View {

    public static float CYCLE_RADIUS_OUT = 0;
    public static float CYCLE_RADIUS_IN = 0;

    private Paint mPaint;

    public RingView(Context context) {
        super(context);
        init();
    }

    public RingView(Context context,
            @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        CYCLE_RADIUS_OUT = dp2px(31.0f);
        CYCLE_RADIUS_IN = dp2px(21.0f);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(getResources().getColor(R.color.color_fc647c));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(CYCLE_RADIUS_OUT, CYCLE_RADIUS_OUT, CYCLE_RADIUS_OUT, mPaint);

        mPaint.setColor(getResources().getColor(R.color.color_ffffff));
        canvas.drawCircle(CYCLE_RADIUS_OUT, CYCLE_RADIUS_OUT, CYCLE_RADIUS_IN, mPaint);



        // 1
//        mPaint.setColor(getResources().getColor(R.color.colorPrimaryDark));
//        canvas.drawCircle(CYCLE_RADIUS_OUT, 0, 10, mPaint);
//
//        // 2
//        mPaint.setColor(getResources().getColor(R.color.colorPrimaryDark));
//        canvas.drawCircle(CYCLE_RADIUS_OUT, CYCLE_RADIUS_OUT * 2, 10, mPaint);
//
//        // 3
//        mPaint.setColor(getResources().getColor(R.color.colorPrimaryDark));
//        canvas.drawCircle(0, CYCLE_RADIUS_OUT, 10, mPaint);
//
//        // 4
//        mPaint.setColor(getResources().getColor(R.color.colorPrimaryDark));
//        canvas.drawCircle(CYCLE_RADIUS_OUT * 2, CYCLE_RADIUS_OUT, 10, mPaint);

        // 5
//        mPaint.setColor(getResources().getColor(R.color.colorPrimaryDark));
//        canvas.drawCircle(54, 54, 10, mPaint);
//
//        mPaint.setColor(getResources().getColor(R.color.colorPrimaryDark));
//        canvas.drawCircle(194, 54, 10, mPaint);
//
//        mPaint.setColor(getResources().getColor(R.color.colorPrimaryDark));
//        canvas.drawCircle(54, 194, 10, mPaint);
//
//        mPaint.setColor(getResources().getColor(R.color.colorPrimaryDark));
//        canvas.drawCircle(194, 194, 10, mPaint);

        mPaint.setColor(getResources().getColor(R.color.color_fc647c));
    }

    public int dp2px(final float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
