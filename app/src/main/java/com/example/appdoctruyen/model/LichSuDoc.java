package com.example.appdoctruyen.model;

import java.util.Date;

public class LichSuDoc {
    private int id;
    private String tenNguoiDung;
    private int idTruyen;
    private String tenTruyen;
    private String tenChapter;
    private int chapterNumber;
    private String readTime;
    private String image;

    public LichSuDoc(int id, String tenNguoiDung, int idTruyen, String tenTruyen, String tenChapter, int chapterNumber, String readTime, String image) {
        this.id = id;
        this.tenNguoiDung = tenNguoiDung;
        this.idTruyen = idTruyen;
        this.tenTruyen = tenTruyen;
        this.tenChapter = tenChapter;
        this.chapterNumber = chapterNumber;
        this.readTime = readTime;
        this.image = image;
    }

    public LichSuDoc(String tenNguoiDung, int idTruyen, String tenTruyen, String tenChapter, int chapterNumber, String readTime, String image) {
        this.tenNguoiDung = tenNguoiDung;
        this.idTruyen = idTruyen;
        this.tenTruyen = tenTruyen;
        this.tenChapter = tenChapter;
        this.chapterNumber = chapterNumber;
        this.readTime = readTime;
        this.image = image;
    }

    public LichSuDoc() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public int getIdTruyen() {
        return idTruyen;
    }

    public void setIdTruyen(int idTruyen) {
        this.idTruyen = idTruyen;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getTenChapter() {
        return tenChapter;
    }

    public void setTenChapter(String tenChapter) {
        this.tenChapter = tenChapter;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getReadTime() {
        return readTime;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
