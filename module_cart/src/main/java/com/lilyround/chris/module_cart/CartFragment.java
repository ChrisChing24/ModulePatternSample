package com.lilyround.chris.module_cart;

import android.view.View;
import android.widget.TextView;

import com.lilyround.chris.lib_common.base.RxLazyFragment;

import java.util.ArrayList;
import java.util.List;


/*
 * Created by chris on 2018/7/3 13:32
 * 购物车fragment
 */
public class CartFragment extends RxLazyFragment {


    private FloatHeadListView mListView;
    private TextView mTvFirst;
    private TextView mTvSecond;
    private View mEmptyView;

    @Override
    public int getLayout() {
        return R.layout.fragment_cart;
    }

    @Override
    public void initViews(View view) {
        mListView = findId(R.id.lv);
        mTvFirst = findId(R.id.tv_first);
        mTvSecond = findId(R.id.tv_second);
        mEmptyView = findId(R.id.view_empty);



//        ConstraintLayout clHeader2 = findId(R.id.header2);
//        tvFirst.setVisibility(View.GONE);
//        tvSecond.setVisibility(View.GONE);
//        Banner banner = new Banner(getContext());
//        View header2 = LayoutInflater.from(getContext()).inflate(R.layout.layout_header, null);
//
//        List<BannerBean> list = new ArrayList<>();
//        BannerBean bannerBean = new BannerBean();
//        bannerBean.setImageUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530871517168&di=6bb62f9b2812446cf3adef173653d3d8&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fd439b6003af33a87436092e0ca5c10385343b53f.jpg");
//        list.add(bannerBean);
//        BannerBean bannerBean1 = new BannerBean();
//        bannerBean1.setImageUrl("https://ss3.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=45252389291f95cab9f594b6f9167fc5/72f082025aafa40f99d4e82aa764034f78f01932.jpg");
//        list.add(bannerBean1);
//        BannerBean bannerBean2 = new BannerBean();
//        bannerBean2.setImageUrl("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=d31d7aca77f40ad10ae4c1e3672d1151/d439b6003af33a8730364de8ca5c10385243b5ed.jpg");
//        list.add(bannerBean2);
//        banner.setBannerData(list)
//                .setShufflingTime(3)
//                .build();
//        listView.addHeaderView(banner);
//        listView.addHeaderView(header2);

//        listView.setFloatView(banner, header2);


//        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                if (header2.getVisibility() == View.VISIBLE) {
//                    clHeader2.setVisibility(firstVisibleItem >= 1 ? View.VISIBLE : View.GONE);
//                }
//            }
//        });
    }


    @Override
    public void loadData() {
        mListView.setFloatView(mTvFirst, mTvSecond, mEmptyView);
        List<String> itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            itemList.add("item" + i);
        }
        TestAdapter adapter = new TestAdapter(getActivity(), itemList);
        mListView.setAdapter(adapter);
    }

    public static CartFragment instance() {
        return new CartFragment();
    }
}
