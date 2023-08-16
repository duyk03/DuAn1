/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.model.HoaDon;
import com.raven.uitlities.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vha74
 */
public class HoaDonRepository {

    public List<HoaDon> getAll() {
        String query = "select maHD,maNV,tenNV,tenKH,maSp,tenXe,mauSac,xuatXu,donGia,soLuong,soTienGiam,tongTien,ngayThanhToan,trangThai,note from HOADON WHERE trangThai = 0";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> listhd = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getLong(9), rs.getInt(10), rs.getLong(11), rs.getLong(12), rs.getString(13), rs.getInt(14), rs.getString(15));
                listhd.add(hd);
            }
            return listhd;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getSearchTrangThai(int trangThai) {
        String query = "select maHD,maNV,tenNV,tenKH,maSp,tenXe,mauSac,xuatXu,donGia,soLuong,soTienGiam,tongTien,ngayThanhToan,trangThai,note from HOADON where trangThai = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, trangThai);
            ResultSet rs = ps.executeQuery();
            ArrayList<HoaDon> listHD = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getLong(9), rs.getInt(10), rs.getLong(11), rs.getLong(12), rs.getString(13), rs.getInt(14), rs.getString(15));
                listHD.add(hd);
            }
            return listHD;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getSearchThoiGian(String ngayThanhToan) {
        String query = "select maHD,maNV,tenNV,tenKH,maSp,tenXe,mauSac,xuatXu,donGia,soLuong,soTienGiam,tongTien,ngayThanhToan,trangThai,note from HOADON where ngayThanhToan = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ngayThanhToan);
            ResultSet rs = ps.executeQuery();
            ArrayList<HoaDon> listHD = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getLong(9), rs.getInt(10), rs.getLong(11), rs.getLong(12), rs.getString(13), rs.getInt(14), rs.getString(15));
                listHD.add(hd);
            }
            return listHD;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDon> getOneSP(String ma) {
        String query = "select maHD,maNV,tenNV,tenKH,maSp,tenXe,mauSac,xuatXu,donGia,soLuong,soTienGiam,tongTien,ngayThanhToan,trangThai,note from HOADON where maHD = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            ArrayList<HoaDon> listHD = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getLong(9), rs.getInt(10), rs.getLong(11), rs.getLong(12), rs.getString(13), rs.getInt(14), rs.getString(15));
                listHD.add(hd);
            }
            return listHD;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean delete(String ma) {
        String query = "delete from HoaDon where maHD = ?";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
    
      public List<HoaDon> sum() {
        String query = "SELECT COUNT(trangThai)\n"
                + "  FROM HOADON WHERE trangThai = 1";
        try ( Connection con = DBConnect.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> listhd = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getInt(1));
                listhd.add(hd);
            }
            return listhd;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
      
      public static void main(String[] args) {
        List<HoaDon> lisst = new HoaDonRepository().sum();
        for (HoaDon x : lisst) {
            System.out.println(x.toString());
        }
    }

}
