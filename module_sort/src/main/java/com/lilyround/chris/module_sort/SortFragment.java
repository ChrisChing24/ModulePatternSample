package com.lilyround.chris.module_sort;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lilyround.chris.lib_common.base.RxLazyFragment;
import com.lilyround.chris.lib_common.view.banner.Banner;
import com.lilyround.chris.lib_common.view.banner.BannerBean;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/*
 * Created by chris on 2018/7/3 13:37
 * 分类fragment
 */
public class SortFragment extends RxLazyFragment {
    @Override
    public int getLayout() {
        return R.layout.fragment_sort;
    }

    @Override
    public void initViews(View view) {
        Banner banner = findId(R.id.banner);
        ImageView imageView = findId(R.id.iv);
        List<BannerBean> list = new ArrayList<>();
        BannerBean bannerBean = new BannerBean();
        bannerBean.setImageUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530871517168&di=6bb62f9b2812446cf3adef173653d3d8&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fd439b6003af33a87436092e0ca5c10385343b53f.jpg");
        list.add(bannerBean);
        BannerBean bannerBean1 = new BannerBean();
        bannerBean1.setImageUrl("https://ss3.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=45252389291f95cab9f594b6f9167fc5/72f082025aafa40f99d4e82aa764034f78f01932.jpg");
        list.add(bannerBean1);
        BannerBean bannerBean2 = new BannerBean();
        bannerBean2.setImageUrl("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=d31d7aca77f40ad10ae4c1e3672d1151/d439b6003af33a8730364de8ca5c10385243b5ed.jpg");
        list.add(bannerBean2);
        banner.setBannerData(list)
                .setShufflingTime(3)
                .build();

        Glide.with(getContext())
                .load("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=d31d7aca77f40ad10ae4c1e3672d1151/d439b6003af33a8730364de8ca5c10385243b5ed.jpg")
                .into(imageView);


    }

    @Override
    public void loadData() {
        BannerBean bannerBean = new BannerBean();
        bannerBean.setImageUrl("888.png");
        Gson gson = new Gson();
        String json = gson.toJson(bannerBean);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("imageUrl", "666.jpg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("toJson", "json = " + json);
        Log.d("toString", "jsonObject = " + jsonObject.toString());

        String str = "cartKey=f2a957195d73c5732a206222edac6dcb&encryptversion=2&timestamp=20180712100041" +
                "&os=android&venderId=2011102716210000&signmethod=md5&format=json&type=mobile" +
                "&channelName=yaowang_test&versionName=5.3.2&versionCode=549&screensize=540*960" +
                "&width=540&height=960";
        Bundle bundle = new Bundle();
        String[] keyValues = str.split("&");
        for (String keyValue : keyValues) {
            bundle.putString(keyValue.substring(0, keyValue.indexOf("=")),
                    keyValue.substring(keyValue.indexOf("=") + 1));
            Log.d("key", "key = " + keyValue.substring(0, keyValue.indexOf("=")));
            Log.d("value", "value = " + keyValue.substring(keyValue.indexOf("=") + 1));
        }

        JSONObject jsonObject2 = new JSONObject();
        Set<String> keySet = bundle.keySet();
        for (String key : keySet) {
            try {
                jsonObject2.put(key, bundle.get(key));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Log.d("json", "json = " + jsonObject2.toString());

    }

    public static SortFragment instance() {
        return new SortFragment();
    }
}
