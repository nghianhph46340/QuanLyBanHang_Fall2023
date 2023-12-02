/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ChucNangBanHang;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class ChucNangBanHangView extends javax.swing.JFrame {

    /**
     * Creates new form ChucNangBanHangView
     */
    ArrayList<SanPham> listSP = new ArrayList<>();
    DefaultTableModel dftm;
    QuanLyBanHang quanLyBanHang = new QuanLyBanHang();
    ArrayList<GioHang> listGH = new ArrayList<>();
    private String maHD = "";

    LocalDate date = LocalDate.now();

    public ChucNangBanHangView() {
        initComponents();
        tblGioHang.setEnabled(false);
        setFormHoaDon(false);
        btnThanhToan.setEnabled(false);
        btnThemSanPham.setEnabled(false);
        tblChiTietSanPham.setEnabled(false);
        loadDataSP(quanLyBanHang.getListSP());
        loadDataHD(quanLyBanHang.getListHoaDon());
        if (!maHD.equals("")) {
            setFormHoaDon(true);
            tblChiTietSanPham.setEnabled(true);
            btnThemSanPham.setEnabled(true);
            loadDataGH(maHD);
        }

    }

    void loadDataSP(ArrayList<SanPham> list) {
        Integer stt = 1;
        dftm = (DefaultTableModel) tblChiTietSanPham.getModel();
        dftm.setRowCount(0);
        for (SanPham sanPham : list) {
            dftm.addRow(new Object[]{
                stt++,
                sanPham.getMaSp(),
                sanPham.getTenSP(),
                sanPham.getNgayTao(),
                sanPham.getTrongLuong(),
                sanPham.getMoTa(),
                sanPham.getSoLuong(),
                sanPham.getGiaNhap(),
                sanPham.getGiaBan()
            });
        }
    }

    void loadDataHD(ArrayList<HoaDon> list) {
        dftm = (DefaultTableModel) tblHoaDon.getModel();
        dftm.setRowCount(0);
        Integer stt = 1;

        for (HoaDon hoaDon : list) {
            dftm.addRow(new Object[]{
                stt++,
                hoaDon.getMaHoaDon(),
                hoaDon.getNgayTao(),
                hoaDon.getTenNV(),
                hoaDon.getTinhTrang()
            });
        }
    }

    void loadDataGH(String maHD) {
        dftm = (DefaultTableModel) tblGioHang.getModel();
        Integer stt = 1;
        dftm.setRowCount(0);
        for (GioHang gioHang : quanLyBanHang.getListGH(maHD)) {
            dftm.addRow(new Object[]{
                stt++,
                gioHang.getMaSP(),
                gioHang.getTenSp(),
                gioHang.getSoLuong(),
                gioHang.getDonGia(),
                gioHang.getThanhTien()
            });

        }
    }

    void setFormHoaDon(boolean hd) {

        txtMaHD.setEnabled(hd);
        txtNgayTao.setEnabled(hd);
        txtTenNV.setEnabled(hd);
        txtTienKhachDua.setEnabled(hd);
        txtTienThua.setEnabled(hd);
        txtTongTien.setEnabled(hd);

    }

    HoaDon getFormHD(String tt) {
        HoaDon hd = new HoaDon();
        hd.setMaHoaDon(txtMaHD.getText());
        hd.setNgayTao(txtNgayTao.getText());
        hd.setTenNV(txtTenNV.getText());
        hd.setTinhTrang(tt);

        return hd;
    }

    void setFormHD(HoaDon hd) {
        txtMaHD.setText(hd.maHoaDon);
        txtNgayTao.setText(hd.ngayTao);
        txtTenNV.setText(hd.tenNV);

    }

    Boolean checkMaSP(String maSP) {
        for (GioHang sp : quanLyBanHang.getListGH(maHD)) {
            if (sp.getMaSP().equals(maSP)) {
                return true;
            }
        }
        return false;
    }

    Boolean checkSo(String nhap) {
        try {
            double so = Double.parseDouble(nhap);
            Integer so1 = Integer.valueOf(nhap);
            return true;
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Đã nhập vào không đúng mới nhập lại");
            return false;
        }

    }

    Boolean checkSoAm(Integer soNhapVao, Integer soSoSanh) {
        if (soNhapVao < 0) {
            JOptionPane.showMessageDialog(this, "Số lượng nhập bị âm");
            return false;
        } else {
//            if (soNhapVao > soSoSanh) {
//                JOptionPane.showMessageDialog(this, "Số lượng nhập vào quá lớn");
//                return false;
//            } else {
//
//            }
            return true;
        }

    }

    ArrayList<HoaDon> listTrangThai(String trangThai) {
        ArrayList<HoaDon> list = new ArrayList<>();
        if (quanLyBanHang.getListHoaDon().isEmpty()) {
            System.out.println("Rong");
        } else {
            for (HoaDon hd : quanLyBanHang.getListHoaDon()) {
                if (hd.getTinhTrang().equals(trangThai)) {
                    list.add(hd);
                }
            }
        }
        return list;
    }

    boolean checkForm() {
        if (!txtMaHD.getText().isEmpty() && !txtNgayTao.getText().isEmpty() && !txtTenNV.getText().isEmpty()
                && !txtTienKhachDua.getText().isEmpty() && !txtTongTien.getText().isEmpty() && !txtTienThua.getText().isEmpty()
                && checkSo(txtTienKhachDua.getText())) {
            btnThanhToan.setEnabled(true);
        }
        return false;
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
        btnTaoHoaDon = new javax.swing.JButton();
        rdDaThanhToan = new javax.swing.JRadioButton();
        rdTatCa = new javax.swing.JRadioButton();
        rdDaHuy = new javax.swing.JRadioButton();
        rdChoThanhToan = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtMaHD = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblChiTietSanPham = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnThemSanPham = new javax.swing.JButton();
        btnXoaGH = new javax.swing.JButton();
        btnUpdateSLGH = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        btnTaoHoaDon.setText("Tạo hoá đơn");
        btnTaoHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoHoaDonMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdDaThanhToan);
        rdDaThanhToan.setText("Đã thanh toán");
        rdDaThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdDaThanhToanMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdTatCa);
        rdTatCa.setText("Tất cả");
        rdTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTatCaMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdDaHuy);
        rdDaHuy.setText("Đã huỷ");
        rdDaHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdDaHuyMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdChoThanhToan);
        rdChoThanhToan.setText("Chờ thanh toán");
        rdChoThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdChoThanhToanMouseClicked(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HĐ", "Ngày tạo", "Tên NV", "Tình trạng"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Hoá đơn");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("MãHĐ");

        jLabel3.setText("Ngày tạo");

        jLabel4.setText("TênNV");

        jLabel5.setText("Tổng tiền");

        jLabel6.setText("Tiền khách đưa");

        jLabel7.setText("Tiền thừa");

        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThanhToan)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(txtNgayTao)
                        .addComponent(txtTenNV)
                        .addComponent(txtTongTien)
                        .addComponent(txtTienKhachDua)
                        .addComponent(txtTienThua)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(btnThanhToan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên Sp", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Giỏ hàng");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Sản phẩm");

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblChiTietSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên Sp", "Năm bắt đầu", "Trọng lượng", "Mô tả", "SL SP", "Giá nhập", "Giá bán"
            }
        ));
        tblChiTietSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblChiTietSanPham);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(31, 31, 31))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        btnThemSanPham.setText("Thêm sản phẩm");
        btnThemSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemSanPhamMouseClicked(evt);
            }
        });

        btnXoaGH.setText("Xoá SP");
        btnXoaGH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaGHMouseClicked(evt);
            }
        });

        btnUpdateSLGH.setText("Update SL");
        btnUpdateSLGH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateSLGHMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdChoThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(45, 45, 45)
                                .addComponent(rdTatCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(45, 45, 45)
                                .addComponent(rdDaHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(45, 45, 45)
                                .addComponent(rdDaThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(1, 1, 1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(410, 410, 410))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(417, 417, 417))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnXoaGH)
                            .addComponent(btnUpdateSLGH))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnThemSanPham))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdDaThanhToan)
                    .addComponent(rdDaHuy)
                    .addComponent(rdTatCa)
                    .addComponent(rdChoThanhToan)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnXoaGH)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdateSLGH)))
                        .addGap(38, 38, 38)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemSanPham))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemSanPhamMouseClicked
        // TODO add your handling code here:
        int row = tblHoaDon.getSelectedRow();

        if (row >= 0) {
            String maHD = tblHoaDon.getValueAt(row, 1).toString();
            int i = tblChiTietSanPham.getSelectedRow();
            if (i >= 0) {
                String maSp = tblChiTietSanPham.getValueAt(i, 1).toString();
                String tenSp = tblChiTietSanPham.getValueAt(i, 2).toString();
                String sLTB = tblChiTietSanPham.getValueAt(i, 6).toString();
                Integer slb = Integer.parseInt(sLTB);
                String soLuong1 = JOptionPane.showInputDialog("Nhập số lượng cần mua: ");
                Integer soLuong = null;
                if (checkSo(soLuong1)) {
                    soLuong = Integer.parseInt(soLuong1);
                    Double donGia = (Double) tblChiTietSanPham.getValueAt(i, 8);
                    if ((soLuong <= slb && soLuong > 0)) {
                        boolean check = checkMaSP(maSp);
                        Double thanhTien = donGia * soLuong;
                        GioHang gioHangNew = new GioHang(maHD, maSp, tenSp, soLuong, donGia, thanhTien);
                        if (check) {
                            quanLyBanHang.updateSLGioHangCong(maSp, soLuong, maHD);
                            quanLyBanHang.updateSLSanPhamTru(maSp, soLuong);
                            loadDataSP(quanLyBanHang.getListSP());
                            loadDataGH(maHD);
                        } else {

                            quanLyBanHang.addSanPham(gioHangNew);
                            quanLyBanHang.updateSLSanPhamTru(maSp, soLuong);
                            loadDataGH(maHD);
                            loadDataSP(quanLyBanHang.getListSP());

                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Nhập lại số lượng");
                    }
                }

            }

        }
        txtTongTien.setText(quanLyBanHang.tinhTongTien(quanLyBanHang.getListGH(maHD)) + "");


    }//GEN-LAST:event_btnThemSanPhamMouseClicked

    private void tblChiTietSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSanPhamMouseClicked
        // TODO add your handling code here:
        int i = tblChiTietSanPham.getSelectedRow();
