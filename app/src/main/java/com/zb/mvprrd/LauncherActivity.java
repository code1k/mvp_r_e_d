package com.zb.mvprrd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zb.mvprrd.dagger2demo.Dagger2Activity;
import com.zb.mvprrd.dagger2demo2.Dagger22Activity;
import com.zb.mvprrd.eventbus.EventBusActivity;
import com.zb.mvprrd.mvpDemo.MVPDemoActivity;
import com.zb.mvprrd.retrofitdemo.RetrofitActivity;
import com.zb.mvprrd.rxjavaretrofitdemo.RxJavaRetrofitActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LauncherActivity extends AppCompatActivity {

    @BindView(R.id.rlv)
    RecyclerView rlv;

    private ArrayList<ActivityInfo> activityInfos = new ArrayList<>();

    private void addActivityInfos() {
        activityInfos.add(new ActivityInfo("EventBus_Demo", EventBusActivity.class));
        activityInfos.add(new ActivityInfo("Retrofit_Demo", RetrofitActivity.class));
        activityInfos.add(new ActivityInfo("RxJavaRetrofit_Demo", RxJavaRetrofitActivity.class));
        activityInfos.add(new ActivityInfo("Dagger2_Demo", Dagger2Activity.class));
        activityInfos.add(new ActivityInfo("MVP_Demo", MVPDemoActivity.class));
        activityInfos.add(new ActivityInfo("Dagger2_Demo2", Dagger22Activity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ButterKnife.bind(this);
        addActivityInfos();
        rlv = (RecyclerView) findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter();
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ActivityInfo activityInfo) {
                startActivity(new Intent(LauncherActivity.this, activityInfo.getCls()));
            }
        });
        rlv.setAdapter(myAdapter);
        //添加分割线
        rlv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    public interface OnItemClickListener {
        void onItemClick(ActivityInfo activityInfo);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private OnItemClickListener listener;

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(LauncherActivity.this).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(activityInfos.get(position));
                }
            });
            holder.tv.setText(activityInfos.get(position).getTitle());
        }

        @Override
        public int getItemCount() {
            return activityInfos.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

    private class ActivityInfo {
        public ActivityInfo(String title, Class<?> cls) {
            this.title = title;
            this.cls = cls;
        }

        private String title;
        private Class<?> cls;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Class<?> getCls() {
            return cls;
        }

        public void setCls(Class<?> cls) {
            this.cls = cls;
        }
    }
}
