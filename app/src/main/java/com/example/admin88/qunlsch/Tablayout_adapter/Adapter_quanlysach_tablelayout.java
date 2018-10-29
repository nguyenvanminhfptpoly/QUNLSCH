package com.example.admin88.qunlsch.Tablayout_adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.admin88.qunlsch.fragment.fragment_quanlysach;
import com.example.admin88.qunlsch.fragment.fragment_thongke;

public class Adapter_quanlysach_tablelayout extends FragmentStatePagerAdapter {
    public Adapter_quanlysach_tablelayout(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new fragment_quanlysach();
            case 1:
                return new fragment_thongke();
            default:
                return null;
        }
    }
    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "QUẢN LÝ SÁCH";
            case 1:
                return "THỐNG KÊ";
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return 2;
    }
}
