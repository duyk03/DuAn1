/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.util.Date;

/**
 *
 * @author vha74
 */
public class HoaDon {
    private String maHD;
    private String maNV;
    private String tenNV;
    private String tenKH;
    private String maSP;
    private String tenXe;
    private String mauSac;
    private String xuatXu;
    private long donGia;
    private int soLuong;
    private long soTienGiam;
    private long tongTien;
    private String ngayTao;
    private String ngayThanhToan;
    private int trangThai;
    private String note;

    public HoaDon() {
    }

    public HoaDon(String maHD, String maNV, String tenNV, String tenKH, String maSP, String tenXe, String mauSac, String xuatXu, long donGia, int soLuong, long soTienGiam, long tongTien, String ngayThanhToan, int trangThai, String note) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.maSP = maSP;
        this.tenXe = tenXe;
        this.mauSac = mauSac;
        this.xuatXu = xuatXu;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.soTienGiam = soTienGiam;
        this.tongTien = tongTien;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
        this.note = note;
    }

    public HoaDon(int trangThai) {
        this.trangThai = trangThai;
    }
    
    

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public long getSoTienGiam() {
        return soTienGiam;
    }

    public void setSoTienGiam(long soTienGiam) {
        this.soTienGiam = soTienGiam;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
    

    @Override
    public String toString() {
        return trangThai + "";
    }

    public Object getIdNhanVien() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getIdHTTT() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getIdKhachHang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getMa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
   
    
}
