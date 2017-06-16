package com.zb.mvprrd.dagger2demo2;

import com.zb.mvprrd.dagger2demo2.base.RxPresenter;
import com.zb.mvprrd.dagger2demo2.bean.ApiResult;
import com.zb.mvprrd.dagger2demo2.bean.UserBean;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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
        addSubscribe(service.login(userName, pwd, appType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ApiResult<UserBean>>() {
                    @Override
                    public void call(ApiResult<UserBean> userBeanApiResult) {
                        view.showUserInfo(userBeanApiResult.getT().toString());
                    }
                }));
    }
}
