package com.zb.mvprrd.mvpDemo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：MovieApi.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-24 09:59
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/

public interface MovieApi {
    @GET("https://api.douban.com//v2/movie/top250")
    Observable<MovieFullBean> getTop(@Query("start") int start, @Query("count") int count);
}
