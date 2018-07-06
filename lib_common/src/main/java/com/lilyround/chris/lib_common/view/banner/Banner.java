package com.lilyround.chris.lib_common.view.banner;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lilyround.chris.lib_common.R;
import com.lilyround.chris.lib_common.utils.DisplayUtil;
import com.lilyround.chris.lib_common.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


/*
 * Created by chris on 2018/7/5 14:23
 * 自动无限轮播的banner
 */
public class Banner extends RelativeLayout implements BannerAdapter.ViewPagerOnItemClickListener {

    private ViewPager mViewPager;
    private LinearLayout mLlPoint;
    //选中显示Indicator
    private int selectRes = R.drawable.shape_dots_select;
    //非选中显示Indicator
    private int unSelectRes = R.drawable.shape_dots_default;
    //设置默认自动轮播时间5s
    private int delayTime = 5;
    //当前选中的下标
    private int currentindex = 0;
    //图片数量
    private int imageSize;
    //是否停止轮播了
    private boolean isStopScroll;
    private CompositeSubscription compositeSubscription;

    public Banner(Context context) {
        this(context, null, 0);
    }

    public Banner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Banner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //1、inflate viewpager和小圆点
    //2、设置viewpager的数量
    //3、设置自动轮播的时间
    //4、触摸停止轮播，松手继续轮播
    //5、点击能跳转的回调，到最后一页之后能回到第一页


    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_banner, this, false);
        mViewPager = view.findViewById(R.id.vp_banner);
        mLlPoint = view.findViewById(R.id.ll_point);
    }

    public Banner setBannerData(List<BannerBean> bannerList) {
        if (bannerList.size() == 0) {
            this.setVisibility(GONE);
        } else {
            //判断是否清空 指示器点
            if (mLlPoint.getChildCount() != 0) {
                mLlPoint.removeAllViewsInLayout();
            }
            List<ImageView> imageList = new ArrayList<>();
            for (int i = 0; i < bannerList.size(); i++) {
                //初始化与图片对应个数的小圆点
                View dot = new View(getContext());
                dot.setBackgroundResource(unSelectRes);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        DisplayUtil.dp2px(getContext(), 5),
                        DisplayUtil.dp2px(getContext(), 5));
                params.leftMargin = 10;
                dot.setLayoutParams(params);
                dot.setEnabled(false);
                mLlPoint.addView(dot);
                //默认设置第一个选中
                mLlPoint.getChildAt(0).setBackgroundResource(selectRes);
                //初始化图片
                ImageView imageView = new ImageView(getContext());
                Glide.with(getContext())
                        .load(bannerList.get(i).getImageUrl())
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.im_default_loading)
                        .dontAnimate()
                        .into(imageView);
                imageList.add(imageView);
            }
            BannerAdapter adapter = new BannerAdapter(imageList);
            mViewPager.setAdapter(adapter);
            adapter.setmViewPagerOnItemClickListener(this);
        }

        return this;
    }


    //设置自动轮播时间
    public Banner setShufflingTime(int time) {
        this.delayTime = time;
        return this;
    }

    public void build() {
        //先清除之前的任务，重新开始
        clearSubscribe();
        //监听viewpager的状态，做对应的处理
        mViewPager.clearOnPageChangeListeners();
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentindex = position;
                position = position % imageSize;
                for (int i = 0; i < mLlPoint.getChildCount(); i++) {
                    mLlPoint.getChildAt(i).setBackgroundResource(unSelectRes);
                }
                mLlPoint.getChildAt(position).setBackgroundResource(selectRes);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_IDLE://手指没触碰状态
                        //如果停止轮播，则开始自动轮播
                        if (isStopScroll) {
                            startScroll();
                        }
                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING://状态被打断，即手指触摸了
                        //则停止轮播
                        stopScroll();
                        compositeSubscription.unsubscribe();
                        break;
                }
            }
        });

        //开启轮播
        startScroll();
    }


    //清除任务
    private void clearSubscribe() {
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
        }
    }

    private void stopScroll() {
        isStopScroll = true;
    }


    private void startScroll() {
        compositeSubscription = new CompositeSubscription();
        isStopScroll = false;
        //开启自动轮播
        Subscription subscription = Observable
                .timer(delayTime, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    if (isStopScroll) {
                        return;
                    }
                    isStopScroll = true;
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                });
        compositeSubscription.add(subscription);
    }

    @Override
    public void onItemClick() {
        ToastUtil.ShortToast(currentindex);
    }
}
