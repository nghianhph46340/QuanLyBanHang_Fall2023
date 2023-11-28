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

    public ArrayList<SanPham> getListSP() {
        listSanPham.clear();
        try {
            String sql = "SELECT ma_san_pham, ten_san_pham, ngay_tao, trong_luong, mo_ta, so_luong_ton, gia_nhap, gia_ban FROM SanPham";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getString("ma_san_pham"));
                sp.setTenSP(rs.getString("ten_san_pham"));
                sp.setNamB(rs.getString("ngay_tao"));
                sp.setTrongLuong(rs.getDouble("trong_luong"));
                sp.setMoTa(rs.getString("mo_ta"));
                sp.setSoLuong(rs.getInt("so_luong_ton"));
                sp.setGiaNhap(rs.getDouble("gia_nhap"));
                sp.setGiaBan(rs.getDouble("gia_ban"));
                listSanPham.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    public ArrayList<HoaDon> getListHoaDon() {
        listHoaDon.clear();
        try {
            String sql = "SELECT ma_hoa_don, ngay_tao, ten_nhan_vien, trang_thai FROM HoaDon";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString("ma_hoa_don"));
                hd.setNgayTao(rs.getString("ngay_tao"));
                hd.setTenNV(rs.getString("ten_nhan_vien"));
                hd.setTinhTrang(rs.getString("trang_thai"));
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<GioHang> getListGH() {
        listGioHang.clear();
        try {
            String sql = "SELECT ma_san_pham, ten_san_pham, so_luong, don_gia, thanh_tien FROM GioHang";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                GioHang gh = new GioHang();
                gh.setMaSP(rs.getString("ma_san_pham"));
                gh.setTenSp(rs.getString("ten_san_pham"));
                gh.setSoLuong(rs.getInt("so_luong"));
                gh.setDonGia(rs.getDouble("don_gia"));
                gh.setThanhTien(rs.getDouble("thanh_tien"));
                listGioHang.add(gh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGioHang;
    }

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
        String sql = "insert into HoaDon(ma_hoa_don,ngay_tao,ten_nhan_vien,trang_thai) values(?,?,?,?)";
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
    
    

}
