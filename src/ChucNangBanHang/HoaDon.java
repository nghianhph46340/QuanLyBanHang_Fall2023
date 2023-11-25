/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChucNangBanHang;

/**
 *
 * @author NGHIAPC
 */
public class HoaDon {
   String maHoaDon;
   String ngayTao;
   String tenNV;
   String tinhTrang;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String ngayTao, String tenNV, String tinhTrang) {
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.tenNV = tenNV;
        this.tinhTrang = tinhTrang;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
   
   
}
