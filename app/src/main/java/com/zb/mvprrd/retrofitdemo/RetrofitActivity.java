package com.zb.mvprrd.retrofitdemo;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.zb.mvprrd.R;

import org.reactivestreams.Subscription;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity implements ViewClick {

    @BindView(R.id.bt_get_data)
    Button btGetData;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.bt_upload_data)
    Button btUploadData;
    private ArrayList<Subscription> rx = new ArrayList<>();
    private int REQUST_IMAGE = 1000;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        setOnClickLinster(this, btGetData, btUploadData);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(200, TimeUnit.SECONDS);
        builder.addInterceptor(interceptor);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.douban.com/")
                .build();
    }

    protected void setOnClickLinster(final ViewClick c, View... views) {
        if (views != null && views.length > 0) {
            for (final View v : views) {
                if (v != null) {
                    RxView.clicks(v).throttleFirst(2, TimeUnit.SECONDS)
                            .subscribe(new Consumer<Object>() {
                                @Override
                                public void accept(@NonNull Object o) throws Exception {
                                    c.click(v);
                                }
                            });
                }
            }
        }
    }

    @Override
    public void click(View view) {
        if (view == btGetData) {
            MoveApi moveApi = retrofit.create(MoveApi.class);
            moveApi.getTop(0, 10).enqueue(new Callback<MovieBean>() {
                @Override
                public void onResponse(Call<MovieBean> call, Response<MovieBean> response) {
                    tvResult.setText(response.body().toString());
                }

                @Override
                public void onFailure(Call<MovieBean> call, Throwable t) {
                    tvResult.setText(String.format("获取失败！--->%s", t.getMessage()));
                }
            });
        } else if (view == btUploadData) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            startActivityForResult(intent, REQUST_IMAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUST_IMAGE && resultCode == RESULT_OK && data != null) {
            File file = new File(getRealFilePath(data.getData()));
//            way1(file);
//            way2(file);
            way3(file);
        }
    }

    private Toast toast;

    private void showToast(String s) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, s, Toast.LENGTH_LONG);
        toast.show();
    }

    private void way3(File file) {
        RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody multipartBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("userId", "lwt70007")
                .addFormDataPart("files", file.getName(), body).build();
        retrofit.create(MoveApi.class).uploadWay3(multipartBody)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String body = response.body().string();
                            Log.v("Upload", "success--->" + body);
                            showToast(body);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("Upload error:", t.getMessage());
                        showToast(t.getMessage());
                    }
                });
    }

    private void way2(File file) {
        // 创建 RequestBody，用于封装构建RequestBody
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

// MultipartBody.Part  和后端约定好Key，这里的partName是用image
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("files", file.getName(), requestFile);

// 添加描述
        String descriptionString = "hello, 这是文件描述";
        RequestBody description =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), descriptionString);

// 执行请求
        MoveApi service = retrofit.create(MoveApi.class);
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("userId", "lwt70007");
        Call<ResponseBody> call = service.uploadWay2(body, stringStringHashMap);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String body = response.body().string();
                    Log.v("Upload", "success--->" + body);
                    showToast(body);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("Upload error:", t.getMessage());
                showToast(t.getMessage());
            }
        });
    }

    private void way1(File file) {
        // 创建 RequestBody，用于封装构建RequestBody
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

// MultipartBody.Part  和后端约定好Key，这里的partName是用image
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("image", file.getName(), requestFile);

// 添加描述
        String descriptionString = "hello, 这是文件描述";
        RequestBody description =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), descriptionString);

// 执行请求
        MoveApi service = retrofit.create(MoveApi.class);
        Call<ResponseBody> call = service.uploadWay1(description, body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String body = response.body().string();
                    Log.v("Upload", "success--->" + body);
                    showToast(body);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("Upload error:", t.getMessage());
                showToast(t.getMessage());
            }
        });
    }

    public String getRealFilePath(final Uri uri) {
        if (null == uri) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null)
            data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }

    @Override
    protected void onDestroy() {
        for (Subscription s : rx) {
            if (s != null) {
                s.cancel();
            }
        }
        super.onDestroy();
    }
}


