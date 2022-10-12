/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.*;
/**
 *
 * @author w7
 */
public class NguoiDungDAO {
    public static NguoiDung KiemTraDangNhap(String tendangnhap,String matkhau){
        NguoiDung user = null;
        DBContext db = new DBContext();
        Connection cnn = db.getConnection();
        try {
            PreparedStatement pmst = cnn.prepareStatement("select * from nguoidung where TenDangNhap=? and MatKhau =?");
            pmst.setString(1, tendangnhap);
            pmst.setString(2, matkhau);
            ResultSet rst = pmst.executeQuery();
            if(rst.next()){
                user = new NguoiDung(rst.getString(1), rst.getString(2), rst.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Loi: "+e.toString());
        }
        return user;
    }
}
