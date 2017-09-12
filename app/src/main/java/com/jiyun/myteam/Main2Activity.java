package com.jiyun.myteam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import com.jiyun.myteam.adapter.Regular;
import com.jiyun.myteam.adapter.SPUtils;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_name;
    private EditText et_password;
    private Button bt_load;
    private ImageView iv_qq;
    private ImageView iv_xinlang;
    private TextView tv_pass;
    private TextView tv_zhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        bt_load = (Button) findViewById(R.id.bt_load);
        iv_qq = (ImageView) findViewById(R.id.iv_qq);
        iv_xinlang = (ImageView) findViewById(R.id.iv_xinlang);
        tv_pass = (TextView) findViewById(R.id.tv_pass);
        tv_zhu = (TextView) findViewById(R.id.tv_zhu);


        bt_load.setOnClickListener(this);
        iv_qq.setOnClickListener(this);
        iv_xinlang.setOnClickListener(this);
        tv_zhu.setOnClickListener(this);
        tv_pass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_load://按钮点击登录
                submit();

                break;
            case R.id.iv_qq://第三方qq登录
                initQQ();


                break;
            case R.id.iv_xinlang:
                Toast.makeText(Main2Activity.this, "暂不支持，请使用QQ登录", Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_zhu:
                //注册
//                startActivity(new Intent(Main2Activity.this, AddActivity.class));
                break;
            case R.id.tv_pass://找回密码
//                startActivity(new Intent(Main2Activity.this, HuiActivity.class));
                break;
        }
    }

    private void initQQ() {
        UMShareAPI.get(Main2Activity.this).getPlatformInfo(Main2Activity.this, SHARE_MEDIA.QQ, new UMAuthListener() {

            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                Intent intent = new Intent(Main2Activity.this, HomePageActivity.class);

                startActivity(intent);
                Toast.makeText(Main2Activity.this, "1111111", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        });
    }


    private void submit() {
        // validate
        String name1 = (String) SPUtils.get(this, "name", "123");
        String pass1 = (String) SPUtils.get(this, "pass", "123");
        String name = et_name.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        if (Regular.getInstance().isEmail(name) || Regular.getInstance().isMobileNO(name)) {
            if (password.length() > 5 && password.length() < 17) {
                if (name.equals(name1) && pass1.equals(password)) {
//                    Intent intent = new Intent(Main2Activity.this, Main2Activity.class);
//                    startActivity(new Intent(this, ));
                    Toast.makeText(Main2Activity.this, "登录成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "请输入正确信息", Toast.LENGTH_SHORT).show();
                }
            }

        } else {
            Toast.makeText(this, "请输入正确信息", Toast.LENGTH_SHORT).show();
        }


    }
}
