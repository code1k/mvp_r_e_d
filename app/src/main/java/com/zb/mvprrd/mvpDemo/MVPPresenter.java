package com.zb.mvprrd.mvpDemo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：MVPPresenter.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-24 09:47
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/

public class MVPPresenter implements MVPActivityContract.MVPActivityPresenter {
    private MVPActivityContract.MVPActivityView view;

    @Override
    public void attachView(MVPActivityContract.MVPActivityView view) {
        this.view = view;
    }

    @Override
    public void getData() {
        new Retrofit.Builder()
                .baseUrl("https://api.douban.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
                .build().create(MovieApi.class)
                .getTop(0, 10)
                .subscribeOn(Schedulers.io())
                .serialize()
                .flatMap(new Func1<MovieFullBean, Observable<MovieFullBean.SubjectsBean>>() {
                    @Override
                    public Observable<MovieFullBean.SubjectsBean> call(MovieFullBean movieFullBean) {
                        return Observable.from(movieFullBean.getSubjects());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MovieFullBean.SubjectsBean>() {
                    @Override
                    public void call(MovieFullBean.SubjectsBean subjectsBean) {
                        view.upUI(subjectsBean.toString());
                    }
                });
    }
}
