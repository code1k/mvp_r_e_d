package com.zb.mvprrd.dagger2demo2;

import com.zb.mvprrd.dagger2demo2.base.BaseContract;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：Dagger22Contract.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-28 11:30
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/

public interface Dagger22Contract {
    interface View extends BaseContract.BaseView {
        void showUserInfo(String info);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void login(String userName, String pwd, String appType);
    }
}
