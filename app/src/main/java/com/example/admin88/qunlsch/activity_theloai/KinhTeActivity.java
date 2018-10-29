package com.example.admin88.qunlsch.activity_theloai;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin88.qunlsch.OnItemdeleteListener;
import com.example.admin88.qunlsch.R;
import com.example.admin88.qunlsch.SQlite.KinhTeDAO;
import com.example.admin88.qunlsch.adapter.Adapter_KinhTe;
import com.example.admin88.qunlsch.model.KinhTe_sach;

import java.util.List;

public class KinhTeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter_KinhTe adapter_kinhTe;
    List<KinhTe_sach> kinhTe_saches;
    KinhTe_sach kinhTe_sach;
    KinhTeDAO kinhTeDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinhte);
        recyclerView = findViewById(R.id.recycler_view_kinhte);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        kinhTeDAO = new KinhTeDAO(KinhTeActivity.this);
        kinhTe_saches = kinhTeDAO.getAlllist();
        adapter_kinhTe = new Adapter_KinhTe(kinhTe_saches, KinhTeActivity.this, new OnItemdeleteListener() {
            @Override
            public void onItemdelete(int position) {
                removeItem(position);
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter_kinhTe);
    }
    public void removeItem(int position){
        kinhTe_sach = new KinhTe_sach();
        kinhTe_sach = kinhTe_saches.get(position);
        kinhTe_saches.remove(position);
        updatedata();
        kinhTeDAO.delete(kinhTe_sach);
    }
    public void addsachkinhte(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(KinhTeActivity.this);
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
                    Toast.makeText(KinhTeActivity.this, "Vui lòng nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    kinhTe_sach = new KinhTe_sach(name, gioithieu, gia);
                    kinhTeDAO.insert(kinhTe_sach);
                    updatedata();
                    dialog.dismiss();
                    Toast.makeText(KinhTeActivity.this, "Thêm sách thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void updatedata() {
        kinhTe_saches.clear();
        kinhTe_saches.addAll(kinhTeDAO.getAlllist());
        adapter_kinhTe.notifyDataSetChanged();
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
