/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoConnection1 {

    Connection con = null;

    public Connection getConnection()  {
        try{
        System.out.println("connecting....");
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver Loaded....");
//        con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.100.103:3306/student", "idcard", "id123");
          con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
        System.out.println("connected !!!");
        return con;
    }catch(Exception e){
        e.printStackTrace();
    }
         return con;
    }
}
