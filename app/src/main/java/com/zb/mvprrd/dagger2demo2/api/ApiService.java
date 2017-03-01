package com.zb.mvprrd.dagger2demo2.api;

import com.zb.mvprrd.dagger2demo2.bean.ApiResult;
import com.zb.mvprrd.dagger2demo2.bean.UserBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：ApiService.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-27 14:45
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/

public interface ApiService {
    @FormUrlEncoded
    @POST("/api/user/login")
    Observable<ApiResult<UserBean>> login(@Field("userName") String userName, @Field("password") String password, @Field("appType") String appType);
}
