package com.example.admin88.qunlsch.SQlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin88.qunlsch.model.KinhTe_sach;
import com.example.admin88.qunlsch.model.Ngoaingu_sach;

import java.util.ArrayList;
import java.util.List;

public class NgoainguDAO {
    private SQLiteDatabase db;
    private Ngoaingu_sach ngoaingu_sach;

    public NgoainguDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }
    public long insert(Ngoaingu_sach ngoaingu_sach){
        ContentValues values = new ContentValues();
        values.put("TV_NGOAINGU", ngoaingu_sach.getmTieude());
        values.put("TV_GIOITHIEUNGOAINGU", ngoaingu_sach.getmGioithieu());
        values.put("TV_GIA", ngoaingu_sach.getGia());
        return db.insert("NGOAINGU",null,values);
    }
    public List<Ngoaingu_sach> getAlllist(){
        List<Ngoaingu_sach> list = new ArrayList<>();
        String sql = "select * from NGOAINGU ";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String tieude = cursor.getString(cursor.getColumnIndex("TV_NGOAINGU"));
            String gioithieu = cursor.getString(cursor.getColumnIndex("TV_GIOITHIEUNGOAINGU"));
            double gia = cursor.getDouble(cursor.getColumnIndex("TV_GIA"));
            list.add(new Ngoaingu_sach(id,tieude,gioithieu,gia));
        }
        return list;
    }
    public int delete(Ngoaingu_sach ngoaingu_sach){
        return db.delete("NGOAINGU","ID=?",new String[]{ngoaingu_sach.getId()+""});
    }
}
