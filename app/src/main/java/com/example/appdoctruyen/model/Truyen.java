package com.example.appdoctruyen.model;

import java.io.Serializable;

public class Truyen implements Serializable {
    private int id;
    private String ten;
    private String tacGia;
    private String theLoai;
    private int soChuong;
    private String noiDung, image;

    public Truyen() {
    }

    public Truyen(int id, String ten, String tacGia, String theLoai, int soChuong, String noiDung, String image) {
        this.id = id;
        this.ten = ten;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.soChuong = soChuong;
        this.noiDung = noiDung;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getSoChuong() {
        return soChuong;
    }

    public void setSoChuong(int soChuong) {
        this.soChuong = soChuong;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
}
