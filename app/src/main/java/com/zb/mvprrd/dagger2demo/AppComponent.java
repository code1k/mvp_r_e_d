package com.zb.mvprrd.dagger2demo;

import dagger.Component;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：App2Component.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-23 11:29
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/

@Component
public interface AppComponent {
    void inject(Dagger2Activity dagger2Activity);
    final class Initializer {
        private Initializer() {
        }

        public static AppComponent init() {
            return DaggerAppComponent.create();
        }
    }
}
