package com.jiyun.myteam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import adapter.MyAdapter;
import adapter.SPUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager view_pager;
    private Context context;
    private Button bt_start;
    private ArrayList<View> views;
    private MyAdapter myAdapter;
    Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 100:
                    view_pager.setCurrentItem(1);
                    handler.sendEmptyMessageDelayed(200,2000);
                    break;
                case 200:
                    view_pager.setCurrentItem(2);
                    bt_start.setVisibility(View.VISIBLE);
                    SPUtils.put(MainActivity.this,"Vesion",1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化视图
        initView();
        context = MainActivity.this;
        //添加轮播
        addViewes();
        //根据版本号判断是否执行一次
        VesionOne();
        intiAdapter();
    }

    private void intiAdapter() {
        //设置适配器
        myAdapter = new MyAdapter(views);
        //写个滑动监听，显示按钮或隐藏按钮
        view_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==views.size()-1){
                    bt_start.setVisibility(View.VISIBLE);
                }else {
                    bt_start.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        view_pager.setAdapter(myAdapter);
    }

    private void VesionOne() {
        int vesion = (int) SPUtils.get(context, "Vesion", 0);
        if (vesion==0){
            Message message = handler.obtainMessage();
            message.what=100;
            handler.sendMessageDelayed(message,2000);
        }else {
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        }
    }


    private void addViewes() {
        views = new ArrayList<>();
        View view_item = LayoutInflater.from(context).inflate(R.layout.view_item, null);
        View view_item1 = LayoutInflater.from(context).inflate(R.layout.view_item1, null);
        View view_item2 = LayoutInflater.from(context).inflate(R.layout.view_item2, null);
        views.add(view_item);
        views.add(view_item1);
        views.add(view_item2);
    }

    private void initView() {
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        bt_start = (Button) findViewById(R.id.bt_start);
        bt_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                break;
        }
    }
}
