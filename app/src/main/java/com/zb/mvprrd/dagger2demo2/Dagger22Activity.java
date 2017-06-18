package com.zb.mvprrd.dagger2demo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zb.mvprrd.R;
import com.zb.mvprrd.Dagger22MyApplication;
import com.zb.mvprrd.dagger2demo2.base.BaseContract;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Dagger22Activity extends AppCompatActivity implements BaseContract.BaseView, Dagger22Contract.View {

    @BindView(R.id.bt_get_data)
    Button btGetData;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.bt_upload_data)
    Button btUploadData;

    @Inject
    Dagger22Presenter dagger22Presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        ((Dagger22MyApplication)getApplication()).getAppComponent().inject(this);
        dagger22Presenter.attachView(this);
        btUploadData.setVisibility(View.GONE);
    }

    @OnClick(R.id.bt_get_data)
    public void onClick() {
        dagger22Presenter.login("lwt70007", "123456", "2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dagger22Presenter.detachView();
    }

    @Override
    public void showUserInfo(String info) {
        tvResult.setText(info);
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }
}
