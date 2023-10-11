/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChucNangBanHang;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NGHIAPC
 */
public class QuanLyBanHang {

    Scanner sc = new Scanner(System.in);

    ArrayList<SanPham> listSanPham = new ArrayList<>();

    public QuanLyBanHang() {
        listSanPham.add(new SanPham("SP01", "Bánh kẹo", "2020", 10.5, "Bánh kẹo hoà bình", 45, 15000.00, 17000.00));
        listSanPham.add(new SanPham("SP02", "Xúc xích", "2020", 300.5, "Xúc xích thượng hạng", 100, 10000.00, 15000.00));
        listSanPham.add(new SanPham("SP03", "Bánh bao", "2020", 20.5, "Bánh bao thượng hạng", 200, 40000.00, 45000.00));
        listSanPham.add(new SanPham("SP04", "Mì tôm", "2020", 30.5, "Mì tôm thượng hạng", 150, 3000.00, 5000.00));
        listSanPham.add(new SanPham("SP05", "Phở bò", "2020", 100.5, "Phở bò Hà Lội", 79, 39000.00, 45000.00));

    }

    ArrayList<SanPham> getListSanPham() {

        return listSanPham;
    }

    ArrayList<GioHang> listTraGioHang(ArrayList<SanPham> listSp) {
        ArrayList<GioHang> listSPGioHang = new ArrayList<>();
        GioHang gioHang = new GioHang();
//        for (int i = 0; i < listSp.size(); i++) {
//            String maSP = listSp.get(i).getMaSp();
//            String tenSP = listSp.get(i).getTenSP();
//            Integer soLuong = listSp.get(i).getSoLuong();
//            Double donGia = listSp.get(i).getGiaBan();
//            Double thanhTien = donGia * soLuong;
//        }
//        String maSP = listSp.get(0).getMaSp();
//        gioHang.setMaSP(maSP);
//        String tenSP = listSp.get(0).getTenSP();
//        gioHang.setTenSp(tenSP);
//        Integer soLuong = listSp.get(0).getSoLuong();
//        gioHang.setSoLuong(soLuong);
//        Double donGia = listSp.get(0).getGiaBan();
//        gioHang.setDonGia(donGia);
//        Double thanhTien = donGia * soLuong;
//        gioHang.setThanhTien(thanhTien);
//        listSPGioHang.add(gioHang);

        return listSPGioHang;
    }
}
