package com.lilyround.chris.module_home.api;


import com.lilyround.chris.module_home.bean.HomeBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/*
 * Created by chris on 2018/7/5 13:27
 *
 */
public interface HomeService {

    @FormUrlEncoded
    @POST("products/category/getsecondcategorybysymptom")
    Observable<HomeBean> getHomeData(@Field("platId") String id,
                                     @Field("province") String provinceId);
}
