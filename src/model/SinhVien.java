/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author w7
 */
public class SinhVien {
    private String MaSV;
    private String HoTen;
    private Boolean GioTinh;
    private String Email;
    private String DieThoai;
    private String DiaChi;
    public SinhVien(){}

    public SinhVien(String MaSV, String HoTen, Boolean GioTinh, String Email, String DieThoai, String DiaChi) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.GioTinh = GioTinh;
        this.Email = Email;
        this.DieThoai = DieThoai;
        this.DiaChi = DiaChi;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Boolean getGioTinh() {
        return GioTinh;
    }

    public void setGioTinh(Boolean GioTinh) {
        this.GioTinh = GioTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDieThoai() {
        return DieThoai;
    }

    public void setDieThoai(String DieThoai) {
        this.DieThoai = DieThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
}
