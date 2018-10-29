package com.example.admin88.qunlsch;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin88.qunlsch.SQlite.UserDAO;
import com.example.admin88.qunlsch.model.User;

public class Sign_up_activity extends AppCompatActivity {
    TextInputEditText ed_firstname,ed_name,ed_email,ed_password;
    Button btn_signup;
    UserDAO userDAO;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_activity);
        userDAO = new UserDAO(this);
        ed_email = findViewById(R.id.ed_email);
        ed_firstname = findViewById(R.id.ed_firstname);
        ed_name = findViewById(R.id.ed_name);
        ed_password = findViewById(R.id.ed_paswword);
        btn_signup = findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ho = ed_firstname.getText().toString().trim();
                String name = ed_name.getText().toString().trim();
                String email = ed_email.getText().toString().trim();
                String pass = ed_password.getText().toString().trim();

                if (ed_password.equals("")){
                    Toast.makeText(Sign_up_activity.this, "vui lòng nhập đủ", Toast.LENGTH_SHORT).show();
                }else {
                    userDAO.insert(new User(ho,name,pass,email));
                    Intent intent = new Intent(Sign_up_activity.this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(Sign_up_activity.this, "đăng kí thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
