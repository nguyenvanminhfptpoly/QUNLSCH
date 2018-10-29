package com.example.admin88.qunlsch.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin88.qunlsch.R;
import com.example.admin88.qunlsch.Tablayout_adapter.Adapter_quanlysach_tablelayout;
import com.example.admin88.qunlsch.activity_theloai.AmthucActivity;
import com.example.admin88.qunlsch.activity_theloai.CNTTActivity;
import com.example.admin88.qunlsch.activity_theloai.KinhTeActivity;
import com.example.admin88.qunlsch.activity_theloai.NgoaiNguActivity;
import com.example.admin88.qunlsch.activity_theloai.SucKhoeActivity;
import com.example.admin88.qunlsch.adapter.Adapter_theloai;
import com.example.admin88.qunlsch.model.THeLoai;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_theloai extends Fragment {
    Adapter_theloai adapter_theloai;
    List<THeLoai> tHeLoais;
    ListView lv_danhsach;
    View v;

    public Fragment_theloai() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_theloai, container, false);
        tHeLoais = new ArrayList<>();
        lv_danhsach = v.findViewById(R.id.lv_item_theloai);
        tHeLoais.add(new THeLoai(R.drawable.ic_leak_add_black_24dp, "kinh tế"));
        tHeLoais.add(new THeLoai(R.drawable.ic_ngoaingu, "Ngoại Ngữ"));
        tHeLoais.add(new THeLoai(R.drawable.ic_cntt, "Công nghệ thông tin"));
        tHeLoais.add(new THeLoai(R.drawable.ic_toys_black_24dp, "Ẩm thực"));
        tHeLoais.add(new THeLoai(R.drawable.ic_wc_black_24dp, "Sức khỏe"));
        adapter_theloai = new Adapter_theloai(getContext(), R.layout.item_listview, tHeLoais);
        lv_danhsach.setAdapter(adapter_theloai);
        // Inflate the layout for this fragment
        //setonclicklisstview
        lv_danhsach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getActivity(), KinhTeActivity.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "Nhấn 2 lần để xóa sách", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Intent intent = new Intent(getActivity(), NgoaiNguActivity.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "Nhấn 2 lần để xóa sách", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Intent intent = new Intent(getActivity(), CNTTActivity.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "Nhấn 2 lần để xóa sách", Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    Intent intent = new Intent(getActivity(), AmthucActivity.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "Nhấn 2 lần để xóa sách", Toast.LENGTH_SHORT).show();
                } else if (position == 4) {
                    Intent intent = new Intent(getActivity(), SucKhoeActivity.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "Nhấn 2 lần để xóa sách", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }


}
