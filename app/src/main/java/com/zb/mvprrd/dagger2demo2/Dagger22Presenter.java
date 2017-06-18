package com.zb.mvprrd.dagger2demo2;

import com.zb.mvprrd.dagger2demo2.base.RxPresenter;
import com.zb.mvprrd.dagger2demo2.bean.ApiResult;
import com.zb.mvprrd.dagger2demo2.bean.UserBean;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：Dagger22Presenter.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-27 15:36
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/
public class Dagger22Presenter extends RxPresenter<Dagger22Contract.View> implements Dagger22Contract.Presenter<Dagger22Contract.View> {
    @Inject
    public Dagger22Presenter() {
    }

    @Override
    public void login(String userName, String pwd, String appType) {
        service.login(userName, pwd, appType)
                .observeOn(AndroidSchedulers.mainThread())//指定 subscribe() 事件发送发生在 IO 线程
                .subscribeOn(Schedulers.io())//指定 Subscriber 的回调处理发生在主线程
                .subscribe(new Observer<ApiResult<UserBean>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ApiResult<UserBean> userBeanApiResult) {
                        view.showUserInfo(userBeanApiResult.getT().toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
