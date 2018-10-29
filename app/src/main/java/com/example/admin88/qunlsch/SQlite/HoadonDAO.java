package com.example.admin88.qunlsch.SQlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin88.qunlsch.model.Hoadon;

import java.util.ArrayList;
import java.util.List;

public class HoadonDAO {
    private SQLiteDatabase db;
    private Hoadon hoaDon;

    public HoadonDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }
    public long insert(Hoadon hoaDon){
        ContentValues values = new ContentValues();
        values.put("MAHOADON",hoaDon.getMahoadon());
        values.put("NGAYMUA",hoaDon.getNgaymua());
        return db.insert("HOADONDAO",null,values);
    }
    public List<Hoadon> getAlldata(){
        List<Hoadon> list = new ArrayList<>();
        String sql = "select * from HOADONDAO ";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            String mahoadon = cursor.getString(cursor.getColumnIndex("MAHOADON"));
            String ngaymua = cursor.getString(cursor.getColumnIndex("NGAYMUA"));
            list.add(new Hoadon(mahoadon,ngaymua));
        }
        return list;
    }
    public int delete(Hoadon hoadon){
        return db.delete("HOADONDAO","MAHOADON=?",new String[]{hoadon.getMahoadon()});
    }
}
