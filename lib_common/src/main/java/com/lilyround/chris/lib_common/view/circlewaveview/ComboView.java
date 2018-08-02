package com.lilyround.chris.lib_common.view.circlewaveview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lilyround.chris.lib_common.R;

/**
 * description：
 *
 * @author guo_hx
 * create date：2018/7/12 10:57
 */
public class ComboView extends RelativeLayout {

    public static final int ANIMATION_TIME = 500;

    public static int TIME_ALL = 30;

    private RingView mRingView;
    private BallView mBallView;
    private RelativeLayout mRlContainer;
    private WaveView mWaveView;
    private TextView mTvNumber;
    private AnimatorSet mAnimatorSet;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 2018) {
                if (TIME_ALL > 1) {
                    --TIME_ALL;
                    mHandler.sendEmptyMessageDelayed(2018, 100);
                    mTvNumber.setText(TIME_ALL + "");
                    mWaveView.setPresent(TIME_ALL * 100 / 30);
                } else {
                    TIME_ALL = 30;
                    setVisibility(GONE);
                }
                return true;
            }
            return false;
        }
    });
    private boolean mIsFirst = true;

    public ComboView(Context context) {
        super(context);
        init();
    }

    public ComboView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ComboView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_combo, null);

        mRingView = view.findViewById(R.id.ring_view);
        mBallView = view.findViewById(R.id.ball_view);
        mRlContainer = view.findViewById(R.id.rl_container);
        mWaveView = view.findViewById(R.id.wave_view);
        mTvNumber = view.findViewById(R.id.tv_number);

        addView(view);
    }

    public void sendRepeat() {

        if (getVisibility() == GONE) {
            mIsFirst = true;
        } else {
            mIsFirst = false;
        }
        setVisibility(VISIBLE);
        // ring
        ObjectAnimator scaleXRing = ObjectAnimator.ofFloat(mRingView, "scaleX", 1.0f, 1.8f, 1.0f,
                0.6f, 1.0f, 1.4f, 1.8f);
        scaleXRing.setDuration(ANIMATION_TIME);
        ObjectAnimator scaleYRing = ObjectAnimator.ofFloat(mRingView, "scaleY", 1.0f, 1.8f, 1.0f,
                0.6f, 1.0f, 1.4f, 1.8f);
        scaleYRing.setDuration(ANIMATION_TIME);
        ObjectAnimator alphaRing = ObjectAnimator.ofFloat(mRingView, "alpha", 1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 0.5f, 0.0f);
        alphaRing.setDuration(ANIMATION_TIME);

        // ball
        ObjectAnimator scaleXBall = null;
        ObjectAnimator scaleYBall = null;
        if (mIsFirst) {
            mBallView.setVisibility(VISIBLE);
//            ObjectAnimator.ofFloat(mBallView,"translationX",);
            scaleXBall = ObjectAnimator.ofFloat(mBallView, "scaleX", 1.0f, 1.5f, 1.0f,
                    1.8f, 2.6f);
            scaleXBall.setDuration(ANIMATION_TIME);
            scaleYBall = ObjectAnimator.ofFloat(mBallView, "scaleY", 1.0f, 1.5f, 1.0f,
                    1.8f, 2.6f);
            scaleYBall.setDuration(ANIMATION_TIME);
            mBallView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mBallView.setVisibility(GONE);
                }
            }, ANIMATION_TIME);
        }
//        ObjectAnimator alphaBall = ObjectAnimator.ofFloat(mBallView, "alpha", 1.0f, 1.0f, 1.0f,
//                1.0f, 0.0f);
//        alphaBall.setDuration(ANIMATION_TIME);

        // container
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mRlContainer, "scaleX", 1.0f, 1.8f, 1.0f,
                0.6f, 1.0f, 1.2f, 1.0f);
        scaleX.setDuration(ANIMATION_TIME);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mRlContainer, "scaleY", 1.0f, 1.8f, 1.0f,
                0.6f, 1.0f, 1.2f, 1.0f);
        scaleY.setDuration(ANIMATION_TIME);
        mAnimatorSet = new AnimatorSet();
        if (mIsFirst) {
            mAnimatorSet.playTogether(scaleX, scaleY, scaleXRing, scaleYRing, alphaRing, scaleXBall,
                    scaleYBall);
        } else {
            mAnimatorSet.playTogether(scaleX, scaleY, scaleXRing, scaleYRing, alphaRing);
        }

        mAnimatorSet.start();
        mHandler.removeCallbacksAndMessages(null);
        mTvNumber.setText("30");
        mWaveView.setPresent(100);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(2018);
                TIME_ALL = 30;
            }
        }, ANIMATION_TIME);
    }

    public void release() {
        mAnimatorSet.cancel();
        mHandler.removeCallbacksAndMessages(null);
    }

}
