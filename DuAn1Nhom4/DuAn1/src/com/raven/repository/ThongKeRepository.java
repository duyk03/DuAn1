/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.model.ThongKe;
import com.raven.model.ThongKe;
import com.raven.model.ThongKeDoanhThu;
import com.raven.model.ThongKeDoanhThu;
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
public class ThongKeRepository {

    public List<ThongKe> getAll() {
        String query = "select maSp,tenXe,donGia,sum(soLuong),sum(tongTien) from HOADON group by maSp,tenXe,donGia";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<ThongKe> listtk = new ArrayList<>();
            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getLong(4), rs.getLong(5));
                listtk.add(tk);
            }
            return listtk;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ThongKe> getAllDT() {
        String query = "select maSp,tenXe,donGia,sum(soLuong),sum(tongTien) from HOADON group by maSp,tenXe,donGia order by sum(tongTien) desc";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<ThongKe> listtk = new ArrayList<>();
            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getLong(4), rs.getLong(5));
                listtk.add(tk);
            }
            return listtk;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ThongKe> getAllSL() {
        String query = "select maSp,tenXe,donGia,sum(soLuong),sum(tongTien) from HOADON group by maSp,tenXe,donGia order by sum(soLuong) desc";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<ThongKe> listtk = new ArrayList<>();
            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getLong(4), rs.getLong(5));
                listtk.add(tk);
            }
            return listtk;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ThongKeDoanhThu> getAllThoiGian() {
        String query = "select ngayThanhToan,sum(tongTien),count(id) from HOADON where trangThai=1 group by ngayThanhToan";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<ThongKeDoanhThu> listtk = new ArrayList<>();
            while (rs.next()) {
                ThongKeDoanhThu tk = new ThongKeDoanhThu(rs.getString(1), rs.getLong(2), rs.getLong(3));
                listtk.add(tk);
            }
            return listtk;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ThongKeDoanhThu> getAllThoiGianSX() {
        String query = "select ngayThanhToan,sum(tongTien),count(id) from HOADON where trangThai=1 group by ngayThanhToan order by ngayThanhToan desc";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<ThongKeDoanhThu> listtk = new ArrayList<>();
            while (rs.next()) {
                ThongKeDoanhThu tk = new ThongKeDoanhThu(rs.getString(1), rs.getLong(2), rs.getLong(3));
                listtk.add(tk);
            }
            return listtk;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ThongKeDoanhThu> sreachThoiGian(String ngayBatDau, String ngayKetThuc) {
        String query = "select ngayThanhToan,sum(tongTien),count(id) from HOADON where trangThai=1 and ?<=ngayThanhToan and ngayThanhToan<=? group by ngayThanhToan";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ngayBatDau);
            ps.setObject(2, ngayKetThuc);
            ResultSet rs = ps.executeQuery();
            List<ThongKeDoanhThu> listtk = new ArrayList<>();
            while (rs.next()) {
                ThongKeDoanhThu tk = new ThongKeDoanhThu(rs.getString(1), rs.getLong(2), rs.getLong(3));
                listtk.add(tk);
            }
            return listtk;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<ThongKeDoanhThu> namTK() {
        String query = "select year(ngaythanhtoan) from HOADON group by year(ngayThanhToan)";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<ThongKeDoanhThu> listtk = new ArrayList<>();
            while (rs.next()) {
                ThongKeDoanhThu tk = new ThongKeDoanhThu(rs.getLong(1));
                listtk.add(tk);
            }
            return listtk;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public ThongKeDoanhThu getDoanhThuNam(String nam) {
        String query = "select year(ngaythanhtoan) ,sum(tongTien) ,sum(tongTien)/12 ,"
                + "(select top 1 month(ngayThanhToan) from HOADON where year(ngaythanhtoan) =? group by month(ngayThanhToan) order by sum(tongTien) desc ) "
                + ",(select top 1 month(ngayThanhToan) from HOADON where year(ngaythanhtoan) =? group by month(ngayThanhToan) order by sum(tongTien) asc ) "
                + ",(select top 1 sum(tongTien) from HOADON where year(ngaythanhtoan) =? group by month(ngayThanhToan) order by sum(tongTien) asc )"
                + ",(select top 1 sum(tongTien) from HOADON where year(ngaythanhtoan) =? group by month(ngayThanhToan) order by sum(tongTien) desc )"
                + " from HOADON where year(ngaythanhtoan) =? group by year(ngayThanhToan)";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, nam);
            ps.setObject(2, nam);
            ps.setObject(3, nam);
            ps.setObject(4, nam);
            ps.setObject(5, nam);
            ResultSet rs = ps.executeQuery();
            ThongKeDoanhThu listtk = new ThongKeDoanhThu();
            while (rs.next()) {
                listtk = new ThongKeDoanhThu(rs.getLong(2), rs.getLong(3), rs.getLong(4), rs.getLong(5), rs.getLong(7), rs.getLong(6), rs.getLong(1));

            }
            return listtk;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        List<ThongKe> lisst = new ThongKeRepository().getAll();
        for (ThongKe x : lisst) {
            System.out.println(x.toString());
        }
    }
}
