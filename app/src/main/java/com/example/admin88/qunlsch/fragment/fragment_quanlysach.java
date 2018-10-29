package com.example.admin88.qunlsch.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin88.qunlsch.R;

public class fragment_quanlysach extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener {
    View v1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v1 = inflater.inflate(R.layout.fragment_quanlysach,container,false);
        loadFragment(new Fragment_theloai());
        BottomNavigationView navigationView = v1.findViewById(R.id.navigation_view);
        navigationView.setOnNavigationItemSelectedListener(this);
        return v1;
    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.it_tl:
                loadFragment(new Fragment_theloai());
                break;
            case R.id.it_tk:
                Toast.makeText(getActivity(), "Nhấn 2 lần để xóa sách tồn kho", Toast.LENGTH_SHORT).show();
                loadFragment(new Fragment_tonkho());
                break;
        }
        return true;
    }
}
