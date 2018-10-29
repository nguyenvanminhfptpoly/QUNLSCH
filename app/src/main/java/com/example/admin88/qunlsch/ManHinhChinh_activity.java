package com.example.admin88.qunlsch;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.support.design.widget.TabLayout;
import android.widget.TableLayout;

import com.example.admin88.qunlsch.Tablayout_adapter.Adapter_quanlysach_tablelayout;
import com.example.admin88.qunlsch.adapter.Adapter_Hoadon;
import com.example.admin88.qunlsch.fragment.fragment_quanlysach;
import com.example.admin88.qunlsch.model.Hoadon;

import java.util.ArrayList;
import java.util.List;

public class ManHinhChinh_activity extends AppCompatActivity {
    android.support.v7.widget.SearchView view;
    private Toolbar toolbar;
    Adapter_quanlysach_tablelayout adapter_quanlysach_tablelayout;
    List<Hoadon> hoadons;
    Adapter_Hoadon adapter_hoadon;
    ViewPager viewPager;
    TabLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man_hinh_chinh_activity);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        tableLayout = findViewById(R.id.table_layout);
        adapter_quanlysach_tablelayout = new Adapter_quanlysach_tablelayout(getSupportFragmentManager());
        viewPager = findViewById(R.id.vp_danhsach);
        viewPager.setAdapter(adapter_quanlysach_tablelayout);
        tableLayout.setupWithViewPager(viewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        final MenuItem menuItem = menu.findItem(R.id.search);
        view = (android.support.v7.widget.SearchView) menuItem.getActionView();
        view.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
