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
import com.example.admin88.qunlsch.SQlite.CnttDAO;
import com.example.admin88.qunlsch.adapter.Adapter_CNTT;
import com.example.admin88.qunlsch.model.CNTT_sach;
import com.example.admin88.qunlsch.model.KinhTe_sach;

import java.util.List;

public class CNTTActivity extends AppCompatActivity {
    RecyclerView recyclerView_cntt;
    Adapter_CNTT adapter_cntt;
    List<CNTT_sach> cntt_saches;
    CnttDAO cnttDAO;
    CNTT_sach cntt_sach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cntt);
        recyclerView_cntt = findViewById(R.id.recycler_view_cntt);
        recyclerView_cntt.setLayoutManager(new LinearLayoutManager(CNTTActivity.this));
        recyclerView_cntt.setHasFixedSize(true);
        cnttDAO = new CnttDAO(CNTTActivity.this);
        cntt_saches = cnttDAO.getAlllist();
        adapter_cntt = new Adapter_CNTT(cntt_saches, CNTTActivity.this, new OnItemdeleteListener() {
            @Override
            public void onItemdelete(int position) {

            }
        });
        recyclerView_cntt.setAdapter(adapter_cntt);
    }
    public void removeItem(int position){
        cntt_sach = new CNTT_sach();
        cntt_sach = cntt_saches.get(position);
        cntt_saches.remove(position);
        updatedata();
        cnttDAO.delete(cntt_sach);
    }
    public void addsachcntt(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(CNTTActivity.this);
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
                    Toast.makeText(CNTTActivity.this, "Vui lòng nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                } else {
                    cntt_sach = new CNTT_sach(name, gioithieu, gia);
                    cnttDAO.insert(cntt_sach);
                    updatedata();
                    dialog.dismiss();
                    Toast.makeText(CNTTActivity.this, "Thêm sách thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void updatedata(){
        cntt_saches.clear();
        cntt_saches.addAll(cnttDAO.getAlllist());
        adapter_cntt.notifyDataSetChanged();
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
