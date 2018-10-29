package com.example.admin88.qunlsch.model;

public class Hoadon {
    private String mahoadon,ngaymua;

    public Hoadon(String mahoadon, String ngaymua) {
        this.mahoadon = mahoadon;
        this.ngaymua = ngaymua;
    }

    public Hoadon() {
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }
}
