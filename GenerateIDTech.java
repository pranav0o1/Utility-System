/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.DAO;
import dao.DaoConnection;
import dao.FrantSideWritee;
import dao.ImageBackSiderWrite;
import java.awt.Frame;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class GenerateIDTech extends javax.swing.JPanel {

    DaoConnection dc = new DaoConnection();
    Connection conn;
    DefaultListModel listModel = new DefaultListModel();
    /**
     * Creates new form GenerateID
     */
   
    Frame frm;
    public GenerateIDTech(Frame frm) {
       this.frm=frm;
        initComponents();

         frm.setExtendedState(MAXIMIZED_BOTH);
        
        conn = dc.getConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcoption = new javax.swing.JComboBox();
        Bt_Generate = new javax.swing.JButton();
        bt_back = new javax.swing.JButton();
        jc_Shift = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(26, 42, 57));
        jPanel4.setMaximumSize(new java.awt.Dimension(953, 30));
        jPanel4.setMinimumSize(new java.awt.Dimension(953, 30));
        jPanel4.setPreferredSize(new java.awt.Dimension(953, 30));
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setPreferredSize(new java.awt.Dimension(953, 442));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(UserList);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(26, 42, 57));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Depatment");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 251, 0, 0);
        jPanel2.add(jLabel1, gridBagConstraints);

        jcoption.setForeground(new java.awt.Color(26, 42, 57));
        jcoption.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----Select Dept-------", "ME", "Civil", "E & TC", "CO", "IF" }));
        jcoption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcoptionMouseClicked(evt);
            }
        });
        jcoption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcoptionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 6, 0, 251);
        jPanel2.add(jcoption, gridBagConstraints);

        Bt_Generate.setBackground(new java.awt.Color(255, 255, 255));
        Bt_Generate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Bt_Generate.setForeground(new java.awt.Color(26, 42, 57));
        Bt_Generate.setText("Generate ID");
        Bt_Generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bt_GenerateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 251, 32, 0);
        jPanel2.add(Bt_Generate, gridBagConstraints);

        bt_back.setBackground(new java.awt.Color(255, 255, 255));
        bt_back.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        bt_back.setForeground(new java.awt.Color(26, 42, 57));
        bt_back.setText("Back");
        bt_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 77, 32, 251);
        jPanel2.add(bt_back, gridBagConstraints);

        jc_Shift.setForeground(new java.awt.Color(26, 42, 57));
        jc_Shift.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----- Select Shift -----", "I", "II" }));
        jc_Shift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_ShiftActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 36;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 251);
        jPanel2.add(jc_Shift, gridBagConstraints);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Shift");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 46;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 251, 0, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void Bt_GenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bt_GenerateActionPerformed
        // TODO add your handling code here:
        List rollno = UserList.getSelectedValuesList();
        if (rollno.size() == 0) {
            JOptionPane.showMessageDialog(null, "Please Select Teacher ID ....");
        } else {
            int cont = 0;
            String name = "";
            String contact = "";
//            String dob = "";
            String Id = "";
            String dept = "";
            String shift = "";
            String desig = "";
            String Address = "";
            Blob userimage = null;
//            Blob sing = null;
            File f1 = null;
            File f2 = null;
            String last = "";
            ArrayList al = new ArrayList();
            System.out.println(rollno);
            try {
                for (int i = 0; i < rollno.size(); i++) {
                    String get = (String) rollno.get(i);
                    System.out.println("Get Roll No " + get);

//                if(cont==0){
                    String query = "Select * from tbtecher where id='" + get + "'";
                    PreparedStatement ps = conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        name = rs.getString("first");
                        last = rs.getString("last");
                        contact = rs.getString("contact");
//                        dob = rs.getString("dob");
                        Id = rs.getString("id");
                        dept = rs.getString("dept");
                        shift = rs.getString("shift");
                        Address = rs.getString("address");
                        desig = rs.getString("desig");
                        userimage = rs.getBlob("photo");
//                        sing = rs.getBlob("sign");

                        File f = new File(System.getProperty("user.dir") + File.separator + "temp");
                        f.mkdir();

                        File userfrant = new File(System.getProperty("user.dir") + File.separator + "temp" + File.separator + Id + "user.jpg");
                        InputStream binaryStream = userimage.getBinaryStream(1, userimage.length());
                        FileOutputStream fos = new FileOutputStream(userfrant);
                        int c = 0;
                        while ((c = binaryStream.read()) != -1) {
                            fos.write(c);
                        }
                        fos.close();

                        File file = new File(System.getProperty("user.dir") + File.separator + dept + File.separator + Id);
                        file.mkdirs();
                        f1 = new File(System.getProperty("user.dir") + File.separator + dept + File.separator + Id + File.separator + Id + "Frant.jpg");
                        f2 = new File(System.getProperty("user.dir") + File.separator + dept + File.separator + Id + File.separator + Id + "back.jpg");
                        FrantSideWritee fsw = new FrantSideWritee();
                        fsw.ForntSideTech(userfrant, name, dept, f1, last,desig,shift);
                        ImageBackSiderWrite ibsw = new ImageBackSiderWrite();
                        ibsw.DrawBackTech(Address, contact, f2);
                        al.add(Id);
                    }


                }
                DAO dao = new DAO();
                dao.imageWariterTech(al, Id, dept,shift);
//            ItextMerge merge = new ItextMerge();
//            merge.pdfmarge(rollno, dept);
//                break;
                JOptionPane.showMessageDialog(null, "ID Card Generated Successfully.....");
//                jc_Shift.setSelectedIndex(0);
//                jc_Year.setSelectedIndex(0);
                jcoption.setSelectedIndex(0);
//                jc_Shift.setEnabled(false);
//                jc_Year.setEnabled(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_Bt_GenerateActionPerformed

    private void jcoptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcoptionActionPerformed
        
    }//GEN-LAST:event_jcoptionActionPerformed

    private void jcoptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcoptionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jcoptionMouseClicked

    private void bt_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backActionPerformed
        // TODO add your handling code here:
        MainPln.PnelMn.removeAll();
        MainPln.PnelMn.add(new Login(frm));
        MainPln.PnelMn.updateUI();
    }//GEN-LAST:event_bt_backActionPerformed

    private void jc_ShiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_ShiftActionPerformed
        // TODO add your handling code here:
        if (jc_Shift.getSelectedIndex() == 0) {
            //            JOptionPane.showMessageDialog(null, "Please Select Shift...");
        } else {
            String DeptName = (String) jcoption.getSelectedItem();
//            String year = (String) jc_Year.getSelectedItem();
            String shift = (String) jc_Shift.getSelectedItem();
            int tempVal = 0;
            //            Connection conn = dbcon.getConnection();
            try {

                listModel.clear();
                this.UserList.setModel(listModel);
                UserList.updateUI();
                JCheckBox box = new JCheckBox(DeptName);
                String sql_query = "select * from tbtecher where dept='" + DeptName + "'&& shift='" + shift + "'";

                PreparedStatement pre = conn.prepareStatement(sql_query);

                ResultSet rs1 = pre.executeQuery();

                while (rs1.next()) {
//                    String first = rs1.getString("first");
                    String Rollno = rs1.getString("id");
                    //                    box.(Rollno);
                    //                String string = rs1.getString(2);
                    //                    listModel.addElement(name);
                    listModel.addElement(Rollno);
//                    listModel.addElement(first);
                    //                    jPanel3.add(box);
                    this.UserList.setModel(listModel);
                    updateUI();
                    //                jcoption.addItem(temp);
                    //                tempVal++;
                }
                //            conn.close();
                //                int totalNoOfProduct = tempVal;
                //            System.out.println("totalNoOfProduct" + totalNoOfProduct);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jc_ShiftActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bt_Generate;
    private javax.swing.JList UserList;
    private javax.swing.JButton bt_back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jc_Shift;
    private javax.swing.JComboBox jcoption;
    // End of variables declaration//GEN-END:variables
}
