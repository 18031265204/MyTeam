package com.jiyun.myteam;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Register2Activity extends AppCompatActivity {
  private EditText edyanzheng;
    private TextView tijiao;
    Handler handler =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        edyanzheng = (EditText) findViewById(R.id.yanzheng);
        tijiao = (TextView) findViewById(R.id.huoqu);
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(10000, 1000) {
                    @Override
                    public void onTick(long mm) {
                        tijiao.setEnabled(false);
                        tijiao.setText(mm/1000+"S");

                    }

                    @Override
                    public void onFinish() {
                        Random random = new Random();
                        for (int i = 0; i < 10; i++) {
                            int i1 = random.nextInt(1000);
                            edyanzheng.setText(i1+"");
                        }
                         tijiao.setEnabled(true);
                        tijiao.setText("重新获取");
                    }
                }.start();
            }
        });

    }



    public  void demo(View button){
        Toast.makeText(this, "跳转到登录页面", Toast.LENGTH_SHORT).show();
    }


  
}
