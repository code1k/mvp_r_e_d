package com.zb.mvprrd.mvpDemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.zb.mvprrd.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MVPDemoActivity extends AppCompatActivity implements MVPActivityContract.MVPActivityView {

    @BindView(R.id.bt_get_data)
    Button btGetData;
    @BindView(R.id.tv_result)
    TextView tvResult;

    MVPPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpdemo);
        ButterKnife.bind(this);
        presenter = new MVPPresenter();
        presenter.attachView(this);
//        PrinterInfo
    }

    @OnClick(R.id.bt_get_data)
    public void onClick() {
        tvResult.setText("");
        presenter.getData();
    }

    @Override
    public void upUI(String s) {
        tvResult.append(s);
        tvResult.append("\n\n");
    }
}
