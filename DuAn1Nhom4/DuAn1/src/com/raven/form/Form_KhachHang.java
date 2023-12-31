/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.raven.model.KhachHang;
import com.raven.service.KhachHangService;
import com.raven.service.impl.KhachHangImpl;
import com.raven.view.ViewKhachHang;
import static java.lang.Thread.sleep;

public class Form_KhachHang extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<KhachHang> list = new ArrayList<>();
    private KhachHangService khachhangService = new KhachHangImpl();
    private KhachHangImpl khachhangImpl = new KhachHangImpl();

    public Form_KhachHang() {
        initComponents();
 
        tblkhachHang.setModel(dtm);
        String[] hearder = {"ID", "Mã khách hàng", "Họ tên", "Ngày sinh", "Giới tính", "SDT", "Địa chỉ", "Quốc gia", "Trạng thái"};
        dtm.setColumnIdentifiers(hearder);
        list = khachhangService.getAll();
        cbbTrangThai();
        ShowData(list);
        ChuChay();
    }
    
    public void cbbTrangThai(){
        cbbTrangThai.removeAllItems();
        cbbTrangThai.addItem("Mới");
        cbbTrangThai.addItem("Cũ");
    }

    public void ChuChay() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                String txt = lbChuChay.getText() + "  ";
                while (true) {
                    txt = txt.substring(1, txt.length()) + txt.charAt(0);
                    try {
                        sleep(100);
                        //Uy tín-Chất Lượng-Giá Tốt
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ViewKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    lbChuChay.setText(txt);
                }
            }
        };
        thread.start();
    }

    public void ShowData(List<KhachHang> listS) {
        dtm.setRowCount(0);
        listS.forEach(s -> dtm.addRow(s.toRowData()));

    }

    public void FillToTable(int index) {
        KhachHang kh = list.get(index);
//        System.out.println(kh.getMaKh());
        ID.setText(kh.getId());
        txtmaKH.setText(kh.getMaKh());
        txtHoTen.setText(kh.getHoTen());
        try {
            int row = tblkhachHang.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dtm.getValueAt(row, 3).toString());
            txtNgaysinh.setDate(date);
        } catch (Exception e) {
            
        }
        boolean gt = kh.isGioiTinh();
        if (gt == true) {
            rboNam.setSelected(true);

        } else {
            rboNu.setSelected(true);
        }
        txtSDT.setText(kh.getSdt());
        txtDiaChi.setText(kh.getDiaChi());
        txtQuocGia.setText(kh.getQuocGia());
        int trangThai = kh.getTrangThai();
        if (trangThai == 0) {
            cboTrangThai.setSelectedIndex(0);
        } else {
            cboTrangThai.setSelectedIndex(1);
        }
    }

    private boolean checkEmail(String txt) {
        Pattern p = Pattern.compile("^[A-Za-z0-9]+@[A-Za-z0-9]+.+[A-Za-z0-9]+$");
        Matcher m = p.matcher(txt);
        return m.matches();
    }

    private boolean checkSo(String txt) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(txt);
        return m.matches();
    }

    public void lammoi() {
        ID.setText("ID");
        txtmaKH.setText("");
        txtHoTen.setText("");
//        txtNgaysinh.setDateFormatString("");
        rboNam.setSelected(true);
        txtSDT.setText("");
        txtDiaChi.setText("");
        txtQuocGia.setText("");
        cboTrangThai.setSelectedIndex(0);
        txtTimKiem.setText("");
        JOptionPane.showMessageDialog(this, "Đã làm mới");
      
    }
    public void sortName() {
        Collections.sort(list, (s1, s2) -> (s1.getHoTen().compareTo(s2.getHoTen())));
        ShowData(list);
    }
    public void sortMa() {
                Collections.sort(list, (s1, s2) -> (s1.getMaKh().compareTo(s2.getMaKh())));
        ShowData(list);
        JOptionPane.showMessageDialog(this, "Sắp xếp thành công");

    }
     public void hienthi() {
        list = khachhangService.getAll();
        ShowData(list);
        JOptionPane.showMessageDialog(this, "Hiển thị thành công ");
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtmaKH = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rboNam = new javax.swing.JRadioButton();
        rboNu = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtQuocGia = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblkhachHang = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        lbChuChay = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        txtNgaysinh = new com.toedter.calendar.JDateChooser();
        cbbSapXep = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("Mã khách hàng :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("Họ tên khách hàng :");

        txtmaKH.setBorder(null);
        txtmaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaKHActionPerformed(evt);
            }
        });

        txtHoTen.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Giới tính :");

        rboNam.setBackground(new java.awt.Color(0, 255, 255));
        buttonGroup1.add(rboNam);
        rboNam.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rboNam.setSelected(true);
        rboNam.setText("Nam");
        rboNam.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        rboNu.setBackground(new java.awt.Color(0, 255, 255));
        buttonGroup1.add(rboNu);
        rboNu.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        rboNu.setText("Nữ");
        rboNu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rboNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rboNuActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Ngày sinh :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Số điện thoại :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Địa chỉ :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("Quốc gia :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Trạng thái :");

        txtSDT.setBorder(null);

        txtDiaChi.setBorder(null);

        txtQuocGia.setBorder(null);

        btnThem.setBackground(new java.awt.Color(255, 255, 0));
        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save.png"))); // NOI18N
        btnThem.setText("Lưu");
        btnThem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThem.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnThemMouseMoved(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(255, 255, 0));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 255, 0));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(255, 255, 0));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setText("Nhập mã cần tìm :");

        txtTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTimKiem.setBackground(new java.awt.Color(255, 255, 0));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiem)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblkhachHang.setBackground(new java.awt.Color(0, 255, 255));
        tblkhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblkhachHang.setSelectionBackground(new java.awt.Color(51, 0, 204));
        tblkhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkhachHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblkhachHang);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Tìm Kiếm");

        cboTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Online", "Offline" }));
        cboTrangThai.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiActionPerformed(evt);
            }
        });

        lbChuChay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbChuChay.setForeground(new java.awt.Color(255, 51, 51));
        lbChuChay.setText("Uy tín - Chất Lượng - Giá tốt");
        lbChuChay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuaHang/LogoView.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setText("ID :");

        ID.setBackground(new java.awt.Color(255, 255, 255));
        ID.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        cbbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp xếp theo tên", "Sắp xếp theo mã" }));
        cbbSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSapXepActionPerformed(evt);
            }
        });

        jLabel9.setText("Sắp xếp");

        jLabel10.setText("Trạng thái");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(68, 68, 68)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCapNhat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHoTen)
                            .addComponent(txtmaKH)
                            .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT)
                            .addComponent(txtDiaChi)
                            .addComponent(txtQuocGia)
                            .addComponent(ID, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rboNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNgaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbChuChay, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbbSapXep, 0, 138, Short.MAX_VALUE)
                                            .addComponent(cbbTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(39, 39, 39))))))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbChuChay, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtmaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHoTen))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rboNam)
                            .addComponent(rboNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtQuocGia, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnCapNhat)
                            .addComponent(btnXoa)
                            .addComponent(btnLamMoi)
                            .addComponent(jLabel16))))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtmaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaKHActionPerformed

    private void rboNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rboNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rboNuActionPerformed

    private void btnThemMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseMoved
        // TODO add your handling codưe here:
    }//GEN-LAST:event_btnThemMouseMoved

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        String makh = txtmaKH.getText();
        String hoTen = txtHoTen.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String ngaysinh = dateFormat.format(txtNgaysinh.getDate());
        boolean gioitinh = rboNam.isSelected();
        String diaChi = txtDiaChi.getText();
        String quocGia = txtQuocGia.getText();
        String sdt = txtSDT.getText();
        int trangThai = cboTrangThai.getSelectedIndex();
        if (makh.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (hoTen.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (ngaysinh.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!checkSo(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là số!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (diaChi.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (quocGia.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Quốc gia không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (sdt.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (sdt.length() != 10) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký tự!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            KhachHang nv = new KhachHang(makh, hoTen, ngaysinh, gioitinh, sdt, diaChi, quocGia, trangThai);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(nv)) {
                    JOptionPane.showMessageDialog(this, "Nhân viên đã tồn tại", "Invalidation", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            boolean addNv = khachhangImpl.Add(nv);
            if (addNv == true) {
                JOptionPane.showMessageDialog(this, "Add thành công");
                list = khachhangImpl.getAll();
                ShowData(list);
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Add thất bại");
                return;
            }

        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        String makh = txtmaKH.getText();
        String hoTen = txtHoTen.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String ngaysinh = dateFormat.format(txtNgaysinh.getDate());
        boolean gioitinh = rboNam.isSelected();
        String diaChi = txtDiaChi.getText();
        String quocGia = txtQuocGia.getText();
        String sdt = txtSDT.getText();
        int trangThai = cboTrangThai.getSelectedIndex();
        if (makh.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (hoTen.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (ngaysinh.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!checkSo(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là số!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (diaChi.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (quocGia.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Quốc gia không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (sdt.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (sdt.length() != 10) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là 10 ký tự!", "Invalidation", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            KhachHang kh = new KhachHang(makh, hoTen, ngaysinh, gioitinh, sdt, diaChi, quocGia, trangThai);
            JOptionPane.showMessageDialog(this, khachhangImpl.update(kh, makh));
            list = khachhangImpl.getAll();
            ShowData(list);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String ma = txtmaKH.getText();
        JOptionPane.showMessageDialog(this, khachhangService.delete(ma));
        list = khachhangService.getAll();
        ShowData(list);
        lammoi();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed

        //        txtmaKH.setText("");
        //        txtHoTen.setText("");
        //        txtngaySinh.setText("");
        //        rboNam.setSelected(rootPaneCheckingEnabled);
        //        txtSDT.setText("");
        //        txtDiaChi.setText("");
        //        txtQuocGia.setText("");
        //        cboTrangThai.setSelectedIndex(0);
        //        txtTimKiem.setText("");
        //        JOptionPane.showMessageDialog(this, "Đã làm mới");
        lammoi();
        hienthi();
        
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String maKh = txtTimKiem.getText();
        list = khachhangImpl.getOne(maKh);
        if (maKh.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống!");
            return;
        } else if (list.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Tìm thành công");
            ShowData(list);
            return;
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblkhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhachHangMouseClicked
        int row = tblkhachHang.getSelectedRow();
        khachhangService.getAll();
        FillToTable(row);
    }//GEN-LAST:event_tblkhachHangMouseClicked

    private void cboTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTrangThaiActionPerformed

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseMoved

    private void cbbSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSapXepActionPerformed
       if (cbbSapXep.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Sắp xếp thành công");
            sortName();
        } else {
            JOptionPane.showMessageDialog(this, "Sắp xếp thành công");
            sortMa();
        }    
    }//GEN-LAST:event_cbbSapXepActionPerformed

    private void cbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed
        String i = (String) cbbTrangThai.getSelectedItem();
        if(i == "Mới"){
             List<KhachHang> kh = khachhangImpl.listMoi(list);     
             ShowData(kh);
            
        }else {
            List<KhachHang> kh = khachhangImpl.listCu(list);            
            ShowData(kh);
             
        }
    }//GEN-LAST:event_cbbTrangThaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbSapXep;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbChuChay;
    private javax.swing.JRadioButton rboNam;
    private javax.swing.JRadioButton rboNu;
    private javax.swing.JTable tblkhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private com.toedter.calendar.JDateChooser txtNgaysinh;
    private javax.swing.JTextField txtQuocGia;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtmaKH;
    // End of variables declaration//GEN-END:variables
}
