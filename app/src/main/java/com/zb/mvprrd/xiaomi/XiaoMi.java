package com.zb.mvprrd.xiaomi;

import java.io.Serializable;

/*************************************************************************************************
 * 文件名称：XiaoMi.java<br>
 * 内容摘要：<br>
 * 当前版本：V1.0<br>
 * 作   者： 翟彬<br>
 * 完成日期：2017-06-17 00:29<br>
 * 修改记录：<br>
 * 修改日期：<br>
 * 版本号：<br>
 * 修改人：<br>
 * 修改内容：<br>
 ************************************************************************************************/

public class XiaoMi implements Serializable{

    private static final long serialVersionUID = 1160051265293272600L;
    /**
     * code : 1
     * message : success
     * correlation_id : 37C0821C-CCC0-D725-92D3-F28A8B76A237
     */

    private int code;
    private String message;
    private String correlation_id;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCorrelation_id() {
        return correlation_id;
    }

    public void setCorrelation_id(String correlation_id) {
        this.correlation_id = correlation_id;
    }

    @Override
    public String toString() {
        return "XiaoMi{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", correlation_id='" + correlation_id + '\'' +
                '}';
    }
}
