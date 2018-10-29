package com.example.admin88.qunlsch.SQlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin88.qunlsch.model.KinhTe_sach;

import java.util.ArrayList;
import java.util.List;

public class KinhTeDAO {
    private SQLiteDatabase db;
    private KinhTe_sach kinhTe_sach;

    public KinhTeDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }
    public long insert(KinhTe_sach kinhTe_sach){
        ContentValues values = new ContentValues();
        values.put("TV_KINHTE", kinhTe_sach.getmTieude());
        values.put("TV_GIOITHIEUKINHTE", kinhTe_sach.getmGioithieu());
        values.put("TV_GIA", kinhTe_sach.getGia());
        return db.insert("KINHTE",null,values);
    }
    public List<KinhTe_sach> getAlllist(){
        List<KinhTe_sach> list = new ArrayList<>();
        String sql = "select * from KINHTE ";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String tieude = cursor.getString(cursor.getColumnIndex("TV_KINHTE"));
            String gioithieu = cursor.getString(cursor.getColumnIndex("TV_GIOITHIEUKINHTE"));
            double gia = cursor.getDouble(cursor.getColumnIndex("TV_GIA"));
            list.add(new KinhTe_sach(id,tieude,gioithieu,gia));
        }
        return list;
    }
    public int delete(KinhTe_sach kinhTe_sach){
        return db.delete("KINHTE","ID=?",new String[]{kinhTe_sach.getId()+""});
    }
}
