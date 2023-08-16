/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.service.impl;

import java.util.List;
import com.raven.model.KhachHang;
import com.raven.repository.KhachHangRepository;
import com.raven.service.KhachHangService;
import java.util.ArrayList;

/**
 *
 * @author FPTSHOP
 */
public class KhachHangImpl implements KhachHangService{
    
    private KhachHangRepository khachhangRp = new KhachHangRepository();
 
    @Override
    public List<KhachHang> getAll() {
        return khachhangRp.getAll();
    }

    @Override
    public boolean Add(KhachHang kh) {
        return khachhangRp.add(kh);
        
    }

    @Override
    public String delete(String makh) {
        boolean delete = khachhangRp.delete(makh);
        if(delete){
            return "delete thành công";
        }else{
            return "delete lỗi";
        }
    }

    @Override
    public String update(KhachHang kh, String maKh) {
        boolean update = khachhangRp.update(kh, maKh);
        if(update){
            return "update thành công";
        }else{
            return "update lỗi";
        }
    }

    @Override
    public List<KhachHang> getOne(String maKh) {
        return khachhangRp.getOne(maKh);
    }

    @Override
    public List<KhachHang> listMoi(List<KhachHang> listMoi) {
        List<KhachHang> list = new ArrayList<>();
        for (KhachHang kh : listMoi) {
            if (kh.getTrangThai()== 0) {
                list.add(kh);
            }
        }
        return list;
    }

    @Override
    public List<KhachHang> listCu(List<KhachHang> listCu) {
         List<KhachHang> list = new ArrayList<>();
        for (KhachHang kh : listCu) {
            if (kh.getTrangThai()== 1) {
                list.add(kh);
            }
        }
        return list;
    }
    
    
}
