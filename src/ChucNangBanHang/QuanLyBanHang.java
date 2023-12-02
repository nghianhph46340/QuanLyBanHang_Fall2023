/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChucNangBanHang;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
import java.util.List;

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
                sp.setNgayTao(rs.getString("ngay_tao"));
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

    ArrayList<SanPham> traListSP() {
        return listSanPham;
    }
    
     public HoaDon getRow(int row){
        return listHoaDon.get(row);                   
    }
    
    public Double tinhTongTien(ArrayList<GioHang> list){
        Double tongTien = 0.0;
        for (GioHang gioHang : list) {
            tongTien += gioHang.getThanhTien();
        }
        return tongTien;
        
    }

    public ArrayList<HoaDon> getListHoaDon() {
        listHoaDon.clear();
        try {
            String sql = "SELECT ma_hoa_don, ngay_tao, NhanVien.ho_ten, trang_thai FROM HoaDon" + "\n"
                    + "join NhanVien on NhanVien.ma_nhan_vien = HoaDon.ma_nhan_vien" + "\n"
                    + "where NhanVien.ma_nhan_vien = 'NV001'";

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

    public ArrayList<GioHang> getListGH(String maHD) {
        listGioHang.clear();
        try {
            String sql = "select ma_san_pham,ten_san_pham,so_luong,don_gia,thanh_tien from GioHang where ma_hoa_don = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement ptm = conn.prepareStatement(sql);
            ptm.setString(1, maHD);
            ResultSet rs = ptm.executeQuery();

            try {
                while (rs.next()) {
                    GioHang gh = new GioHang();
                    gh.setMaSP(rs.getString(1));
                    gh.setTenSp(rs.getString(2));
                    gh.setSoLuong(rs.getInt(3));
                    gh.setDonGia(rs.getDouble(4));
                    gh.setThanhTien(rs.getDouble(5));

                    listGioHang.add(gh);
                }
            } catch (Exception e) {
                System.out.println(1);
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (ptm != null) {
                        ptm.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
        String sql = "insert into HoaDon(ma_hoa_don,ngay_tao,trang_thai,ma_nhan_vien) values(?,?,?,?)";

        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, hd.getMaHoaDon());
            stm.setString(2, hd.getNgayTao());
            stm.setString(3, hd.getTinhTrang());
            stm.setString(4, "NV001");
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SanPham> search(String keyWord) {
        String sql = "select * from SanPham where ma_san_pham like ? or ten_san_pham like ?";
        listSanPham.clear();
        try {
            try {
                Connection conn = DBConnect.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + keyWord + "%");
                stm.setString(2, "%" + keyWord + "%");
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMaSp(rs.getString("ma_san_pham"));
                    sp.setTenSP(rs.getString("ten_san_pham"));
                    sp.setNgayTao(rs.getString("ngay_tao"));
                    sp.setTrongLuong(Double.parseDouble(rs.getString("trong_luong")));
                    sp.setMoTa(rs.getString("mo_ta"));
                    sp.setSoLuong(Integer.parseInt(rs.getString("so_luong_ton")));
                    sp.setGiaNhap(Double.parseDouble(rs.getString("gia_nhap")));
                    sp.setGiaBan(Double.parseDouble(rs.getString("gia_ban")));
                    listSanPham.add(sp);
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    public ArrayList<SanPham> updateSLSanPhamTru(String maSP, Integer soLuong) {
        String sql = "update SanPham set so_luong_ton = so_luong_ton - ? where ma_san_pham = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setString(2, maSP);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    public ArrayList<GioHang> updateSLGioHangCong(String ma, Integer soLuong, String maHD) {
        String sql = "update GioHang set so_luong = so_luong + ? where ma_san_pham = ? and ma_hoa_don = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setString(2, ma);
            stm.setString(3, maHD);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGioHang;
    }

    public ArrayList<SanPham> updateSLSanPhamCong(String maSP, Integer soLuong) {
        String sql = "update SanPham set so_luong_ton = so_luong_ton + ? where ma_san_pham = ? ";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setString(2, maSP);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    public ArrayList<GioHang> updateSLGioHangTru(String ma, Integer soLuong, String maHD) {
        String sql = "update GioHang set so_luong =  ? where ma_san_pham = ? and ma_hoa_don = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setString(2, ma);
            stm.setString(3, maHD);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGioHang;
    }

    public ArrayList<GioHang> DeleteGioHang(String maSP) {
        String sql = "delete from GioHang where ma_san_pham = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maSP);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGioHang;
    }

    public ArrayList<HoaDon> LocHoaDon(String trangThai) {
        listHoaDon.clear();
        String sql = "select ma_hoa_don, ngay_tao,NhanVien.ho_ten  from HoaDon\n"
                + "join NhanVien on NhanVien.ma_nhan_vien = HoaDon.ma_nhan_vien\n"
                + "where trang_thai = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "N" + trangThai);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString("ma_hoa_don"));
                hd.setNgayTao(rs.getString("ngay_tao"));
                hd.setTenNV(rs.getString("NhanVien.ho_ten"));
                hd.setTinhTrang(trangThai);
                listHoaDon.add(hd);
                
            }
            rs.close();
            stm.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }
    
    public ArrayList<GioHang> setThanhTienGH(String maSP,String maHD, Double tt){
        String sql = "update GioHang set thanh_tien = ? where ma_hoa_don = ? and ma_san_pham = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setDouble(1, tt);
            stm.setString(2, maHD);
            stm.setString(3, maSP);
            stm.executeUpdate();
            conn.close();
            return listGioHang;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGioHang;
    }
    public ArrayList<HoaDon> updateTTHD(String maHD, String tinhTrang) {
        String sql = "update HoaDon set trang_thai = ? where ma_hoa_don = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tinhTrang);
            stm.setString(2, maHD);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }
}
