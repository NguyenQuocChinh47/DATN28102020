package com.example.datn28102020.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datn28102020.HomeActivity;
import com.example.datn28102020.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private ImageView ivLogo;
    private TextView tvLogin, text1, txtRegister;
    private EditText edtEmail, edtPassword;
    private Button btnLogin;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        anhXa();
        clickRegister();
        clickLogin();
    }

    private void clickLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email    = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if(email.isEmpty()){
                    edtEmail.setError("Không được để trống");
                    edtEmail.requestFocus();
                    return;
                }
                if (password.isEmpty()){
                    edtPassword.setError("Không được để trống");
                    edtPassword.requestFocus();
                    return;
                }
                login(email, password);
            }
        });
    }

    private void anhXa() {
        ivLogo      = findViewById(R.id.iv_logo);
        tvLogin     = findViewById(R.id.tv_login);
        text1       = findViewById(R.id.text1);
        txtRegister = findViewById(R.id.txt_register);
        edtEmail    = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin    = findViewById(R.id.btn_login);
    }

    private void clickRegister(){
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login(String email, String password){
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                          Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                      }else {
                          Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();
                      }
                    }
                });
    }
}