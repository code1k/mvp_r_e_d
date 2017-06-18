package com.zb.mvprrd.eventbus;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.zb.mvprrd.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusActivity extends AppCompatActivity {

    @BindView(R.id.bt_send_event_bus)
    Button btSendEventBus;
    @BindView(R.id.tv_event_bus_content)
    TextView tvEventBusContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        ObjectAnimator animator = ObjectAnimator.ofInt(this,"aaa",0,100);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animation.getAnimatedValue("aaa");
            }
        });
    }

    @OnClick(R.id.bt_send_event_bus)
    public void onClick() {
        EventBus.getDefault().post(new EventBusContent("1", "事件内容！！！"));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReacive(EventBusContent content) {
        tvEventBusContent.setText(content.getType() + "---->" + content.getContent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
