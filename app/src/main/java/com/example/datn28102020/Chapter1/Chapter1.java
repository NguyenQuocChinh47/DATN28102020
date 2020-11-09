package com.example.datn28102020.Chapter1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.datn28102020.Chapter1.Unit1.Fragment1_1_1;
import com.example.datn28102020.Chapter1.Unit1.Unit1_1Activity;
import com.example.datn28102020.R;

public class Chapter1 extends AppCompatActivity {
    private Toolbar toolbar;
    private Button btnUnit1, btnUnit2, btnUnit3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1);
        anhXa();
        handleToolbar();
        clickOnUnit();
    }

    private void clickOnUnit() {
        btnUnit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chapter1.this, Unit1_1Activity.class);
                startActivity(intent);
            }
        });
    }

    private void handleToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chương I");
    }

    private void anhXa() {
        toolbar     = findViewById(R.id.toolbar_chapter1);
        btnUnit1    = findViewById(R.id.btn_unit1);
        btnUnit2    = findViewById(R.id.btn_unit2);
        btnUnit3    = findViewById(R.id.btn_unit3);
    }
}