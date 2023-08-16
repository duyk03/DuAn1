/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author vha74
 */
public class ThongKe {

    private String maSP;
    private String tenSP;
    private int namSX;
    private int soLuonTon;
    private long giaBan;
    private long soLuongBan;
    private long tongTien;

    public ThongKe() {
    }

    public ThongKe(String maSP, String tenSP, long giaBan, long soLuongBan, long tongTien) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.soLuongBan = soLuongBan;
        this.tongTien = tongTien;
    }



    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public int getSoLuonTon() {
        return soLuonTon;
    }

    public void setSoLuonTon(int soLuonTon) {
        this.soLuonTon = soLuonTon;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    public long getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(long soLuongBan) {
        this.soLuongBan = soLuongBan;
    }
}
