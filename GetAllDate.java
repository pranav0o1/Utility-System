/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author yatin
 */
public class GetAllDate {

    DaoConnection dc = new DaoConnection();
    Connection con;

    public GetAllDate() {
    con=dc.getConnection();
    }
    
    public void setAllDateDb(String tbName) {
        try {
            List<String> monthsList = new ArrayList<String>();
            String[] months = new DateFormatSymbols().getMonths();
            for (int i = 0; i < months.length - 1; i++) {
                String month = months[i];
//      System.out.println("month = " + month);
                monthsList.add(months[i]);
            }
//            System.out.println("" + monthsList);

            Calendar cal = Calendar.getInstance();

            int get = cal.get(Calendar.MONTH);
            for (int ii = 0; ii < 12; ii++) {
                
            
//            System.out.println("" + get);
            cal.set(Calendar.MONTH, ii);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//            int maxDay = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
//            System.out.println("Maxday ::: " + maxDay);

            SimpleDateFormat df = new SimpleDateFormat("EEE_dd_MMM_yyyy");
            String format = df.format(cal.getTime());
//                System.out.println(""+format);
//            con = dc.getConnection();

            String query = "ALTER TABLE `idcard`.`" + tbName + "` ADD COLUMN `" + format + "` VARCHAR(45) DEFAULT 0";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();

            for (int i = 1; i < maxDay; i++) {
                cal.set(Calendar.DAY_OF_MONTH, i + 1);
//                System.out.println(df.format(cal.getTime()));
                String data = df.format(cal.getTime());
//                System.out.println("date "+data);
//            con.close();
//                con = dc.getConnection();

                String query1 = "ALTER TABLE `idcard`.`" + tbName + "` ADD COLUMN `" + data + "` VARCHAR(45) DEFAULT 0";
                PreparedStatement ps1 = con.prepareStatement(query1);
                ps1.executeUpdate();
//            con.close();
            }
            }
        
        } catch (Exception e) {
//           e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        new GetAllDate().setAllDateDb("a_advanced_java_programming_co_ty_i_th");
//    }
            
}
