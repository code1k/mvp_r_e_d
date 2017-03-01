package com.zb.mvprrd.dagger2demo;

import javax.inject.Inject;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：UserModel.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-23 11:21
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/

public class UserModel {
    private String name;

    @Inject
    public UserModel() {
        this.name = "Hello Dagger2,I`m from Inject";
    }

//    @Inject
//    public UserModel(String name) {
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
