package com.example.admin88.qunlsch.SQlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBmanager extends SQLiteOpenHelper {
    private static final String DATABASENAME = "QUAN_LY_SACH";
    private static final String TABLE_USER = "USER";
    private static final String TABLE_KINHTE = "KINHTE";
    private static final String TABLE_NGOAINGU = "NGOAINGU";
    private static final String TABLE_CNTT = "CNTT";
    private static final String TABLE_AMTHUC = "AMTHUC";
    private static final String TABLE_SUCKHOE = "SUCKHOE";
    private static final String TABLE_HOADON = "HOADONDAO";
    private static final String TABLE_TONKHO = "TONKHO";
    private static final String ID = "ID";
    private static final String IDKT = "ID";
    private static final String IDNN = "ID";
    private static final String HO = "HO";
    private static final String NAME = "NAME";
    private static final String EMAIL = "EMAIL";
    private static final String PASS = "PASS";
    private static final String TV_KINHTE = "TV_KINHTE";
    private static final String TV_GIOITHIEUKINHTE = "TV_GIOITHIEUKINHTE";
    private static final String TV_GIA = "TV_GIA";

    public DBmanager(Context context) {
        super(context, DATABASENAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String User = "create table USER (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "HO TEXT," +
                "NAME TEXT," +
                "EMAIL TEXT," +
                "PASS TEXT)";
        db.execSQL(User);
        String kinhte = "create table KINHTE (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TV_KINHTE TEXT," +
                "TV_GIOITHIEUKINHTE TEXT," +
                "TV_GIA DOUBLE)";
        db.execSQL(kinhte);
        String ngoaingu = "create table NGOAINGU (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TV_NGOAINGU TEXT," +
                "TV_GIOITHIEUNGOAINGU TEXT," +
                "TV_GIA DOUBLE)";
        db.execSQL(ngoaingu);
        String cntt = "create table CNTT (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TV_CNTT TEXT," +
                "TV_GIOITHIEUCNTT TEXT," +
                "TV_GIA DOUBLE)";
        db.execSQL(cntt);
        String amthuc = "create table AMTHUC (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TV_AMTHUC TEXT," +
                "TV_GIOITHIEUAMTHUC TEXT," +
                "TV_GIA DOUBLE)";
        db.execSQL(amthuc);
        String suckhoe = "create table SUCKHOE (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TV_SUCKHOE TEXT," +
                "TV_GIOITHIEUSUCKHOE TEXT," +
                "TV_GIA DOUBLE)";
        db.execSQL(suckhoe);
        String tonkho = "create table TONKHO (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TV_TONKHO TEXT," +
                "TV_GIOITHIEUSACHTONKHO TEXT," +
                "TV_GIA DOUBLE)";
        db.execSQL(tonkho);
        String hoadon = "create table HOADONDAO (" +
                "MAHOADON TEXT PRIMARY KEY," +
                "NGAYMUA TEXT)";
        db.execSQL(hoadon);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_KINHTE);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NGOAINGU);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CNTT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_AMTHUC);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SUCKHOE);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_HOADON);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_TONKHO);

        onCreate(db);

    }
}
