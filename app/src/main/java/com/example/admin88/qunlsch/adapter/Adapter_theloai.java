package com.example.admin88.qunlsch.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin88.qunlsch.R;
import com.example.admin88.qunlsch.model.THeLoai;

import java.util.List;

public class Adapter_theloai extends ArrayAdapter<THeLoai> {

    private List<THeLoai> tHeLoais;
    private Context context;
    LayoutInflater inflater;
    public Adapter_theloai(@NonNull Context context, int resource, @NonNull List<THeLoai> objects) {
        super(context, resource, objects);
        this.tHeLoais = objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHodel hodel;
        if (convertView == null) {
            hodel = new ViewHodel();
            convertView = inflater.inflate(R.layout.item_listview, parent, false);
            hodel.img_avatar = convertView.findViewById(R.id.img_avatar);
            hodel.tv_theloai = convertView.findViewById(R.id.theloai);
            convertView.setTag(hodel);
        } else {
            hodel = (ViewHodel) convertView.getTag();
        }
        THeLoai tHeLoai = tHeLoais.get(position);
        hodel.tv_theloai.setText(tHeLoai.getTheloai());
        hodel.img_avatar.setImageResource(tHeLoai.getImg_avatar());

        return convertView;

    }

    public class ViewHodel{
        public TextView tv_theloai;
        public ImageView img_avatar;
    }
}
