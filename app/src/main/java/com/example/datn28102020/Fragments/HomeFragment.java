package com.example.datn28102020.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datn28102020.Chapter1.Chapter1;
import com.example.datn28102020.HomeActivity;
import com.example.datn28102020.R;


public class HomeFragment extends Fragment {
    private View view;
    private TextView textView;
    private Button btnChapter1, btnChapter2, btnChapter3, btnChapter4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_home, container, false);
        anhXa();
        clickOnChapter();
        return view;
    }

    private void  clickOnChapter() {
        btnChapter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Chapter1.class);
                startActivity(intent);
            }
        });
    }

    private void anhXa(){
        btnChapter1 = view.findViewById(R.id.btnChapter1);
        btnChapter2 = view.findViewById(R.id.btnChapter2);
        btnChapter3 = view.findViewById(R.id.btnChapter3);
        btnChapter4 = view.findViewById(R.id.btnChapter4);
    };
}