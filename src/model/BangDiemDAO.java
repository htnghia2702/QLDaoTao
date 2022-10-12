/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author w7
 */
public class BangDiemDAO {
    public static ArrayList<BangDiem> DocDuLieuBD(){
        ArrayList<BangDiem> dsBD = new ArrayList<>();
        Connection cnn = DBContext.getConnection();
        try {
            Statement smt = cnn.createStatement();
            ResultSet rst = smt.executeQuery("select * from bangdiem");
            while(rst.next()){
                BangDiem bd = new BangDiem(rst.getInt(1), rst.getString(2), rst.getFloat(3),rst.getFloat(4), rst.getFloat(5));
                dsBD.add(bd);
            }
        } catch (Exception e) {
            System.out.println("Loi: "+e.toString());
        }
        return dsBD;
    }
    public static BangDiem TimSV(String maSV){
        BangDiem sv =null;
        Connection cnn = DBContext.getConnection();
        try {
           PreparedStatement pmst = cnn.prepareStatement("select * from bangdiem where MaSV=?");
           pmst.setString(1, maSV);
           ResultSet rst = pmst.executeQuery();
           if(rst.next())
               sv = new BangDiem(rst.getInt(1),rst.getString(2),rst.getFloat(3),rst.getFloat(4),rst.getFloat(5));
        } catch (Exception e) {
            System.out.println("Loi: "+e.toString());
        }
        return sv;
    }
    public static int ThemMoiBD(BangDiem x){
        Connection cnn = DBContext.getConnection();
        try {
            PreparedStatement pmst = cnn.prepareStatement("insert into bangdiem(masv,TiengAnh,TinHoc,GDTC) values(?,?,?,?)");
            pmst.setString(1, x.getMaSV());
            pmst.setFloat(2, x.getTiengAnh());
            pmst.setFloat(3, x.getTinHoc());
            pmst.setFloat(4, x.getGDTC());
            int row = pmst.executeUpdate();
            if(row >0)
                return row;
        } catch (Exception e) {
            System.out.println("Loi: "+e.toString());
        }
        return -1;
    }
    public static int CapNhatDB(BangDiem x){
        Connection cnn = DBContext.getConnection();
        try {
            PreparedStatement pmst = cnn.prepareStatement("update bangdiem set TiengAnh=?,TinHoc=?,GDTC=? where MaSV=?");
            pmst.setString(4, x.getMaSV());
            pmst.setFloat(1, x.getTiengAnh());
            pmst.setFloat(2, x.getTinHoc());
            pmst.setFloat(3, x.getGDTC());
            int row = pmst.executeUpdate();
            if(row >0)
                return row;
        } catch (Exception e) {
            System.out.println("Loi: "+e.toString());
        }
        return -1;
    }
    public static int XoaBD(String MaSV){
        Connection cnn = DBContext.getConnection();
        try {
            PreparedStatement pmst = cnn.prepareStatement("delete from bangdiem where MaSV=?");
            pmst.setString(1, MaSV);
            int row = pmst.executeUpdate();
            if(row > 0)
                return row;
        } catch (Exception e) {
            System.out.println("Loi: "+e.toString());
        }
        return 0;
    }
    
    public static void main(String args[])
    {
          System.out.println("Ket qua:" + BangDiemDAO.XoaBD("a02"));
    }
}
