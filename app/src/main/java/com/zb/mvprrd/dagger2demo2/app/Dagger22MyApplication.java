package com.zb.mvprrd.dagger2demo2.app;

import android.app.Application;

import com.zb.mvprrd.dagger2demo2.api.ApiModule;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：Dagger22MyApplication.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-27 16:45
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/

public class Dagger22MyApplication extends Application {
    private App2Component appComponent;
    private static Dagger22MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        appComponent = DaggerApp2Component.builder()
                .apiModule(new ApiModule()).build();
    }

    public App2Component getAppComponent() {
        return appComponent;
    }

    public static Dagger22MyApplication getApp() {
        return myApplication;
    }
}
