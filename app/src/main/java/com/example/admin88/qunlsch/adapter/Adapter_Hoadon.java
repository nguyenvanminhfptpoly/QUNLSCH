package com.example.admin88.qunlsch.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin88.qunlsch.OnItemdeleteListener;
import com.example.admin88.qunlsch.R;
import com.example.admin88.qunlsch.model.Hoadon;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Hoadon extends RecyclerView.Adapter<Adapter_Hoadon.Viewhodel> {
    private List<Hoadon> hoadons;
    private Context context;
    private OnItemdeleteListener listener;

    public Adapter_Hoadon(List<Hoadon> hoadons, Context context,OnItemdeleteListener listener3) {
        this.hoadons = hoadons;
        this.context = context;
        this.listener = listener3;
    }

    @NonNull
    @Override
    public Viewhodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_hoadon,parent,false);
        return new Viewhodel(v,listener);
    }
    public void setonItemDeleteListener(OnItemdeleteListener listener2){
        listener2 = listener;
    }
    @Override
    public void onBindViewHolder(@NonNull Viewhodel holder, final int position) {
        holder.tv_ngaymua.setText(hoadons.get(position).getNgaymua());
        holder.tv_mahoadon.setText(hoadons.get(position).getMahoadon());
        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemdelete(position);
                Toast.makeText(context, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void setFillter(List<Hoadon> filter){
        hoadons = new ArrayList<>();
        hoadons.addAll(filter);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return hoadons.size();
    }

    public static class Viewhodel extends RecyclerView.ViewHolder{
    public TextView tv_mahoadon,tv_ngaymua;
    public ImageView img_delete;
        public Viewhodel(View itemView, OnItemdeleteListener listener1) {
            super(itemView);
            tv_mahoadon = itemView.findViewById(R.id.tv_mahoadon);
            tv_ngaymua = itemView.findViewById(R.id.tv_ngaymua);
            img_delete = itemView.findViewById(R.id.img_delete);
        }
    }
}
