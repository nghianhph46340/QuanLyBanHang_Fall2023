/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChucNangBanHang;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author NGHIAPC
 */
public class QuanLyBanHang {

    Scanner sc = new Scanner(System.in);

    ArrayList<SanPham> listSanPham = new ArrayList<>();
    ArrayList<GioHang> listGioHang = new ArrayList<>();
    ArrayList<HoaDon> listHoaDon = new ArrayList<>();
    
    public ArrayList<SanPham> getListSP(){
        listSanPham.clear();
        try {
            String sql = "Select ma_san_pham,ten_san_pham,ngay_tao,trong_luong,mo_ta,so_luong_ton,gia_nhap,gia_ban from SanPham";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setNamB(rs.getString(3));
                sp.setTrongLuong(rs.getDouble(4));
                sp.setMoTa(rs.getString(5));
                sp.setSoLuong(rs.getInt(6));
                sp.setGiaNhap(rs.getDouble(7));
                sp.setGiaBan(rs.getDouble(8));
                listSanPham.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
    
//    public QuanLyBanHang() {
//        listSanPham.add(new SanPham("SP01", "Bánh kẹo", "2020", 10.5, "Bánh kẹo hoà bình", 45, 15000.00, 17000.00));
//        listSanPham.add(new SanPham("SP02", "Xúc xích", "2020", 300.5, "Xúc xích thượng hạng", 100, 10000.00, 15000.00));
//        listSanPham.add(new SanPham("SP03", "Bánh bao", "2020", 20.5, "Bánh bao thượng hạng", 200, 40000.00, 45000.00));
//        listSanPham.add(new SanPham("SP04", "Mì tôm", "2020", 30.5, "Mì tôm thượng hạng", 150, 3000.00, 5000.00));
//        listSanPham.add(new SanPham("SP05", "Phở bò", "2020", 100.5, "Phở bò Hà Lội", 79, 39000.00, 45000.00));
//
//    }
    public ArrayList listHoaDonFake(){
       listHoaDon.add(new HoaDon("HD01", "2023/4/5", "Nguyễn Hữu Nghĩa", "Chưa thanh toán"));
       return listHoaDon;
    }

<<<<<<< Updated upstream
    ArrayList<HoaDon> getListHoaDon(){
=======
    public ArrayList<HoaDon> getListHoaDon() {
        listHoaDon.clear();
        try {
            String sql = "SELECT ma_hoa_don, ngay_tao, ten_nguoi_tao, trang_thai FROM HoaDon";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString("ma_hoa_don"));
                hd.setNgayTao(rs.getString("ngay_tao"));
                hd.setTenNV(rs.getString("ten_nguoi_tao"));
                hd.setTinhTrang(rs.getString("trang_thai"));
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
>>>>>>> Stashed changes
        return listHoaDon;
    }

    ArrayList<GioHang> themSpGioHang(GioHang gioHang) {
        
        listGioHang.add(gioHang);
        return listGioHang;
//        for (SanPham sanPham : listSanPham) {
//            if (sanPham.getMaSp().equals(gioHang.getMaSP())) {
//                listGioHang.add(gioHang);
//                return listGioHang;
//            }
//        }
//        return null;
    }
    ArrayList<GioHang> getListGioHang(){
        return listGioHang;
    }

<<<<<<< Updated upstream
//    ArrayList<GioHang> listTraGioHang(ArrayList<SanPham> listSp) {
//        ArrayList<GioHang> listSPGioHang = new ArrayList<>();
//        GioHang gioHang = new GioHang();
////        for (int i = 0; i < listSp.size(); i++) {
////            String maSP = listSp.get(i).getMaSp();
////            String tenSP = listSp.get(i).getTenSP();
////            Integer soLuong = listSp.get(i).getSoLuong();
////            Double donGia = listSp.get(i).getGiaBan();
////            Double thanhTien = donGia * soLuong;
////        }
////        String maSP = listSp.get(0).getMaSp();
////        gioHang.setMaSP(maSP);
////        String tenSP = listSp.get(0).getTenSP();
////        gioHang.setTenSp(tenSP);
////        Integer soLuong = listSp.get(0).getSoLuong();
////        gioHang.setSoLuong(soLuong);
////        Double donGia = listSp.get(0).getGiaBan();
////        gioHang.setDonGia(donGia);
////        Double thanhTien = donGia * soLuong;
////        gioHang.setThanhTien(thanhTien);
////        listSPGioHang.add(gioHang);
//
//        return listSPGioHang;
//    }
=======
    public void addSanPham(GioHang gh) {
        String sql = "insert into GioHang (ma_hoa_don,ma_san_pham,ten_san_pham,so_luong,don_gia,thanh_tien) values (?,?,?,?,?,?)";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, gh.getMaHD());
            stm.setString(2, gh.getMaSP());
            stm.setString(3, gh.getTenSp());
            stm.setInt(4, gh.getSoLuong());
            stm.setDouble(5, gh.getDonGia());
            stm.setDouble(6, gh.getThanhTien());
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addHoaDon(HoaDon hd) {
        String sql = "insert into HoaDon(ma_hoa_don,ngay_tao,ten_nguoi_tao,trang_thai) values(?,?,?,?)";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, hd.getMaHoaDon());
            stm.setString(2, hd.getNgayTao());
            stm.setString(3, hd.getTenNV());
            stm.setString(4, hd.getTinhTrang());
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

>>>>>>> Stashed changes
}
