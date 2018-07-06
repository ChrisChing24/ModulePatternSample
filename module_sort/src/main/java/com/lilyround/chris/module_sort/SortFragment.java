package com.lilyround.chris.module_sort;

import android.view.View;

import com.lilyround.chris.lib_common.base.RxLazyFragment;
import com.lilyround.chris.lib_common.view.banner.Banner;
import com.lilyround.chris.lib_common.view.banner.BannerBean;

import java.util.ArrayList;
import java.util.List;


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

    }

    @Override
    public void loadData() {

    }

    public static SortFragment instance() {
        return new SortFragment();
    }
}
