package com.example.admin88.qunlsch.SQlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin88.qunlsch.model.Amthuc_sach;
import com.example.admin88.qunlsch.model.Tonkho_sach;

import java.util.ArrayList;
import java.util.List;

public class TonKhoDAO {
    private SQLiteDatabase db;
    private Tonkho_sach amthuc_sach;

    public TonKhoDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }
    public long insert(Tonkho_sach amthuc_sach){
        ContentValues values = new ContentValues();
        values.put("TV_TONKHO", amthuc_sach.getmTieude());
        values.put("TV_GIOITHIEUSACHTONKHO", amthuc_sach.getmGioithieu());
        values.put("TV_GIA", amthuc_sach.getGia());
        return db.insert("TONKHO",null,values);
    }
    public List<Tonkho_sach> getAlllist(){
        List<Tonkho_sach> list = new ArrayList<>();
        String sql = "select * from TONKHO ";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String tieude = cursor.getString(cursor.getColumnIndex("TV_TONKHO"));
            String gioithieu = cursor.getString(cursor.getColumnIndex("TV_GIOITHIEUSACHTONKHO"));
            double gia = cursor.getDouble(cursor.getColumnIndex("TV_GIA"));
            list.add(new Tonkho_sach(id,tieude,gioithieu,gia));
        }
        return list;
    }
    public int delete(Tonkho_sach amthuc_sach){
        return db.delete("TONKHO","ID=?",new String[]{amthuc_sach.getId()+""});
    }
}
