package com.example.datn28102020.Chapter1.Unit1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Adapter1_1 extends FragmentStatePagerAdapter {
    private String listTab[] = {"Bài giảng", "Video", "Bài tập"};
    private Fragment1_1_1 fragment1_1_1;
    private Fragment1_1_2 fragment1_1_2;
    private Fragment1_1_3 fragment1_1_3;
    public Adapter1_1(FragmentManager fm) {
        super(fm);
        fragment1_1_1 = new Fragment1_1_1();
        fragment1_1_2 = new Fragment1_1_2();
        fragment1_1_3 = new Fragment1_1_3();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return fragment1_1_1;
        }
        else if (position == 1){
            return fragment1_1_2;
        }
        else if (position == 2){
            return fragment1_1_3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return listTab.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTab[position];
    }
}
