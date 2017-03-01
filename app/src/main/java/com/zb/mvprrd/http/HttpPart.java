package com.zb.mvprrd.http;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：HttpPart.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2016-07-08 09:47
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/
public class HttpPart {
    private final String TAG = "HttpPart.class";
    protected String key, value;

    public HttpPart(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
