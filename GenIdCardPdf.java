/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class GenIdCardPdf {
    public static void main(String[] args) {
//          List rollno = UserList.getSelectedValuesList();
//        if (rollno.size() == 0) {
//            JOptionPane.showMessageDialog(null, "Please Select Roll No....");
//        } else {
            int cont = 0;
            String name = "";
            String contact = "";
            String dob = "";
            String roll = "";
            String dept = "";
            String shift = "";
            String address = "";
            String year = "";
            Blob userimage = null;
//            Blob sing = null;
            String bg="";
            File f1 = null;
            File f2 = null;
            String last = "";
            ArrayList al = new ArrayList();
//            System.out.println(rollno);
            try {
                DaoConnection dc=new DaoConnection();
                Connection conn=dc.getConnection();
                
//                for (int i = 0; i < rollno.size(); i++) {
                    String get = "1";
                    System.out.println("Get Roll No " + get);

//                if(cont==0){
                    String query = "Select * from registrationtbl where roll='" + get + "'";
                    PreparedStatement ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        name = rs.getString("name");
                        last = rs.getString("last");
                        contact = rs.getString("contact");
                        dob = rs.getString("dob");
                        roll = rs.getString("roll");
                        dept = rs.getString("department");
                        shift = rs.getString("shift");
                        year = rs.getString("year");
                        address = rs.getString("address");
                        userimage = rs.getBlob("photo");
                        bg = rs.getString("bloodgroup");

                        File f = new File(System.getProperty("user.dir") + File.separator + "temp");
                        f.mkdir();

                        File userfrant = new File(System.getProperty("user.dir") + File.separator + "temp" + File.separator + roll + "user.jpg");
                        InputStream binaryStream = userimage.getBinaryStream(1, userimage.length());
                        FileOutputStream fos = new FileOutputStream(userfrant);
                        int c = 0;
                        while ((c = binaryStream.read()) != -1) {
                            fos.write(c);
                        }
                        fos.close();
//                        String singure = System.getProperty("user.dir") + File.separator + "temp" + File.separator + roll + "sing.jpg";
//                        InputStream binaryStream1 = sing.getBinaryStream(1, sing.length());
//                        FileOutputStream fos1 = new FileOutputStream(singure);
//                        int cc = 0;
//                        while ((cc = binaryStream1.read()) != -1) {
//                            fos1.write(cc);
//                        }
//                        fos1.close();
//                        ImageTransparency it = new ImageTransparency();
//                        it.imagebackgroundremove(singure, singure);

                        File file = new File(System.getProperty("user.dir") + File.separator + dept + File.separator + roll);
                        file.mkdirs();
                        f1 = new File(System.getProperty("user.dir") + File.separator + dept + File.separator + roll + File.separator + roll + "Frant.jpg");
                        f2 = new File(System.getProperty("user.dir") + File.separator + dept + File.separator + roll + File.separator + roll + "back.jpg");
                        FrantSideWritee fsw = new FrantSideWritee();
                        fsw.ForntSide(userfrant, name, roll, dept, year, shift, f1, last);
                        ImageBackSiderWrite ibsw = new ImageBackSiderWrite();
                        ibsw.DrawBack(address, contact, dob,bg, f2);
                        al.add(roll);
                    }

//                rollno.get(1);
//                rollno.get(2);
//                rollno.get(3);
//                rollno.get();
//                rollno.get(0);
//                }
//                File filee = new File("D:" + File.separator + "ID Card PDF" + File.separator + dept + File.separator + roll + ".pdf");
//                }
                DAO dao = new DAO();
                dao.imageWariter(al, roll, dept, year, shift);
//            ItextMerge merge = new ItextMerge();
//            merge.pdfmarge(rollno, dept);
//                break;
                JOptionPane.showMessageDialog(null, "ID Card Generated Successfully.....");
//                jc_Shift.setSelectedIndex(0);
//                jc_Year.setSelectedIndex(0);
//                jcoption.setSelectedIndex(0);
//                jc_Shift.setEnabled(false);
//                jc_Year.setEnabled(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
//        }
    }
    
}
