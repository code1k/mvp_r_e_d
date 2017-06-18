package com.zb.mvprrd.dagger2demo2.api;

import com.zb.mvprrd.Dagger22MyApplication;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：ApiModule.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-27 15:01
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/
@Module
public class ApiModule {
    @Provides
    public Dagger22MyApplication getApp() {
        return Dagger22MyApplication.getApp();
    }

    @Singleton
    @Provides
    public OkHttpClient providesOkhttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        return okHttpClient;
    }

    @Provides
    public ApiService prodivesApi() {
        return Api2.getInstance();
    }
}
