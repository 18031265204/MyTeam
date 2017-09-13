package com.jiyun.myteam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jiyun.lenovo.app.PeopleBeanDao;
import com.jiyun.myteam.Bean.PeopleBean;
import com.jiyun.myteam.DaoUtils.DaoDemo;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText phonenumbel;
    private EditText password;
    private Button intent;
    private ImageView backk;
    private PeopleBean peopleBean;
    private String passwordString;
    private String phonenumbelString;
    private int i;
    private PeopleBeanDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        dao = DaoDemo.getIentece(RegisterActivity.this).getDao();
    }

    private void initView() {
        phonenumbel = (EditText) findViewById(R.id.phonenumbel);
        password = (EditText) findViewById(R.id.password);
        intent = (Button) findViewById(R.id.intent);

        intent.setOnClickListener(this);
        backk = (ImageView) findViewById(R.id.backk);
        backk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.intent:
                     submit();
                Intent intent = new Intent(RegisterActivity.this, Register2Activity.class);
                startActivity(intent);
                break;
        }
    }

    private void submit() {
        String numbel = phonenumbel.getText().toString().trim();
        String pass = password.getText().toString().trim();

        peopleBean = new PeopleBean(null,numbel,pass);
        dao.insertInTx(peopleBean);

//        // validate
//        phonenumbelString = phonenumbel.getText().toString().trim();
//        String numbel ="\\d{11,}$";
//        boolean matches = phonenumbelString.matches(numbel);
//        if (TextUtils.isEmpty(phonenumbelString)) {
//            Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
//            return;
//        }else if (matches==true){
//            Toast.makeText(this, "正确", Toast.LENGTH_SHORT).show();
//            return;
//        }else if (matches == false){
//            Toast.makeText(this, "只能是纯数字", Toast.LENGTH_SHORT).show();
//             return;
//        }else if (phonenumbelString.length()>11){
//            Toast.makeText(this, "数字长度错误", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        else {
//            i = Integer.parseInt(phonenumbelString);
//
//        passwordString = password.getText().toString().trim();
//        if (TextUtils.isEmpty(passwordString)){
//            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        else if (passwordString.length()>10) {
//            Toast.makeText(this, "密码最长为10位数,请重新输入", Toast.LENGTH_SHORT).show();
//            return;
//        }else {
//
//        }
//
//        // TODO validate success, do something
//
//        }
    }
}
