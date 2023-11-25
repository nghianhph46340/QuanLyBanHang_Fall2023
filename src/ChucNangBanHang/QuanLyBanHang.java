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

    ArrayList<HoaDon> getListHoaDon(){
        listHoaDon.clear();
        try {
            String sql = "select ma_hoa_don,ngay_tao,ho_ten,trang_thai from HoaDon" + "\n" +
                        "join NhanVien on NhanVien.id = HoaDon.id_nhan_vien";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString(1));
                hd.setNgayTao(rs.getString(2));
                hd.setTenNV(rs.getString(3));
                hd.setTinhTrang(rs.getString(4));
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    ArrayList<GioHang> themSpGioHang(GioHang gioHang) {
        
        listGioHang.add(gioHang);
        return listGioHang;
    }
    ArrayList<GioHang> getListGioHang(){
        return listGioHang;
    }

}
