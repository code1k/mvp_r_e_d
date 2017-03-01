package com.zb.mvprrd.dagger2demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import com.zb.mvprrd.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Dagger2Activity extends AppCompatActivity {

    @BindView(R.id.tv)
    AppCompatTextView tv;

    @Inject
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);
        ButterKnife.bind(this);

        AppComponent.Initializer.init().inject(this);

        tv.setText(userModel.getName());
    }
}
