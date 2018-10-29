package com.example.admin88.qunlsch.model;

public class THeLoai {
    private int img_avatar;
    private String theloai;

    public THeLoai(int img_avatar, String theloai) {
        this.img_avatar = img_avatar;
        this.theloai = theloai;
    }

    public THeLoai() {
    }

    public int getImg_avatar() {
        return img_avatar;
    }

    public void setImg_avatar(int img_avatar) {
        this.img_avatar = img_avatar;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }
}
