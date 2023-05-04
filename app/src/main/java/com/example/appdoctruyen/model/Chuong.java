package com.example.appdoctruyen.model;

import java.io.Serializable;

public class Chuong implements Serializable {
    private int id;
    private int idTruyen;
    private int soThuTu;
    private String ten;
    private String noiDung;

    public Chuong() {
    }

    public Chuong(int id, int idTruyen, int soThuTu, String ten, String noiDung) {
        this.id = id;
        this.idTruyen = idTruyen;
        this.soThuTu = soThuTu;
        this.ten = ten;
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

    public int getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
