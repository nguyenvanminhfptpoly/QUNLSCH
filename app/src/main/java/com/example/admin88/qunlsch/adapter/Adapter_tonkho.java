package com.example.admin88.qunlsch.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin88.qunlsch.OnItemdeleteListener;
import com.example.admin88.qunlsch.R;
import com.example.admin88.qunlsch.model.Amthuc_sach;
import com.example.admin88.qunlsch.model.Tonkho_sach;

import java.util.List;

public class Adapter_tonkho extends RecyclerView.Adapter<Adapter_tonkho.Viewhodel> {
    private List<Tonkho_sach> amthuc_saches;
    private Context context;
    private OnItemdeleteListener listener;


    public Adapter_tonkho(List<Tonkho_sach> kinhTe_saches, Context context, OnItemdeleteListener listener) {
        this.amthuc_saches = kinhTe_saches;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Viewhodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v_kinhte = LayoutInflater.from(context).inflate(R.layout.item_sach_tonkho,parent,false);
        return new Viewhodel(v_kinhte, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhodel holder, final int position) {
        holder.tv_tieude.setText(amthuc_saches.get(position).getmTieude());
        holder.tv_gioithieu.setText(amthuc_saches.get(position).getmGioithieu());
        holder.tv_gia.setText(amthuc_saches.get(position).getGia()+"");
        holder.img_delete_amthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemdelete(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return amthuc_saches.size();
    }

    public static class Viewhodel extends RecyclerView.ViewHolder{
    public ImageView img_kinhte,img_delete_amthuc;
    public TextView tv_tieude,tv_gioithieu,tv_gia;
        public Viewhodel(View itemView, OnItemdeleteListener listener1) {
            super(itemView);
            img_kinhte = itemView.findViewById(R.id.img_tonkho);
            tv_gia = itemView.findViewById(R.id.tv_gia);
            tv_gioithieu = itemView.findViewById(R.id.tv_gioithieu_tonkho);
            tv_tieude = itemView.findViewById(R.id.tv_tonkho);
            img_delete_amthuc = itemView.findViewById(R.id.img_delete_tonkho);
        }
    }
}
