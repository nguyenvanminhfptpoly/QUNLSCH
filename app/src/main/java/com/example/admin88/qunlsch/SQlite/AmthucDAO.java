package com.example.admin88.qunlsch.SQlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin88.qunlsch.model.Amthuc_sach;
import com.example.admin88.qunlsch.model.KinhTe_sach;

import java.util.ArrayList;
import java.util.List;

public class AmthucDAO {
    private SQLiteDatabase db;
    private Amthuc_sach amthuc_sach;

    public AmthucDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }
    public long insert(Amthuc_sach amthuc_sach){
        ContentValues values = new ContentValues();
        values.put("TV_AMTHUC", amthuc_sach.getmTieude());
        values.put("TV_GIOITHIEUAMTHUC", amthuc_sach.getmGioithieu());
        values.put("TV_GIA", amthuc_sach.getGia());
        return db.insert("AMTHUC",null,values);
    }
    public List<Amthuc_sach> getAlllist(){
        List<Amthuc_sach> list = new ArrayList<>();
        String sql = "select * from AMTHUC ";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String tieude = cursor.getString(cursor.getColumnIndex("TV_AMTHUC"));
            String gioithieu = cursor.getString(cursor.getColumnIndex("TV_GIOITHIEUAMTHUC"));
            double gia = cursor.getDouble(cursor.getColumnIndex("TV_GIA"));
            list.add(new Amthuc_sach(id,tieude,gioithieu,gia));
        }
        return list;
    }
    public int delete(Amthuc_sach amthuc_sach){
        return db.delete("AMTHUC","ID=?",new String[]{amthuc_sach.getId()+""});
    }
}
