package com.example.auth_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText log_username_txt;
    private EditText log_password_txt;
    private Button login_btn;
    private Button register_btn;
    private Auth auth = new Auth();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = log_username_txt.getText().toString();
                String password = log_password_txt.getText().toString();

                if (username.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Fill The Username Field", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Fill The Password Field", Toast.LENGTH_SHORT).show();
                } else {

                    boolean loginFeedback = auth.checkLogin(username, password);
                    if (loginFeedback == true) {
                        Toast.makeText(getApplicationContext(), "Successful Operation", Toast.LENGTH_SHORT).show();
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(MainActivity.this, hello.class));
                            }
                        }, 1000);
                    } else {
                        Toast.makeText(getApplicationContext(), "Incorrect Username Or Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = log_username_txt.getText().toString();
                String password = log_password_txt.getText().toString();

                if (username.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Fill The Username Field", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Fill The Password Field", Toast.LENGTH_SHORT).show();
                } else {
                    boolean registerFeedback = auth.Register(username, password);
                    if (registerFeedback == true) {
                        Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(MainActivity.this, hello.class));
                            }
                        }, 1000);
                    } else {
                        Toast.makeText(getApplicationContext(), "Username is already Exists", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }

    private void setupViews() {
        log_username_txt = findViewById(R.id.log_username_txt);
        log_password_txt = findViewById(R.id.log_password_txt);
        login_btn = findViewById(R.id.login_btn);
        register_btn = findViewById(R.id.register_btn);
    }
}