package com.example.admin88.qunlsch.activity_theloai;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin88.qunlsch.OnItemdeleteListener;
import com.example.admin88.qunlsch.R;
import com.example.admin88.qunlsch.SQlite.NgoainguDAO;
import com.example.admin88.qunlsch.adapter.Adapter_ngoaingu;
import com.example.admin88.qunlsch.model.KinhTe_sach;
import com.example.admin88.qunlsch.model.Ngoaingu_sach;

import java.util.List;

public class NgoaiNguActivity extends AppCompatActivity {
    RecyclerView recyclerView_ngoaingu;
    Ngoaingu_sach ngoaingu_sach;
    Adapter_ngoaingu adapter_ngoaingu;
    List<Ngoaingu_sach> ngoaingu_saches;
    NgoainguDAO ngoainguDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngoai_ngu);
        recyclerView_ngoaingu = findViewById(R.id.recycler_view_ngoaingu);
        ngoainguDAO = new NgoainguDAO(NgoaiNguActivity.this);
        ngoaingu_saches = ngoainguDAO.getAlllist();
        adapter_ngoaingu = new Adapter_ngoaingu(ngoaingu_saches, NgoaiNguActivity.this, new OnItemdeleteListener() {
            @Override
            public void onItemdelete(int position) {
                removeItem(position);
            }
        });
        recyclerView_ngoaingu.setAdapter(adapter_ngoaingu);
        recyclerView_ngoaingu.setHasFixedSize(true);
        recyclerView_ngoaingu.setLayoutManager(new LinearLayoutManager(this));
    }
    public void removeItem(int position){
        ngoaingu_sach = new Ngoaingu_sach();
        ngoaingu_sach = ngoaingu_saches.get(position);
        ngoaingu_saches.remove(position);
        updatedata();
        ngoainguDAO.delete(ngoaingu_sach);
    }
    public void addsachngoaingu(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(NgoaiNguActivity.this);
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
                if (name.isEmpty() && gioithieu.isEmpty()) {
                    Toast.makeText(NgoaiNguActivity.this, "Vui lòng nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    ngoaingu_sach = new Ngoaingu_sach(name, gioithieu, gia);
                    ngoainguDAO.insert(ngoaingu_sach);
                    updatedata();
                    dialog.dismiss();
                    Toast.makeText(NgoaiNguActivity.this, "Thêm sách thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void updatedata(){
        ngoaingu_saches.clear();
        ngoaingu_saches.addAll(ngoainguDAO.getAlllist());
        adapter_ngoaingu.notifyDataSetChanged();

    }
    public double ParseDouble(String strNumber) {
        if (strNumber != null && strNumber.length() > 0) {
            try {
                return Double.parseDouble(strNumber);
            } catch (Exception e) {
                return -1;   // or some value to mark this field is wrong. or make a function validates field first ...
            }
        } else {
            Toast.makeText(this, "Nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }
}
