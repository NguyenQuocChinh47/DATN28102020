package com.example.datn28102020.Chapter1.Unit1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.datn28102020.Chapter1.Unit1.Adapter1_1;
import com.example.datn28102020.R;
import com.google.android.material.tabs.TabLayout;

public class Unit1_1Activity extends AppCompatActivity {
    private Toolbar toolBarUnit1;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1);
        anhXa();
        //xử lý toolbar
        setSupportActionBar(toolBarUnit1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bài 1");
        //kết nối và đổ dữ liệu thông qua adapter
        viewPager.setAdapter(new Adapter1_1(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    private void anhXa() {
        toolBarUnit1    = findViewById(R.id.tool_bar_unit1);
        viewPager       = findViewById(R.id.view_pager_1_1);
        tabLayout       = findViewById(R.id.tab_layout_1_1);
    }
}