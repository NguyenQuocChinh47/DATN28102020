package com.example.datn28102020.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datn28102020.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private TextView tvRegister;
    private EditText edtName, edtEmail, edtPassword, edtRepeatPassword;
    private Button btnCancel, btnRegister;
    private FirebaseAuth auth;
    private DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        anhXa();
        handleCancel();
        handleRegister();
    }

    private void handleRegister() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email            = edtEmail.getText().toString().trim();
                String username         = edtName.getText().toString().trim();
                String password         = edtPassword.getText().toString().trim();
                String repeatPassword   =  edtRepeatPassword.getText().toString().trim();

                if (username.isEmpty()){
                    edtName.setError("Không được để trống");
                    edtName.requestFocus();
                    return;
                }
                if(email.isEmpty()){
                    edtEmail.setError("Không được để trống");
                    edtEmail.requestFocus();
                    return;
                }
                if (password.isEmpty()|| password.length()<7){
                    edtPassword.setError("Không được để trống và trên 8 ký tự");
                    edtPassword.requestFocus();
                    return;
                }
                if (repeatPassword.isEmpty() || repeatPassword.length()<7){
                    edtRepeatPassword.setError("Không được để trống và trên 8 ký tự");
                    edtRepeatPassword.requestFocus();
                    return;
                }
                if (!password.equals(repeatPassword)){
                    Toast.makeText(RegisterActivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                }else {
                    register(email, username, password);
                }
            }
        });
    }

    private void handleCancel() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhXa() {
        tvRegister = findViewById(R.id.tv_register);
        edtName = findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        edtRepeatPassword = findViewById(R.id.edt_repeatpassword);
        btnCancel = findViewById(R.id.btn_cancel);
        btnRegister = findViewById(R.id.btn_register);
    }

    private void register(String email, String username,  String password){

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            assert firebaseUser != null;
                            String userid = firebaseUser.getUid();

                            reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("username", username);
                            hashMap.put("imageURL", "default");

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                    }
                                }
                            });
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}