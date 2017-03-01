package com.zb.mvprrd.dagger2demo2.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：RxPresenter.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-27 15:46
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/

public class RxPresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {
    protected T view;

    protected CompositeSubscription subscription;

    protected void unSubscribe() {
        subscription.unsubscribe();
    }

    protected void addSubscribe(Subscription s) {
        if (subscription == null) {
            subscription = new CompositeSubscription();
        }
        subscription.add(s);
    }

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }
}
