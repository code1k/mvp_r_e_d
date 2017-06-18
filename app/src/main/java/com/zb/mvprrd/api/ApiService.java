package com.zb.mvprrd.api;

import com.zb.mvprrd.xiaomi.XiaoMi;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*************************************************************************************************
 * 文件名称：ApiService.java<br>
 * 内容摘要：<br>
 * 当前版本：V1.0<br>
 * 作   者： 翟彬<br>
 * 完成日期：2017-06-16 23:44<br>
 * 修改记录：<br>
 * 修改日期：<br>
 * 版本号：<br>
 * 修改人：<br>
 * 修改内容：<br>
 ************************************************************************************************/

public interface ApiService {
    @FormUrlEncoded
    @POST("http://hm.xiaomi.com/v1/data/band_data.json")
    @Headers({
            "appplatform:android_phone",
            "country:CN",
            "cv:3154_2.4.2",
            "appname:com.xiaomi.hm.health",
            "lang:zh_CN",
            "apptoken:TQVBQFJyQktGHlp6QkpbRl5LRl5qek4uXAQABAAAAAItF4d-5q_ia7ygJFfQErw-3Emh2qdt-JHDZSrRlcPhf_ynWSL_MLX5DtBsRxVKrkzmsEJg6dJw18BHqKYy9fqxDZGntjne9_K_6DE2fg4RJcJw0QhDFFWXFR73-qI-Cxt6rRtAc7oVD2B4BR9PuxWMLm5yLqIg0tQk5KS5GifybTSAy5OoRm0di1DgXwQ0PuIzT3WJgd3ZL_Kcop4qWDXc",
            "channel:Normal",
            "timezone:Asia/Shanghai",
            "Content-Type:application/x-www-form-urlencoded",
    })
    Observable<XiaoMi> xiaomi(@Query("r") String r, @Query("t") String t, @FieldMap HashMap<String,String> data);
}
