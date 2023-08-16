 
package com.raven.model;

 
public class ThongKeDoanhThu {

    
    private String thoiGian;
    private Long doanhThu;
    private Long tongDoanhThu;
    private Long doanhThuThangNhieu;
    private Long doanhThuThangIt;
    private Long  soHoaDon, tbDoanhThu, thangNhieu, thangIt, nam;

    
    public ThongKeDoanhThu(String thoiGian, long doanhThu, Long soHoaDon) {
        this.thoiGian = thoiGian;
        this.doanhThu = doanhThu;
        this.soHoaDon = soHoaDon;
    }
    
    

    public ThongKeDoanhThu(Long nam) {
        this.nam = nam;
    }

    public ThongKeDoanhThu(Long tongDoanhThu, Long tbDoanhThu, Long thangNhieu, Long thangIt, Long doanhThuThangNhieu, Long doanhThuThangIt, Long nam) {
        this.tongDoanhThu = tongDoanhThu;
        this.tbDoanhThu = tbDoanhThu;
        this.thangNhieu = thangNhieu;
        this.thangIt = thangIt;
        this.doanhThuThangNhieu = doanhThuThangNhieu;
        this.doanhThuThangIt = doanhThuThangIt;
        this.nam = nam;
    }

    public ThongKeDoanhThu() {
    }

    public Long getNam() {
        return nam;
    }

    public void setNam(Long nam) {
        this.nam = nam;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Long getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(Long doanhThu) {
        this.doanhThu = doanhThu;
    }

    public Long getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(Long soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public Long getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(Long tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }

    public Long getTbDoanhThu() {
        return tbDoanhThu;
    }

    public void setTbDoanhThu(Long tbDoanhThu) {
        this.tbDoanhThu = tbDoanhThu;
    }

    public Long getThangNhieu() {
        return thangNhieu;
    }

    public void setThangNhieu(Long thangNhieu) {
        this.thangNhieu = thangNhieu;
    }

    public Long getThangIt() {
        return thangIt;
    }

    public void setThangIt(Long thangIt) {
        this.thangIt = thangIt;
    }

    public Long getDoanhThuThangNhieu() {
        return doanhThuThangNhieu;
    }

    public void setDoanhThuThangNhieu(Long doanhThuThangNhieu) {
        this.doanhThuThangNhieu = doanhThuThangNhieu;
    }

    public Long getDoanhThuThangIt() {
        return doanhThuThangIt;
    }

    public void setDoanhThuThangIt(Long doanhThuThangIt) {
        this.doanhThuThangIt = doanhThuThangIt;
    }

}
