package com.zb.mvprrd.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.zb.mvprrd.retrofitdemo.MovieBean;
import com.zb.mvprrd.utils.AppManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*************************************************************************************************
 * 版权所有 (C)2016,  四川乐望云教育科技有限公司
 * 文件名称：HTTPService.java
 * 内容摘要：
 * 当前版本：V1.0
 * 作   者： 翟彬
 * 完成日期：2017-02-23 16:00
 * 修改记录：
 * 修改日期：
 * 版本号：
 * 修改人：
 * 修改内容：
 ************************************************************************************************/

public class HTTPService {

    private static final Retrofit.Builder builder;

    static {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().connectTimeout(100, TimeUnit.SECONDS).addInterceptor(interceptor).build();
        builder = new Retrofit.Builder().client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }

    private static final String TAG = "HTTPService.class";

    /**
     * 请求成功返回代码
     */
    public static final String CODE_REQUEST_SUCCESS = "200";
    /**
     * 请求失败
     */
    public static final String CODE_REQUES_FAIL = "110";
    /**
     * 身份验证失效
     */
    public static final String CODE_SIGNATURE_OUTDATE = "121";
    /**
     * 请求signature身份失效
     */
    public static final String CODE_REQUEST_SIGNATURE_FAIL = "111";
    /**
     * 网络异常
     */
    public static final String CODE_NET_ERROR = "1000";
    /**
     * 数据异常
     */
    public static final String CODE_DATA_ERROR = "1001";
    /**
     * 数据处理异常
     */
    public static final String CODE_DEAL_DATA_ERROR = "1002";
    /**
     * 获取身份验证信息异常
     */
    public static final String CODE_SIGNATURE_ERROR = "1003";
    /**
     * 未知错误
     */
    public static final String CODE_UNKNOWN_ERROR = "1004";


    private String url;
    private ArrayList<HttpPart> parts = new ArrayList<HttpPart>();
    private boolean auth = true;
    private String requestTag;
    public static String BASE_URL;
    private HttpResult result;


    public HTTPService() {
        this.requestTag = System.currentTimeMillis() + "." + (int) (Math.random() * 1000) + "";
    }

    public HTTPService(String requestTag) {
        this.requestTag = requestTag;
    }

    /**
     * 开始联网请求
     */
    public void start() {
        if (!isConnected(AppManager.I().getApplicationContext())) {
            return;
        }
        initRequestParams();
    }

    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient httpClient = new OkHttpClient.Builder().connectTimeout(100, TimeUnit.SECONDS).addInterceptor(interceptor).build();
            retrofit = new Retrofit.Builder().client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }



    private void initRequestParams() {
        builder.baseUrl(BASE_URL).build();
        retrofit.create(HttpApi.class)
                .getTop(0, 1)
                .subscribe(new Consumer<HttpResult<List<MovieBean>>>() {
                    @Override
                    public void accept(@NonNull HttpResult<List<MovieBean>> listHttpResult) throws Exception {

                    }
                });
    }

    /**
     * @return 是否连接上
     */
    public static boolean isConnected(Context context) {
        //通过系统的服务，获取到连接的管理器
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//                manager.getActiveNetwork();//这个方法，是在SDK23才添加的，所以，不建议使用
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();//这个方法，实在SDK1就有了，所以没问题
        //如果没有，那么直接返回false，表示没有可用的网络连接
        if (activeNetworkInfo == null) {
            return false;
        }
        //判断，当两个都满足的时候才返回true，其他的都返回false；
        return activeNetworkInfo.isConnected() & activeNetworkInfo.isAvailable();

    }
}
