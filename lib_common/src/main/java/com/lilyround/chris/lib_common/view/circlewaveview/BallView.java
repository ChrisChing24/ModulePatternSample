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
 * create date：2018/7/12 14:43
 */
public class BallView extends View {

    public static float CYCLE_RADIUS = 0;
    public static float CYCLE_RADIUS_BALL = 5;

    private Paint mPaint;

    public BallView(Context context) {
        super(context);
        init();
    }

    public BallView(Context context,
            @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public BallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        CYCLE_RADIUS = dp2px(31.0f);

        mPaint = new Paint();
//        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        // 1
//        mPaint.setColor(getResources().getColor(R.color.color_31A8FF));
//        canvas.drawCircle(CYCLE_RADIUS_OUT, 5, CYCLE_RADIUS_BALL, mPaint);
//
//        // 2
//        mPaint.setColor(getResources().getColor(R.color.color_FFD931));
//        canvas.drawCircle(CYCLE_RADIUS_OUT, CYCLE_RADIUS_OUT * 2, CYCLE_RADIUS_BALL, mPaint);
//
//        // 3
//        mPaint.setColor(getResources().getColor(R.color.color_FF3175));
//        canvas.drawCircle(0, CYCLE_RADIUS_OUT, CYCLE_RADIUS_BALL, mPaint);
//
//        // 4
//        mPaint.setColor(getResources().getColor(R.color.color_9024FF));
//        canvas.drawCircle(CYCLE_RADIUS_OUT * 2, CYCLE_RADIUS_OUT, CYCLE_RADIUS_BALL, mPaint);
//
//        // 5
//        mPaint.setColor(getResources().getColor(R.color.color_9024FF));
////        canvas.drawCircle(CYCLE_RADIUS_OUT * 0.293f, CYCLE_RADIUS_OUT * 0.293f, CYCLE_RADIUS_BALL, mPaint);
//        canvas.drawCircle(CYCLE_RADIUS_OUT * 0.32f, CYCLE_RADIUS_OUT * 0.32f, CYCLE_RADIUS_BALL, mPaint);
//
//        mPaint.setColor(getResources().getColor(R.color.color_FFD931));
////        canvas.drawCircle(CYCLE_RADIUS_OUT * 1.707f, CYCLE_RADIUS_OUT * 0.293f, CYCLE_RADIUS_BALL, mPaint);
//        canvas.drawCircle(CYCLE_RADIUS_OUT * 1.6f, CYCLE_RADIUS_OUT * 0.3f, CYCLE_RADIUS_BALL, mPaint);
//
//        mPaint.setColor(getResources().getColor(R.color.color_31A8FF));
////        canvas.drawCircle(CYCLE_RADIUS_OUT * 0.293f, CYCLE_RADIUS_OUT * 1.707f, CYCLE_RADIUS_BALL, mPaint);
//        canvas.drawCircle(CYCLE_RADIUS_OUT * 0.3f, CYCLE_RADIUS_OUT * 1.6f, CYCLE_RADIUS_BALL, mPaint);
//
//        mPaint.setColor(getResources().getColor(R.color.color_FF3175));
////        canvas.drawCircle(CYCLE_RADIUS_OUT * 1.707f, CYCLE_RADIUS_OUT * 1.707f, CYCLE_RADIUS_BALL, mPaint);
//        canvas.drawCircle(CYCLE_RADIUS_OUT * 1.6f, CYCLE_RADIUS_OUT * 1.6f, CYCLE_RADIUS_BALL, mPaint);

        // 1
        mPaint.setColor(getResources().getColor(R.color.color_31A8FF));
        canvas.drawCircle(CYCLE_RADIUS, 5, CYCLE_RADIUS_BALL, mPaint);

        // 2
        mPaint.setColor(getResources().getColor(R.color.color_FFD931));
        canvas.drawCircle(CYCLE_RADIUS, CYCLE_RADIUS * 1.7f, CYCLE_RADIUS_BALL, mPaint);

        // 3
        mPaint.setColor(getResources().getColor(R.color.color_FF3175));
        canvas.drawCircle(CYCLE_RADIUS * 0.3f, CYCLE_RADIUS, CYCLE_RADIUS_BALL, mPaint);

        // 4
        mPaint.setColor(getResources().getColor(R.color.color_9024FF));
        canvas.drawCircle(CYCLE_RADIUS * 2, CYCLE_RADIUS, CYCLE_RADIUS_BALL, mPaint);

        // 5
        mPaint.setColor(getResources().getColor(R.color.color_9024FF));
//        canvas.drawCircle(CYCLE_RADIUS_OUT * 0.293f, CYCLE_RADIUS_OUT * 0.293f, CYCLE_RADIUS_BALL, mPaint);
        canvas.drawCircle(CYCLE_RADIUS * 0.32f, CYCLE_RADIUS * 0.32f, CYCLE_RADIUS_BALL, mPaint);

        mPaint.setColor(getResources().getColor(R.color.color_FFD931));
//        canvas.drawCircle(CYCLE_RADIUS_OUT * 1.707f, CYCLE_RADIUS_OUT * 0.293f, CYCLE_RADIUS_BALL, mPaint);
        canvas.drawCircle(CYCLE_RADIUS * 1.6f, CYCLE_RADIUS * 0.3f, CYCLE_RADIUS_BALL, mPaint);

        mPaint.setColor(getResources().getColor(R.color.color_31A8FF));
//        canvas.drawCircle(CYCLE_RADIUS_OUT * 0.293f, CYCLE_RADIUS_OUT * 1.707f, CYCLE_RADIUS_BALL, mPaint);
        canvas.drawCircle(CYCLE_RADIUS * 0.3f, CYCLE_RADIUS * 1.6f, CYCLE_RADIUS_BALL, mPaint);

        mPaint.setColor(getResources().getColor(R.color.color_FF3175));
//        canvas.drawCircle(CYCLE_RADIUS_OUT * 1.707f, CYCLE_RADIUS_OUT * 1.707f, CYCLE_RADIUS_BALL, mPaint);
        canvas.drawCircle(CYCLE_RADIUS * 1.6f, CYCLE_RADIUS * 1.6f, CYCLE_RADIUS_BALL, mPaint);
    }

    public int dp2px(final float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
