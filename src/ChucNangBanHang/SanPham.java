/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChucNangBanHang;

import java.util.Date;

/**
 *
 * @author NGHIAPC
 */
public class SanPham {

    private String maSp;
    private String tenSP;
    private String ngayTao;
    private Double trongLuong;
    private String moTa;
    private Integer soLuong;
    private Double giaNhap;
    private Double giaBan;

    public SanPham() {
    }

    public SanPham(String maSp, String tenSP, String ngayTao, Double trongLuong, String moTa, Integer soLuong, Double giaNhap, Double giaBan) {
        this.maSp = maSp;
        this.tenSP = tenSP;
        this.ngayTao = ngayTao;
        this.trongLuong = trongLuong;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Double getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(Double trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSp=" + maSp + ", tenSP=" + tenSP + ", ngayTao=" + ngayTao+ ", trongLuong=" + trongLuong + ", moTa=" + moTa + ", soLuong=" + soLuong + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }

    public void inThonTin() {
        System.out.println("SanPham{" + "maSp=" + maSp + ", tenSP=" + tenSP + ", ngayTao=" + ngayTao + ", trongLuong=" + trongLuong + ", moTa=" + moTa + ", soLuong=" + soLuong + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}');
    }
}
