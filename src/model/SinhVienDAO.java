/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author w7
 */
public class SinhVienDAO {
    
    //doc database 
    public static ArrayList<SinhVien> DocDuLieuSV(){
        ArrayList<SinhVien> dsSV = new ArrayList<>();
        Connection cnn = DBContext.getConnection();
        try {
            Statement smt = cnn.createStatement();
            ResultSet rst = smt.executeQuery("select * from sinhVien");
            while(rst.next()){
                SinhVien sv = new SinhVien(rst.getString(1), rst.getString(2), rst.getBoolean(3),rst.getString(4), rst.getString(5), rst.getString(6));
                dsSV.add(sv);
            }
        } catch (Exception e) {
            System.out.println("Loi: "+e.toString());
        }
        return dsSV;
    }
    
    //them moi sinh vien
    public static int ThemMoiSV(SinhVien sv){
        Connection cnn = DBContext.getConnection();
        try {
            PreparedStatement pmst = cnn.prepareStatement("insert into sinhvien(masv,hoten,gioitinh,email,dienthoai,diachi) values(?,?,?,?,?,?)");
            pmst.setString(1, sv.getMaSV());
            pmst.setString(2, sv.getHoTen());
            pmst.setBoolean(3, sv.getGioTinh());
            pmst.setString(4, sv.getEmail());
            pmst.setString(5, sv.getDieThoai());
            pmst.setString(6, sv.getDiaChi());
            int row = pmst.executeUpdate();
            if(row >0)
                return row;
        } catch (Exception e) {
            System.out.println("Loi: "+e.toString());
        }
        return -1;
    }
    public static SinhVien TimSV(String maSV){
        SinhVien sv =null;
        Connection cnn = DBContext.getConnection();
        try {
           PreparedStatement pmst = cnn.prepareStatement("select * from sinhvien where MaSV=?");
           pmst.setString(1, maSV);
           ResultSet rst = pmst.executeQuery();
           if(rst.next())
               sv = new SinhVien(rst.getString(1),rst.getString(2),rst.getBoolean(3),rst.getString(4),rst.getString(5),rst.getString(6));
        } catch (Exception e) {
            System.out.println("Loi: "+e.toString());
        }
        return sv;
    }
    public static int CapNhatSV(SinhVien sv){
        Connection cnn = DBContext.getConnection();
        try {
            PreparedStatement pmst = cnn.prepareStatement("update sinhvien set HoTen=?,GioiTinh=?,Email=?,DienThoai=?,DiaChi=? where MaSV=?");
            pmst.setString(1, sv.getHoTen());
            pmst.setBoolean(2, sv.getGioTinh());
            pmst.setString(3, sv.getEmail());
            pmst.setString(4, sv.getDieThoai());
            pmst.setString(5, sv.getDiaChi());
            pmst.setString(6, sv.getMaSV());
            int row = pmst.executeUpdate();
            if(row >0)
                return row;
        } catch (Exception e) {
            System.out.println("Loi: "+e.toString());
        }
        return 0;
    }
    public static int XoaSV(String MaSV){
        Connection cnn = DBContext.getConnection();
        try {
            PreparedStatement pmst = cnn.prepareStatement("delete from sinhvien where MaSV=?");
            pmst.setString(1, MaSV);
            int row = pmst.executeUpdate();
            if(row > 0)
                return row;
        } catch (Exception e) {
            System.out.println("Loi: "+e.toString());
        }
        return 0;
    }
   
}
