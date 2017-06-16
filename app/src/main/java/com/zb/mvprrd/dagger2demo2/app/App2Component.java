package com.zb.mvprrd.dagger2demo2.app;

import com.zb.mvprrd.dagger2demo2.Dagger22Activity;
import com.zb.mvprrd.dagger2demo2.api.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：App2Component.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-27 16:41
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/

@Singleton
@Component(modules = {ApiModule.class})
public interface App2Component {
    Dagger22Activity inject(Dagger22Activity dagger22Activity);
}
