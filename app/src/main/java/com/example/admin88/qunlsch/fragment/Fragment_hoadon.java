package com.example.admin88.qunlsch.fragment;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.admin88.qunlsch.OnItemdeleteListener;
import com.example.admin88.qunlsch.R;
import com.example.admin88.qunlsch.SQlite.HoadonDAO;
import com.example.admin88.qunlsch.adapter.Adapter_Hoadon;
import com.example.admin88.qunlsch.model.Hoadon;

import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_hoadon extends Fragment {
    Adapter_Hoadon adapter_hoadon;
    List<Hoadon>  hoadons;
    HoadonDAO hoadonDAO;
    Hoadon hoadon;
    RecyclerView recyclerView;

    FloatingActionButton button;
    private int mYear, mMonth, mDay;
    public Fragment_hoadon() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hoadon, container, false);

        recyclerView = v.findViewById(R.id.recycler_view_hoadon);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        hoadonDAO = new HoadonDAO(getActivity());
        hoadons = hoadonDAO.getAlldata();
        adapter_hoadon = new Adapter_Hoadon(hoadons, getActivity(), new OnItemdeleteListener() {
            @Override
            public void onItemdelete(int position) {
                removeItem(position);
            }
        });
        recyclerView.setAdapter(adapter_hoadon);
        button = v.findViewById(R.id.fab);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View view = getLayoutInflater().inflate(R.layout.dialog_hoadon,null);
                final Button button = view.findViewById(R.id.btn_date);
                final Button btn_confim  = view.findViewById(R.id.btn_confim);
                final EditText ed_mahoadon = view.findViewById(R.id.ed_mahoadon);
                final EditText ed_ngaymua = view.findViewById(R.id.ed_ngaymua);
                builder.setView(view);
                final Dialog dialog = builder.create();
                dialog.show();

                btn_confim.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String mahoadon = ed_mahoadon.getText().toString();
                        String ngaymua = ed_ngaymua.getText().toString();
                        if (mahoadon.equals("") && ngaymua.equals("")){
                            Toast.makeText(getActivity(), "Nhap du du lieu", Toast.LENGTH_SHORT).show();
                        }else {
                            hoadon = new Hoadon(mahoadon,ngaymua);
                            hoadonDAO.insert(hoadon);
                            dialog.dismiss();
                            updatedata();
                            Toast.makeText(getActivity(), "Them thanh cong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (v == button) {

                            // Get Current Date
                            final Calendar c = Calendar.getInstance();
                            mYear = c.get(Calendar.YEAR);
                            mMonth = c.get(Calendar.MONTH);
                            mDay = c.get(Calendar.DAY_OF_MONTH);


                            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                                    new DatePickerDialog.OnDateSetListener() {

                                        @Override
                                        public void onDateSet(DatePicker view, int year,
                                                              int monthOfYear, int dayOfMonth) {

                                            ed_ngaymua.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                        }
                                    }, mYear, mMonth, mDay);
                            datePickerDialog.show();

                        }
                    }
                });
            }
        });
        return v;
    }
    public void updatedata(){
        hoadons.clear();
        hoadons.addAll(hoadonDAO.getAlldata());
        adapter_hoadon.notifyDataSetChanged();
    }
    public void removeItem(int position){
        hoadon = new Hoadon();
        hoadon = hoadons.get(position);
        hoadons.remove(position);
        updatedata();
        hoadonDAO.delete(hoadon);
    }
}
