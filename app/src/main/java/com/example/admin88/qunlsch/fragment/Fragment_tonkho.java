package com.example.admin88.qunlsch.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin88.qunlsch.OnItemdeleteListener;
import com.example.admin88.qunlsch.R;
import com.example.admin88.qunlsch.SQlite.TonKhoDAO;
import com.example.admin88.qunlsch.activity_theloai.AmthucActivity;
import com.example.admin88.qunlsch.activity_theloai.CNTTActivity;
import com.example.admin88.qunlsch.activity_theloai.KinhTeActivity;
import com.example.admin88.qunlsch.activity_theloai.NgoaiNguActivity;
import com.example.admin88.qunlsch.activity_theloai.SucKhoeActivity;
import com.example.admin88.qunlsch.adapter.Adapter_theloai;
import com.example.admin88.qunlsch.adapter.Adapter_tonkho;
import com.example.admin88.qunlsch.model.THeLoai;
import com.example.admin88.qunlsch.model.Tonkho_sach;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_tonkho extends Fragment {
    Tonkho_sach tonkho_sach;
    Adapter_tonkho adapter_tonkho;
    List<Tonkho_sach> tonkho_saches;
    TonKhoDAO tonKhoDAO;
    RecyclerView recyclerView;
    View v;
    FloatingActionButton fab;
    public Fragment_tonkho() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_tonkho, container, false);
        tonKhoDAO = new TonKhoDAO(getActivity());
        tonkho_saches = tonKhoDAO.getAlllist();
        adapter_tonkho = new Adapter_tonkho(tonkho_saches, getActivity(), new OnItemdeleteListener() {
            @Override
            public void onItemdelete(int position) {
                removeItem(position);
            }
        });
        recyclerView = v.findViewById(R.id.recycler_view_);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fab = v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View mview = getLayoutInflater().inflate(R.layout.dialog_kinhte_add, null);
                Button btn_add = mview.findViewById(R.id.button_add);
                final EditText ed_name = mview.findViewById(R.id.ed_tieude);
                final EditText ed_giothieu = mview.findViewById(R.id.ed_gioithieu);
                final EditText ed_gia = mview.findViewById(R.id.ed_gia);
                builder.setView(mview);
                final AlertDialog dialog = builder.create();
                dialog.show();

                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = ed_name.getText().toString().trim();
                        String gioithieu = ed_giothieu.getText().toString().trim();
                        double gia = ParseDouble(ed_gia.getText().toString().trim());
                        if (name.equals("") && gioithieu.equals("")) {
                            Toast.makeText(getActivity(), "Vui lòng nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                        } else {
                            tonkho_sach = new Tonkho_sach(name,gioithieu,gia);
                            tonKhoDAO.insert(tonkho_sach);
                            updatedata();
                            Toast.makeText(getActivity(), "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        recyclerView.setAdapter(adapter_tonkho);
        return v;
    }
    public void removeItem(int position){
        tonkho_sach = new Tonkho_sach();
        tonkho_sach = tonkho_saches.get(position);
        tonkho_saches.remove(position);
        updatedata();
        tonKhoDAO.delete(tonkho_sach);
    }
    public void updatedata(){
        tonkho_saches.clear();
        tonkho_saches.addAll(tonKhoDAO.getAlllist());
        adapter_tonkho.notifyDataSetChanged();
    }
    public double ParseDouble(String strNumber) {
        if (strNumber != null && strNumber.length() > 0) {
            try {
                return Double.parseDouble(strNumber);
            } catch (Exception e) {
                return -1;   // or some value to mark this field is wrong. or make a function validates field first ...
            }
        } else {
            Toast.makeText(getActivity(), "Nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }
}
