/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChucNangBanHang;

/**
 *
 * @author NGHIAPC
 */
public class GioHang {
    private String maSP;
    private String tenSp;
    private Integer soLuong;
    private Double donGia;
    private Double thanhTien;

    public GioHang() {
    }

    public GioHang(String maSP, String tenSp, Integer soLuong, Double donGia, Double thanhTien) {
        this.maSP = maSP;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "GioHang{" + "maSP=" + maSP + ", tenSp=" + tenSp + ", soLuong=" + soLuong + ", donGia=" + donGia + ", thanhTien=" + thanhTien + '}';
    }
    
}
