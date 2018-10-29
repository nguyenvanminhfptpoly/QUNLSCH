package com.example.admin88.qunlsch.model;

public class Amthuc_sach {
    private int id;
    private String mTieude,mGioithieu;
    private double gia;

    public Amthuc_sach(int id, String mTieude, String mGioithieu, double gia) {
        this.id = id;
        this.mTieude = mTieude;
        this.mGioithieu = mGioithieu;
        this.gia = gia;
    }

    public Amthuc_sach(String mTieude, String mGioithieu, double gia) {

        this.mTieude = mTieude;
        this.mGioithieu = mGioithieu;
        this.gia = gia;
    }



    public Amthuc_sach() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getmTieude() {
        return mTieude;
    }

    public void setmTieude(String mTieude) {
        this.mTieude = mTieude;
    }

    public String getmGioithieu() {
        return mGioithieu;
    }

    public void setmGioithieu(String mGioithieu) {
        this.mGioithieu = mGioithieu;
    }


}
