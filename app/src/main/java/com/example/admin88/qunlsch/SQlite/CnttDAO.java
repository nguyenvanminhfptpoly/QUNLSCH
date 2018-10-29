package com.example.admin88.qunlsch.SQlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin88.qunlsch.model.CNTT_sach;
import com.example.admin88.qunlsch.model.KinhTe_sach;

import java.util.ArrayList;
import java.util.List;

public class CnttDAO {
    private SQLiteDatabase db;
    private CNTT_sach cntt_sach;

    public CnttDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }
    public long insert(CNTT_sach cntt_sach){
        ContentValues values = new ContentValues();
        values.put("TV_CNTT", cntt_sach.getmTieude());
        values.put("TV_GIOITHIEUCNTT", cntt_sach.getmGioithieu());
        values.put("TV_GIA", cntt_sach.getGia());
        return db.insert("CNTT",null,values);
    }
    public List<CNTT_sach> getAlllist(){
        List<CNTT_sach> list = new ArrayList<>();
        String sql = "select * from CNTT ";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String tieude = cursor.getString(cursor.getColumnIndex("TV_CNTT"));
            String gioithieu = cursor.getString(cursor.getColumnIndex("TV_GIOITHIEUCNTT"));
            double gia = cursor.getDouble(cursor.getColumnIndex("TV_GIA"));
            list.add(new CNTT_sach(id,tieude,gioithieu,gia));
        }
        return list;
    }
    public int delete(CNTT_sach cntt_sach){
        return db.delete("CNTT","ID=?",new String[]{cntt_sach.getId()+""});
    }
}
