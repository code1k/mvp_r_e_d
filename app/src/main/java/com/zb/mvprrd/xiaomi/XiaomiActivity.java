package com.zb.mvprrd.xiaomi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.zb.mvprrd.R;
import com.zb.mvprrd.api.Api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/*************************************************************************************************
 * 文件名称：XiaomiActivity.java<br>
 * 内容摘要：<br>
 * 当前版本：V1.0<br>
 * 作   者： 翟彬<br>
 * 完成日期：2017-06-16 23:31<br>
 * 修改记录：<br>
 * 修改日期：<br>
 * 版本号：<br>
 * 修改人：<br>
 * 修改内容：<br>
 ************************************************************************************************/

public class XiaomiActivity extends AppCompatActivity {
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.bt_send)
    Button btSend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaomi);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_send)
    public void onViewClicked() {

        try {
            HashMap<String, String> data = new HashMap<>();
            data.put("last_source", "8");
            data.put("userid", "1018774902");
            data.put("last_sync_data_time", (new Date().getTime() / 1000 + "").split("\\.")[0]);
            data.put("appid", "2882303761517154077");
            data.put("callid", new Date().getTime() + "");
            data.put("channel", "Normal");
            data.put("country", "CN");
            data.put("cv", "3154_2.4.2");
            data.put("data_json", "[{\"data_hr\":\"\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/+" +
                    "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" +
                    "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" +
                    "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" +
                    "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" +
                    "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" +
                    "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" +
                    "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/7+\\/v7+\\/v7+\\/v7+\\/v7+\\/" +
                    "v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\",\"date\":\"" +
                    new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +
                    "\",\"data\":[{\"start\":0,\"stop\":1439," +
                    "\"value\":\"AwAAAwAAAwAAAwAAAwAAAwAAAwAAAwAAAwAAAwAAAwAAfgAA" +
                    "ABsAUAsAUBUAUC8AUwAAUEYAAUcSYwAAYAIAYE0LYCAAYAAAYCsAYGINYwAAY" +
                    "wAAYwAAYwAAYwAAYwAAcwAAcwAAcAQAcwAAcwAAcwAAcwAAcwAAcwAAcwA" +
                    "AcA8AcA8AcwAAcwAAcwAAcAoAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwA" +
                    "AcwAAcwAAcwAAcwAAcwAAcwAAcEoKYwAAYwAAYwAAYwAAYAgAYwAAYwAAcw" +
                    "AAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAc" +
                    "AwAcAcAcwAAcAkAcwAAcCcAcBsAcwAAcwAAcBQAcFILYwAAYwAAYwAAYwAAYw" +
                    "AAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcEUAcHUAcBUKYD" +
                    "oAYG4NYwAAYAIAYAAAYHYOEKsNYCUAYwAAYwAAYHMNYwAAYwAAYwAAYwAAYw" +
                    "AAYwAAcwAAcwAAcwAAcwAAcwAAcwAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAA" +
                    "\",\"tz\":32,\"did\":\"D4C785FFFED33936\",\"src\":8}],\"summary\":\"{\\\"v\\\":5," +
                    "\\\"slp\\\":{\\\"st\\\":" +
                    new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd")
                            .format(new Date())).getTime() / 1000 +
                    ",\\\"ed\\\":" +
                    new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd")
                            .format(new Date())).getTime() / 1000 +
                    ",\\\"dp\\\":0,\\\"lt\\\":0,\\\"wk\\\":0,\\\"usrSt\\\":-1440,\\\"usrEd\\\":-1440,\\\"wc\\\":0}," +
                    "\\\"stp\\\":{\\\"ttl\\\":" +
                    ((int) (Math.random() * 30000) + 50000) +
//                    61000 +
                    ",\\\"dis\\\":16000,\\\"cal\\\":1200,\\\"wk\\\":1200,\\\"rn\\\":4,\\\"runDist\\\":8300," +
                    "\\\"runCal\\\":800}," +
                    "\\\"goal\\\":2000}\"," +
                    "\"source\":8,\"type\":0}]");
            data.put("device", "android_24");
            data.put("device_type", "0");
            data.put("lang", "zh_CN");
            data.put("last_deviceid", "D4C785FFFED33936");
            data.put("timezone", "Asia/Shanghai");
            data.put("uuid", "e280e9045b80");
            data.put("v", "2.0");

            MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
            builder.addFormDataPart("last_source", "8");
            builder.addFormDataPart("userid", "1018774902");
            builder.addFormDataPart("last_sync_data_time", (new Date().getTime() / 1000 + "").split("\\.")[0]);
            builder.addFormDataPart("appid", "2882303761517154077");
            builder.addFormDataPart("callid", new Date().getTime() + "");
            builder.addFormDataPart("channel", "Normal");
            builder.addFormDataPart("country", "CN");
            builder.addFormDataPart("cv", "3154_2.4.2");
            builder.addFormDataPart("data_json", "[{\"data_hr\":\"\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/+" +
                    "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" +
                    "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" +
                    "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" +
                    "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" +
                    "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" +
                    "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/" +
                    "\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/7+\\/v7+\\/v7+\\/v7+\\/v7+\\/" +
                    "v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7" +
                    "+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\\/v7+\",\"date\":\"" +
                    new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +
                    "\",\"data\":[{\"start\":0,\"stop\":1439," +
                    "\"value\":\"AwAAAwAAAwAAAwAAAwAAAwAAAwAAAwAAAwAAAwAAAwAAfgAA" +
                    "ABsAUAsAUBUAUC8AUwAAUEYAAUcSYwAAYAIAYE0LYCAAYAAAYCsAYGINYwAAY" +
                    "wAAYwAAYwAAYwAAYwAAcwAAcwAAcAQAcwAAcwAAcwAAcwAAcwAAcwAAcwA" +
                    "AcA8AcA8AcwAAcwAAcwAAcAoAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwA" +
                    "AcwAAcwAAcwAAcwAAcwAAcwAAcEoKYwAAYwAAYwAAYwAAYAgAYwAAYwAAcw" +
                    "AAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAc" +
                    "AwAcAcAcwAAcAkAcwAAcCcAcBsAcwAAcwAAcBQAcFILYwAAYwAAYwAAYwAAYw" +
                    "AAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcwAAcEUAcHUAcBUKYD" +
                    "oAYG4NYwAAYAIAYAAAYHYOEKsNYCUAYwAAYwAAYHMNYwAAYwAAYwAAYwAAYw" +
                    "AAYwAAcwAAcwAAcwAAcwAAcwAAcwAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgA" +
                    "AfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAA" +
                    "fgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAf" +
                    "gAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfgAAfg" +
                    "AAfgAAfgAAfgAAfgAAfgAA" +
                    "\",\"tz\":32,\"did\":\"D4C785FFFED33936\",\"src\":8}],\"summary\":\"{\\\"v\\\":5," +
                    "\\\"slp\\\":{\\\"st\\\":" +
                    new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd")
                            .format(new Date())).getTime() / 1000 +
                    ",\\\"ed\\\":" +
                    new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd")
                            .format(new Date())).getTime() / 1000 +
                    ",\\\"dp\\\":0,\\\"lt\\\":0,\\\"wk\\\":0,\\\"usrSt\\\":-1440,\\\"usrEd\\\":-1440,\\\"wc\\\":0}," +
                    "\\\"stp\\\":{\\\"ttl\\\":" +
                    ((int) (Math.random() * 30000) + 50000) +
                    ",\\\"dis\\\":16000,\\\"cal\\\":1200,\\\"wk\\\":1200,\\\"rn\\\":4,\\\"runDist\\\":8300," +
                    "\\\"runCal\\\":800}," +
                    "\\\"goal\\\":2000}\"," +
                    "\"source\":8,\"type\":0}]");
            builder.addFormDataPart("device", "android_24");
            builder.addFormDataPart("device_type", "0");
            builder.addFormDataPart("lang", "zh_CN");
            builder.addFormDataPart("last_deviceid", "D4C785FFFED33936");
            builder.addFormDataPart("timezone", "Asia/Shanghai");
            builder.addFormDataPart("uuid", "e280e9045b80");
            builder.addFormDataPart("v", "2.0");

            Observable<XiaoMi> xiaomi = Api.getApiServer().xiaomi("e280e9045b80", new Date().getTime() + "", data);

            xiaomi
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<XiaoMi>() {

                        @Override
                        public void onError(Throwable e) {
                            tvStatus.append("\n"+e.getLocalizedMessage());
                        }

                        @Override
                        public void onComplete() {
                            tvStatus.append("\n完成！");
                        }

                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(XiaoMi xiaoMi) {
                            tvStatus.append("\n"+xiaoMi.toString());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
