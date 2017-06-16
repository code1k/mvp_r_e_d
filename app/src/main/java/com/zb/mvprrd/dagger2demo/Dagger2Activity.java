package com.zb.mvprrd.dagger2demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zb.mvprrd.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Dagger2Activity extends AppCompatActivity {

    @Inject
    UserModel userModel;

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);

        AppComponent.Initializer.init().inject(this);
        ButterKnife.bind(this);
        tv.setText(userModel.getName());
    }
}
