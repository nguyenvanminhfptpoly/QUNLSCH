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

public class fragment_thongke extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener  {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thongke,container,false);
        loadFragment(new Fragment_hoadon());
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.nav2);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        return view;
    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container2, fragment);
            fragmentTransaction.commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.it_hd:
                loadFragment(new Fragment_hoadon());
                Toast.makeText(getActivity(), "Nhấn 2 lần để xóa", Toast.LENGTH_SHORT).show();
                break;
            case R.id.it_ds:
                loadFragment(new Fragment_doanhso());
                break;
            case R.id.it_sbc:
                loadFragment(new Fragment_sachbanchay());
                break;
        }
        return false;
    }
}
