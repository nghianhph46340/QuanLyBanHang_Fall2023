/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChucNangBanHang;

/**
 *
 * @author NGHIAPC
 */
public class SanPham {
    private String maSp;
    private String tenSP;
    private String NamB;
    private Double trongLuong;
    private String moTa;
    private Integer soLuong;
    private Double giaNhap;
    private Double giaBan;

    public SanPham() {
    }

    public SanPham(String maSp, String tenSP, String NamB, Double trongLuong, String moTa, Integer soLuong, Double giaNhap, Double giaBan) {
        this.maSp = maSp;
        this.tenSP = tenSP;
        this.NamB = NamB;
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

    public String getNamB() {
        return NamB;
    }

    public void setNamB(String NamB) {
        this.NamB = NamB;
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
     
}
