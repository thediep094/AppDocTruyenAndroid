package com.example.appdoctruyen.model;

import java.io.Serializable;

public class BinhLuan implements Serializable {
    private int id;
    private int idTruyen;
    private String tenNguoiDung;
    private String noiDung;

    public BinhLuan() {
    }

    public BinhLuan(int idTruyen, String tenNguoiDung, String noiDung) {
        this.idTruyen = idTruyen;
        this.tenNguoiDung = tenNguoiDung;
        this.noiDung = noiDung;
    }

    public BinhLuan(int id, int idTruyen, String tenNguoiDung, String noiDung) {
        this.id = id;
        this.idTruyen = idTruyen;
        this.tenNguoiDung = tenNguoiDung;
        this.noiDung = noiDung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTruyen() {
        return idTruyen;
    }

    public void setIdTruyen(int idTruyen) {
        this.idTruyen = idTruyen;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
