package com.example.admin88.qunlsch.model;

public class User {
    private int id;
    private String mHo,mName,mPass,mEmail;

    public User(int id,String mHo, String mName, String mPass, String mEmail) {
        this.id=id;
        this.mHo = mHo;
        this.mName = mName;
        this.mPass = mPass;
        this.mEmail = mEmail;
    }

    public User(String mHo, String mName, String mPass, String mEmail) {
        this.mHo = mHo;
        this.mName = mName;
        this.mPass = mPass;
        this.mEmail = mEmail;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmHo() {
        return mHo;
    }

    public void setmHo(String mHo) {
        this.mHo = mHo;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPass() {
        return mPass;
    }

    public void setmPass(String mPass) {
        this.mPass = mPass;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}
