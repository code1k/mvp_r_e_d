package com.zb.mvprrd.retrofitdemo;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：MoveApi.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-22 16:49
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/

//                                           https://api.douban.com//v2/movie/top250
public interface MoveApi {
    @GET("/v2/movie/top250")
    Call<MovieBean> getTop(@Query("start") int start, @Query("count") int count);

    @Multipart
    @POST("http://test.leeonedu.com/Api/Lessons/Upload")
    Call<ResponseBody> uploadWay1(@Part("img") RequestBody part, @Part MultipartBody.Part body);

    @Multipart
    @POST("http://test.leeonedu.com/Api/Lessons/Upload")
    Call<ResponseBody> uploadWay2(@Part MultipartBody.Part body, @PartMap() Map<String, String> f);

    @POST("http://test.leeonedu.com/Api/Lessons/Upload")
    Call<ResponseBody> uploadWay3(@Body MultipartBody body);
}
