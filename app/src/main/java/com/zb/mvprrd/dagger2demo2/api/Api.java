package com.zb.mvprrd.dagger2demo2.api;

import com.zb.mvprrd.dagger2demo2.bean.ApiResult;
import com.zb.mvprrd.dagger2demo2.bean.UserBean;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：Api.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-27 14:27
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/
public class Api {
    private static Api api;
    private ApiService apiService;

    private Api(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl("http://test.leeonedu.com/")
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static synchronized Api getInstance(OkHttpClient okHttpClient) {
        if (api == null) {
            api = new Api(okHttpClient);
        }
        return api;
    }

    public Observable<ApiResult<UserBean>> login(String userName, String password, String appType) {
        return apiService.login(userName, password, appType);
    }

}
