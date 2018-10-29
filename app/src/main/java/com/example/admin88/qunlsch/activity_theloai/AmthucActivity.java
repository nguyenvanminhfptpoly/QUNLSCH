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
import com.example.admin88.qunlsch.SQlite.AmthucDAO;
import com.example.admin88.qunlsch.adapter.Adapter_AMTHUC;
import com.example.admin88.qunlsch.model.Amthuc_sach;
import com.example.admin88.qunlsch.model.CNTT_sach;

import java.util.List;

public class AmthucActivity extends AppCompatActivity {
    RecyclerView recyclerView_amthuc;
    Adapter_AMTHUC adapter_amthuc;
    List<Amthuc_sach> amthuc_saches;
    Amthuc_sach amthuc_sach;
    AmthucDAO amthucDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amthuc);
        amthucDAO = new AmthucDAO(AmthucActivity.this);
        recyclerView_amthuc = findViewById(R.id.recycler_view_amthuc);
        recyclerView_amthuc.setHasFixedSize(true);
        recyclerView_amthuc.setLayoutManager(new LinearLayoutManager(AmthucActivity.this));
        amthuc_saches = amthucDAO.getAlllist();
        adapter_amthuc = new Adapter_AMTHUC(amthuc_saches, AmthucActivity.this, new OnItemdeleteListener() {
            @Override
            public void onItemdelete(int position) {
                removeItem(position);
            }
        });
        recyclerView_amthuc.setAdapter(adapter_amthuc);
    }
    public void removeItem(int position){
        amthuc_sach = new Amthuc_sach();
        amthuc_sach = amthuc_saches.get(position);
        amthuc_saches.remove(position);
        updatedata();
        amthucDAO.delete(amthuc_sach);
    }
    public void addsachamthuc(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AmthucActivity.this);
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
                double gia = ParseDouble(ed_gia.getText().toString());

                if (name.isEmpty() && gioithieu.isEmpty() ) {
                    Toast.makeText(AmthucActivity.this, "Vui lòng nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                        amthuc_sach = new Amthuc_sach(name, gioithieu, gia);
                        amthucDAO.insert(amthuc_sach);
                        updatedata();
                        dialog.dismiss();
                        Toast.makeText(AmthucActivity.this, "Thêm sách thành công", Toast.LENGTH_SHORT).show();
                    }

            }
        });
    }
    public void updatedata(){
        amthuc_saches.clear();
        amthuc_saches.addAll(amthucDAO.getAlllist());
        adapter_amthuc.notifyDataSetChanged();
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
