package com.zb.mvprrd.rxjavaretrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.widget.TextView;

import com.zb.mvprrd.R;
import com.zb.mvprrd.retrofitdemo.MovieBean;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class RxJavaRetrofitActivity extends AppCompatActivity {
    //https://api.douban.com/   v2/movie/top250   ?  start=0&count=50
    @BindView(R.id.bt_get_data)
    AppCompatButton btGetData;
    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_retrofit);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_get_data)
    public void onClick() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("https://api.douban.com/")
                .client(client);

        RTMoveApi rtMoveApi = builder.build().create(RTMoveApi.class);
        Observable<MovieBean> top = rtMoveApi.getTop(0, 10);
        top.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MovieBean>() {
                    @Override
                    public void call(MovieBean movieBean) {
                        tvResult.setText(movieBean.toString());
                    }
                });
    }
}
