package com.zb.mvprrd.dagger2demo2.base;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：BaseContract.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-27 15:42
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/

public interface BaseContract {
    public interface BaseView {
        void showError();

        void complete();
    }

    public interface BasePresenter<T> {
        void attachView(T view);

        void detachView();
    }
}
