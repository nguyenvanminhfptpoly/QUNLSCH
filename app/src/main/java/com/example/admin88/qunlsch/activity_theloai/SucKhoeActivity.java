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
import com.example.admin88.qunlsch.SQlite.SuckhoeDAO;
import com.example.admin88.qunlsch.adapter.Adapter_suckhoe;
import com.example.admin88.qunlsch.model.Amthuc_sach;
import com.example.admin88.qunlsch.model.Suckhoe_sach;

import java.util.List;

public class SucKhoeActivity extends AppCompatActivity {
    RecyclerView recyclerView_suckhoe;
    List<Suckhoe_sach> suckhoe_saches;
    Suckhoe_sach suckhoe_sach;
    Adapter_suckhoe adapter_suckhoe;
    SuckhoeDAO suckhoeDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suc_khoe);
        recyclerView_suckhoe = findViewById(R.id.recycler_view_suckhoe);
        recyclerView_suckhoe.setLayoutManager(new LinearLayoutManager(SucKhoeActivity.this));
        recyclerView_suckhoe.setHasFixedSize(true);
        suckhoeDAO = new SuckhoeDAO(SucKhoeActivity.this);
        suckhoe_saches = suckhoeDAO.getAlllist();
        adapter_suckhoe = new Adapter_suckhoe(suckhoe_saches, SucKhoeActivity.this, new OnItemdeleteListener() {
            @Override
            public void onItemdelete(int position) {
                removeItem(position);
            }
        });
        recyclerView_suckhoe.setAdapter(adapter_suckhoe);


    }
    public void removeItem(int position){
        suckhoe_sach = new Suckhoe_sach();
        suckhoe_sach = suckhoe_saches.get(position);
        suckhoe_saches.remove(position);
        updatedata();
        suckhoeDAO.delete(suckhoe_sach);
    }
    public void addsachsuckhoe(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(SucKhoeActivity.this);
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
                    Toast.makeText(SucKhoeActivity.this, "Vui lòng nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    suckhoe_sach = new Suckhoe_sach(name, gioithieu, gia);
                    suckhoeDAO.insert(suckhoe_sach);
                    updatedata();
                    dialog.dismiss();
                    Toast.makeText(SucKhoeActivity.this, "Thêm sách thành công", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void updatedata(){
        suckhoe_saches.clear();
        suckhoe_saches.addAll(suckhoeDAO.getAlllist());
        adapter_suckhoe.notifyDataSetChanged();
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
