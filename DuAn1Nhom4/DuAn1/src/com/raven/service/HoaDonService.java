/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.service;

import com.raven.model.HoaDon;
import java.util.List;


/**
 *
 * @author vha74
 */
public interface HoaDonService {

    List<HoaDon> getAll();
    
    
    List<HoaDon> sum();

    public List<HoaDon> getOneSP(String ma);

     public List<HoaDon> getSearchTrangThai(int trangThai);
     
      public List<HoaDon> getSearchThoiGian(String ngayThanhToan);

    public boolean delete(String id);

}
