package com.example.admin88.qunlsch;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin88.qunlsch.SQlite.UserDAO;
import com.example.admin88.qunlsch.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextInputEditText ed_user, ed_pass;
    TextView tv_changepass, tv_signup;
    Button btn_Login;
    User user;
    List<User> users;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        users = new ArrayList<>();
        userDAO = new UserDAO(MainActivity.this);
        ed_pass = findViewById(R.id.ed_passs);
        ed_user = findViewById(R.id.ed_user);
        tv_changepass = findViewById(R.id.dmk);
        tv_signup = findViewById(R.id.signup);
        btn_Login = findViewById(R.id.login);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String name = ed_user.getText().toString();
//                String pass = ed_pass.getText().toString();
//                if (name.equals("") && pass.equals("")){
//                    Toast.makeText(MainActivity.this, "Nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
//                }else if(name == user.getmName() && pass == user.getmPass()) {
                    Intent intent = new Intent(MainActivity.this, ManHinhChinh_activity.class);
                    startActivity(intent);
//                }
            }
        });
    }

    public void sign_up(View view) {
        Intent intent = new Intent(MainActivity.this, Sign_up_activity.class);
        startActivity(intent);
    }

}