//        btnThemSanPham.setEnabled(true);

    }//GEN-LAST:event_tblChiTietSanPhamMouseClicked

    private void btnTaoHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoHoaDonMouseClicked
        // TODO add your handling code here:
        int i = quanLyBanHang.getListHoaDon().size();
        i++;
        HoaDon hoaDon = new HoaDon("HD0" + i, date + "", "", "Chưa thanh toán");
        quanLyBanHang.addHoaDon(hoaDon);
        
        loadDataHD(listTrangThai("Chưa thanh toán"));


    }//GEN-LAST:event_btnTaoHoaDonMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
//        tblGioHang.setEnabled(false);
//        setFormHoaDon(false);
//        btnThanhToan.setEnabled(false);
//        btnThemSanPham.setEnabled(false);
//        tblChiTietSanPham.setEnabled(false);
        rdTatCa.setSelected(true);
    }//GEN-LAST:event_formWindowActivated

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        setFormHoaDon(true);
        tblGioHang.setEnabled(true);
        btnThemSanPham.setEnabled(true);
        tblChiTietSanPham.setEnabled(true);
        int selectedRow = tblHoaDon.getSelectedRow();
        if (selectedRow >= 0) {
            String maHoaDon = tblHoaDon.getValueAt(selectedRow, 1).toString();
            maHD = maHoaDon;

            String trangThai = (String) tblHoaDon.getValueAt(selectedRow, 4);
            if (trangThai.equals("Chưa thanh toán")) {
                rdChoThanhToan.setSelected(true);
            } else if (trangThai.equals("Đã thanh toán")) {
                rdDaThanhToan.setSelected(true);
            } else if (trangThai.equals("Đã huỷ")) {
                rdDaHuy.setSelected(true);
            } else {
                rdTatCa.setSelected(true);
            }
            loadDataGH(maHoaDon);
            setFormHD(quanLyBanHang.getRow(selectedRow));
            txtTongTien.setText(quanLyBanHang.tinhTongTien(quanLyBanHang.getListGH(maHD)) + "");
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String keyword = txtSearch.getText();
        //dftm = (DefaultTableModel) tblChiTietSanPham.getModel();

        dftm.setRowCount(0);
//        for (SanPham sanPham: quanLyBanHang.search(keyword)) {
//            dftm.addRow(new Object[]{
//                stt,
//                sanPham.getMaSp(),
//                sanPham.getTenSP(),
//                sanPham.getNgayTao(),
//                sanPham.getTrongLuong(),
//                sanPham.getMoTa(),
//                sanPham.getSoLuong(),
//                sanPham.getGiaNhap(),
//                sanPham.getGiaBan()
//
//            });
//        }
        loadDataSP((ArrayList<SanPham>) quanLyBanHang.search(keyword));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnXoaGHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaGHMouseClicked
        // TODO add your handling code here:
        int row = tblGioHang.getSelectedRow();
        //int row2 = tblHoaDon.getSelectedRow();
        Integer soLuongGH = (Integer) tblGioHang.getValueAt(row, 3);
        if (row >= 0) {
            String maSP = (String) tblGioHang.getValueAt(row, 1);
            quanLyBanHang.DeleteGioHang(maSP);
            quanLyBanHang.updateSLSanPhamCong(maSP, soLuongGH);
            JOptionPane.showMessageDialog(this, "Xoá thành công");
            loadDataGH(maHD);
            loadDataSP(quanLyBanHang.getListSP());
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        }
        txtTongTien.setText(quanLyBanHang.tinhTongTien(quanLyBanHang.getListGH(maHD)) + "");
    }//GEN-LAST:event_btnXoaGHMouseClicked

    private void btnUpdateSLGHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateSLGHMouseClicked
        // TODO add your handling code here:
        int row = tblGioHang.getSelectedRow();
        int row2 = tblHoaDon.getSelectedRow();
        if (row >= 0) {
            String maSP = (String) tblGioHang.getValueAt(row, 1);
            Integer soLuongGH = (Integer) tblGioHang.getValueAt(row, 3);
            String maHD = (String) tblHoaDon.getValueAt(row2, 1);
            Double gia = (Double) tblGioHang.getValueAt(row, 4);
            String so = JOptionPane.showInputDialog("Nhập số lượng sản phẩm cần update");
            if (checkSo(so)) {
                Integer soLuong = Integer.parseInt(so);
                Double thanhTien = gia * soLuong;
                quanLyBanHang.setThanhTienGH(maSP, maHD, thanhTien);
                System.out.println(quanLyBanHang.getListGH(maHD).get(row).getThanhTien() + "1");
                if (soLuong == 0) {
                    quanLyBanHang.DeleteGioHang(maSP);
                    quanLyBanHang.updateSLGioHangTru(maSP, soLuong, maHD);
                    quanLyBanHang.updateSLSanPhamCong(maSP, soLuong);
                    loadDataGH(maHD);
                    loadDataSP(quanLyBanHang.getListSP());
                    txtTongTien.setText(quanLyBanHang.tinhTongTien(quanLyBanHang.getListGH(maHD)) + "");
                }
                if (checkSoAm(soLuong, soLuongGH)) {
                    quanLyBanHang.updateSLGioHangTru(maSP, soLuong, maHD);
                    if (soLuong > soLuongGH) {
                        quanLyBanHang.updateSLSanPhamTru(maSP, (soLuong - soLuongGH));
                    } else {
                        quanLyBanHang.updateSLSanPhamCong(maSP, (soLuongGH - soLuong));
                    }
                    loadDataGH(maHD);
                    loadDataSP(quanLyBanHang.getListSP());
                    txtTongTien.setText(quanLyBanHang.tinhTongTien(quanLyBanHang.getListGH(maHD)) + "");
                }

            }

        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        }
    }//GEN-LAST:event_btnUpdateSLGHMouseClicked

    private void rdChoThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdChoThanhToanMouseClicked
        // TODO add your handling code here:
        String n = "Chưa thanh toán";
        loadDataHD(listTrangThai(n));


    }//GEN-LAST:event_rdChoThanhToanMouseClicked

    private void rdTatCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTatCaMouseClicked
        // TODO add your handling code here:
        loadDataHD(quanLyBanHang.getListHoaDon());

    }//GEN-LAST:event_rdTatCaMouseClicked

    private void rdDaHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdDaHuyMouseClicked
        // TODO add your handling code here:
        String n = "Đã huỷ";
        loadDataHD(listTrangThai(n));

    }//GEN-LAST:event_rdDaHuyMouseClicked

    private void rdDaThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdDaThanhToanMouseClicked
        // TODO add your handling code here:
        String n = "Đã thanh toán";
        loadDataHD(listTrangThai(n));
    }//GEN-LAST:event_rdDaThanhToanMouseClicked

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        // TODO add your handling code here:
        String tienKhachDua = txtTienKhachDua.getText().trim();
        double tongTien = Double.valueOf(txtTongTien.getText());
        double tienThua = 0.0;
        if (checkSo(tienKhachDua)) {
            double tienKhach = Double.valueOf(tienKhachDua);
            tienThua = tienKhach - tongTien;
            if (tienThua < 0) {
                //JOptionPane.showMessageDialog(this, "Quý khách cần thanh toán thêm: "+ (tienThua - tienThua - tienThua));
                txtTienThua.setText("");
            } else {
                txtTienThua.setText(tienThua + "");
                btnThanhToan.setEnabled(true);
            }
        }
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        // TODO add your handling code here:
        String ss = "Đã thanh toán";

        int row = tblHoaDon.getSelectedRow();
        String maHD = (String) tblHoaDon.getValueAt(row, 1);
        if (row >= 0) {
            loadDataHD(quanLyBanHang.updateTTHD(maHD, ss));
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
            loadDataHD(quanLyBanHang.getListHoaDon());
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        }
    }//GEN-LAST:event_btnThanhToanMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChucNangBanHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChucNangBanHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChucNangBanHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChucNangBanHangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChucNangBanHangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnUpdateSLGH;
    private javax.swing.JButton btnXoaGH;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdChoThanhToan;
    private javax.swing.JRadioButton rdDaHuy;
    private javax.swing.JRadioButton rdDaThanhToan;
    private javax.swing.JRadioButton rdTatCa;
    private javax.swing.JTable tblChiTietSanPham;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
