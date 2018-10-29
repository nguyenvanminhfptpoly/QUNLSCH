package com.example.admin88.qunlsch.SQlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin88.qunlsch.model.Amthuc_sach;
import com.example.admin88.qunlsch.model.Suckhoe_sach;

import java.util.ArrayList;
import java.util.List;

public class SuckhoeDAO {
    private SQLiteDatabase db;
    private Suckhoe_sach suckhoe_sach;

    public SuckhoeDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }
    public long insert(Suckhoe_sach suckhoe_sach){
        ContentValues values = new ContentValues();
        values.put("TV_SUCKHOE", suckhoe_sach.getmTieude());
        values.put("TV_GIOITHIEUSUCKHOE", suckhoe_sach.getmGioithieu());
        values.put("TV_GIA", suckhoe_sach.getGia());
        return db.insert("SUCKHOE",null,values);
    }
    public List<Suckhoe_sach> getAlllist(){
        List<Suckhoe_sach> list = new ArrayList<>();
        String sql = "select * from SUCKHOE ";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String tieude = cursor.getString(cursor.getColumnIndex("TV_SUCKHOE"));
            String gioithieu = cursor.getString(cursor.getColumnIndex("TV_GIOITHIEUSUCKHOE"));
            double gia = cursor.getDouble(cursor.getColumnIndex("TV_GIA"));
            list.add(new Suckhoe_sach(id,tieude,gioithieu,gia));
        }
        return list;
    }
    public int delete(Suckhoe_sach suckhoe_sach){
        return db.delete("SUCKHOE","ID=?",new String[]{suckhoe_sach.getId()+""});
    }
}
