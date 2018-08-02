package com.lilyround.chris.lib_common.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;


/*
 * Created by chris on 2018/7/12 10:55
 * 自定义圆形水波纹view
 */
public class CircleRippleView extends View {

    //绘制圆的画笔
    private Paint mCirclePaint;
    //绘制水波纹的画笔
    private Paint mRipplePaint;
    //绘制文字变化的画笔
    private Paint mTextPaint;
    //绘制的宽度
    private int mWidth;
    //绘制的高度
    private int mHeight;
    //画布
    private Canvas mCanvas;
    private Bitmap mBitmap;
    //贝塞尔曲线
    private Path mPath;
    //控制贝塞尔曲线x轴变化
    private int x;
    //控制贝塞尔曲线y轴变化
    private int y;
    //水波纹的百分比
    private int percent = 100;
    //判断控制点坐标是否大于终点或者小于起点的坐标
    private boolean isMax;
    //显示的文字,默认从30减少
    private String text = "30";
    //倒计时的总时间，默认3秒
    private int countdownTime = 3000;
    private PorterDuffXfermode mMode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    //倒计时的次数
    private int num;
    private Handler mHandler = new Handler();
    private final String TAG = this.getClass().getName();

    public CircleRippleView(Context context) {
        this(context, null);
    }

    public CircleRippleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleRippleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(Color.parseColor("#FFFF00"));

        mRipplePaint = new Paint();
        mRipplePaint.setStrokeWidth(10);
        mRipplePaint.setAntiAlias(true);
        mRipplePaint.setColor(Color.parseColor("#FF4081"));

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);

        mPath = new Path();

        //创建一个bitmap
        mBitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        //将bitmap放在画布上，draw的时候改变的就是bitmap
        mCanvas = new Canvas(mBitmap);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = width;
        }


        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = height;
        }

        y = mHeight;
        setMeasuredDimension(mWidth, mHeight);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //控制点坐标大于终点坐标
        if (x > 50) {
            isMax = true;
        } else if (x < 0) {//控制点坐标小于起点坐标
            isMax = false;
        }

        if (isMax) {
            x = x - 1;
        } else {
            x = x + 1;
        }

        //重置曲线
        mPath.reset();
        y = (int) ((1 - percent / 100f) * mHeight);

        //水波纹起始点的位置
        mPath.moveTo(0, 0);
        //绘制水波纹,有两个辅助点坐标，x和y
//        mPath.cubicTo(100 + x * 2, 50 + y, 100 + x * 2, y - 50, mWidth, y);
        mPath.cubicTo(100 + x * 2, 50 + y, 100 + x * 4, y - 50, mWidth, y);
//        mPath.quadTo(50+x*2,);
        mPath.lineTo(mWidth, mHeight);
        mPath.lineTo(0, mHeight);
        mPath.close();


        //清除掉图像 不然path会重叠
        mBitmap.eraseColor(Color.parseColor("#00000000"));

        //画圆
        mCanvas.drawCircle(mWidth / 2, mHeight / 2, mWidth / 2, mCirclePaint);

        mRipplePaint.setXfermode(mMode);
        mCanvas.drawPath(mPath, mRipplePaint);
        mRipplePaint.setXfermode(null);

        canvas.drawBitmap(mBitmap, 0, 0, null);


        //设置字体大小
        mTextPaint.setTextSize(60);
        float textLength = mTextPaint.measureText(text);
        canvas.drawText(text, mWidth / 2 - textLength / 2, mHeight / 2 + 15, mTextPaint);

        //延时绘制view
        postInvalidateDelayed(10);
    }

    public void startAnimator(){
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(this, "scaleX", 1f, 1.3f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(this, "scaleY", 1f, 1.3f, 1f);
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.play(scaleX).with(scaleY);
        animatorSet.start();
    }


    //开始倒计时
    public void startCountdown() {


        if (countdownTime > 0) {
            mHandler.postDelayed(() -> {
                //倒计时每次间隔30毫秒
                countdownTime = countdownTime - 30;
                Log.d(TAG, "countdownTime = " + countdownTime);
                percent -= 1;//百分比每次减一
                num += 1;
                Log.d(TAG, "percent = " + percent);
                Log.d(TAG, "num = " + num);
                text = String.valueOf(30 - num * 3 / 10);
                startCountdown();
            }, 30);
        }

//        //每隔0.03秒发射一次
//        Observable.interval(1000, TimeUnit.MILLISECONDS)
//                .take(countdownTime)
//                .map(new Func1<Long, Long>() {
//                    @Override
//                    public Long call(Long aLong) {
////                        倒计时的的剩余时间每次减少30毫秒
//                        return countdownTime - (aLong + 1);//单位为毫秒
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Long>() {
//                    @Override
//                    public void call(Long aLong) {
//                        //percent每次减少1
////                        percent = (int) (100 - aLong * 1000 / 30);
//                        percent = (int) (100 - (100 - aLong));
////                        text = String.valueOf(30 - aLong * 10);
//                        text = String.valueOf(30 - aLong);
//                    }
//                });
    }


    //重置水波纹为开始的位置
    public void reset() {
        percent = 100;
        countdownTime = 3000;
        num = 0;
        mHandler.removeCallbacksAndMessages(null);
    }
}
