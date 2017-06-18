package com.zb.mvprrd.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*************************************************************************************************
 * 文件名称：Api.java<br>
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

public class Api {
    private static ApiService apiService;

    public static ApiService getApiServer() {
        synchronized (Api.class) {
            if (apiService == null) {
                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .addInterceptor(
                                new HttpLoggingInterceptor()
                                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build();
                apiService = new Retrofit.Builder().client(okHttpClient)
                        .baseUrl("https://www.baidu.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build().create(ApiService.class);
            }
            return apiService;
        }
    }

}
