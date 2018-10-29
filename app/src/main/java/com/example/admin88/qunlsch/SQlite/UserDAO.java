package com.example.admin88.qunlsch.SQlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin88.qunlsch.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private SQLiteDatabase db;
    private User user;

    public UserDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }
    public long insert(User user){
        ContentValues values = new ContentValues();
        values.put("HO",user.getmHo());
        values.put("NAME",user.getmName());
        values.put("EMAIL",user.getmEmail());
        values.put("PASS",user.getmPass());
        return db.insert("USER",null,values);
    }
    public List<User> getAlldata(){
        List<User> list = new ArrayList<>();
        String sql = "select * from USER";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String ho = cursor.getString(cursor.getColumnIndex("HO"));
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            String email = cursor.getString(cursor.getColumnIndex("EMAIL"));
            String pass = cursor.getString(cursor.getColumnIndex("PASS"));
            list.add(new User(id,ho,name,email,pass));

        }
        return list;
    }
    public int uplate(User user){
        ContentValues values = new ContentValues();
        values.put("HO",user.getmHo());
        values.put("NAME",user.getmName());
        values.put("EMAIL",user.getmEmail());
        values.put("PASS",user.getmPass());
        return db.update("USER",values,"ID=?",new String[]{user.getId()+""});
    }
    public int delete(User user){
        return db.delete("USER","ID=?",new String[]{user.getId()+""});
    }
}
