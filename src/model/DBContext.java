/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 *
 * @author w7
 */
public class DBContext {
    public static Connection getConnection(){
        Connection cnn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://PC322\\SQLSERVER;databaseName=QLDaoTao;user=sa;password=12345";
            cnn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println("loi: "+e.toString());
        }
        return cnn;
    }
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
