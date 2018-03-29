/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.DaoConnection;
import dao.GetAllDate;
import dao.PoiWriteExcelFile;
import static gui.Login.typeTeacher;
import java.awt.Frame;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tulajaram
 */
public class pnlAttendance1 extends javax.swing.JPanel {

    /**
     * Creates new form pnlAttendance1
     */
    DefaultTableModel model;
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    DefaultTableModel model3 = new DefaultTableModel();
    JCheckBox jPresent = new JCheckBox("Present");
    JCheckBox jAbsent = new JCheckBox("Absent");
    Connection con;
    DaoConnection dc = new DaoConnection();
    private JTable tbAttendeance1;
    Frame frm;
    Date d;
    String username = "";
    String deptclass = "";
    String year1class = "";
    String shift1class = "";

    public pnlAttendance1(Frame frm) {
        this.frm = frm;

        initComponents();

        d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("EEE_dd_MMM_yyyy");
        System.out.println(">>>>>" + format.format(d));
        dateSelect.setDate(d);
//        tbAttendeance.setVisible(false);
        jScrollPane1.setVisible(false);
        jScrollPane2.setVisible(false);
        lbTo.setVisible(false);
        lbFrom.setVisible(false);
        dateFrom.setVisible(false);
        dateTo.setVisible(false);
        shift.setVisible(false);
//        jcTHPR.setVisible(false);
//        table.setVisible(false);
        branch.setVisible(false);

        try {
            model = new DefaultTableModel();
            frm.setExtendedState(MAXIMIZED_BOTH);
//            lbName.setText(""); 
            lbName.setText(Login.userName);
            lbName.updateUI();
            if (Login.typeTeacher.equalsIgnoreCase("Subject Teacher")) {
//                con.close();
                lbYear.setVisible(false);
                jLabel5.setVisible(false);
                con = dc.getConnection();
                PreparedStatement ps = con.prepareStatement("select * from subject_teacher where username='" + Login.userName + "'");
                ResultSet set = ps.executeQuery();
                while (set.next()) {
                    String Dept = set.getString("department");
                    String ye = set.getString("year");
                    String shft = set.getString("shift");
                    String sub = set.getString("subject");
                    String typee = set.getString("type");

//                    branch.addItem(Dept);
                    year.addItem(ye);
                    shift.addItem(shft);
                    lbDept.setText(Dept);
                    lbShift.setText(shft);

//                    if (typee.contains("+")) {
//                        String[] split = typee.split("\\+");
//                        for (int i = 0; i < split.length; i++) {
//                            jcTHPR.addItem(split[i]);
//                        }
//                    } else {
//                    jcTHPR.addItem(typee);
//                    }
                    String[] split = sub.split(",");
                    for (int i = 0; i < split.length; i++) {
                        jcSubject.addItem(split[i]);
                    }
                }
//                model.addColumn("Name");
//                model.addColumn("Last");
//                model.addColumn("Roll No");
//                model.addColumn("Present / Absent");
                pnlChange.removeAll();
                pnlChange.add(pnltable);
                pnlChange.updateUI();
                jcTecher.setVisible(false);
                btnShow.setVisible(false);
//                btnShowAll.setVisible(false);
                btnGen.setVisible(false);
                btnHoDShow.setVisible(false);
            } else if (Login.typeTeacher.equalsIgnoreCase("Class Teacher")) {
                lbTo.setVisible(true);
                lbFrom.setVisible(true);
                dateFrom.setVisible(true);
                dateTo.setVisible(true);

                shift.setVisible(false);
                jcTHPR.setVisible(false);
//                branch.setVisible(false);
                dateSelect.setVisible(false);
                year.setVisible(false);
                con = dc.getConnection();
                PreparedStatement ps = con.prepareStatement("select * from class_teacher where username='" + Login.userName + "'");
                ResultSet set = ps.executeQuery();

                while (set.next()) {
                    deptclass = set.getString("department");
                    year1class = set.getString("year");
                    shift1class = set.getString("shift");
                }

                PreparedStatement ps1 = con.prepareStatement("select * from subject_teacher where department='" + deptclass + "'&&year='" + year1class + "'&&shift='" + shift1class + "'");
                ResultSet sett = ps1.executeQuery();
                while (sett.next()) {
                    username = sett.getString("username");
//                    subject = sett.getString("subject");
                    jcTecher.addItem(username);
//                    if (subject.contains(",")) {
//                        String[] split = subject.split("\\,");
//                        for (int k = 0; k < split.length; k++) {
//                            jcSubject.addItem(split[k]);
//                        }
//                    } else {
//                        jcSubject.addItem(subject);
//                    }
                }
//                System.out.println("deptclass :"+deptclass);
//                System.out.println("year1class : "+year1class);
//                branch.addItem(deptclass);
                lbDept.setText(deptclass);
                lbYear.setText(year1class);
                jcTecher.setVisible(false);
                jcSubject.setVisible(false);
//                lbYear.setText(deptclass);
//                year.addItem(year1class);
//                shift.addItem(shift1class);
                btnShowAll.setVisible(false);
                pnlChange.removeAll();
                pnlChange.add(table);
                pnlChange.updateUI();
                btnAtta.setVisible(false);
                btnAttendance.setVisible(false);
                jScrollPane1.setVisible(true);
                btnHoDShow.setVisible(false);
//                con.close();
            } else if (Login.typeTeacher.equalsIgnoreCase("H.O.D")) {
                btnShow.setVisible(false);
                btnAttendance.setVisible(false);
                btnShowAll.setVisible(false);
                btnAtta.setVisible(false);
                jcSubject.setVisible(false);
                jcTHPR.setVisible(false);
                jcTecher.setVisible(false);
                branch.setVisible(false);
//                year.setVisible(false);
                btnGen.setVisible(false);
                dateSelect.setVisible(false);
                jLabel5.setVisible(false);
                lbYear.setVisible(false);
                pnlChange.removeAll();
                pnlChange.add(table);
                pnlChange.updateUI();
                jScrollPane1.setVisible(true);
                con = dc.getConnection();
                String dept = "";
                PreparedStatement ps = con.prepareStatement("select department from hod where username='" + Login.userName + "'");
                ResultSet set = ps.executeQuery();
                while (set.next()) {
                    dept = set.getString(1);
                }
                lbDept.setText(dept);
                PreparedStatement ps1 = con.prepareStatement("select year from class_teacher where department='" + dept + "'");
                ResultSet rs = ps1.executeQuery();
                while (rs.next()) {
                    year.addItem(rs.getString(1));
                }

            }

//        try {
//
//            PreparedStatement ps = con.prepareStatement("select * from subject_list");
//            ResultSet set = ps.executeQuery();
//            while (set.next()) {
//                String string1 = set.getString(1);
//                String string = set.getString(2);
//                jcSubject.addItem(string);
//                jcTecher.addItem(string1);
//            }
//            jcSubject.updateUI();
//            jcTecher.updateUI();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbAttendeance = new javax.swing.JTable();
        table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbShowAtt = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        pnlChange = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        pnltable = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        jcTecher = new javax.swing.JComboBox();
        jcSubject = new javax.swing.JComboBox();
        branch = new javax.swing.JComboBox();
        year = new javax.swing.JComboBox();
        shift = new javax.swing.JComboBox();
        jcTHPR = new javax.swing.JComboBox();
        dateSelect = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        lbDept = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbShift = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbYear = new javax.swing.JLabel();
        lbFrom = new javax.swing.JLabel();
        dateFrom = new org.jdesktop.swingx.JXDatePicker();
        lbTo = new javax.swing.JLabel();
        dateTo = new org.jdesktop.swingx.JXDatePicker();
        jPanel3 = new javax.swing.JPanel();
        btnHoDShow = new javax.swing.JButton();
        btnAtta = new javax.swing.JButton();
        btnShowAll = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        btnGen = new javax.swing.JButton();
        btnAttendance = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        tbAttendeance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbAttendeance);

        table.setLayout(new java.awt.BorderLayout());

        tbShowAtt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbShowAtt);

        table.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        pnlChange.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());

        pnltable.setLayout(new java.awt.BorderLayout());
        jPanel6.add(pnltable, java.awt.BorderLayout.CENTER);

        jPanel11.setBackground(new java.awt.Color(26, 42, 57));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Attendance Table");
        jPanel11.add(jLabel4);

        jPanel6.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        pnlChange.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(pnlChange);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(26, 42, 57));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(26, 42, 57));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hi,  ");
        jPanel4.add(jLabel1);

        lbName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(255, 255, 255));
        lbName.setText("Name");
        jPanel4.add(lbName);

        jcTecher.setPreferredSize(new java.awt.Dimension(100, 30));
        jcTecher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcTecherItemStateChanged(evt);
            }
        });
        jcTecher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcTecherActionPerformed(evt);
            }
        });
        jPanel4.add(jcTecher);

        jcSubject.setMaximumSize(new java.awt.Dimension(200, 30));
        jcSubject.setMinimumSize(new java.awt.Dimension(200, 30));
        jcSubject.setPreferredSize(new java.awt.Dimension(200, 30));
        jcSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcSubjectActionPerformed(evt);
            }
        });
        jPanel4.add(jcSubject);

        branch.setMaximumSize(new java.awt.Dimension(100, 30));
        branch.setMinimumSize(new java.awt.Dimension(100, 30));
        branch.setPreferredSize(new java.awt.Dimension(100, 30));
        branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchActionPerformed(evt);
            }
        });
        jPanel4.add(branch);

        year.setMaximumSize(new java.awt.Dimension(100, 30));
        year.setMinimumSize(new java.awt.Dimension(100, 30));
        year.setPreferredSize(new java.awt.Dimension(100, 30));
        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });
        jPanel4.add(year);

        shift.setPreferredSize(new java.awt.Dimension(182, 30));
        shift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftActionPerformed(evt);
            }
        });
        jPanel4.add(shift);

        jcTHPR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TH", "PR" }));
        jcTHPR.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel4.add(jcTHPR);

        dateSelect.setMaximumSize(new java.awt.Dimension(150, 30));
        dateSelect.setMinimumSize(new java.awt.Dimension(150, 30));
        dateSelect.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel4.add(dateSelect);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("  Department :");
        jPanel4.add(jLabel2);

        lbDept.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbDept.setForeground(new java.awt.Color(255, 255, 255));
        lbDept.setText("ABC");
        jPanel4.add(lbDept);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("      Shift :");
        jPanel4.add(jLabel3);

        lbShift.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbShift.setForeground(new java.awt.Color(255, 255, 255));
        lbShift.setText("I");
        jPanel4.add(lbShift);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("    Year :");
        jPanel4.add(jLabel5);

        lbYear.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbYear.setForeground(new java.awt.Color(255, 255, 255));
        lbYear.setText("XY");
        jPanel4.add(lbYear);

        lbFrom.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lbFrom.setForeground(new java.awt.Color(255, 255, 255));
        lbFrom.setText(" FROM : ");
        jPanel4.add(lbFrom);

        dateFrom.setMaximumSize(new java.awt.Dimension(150, 30));
        dateFrom.setMinimumSize(new java.awt.Dimension(150, 30));
        dateFrom.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel4.add(dateFrom);

        lbTo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lbTo.setForeground(new java.awt.Color(255, 255, 255));
        lbTo.setText(" TO : ");
        jPanel4.add(lbTo);

        dateTo.setMaximumSize(new java.awt.Dimension(150, 30));
        dateTo.setMinimumSize(new java.awt.Dimension(150, 30));
        dateTo.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel4.add(dateTo);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(26, 42, 57));

        btnHoDShow.setText("Show HOD Att");
        btnHoDShow.setPreferredSize(new java.awt.Dimension(180, 35));
        btnHoDShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoDShowActionPerformed(evt);
            }
        });
        jPanel3.add(btnHoDShow);

        btnAtta.setText("Show Attandance Table");
        btnAtta.setMinimumSize(new java.awt.Dimension(180, 35));
        btnAtta.setPreferredSize(new java.awt.Dimension(180, 35));
        btnAtta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttaActionPerformed(evt);
            }
        });
        jPanel3.add(btnAtta);

        btnShowAll.setBackground(new java.awt.Color(255, 255, 255));
        btnShowAll.setForeground(new java.awt.Color(26, 42, 57));
        btnShowAll.setText("Show Database");
        btnShowAll.setMaximumSize(new java.awt.Dimension(120, 35));
        btnShowAll.setMinimumSize(new java.awt.Dimension(120, 35));
        btnShowAll.setPreferredSize(new java.awt.Dimension(150, 35));
        btnShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllActionPerformed(evt);
            }
        });
        jPanel3.add(btnShowAll);

        btnShow.setBackground(new java.awt.Color(255, 255, 255));
        btnShow.setForeground(new java.awt.Color(26, 42, 57));
        btnShow.setText("Show Database");
        btnShow.setMaximumSize(new java.awt.Dimension(120, 35));
        btnShow.setMinimumSize(new java.awt.Dimension(120, 35));
        btnShow.setPreferredSize(new java.awt.Dimension(150, 35));
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });
        jPanel3.add(btnShow);

        btnGen.setText("Generate Report");
        btnGen.setPreferredSize(new java.awt.Dimension(150, 35));
        btnGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenActionPerformed(evt);
            }
        });
        jPanel3.add(btnGen);

        btnAttendance.setBackground(new java.awt.Color(255, 255, 255));
        btnAttendance.setForeground(new java.awt.Color(26, 42, 57));
        btnAttendance.setText("Attendance");
        btnAttendance.setPreferredSize(new java.awt.Dimension(120, 35));
        btnAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttendanceActionPerformed(evt);
            }
        });
        jPanel3.add(btnAttendance);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(26, 42, 57));
        jButton2.setText("Back");
        jButton2.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        add(jPanel3, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void shiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftActionPerformed
        // TODO add your handling code here:
//        String name;
//        String rollNo;
//        String last;
//
//        try {
//            if (Login.typeTeacher.equalsIgnoreCase("Subject Teacher")) {
//
////                tbAttendeance1.removeAll();
////                tbAttendeance1.repaint();
////            model = new DefaultTableModel();
////            model.addColumn("Name");
////            model.addColumn("Last");
////            model.addColumn("Roll No");
////            model.addColumn("Present");
//                model.setRowCount(0);
//                String txtBranch = (String) branch.getSelectedItem();
//                String txtYear = (String) year.getSelectedItem();
//                String txtShift = (String) shift.getSelectedItem();
//                Vector v = new Vector();
////                con.close();
//                con = dc.getConnection();
//                PreparedStatement ps = con.prepareStatement("Select * from registrationtbl where department='" + txtBranch + "'&&shift='" + txtShift + "'&&year='" + txtYear + "'");
//                ResultSet set = ps.executeQuery();
//                while (set.next()) {
//                    Vector data = new Vector();
//                    name = set.getString("name");
//                    last = set.getString("last");
//                    rollNo = set.getString("roll");
//                    data.add(name);
//                    data.add(last);
//                    data.add(rollNo);
//                    v.add(data);
//                }
////            DefaultTableModel model = null;
//                con.close();
//                for (int i = 0; i < v.size(); i++) {
//                    Vector get = (Vector) v.get(i);
//                    model.addRow(get);
//                }
//                tbAttendeance1 = new JTable(model) {
//
//                    private static final long serialVersionUID = 1L;
//
//                    @Override
//                    public Class getColumnClass(int column) {
//                        switch (column) {
//                            case 0:
//                                return String.class;
//                            case 1:
//                                return String.class;
//                            case 2:
//                                return String.class;
//                            default:
//                                return Boolean.class;
//                        }
//                    }
//                };
//                tbAttendeance1.setPreferredScrollableViewportSize(tbAttendeance1.getPreferredSize());
//                JScrollPane scrollPane = new JScrollPane(tbAttendeance1);
//                pnltable.add(scrollPane);
//                pnltable.updateUI();
//                tbAttendeance1.updateUI();
//                scrollPane.updateUI();
//            } else {
////                pnltable.removeAll();
////                pnltable.add(table);
////                pnltable.updateUI();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_shiftActionPerformed

    private void btnAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttendanceActionPerformed
        // TODO add your handling code here:
        int checkatt = 0;
        try {
//            Date d=new Date();
            d = dateSelect.getDate();
            SimpleDateFormat format = new SimpleDateFormat("EEE_dd_MMM_yyyy");
            System.out.println(">>>>>" + format.format(d));
            //2014/08/06 15:59:48
//            SimpleDateFormat format=new SimpleDateFormat("");
            String sub = (String) jcSubject.getSelectedItem();
//            String txtBranch = (String) branch.getSelectedItem();
            String txtBranch = lbDept.getText();
            String txtYear = (String) year.getSelectedItem();
            String txtTHPR = (String) jcTHPR.getSelectedItem();
            String txtShift = lbShift.getText();
//            String branchName = txtBranch.replaceAll(" ", "_");
            String branchName = lbDept.getText().replaceAll(" ", "_");
            String yearName = txtYear.replaceAll(" ", "_");
//            String shiftName = txtShift.replaceAll(" ", "_");
            String shiftName = lbShift.getText().replaceAll(" ", "_");
            String subject = sub.replaceAll(" ", "_");
            String tbName = Login.userName + "_" + subject + "_" + branchName + "_" + yearName + "_" + shiftName + "_" + txtTHPR;
            System.out.println("" + tbName);
            createTable(tbName);
            Vector v = new Vector();
            con.close();
            con = dc.getConnection();
            try {
                PreparedStatement pre = con.prepareStatement("insert into tablerecode (dept,tablename,year,techname,subject,type) values (?,?,?,?,?,?)");
                pre.setString(1, branchName);
                pre.setString(2, tbName);
                pre.setString(3, yearName);
                pre.setString(4, Login.userName);
                pre.setString(5, sub);
                pre.setString(6, txtTHPR);
                pre.execute();
            } catch (SQLException e) {

            }
            PreparedStatement ps = con.prepareStatement("Select * from registrationtbl where department='" + txtBranch + "'&&shift='" + txtShift + "'&&year='" + txtYear + "'");
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                Vector data = new Vector();
                String name = set.getString("name");
                String last = set.getString("last");
                String rollNo = set.getString("roll");
                data.add(name);
                data.add(last);
                data.add(rollNo);
                v.add(data);
            }
            con.close();
            con = dc.getConnection();
            Vector check = new Vector();
            PreparedStatement statement = con.prepareStatement("Select * from " + tbName);
            ResultSet executeQuery = statement.executeQuery();
            while (executeQuery.next()) {
                Vector ddd = new Vector();
                ddd.add(executeQuery.getString("name"));
                ddd.add(executeQuery.getString("last"));
                check.add(ddd);
            }
            GetAllDate gad = new GetAllDate();
            gad.setAllDateDb(tbName);
//            AlterTable(tbName);
//            SimpleDateFormat format = new SimpleDateFormat("dd_MM_yyyy");
//            Date d = new Date();
            String format1 = format.format(d);
            String data1 = format1;
            System.out.println("data1 " + data1);
            if (check.isEmpty()) {
                System.out.println("if outer..........");
                con.close();
                con = dc.getConnection();
                PreparedStatement ps1 = con.prepareStatement("insert into " + tbName + "(name,last,roll," + data1 + ") values(?,?,?,?)");

                for (int i = 0; i < v.size(); i++) {
                    Vector data = (Vector) v.get(i);
                    System.out.println("" + data);
                    String status = "";
                    boolean val = true;
                    Object valueAt = tbAttendeance1.getValueAt(i, 3);
                    System.out.println("valueAt ::::::::::::: " + valueAt);
                    if (valueAt == null) {
                        val = false;
                    } else if (valueAt.equals(false)) {
                        val = false;
                    } else {
                        val = true;
                    }

                    System.out.println("value  : " + valueAt);
                    if (val == true) {
                        status = "Absent";//Present
//                        System.out.println("If  ");
                    } else if (valueAt == null) {
                        status = "Present";//Absent
                        System.out.println("else if");
                    } else {
                        status = "Present";//Absent
//                        System.out.println("else");
                    }
                    System.out.println("status : " + status);

                    ps1.setString(1, data.get(0).toString());
                    ps1.setString(2, data.get(1).toString());
                    ps1.setString(3, data.get(2).toString());
                    ps1.setString(4, status);
                    ps1.execute();
                    checkatt = 1;
                }
            } else {
                System.out.println("else outer");
                for (int i = 0; i < v.size(); i++) {
                    Vector mainData = (Vector) v.get(i);
                    Vector actualData = (Vector) check.get(i);
                    boolean val = true;
                    Object valueAt = tbAttendeance1.getValueAt(i, 3);
                    if (valueAt == null) {
                        val = false;
                    } else if (valueAt.equals(false)) {
                        val = false;
                    } else {
                        val = true;
                    }
                    String status = "";
                    System.out.println("value  : " + valueAt);
                    if (val == true) {
                        status = "Absent";//Present
                        System.out.println("If  ");
                    } else {
                        status = "Present";//Absent
                        System.out.println("else");
                    }
                    System.out.println("statuss : " + status);
                    if (mainData.get(0).equals(actualData.get(0)) && mainData.get(1).equals(actualData.get(1))) {
                        System.out.println("if inner........");
                        con.close();
                        con = dc.getConnection();
                        PreparedStatement ps2 = con.prepareStatement("update " + tbName + " set " + data1 + "='" + status + "' where name='" + actualData.get(0).toString() + "'&&last='" + actualData.get(1).toString() + "'");
//                        ps2.setString(1, status);
                        ps2.executeUpdate();
                        checkatt = 1;
                    } else {
                        con.close();
                        con = dc.getConnection();
                        System.out.println("else Inner..........");
                        PreparedStatement ps2 = con.prepareStatement("insert into " + tbName + "s(name,last,roll," + data1 + ") values(?,?,?,?)");
                        ps2.setString(1, mainData.get(0).toString());
                        ps2.setString(2, mainData.get(1).toString());
                        ps2.setString(3, mainData.get(2).toString());
                        ps2.setString(4, status);
                        checkatt = 1;
                    }
                }
            }
            if (checkatt == 1) {
                JOptionPane.showMessageDialog(null, "Attendance Marked Successfully !!!");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAttendanceActionPerformed

    private void branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchActionPerformed
        // TODO add your handling code here:
//        if (branch.getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(null, "Please Select Branch...");
//        } else {
//            String selectedItem = (String) branch.getSelectedItem();
//        }
    }//GEN-LAST:event_branchActionPerformed

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
//        if (year.getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(null, "Please Select Year...");
//        } else {
//
//        }
    }//GEN-LAST:event_yearActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MainPln.PnelMn.removeAll();
        MainPln.PnelMn.add(new Login(frm));
        MainPln.PnelMn.updateUI();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:

        try {
            boolean isflag = true;
            int ii = 1;
            table.setVisible(true);
            model = new DefaultTableModel();
            String teach = "";
            String txtYear = "";
            if (typeTeacher.equalsIgnoreCase("Subject Teacher")) {
                teach = lbName.getText();
                txtYear = (String) year.getSelectedItem();
                pnlChange.removeAll();
                pnlChange.add(table);
                pnlChange.updateUI();
                Thread.sleep(4000);
                pnlChange.removeAll();
                pnlChange.add(table);
                pnlChange.updateUI();
            } else {
                teach = (String) jcTecher.getSelectedItem();
                txtYear = lbYear.getText();
            }
            String sub = (String) jcSubject.getSelectedItem();
//            String txtBranch = (String) branch.getSelectedItem();
            String txtBranch = lbDept.getText();
            table.updateUI();

//            String txtShift = (String) shift.getSelectedItem();
            String txtShift = lbShift.getText();
            String branchName = txtBranch.replaceAll(" ", "_");
            String yearName = txtYear.replaceAll(" ", "_");
            String shiftName = txtShift.replaceAll(" ", "_");
            String subject = sub.replaceAll(" ", "_");
            Vector techlist = new Vector();
            Vector finallist = new Vector();

            if (!sub.equals("Select Subject")) {
                con = dc.getConnection();
                PreparedStatement pre = con.prepareStatement("select tablename,techname,subject from tablerecode where year='" + yearName + "'&&dept='" + branchName + "'");
                ResultSet setSele = pre.executeQuery();
                Vector taableNameData = new Vector();
                while (setSele.next()) {
                    taableNameData.add(setSele.getString(1));
                    String string = setSele.getString(3);
//                    System.out.println("string :"+string);
                    String replaceAll = string.replaceAll("_", " ");
                    System.out.println("replaceAll : "+replaceAll);
                    techlist.add(replaceAll);
                }
                System.out.println("thlist ::: " + taableNameData);
                Vector AllPerRecord = new Vector();
                ResultSetMetaData metaData = null;
                for (int k = 0; k < taableNameData.size(); k++) {

                    String tbName = taableNameData.get(k).toString();//teach + "_" + subject + "_" + branchName + "_" + yearName + "_" + shiftName.trim();
                    PreparedStatement ps = con.prepareStatement("select * from " + tbName.trim());
                    ResultSet set = ps.executeQuery();

                    Vector v = new Vector();

                    metaData = set.getMetaData();
//                    System.out.println("" + metaData.getColumnCount());
//                for (int i = 0; i < metaData.getColumnCount(); i++) {
//                    String columnName = metaData.getColumnName(i + 1);
//                    if (i < 3) {
//                        model.addColumn(columnName);
//                    }
//
//                }
//                model.addColumn(teach);
                    while (set.next()) {
                        Vector v1 = new Vector();
                        for (int j = 0; j < metaData.getColumnCount(); j++) {

                            String string = set.getString(j + 1);
//                    System.out.println("columnName " + columnName);
                            v1.add(string);
                        }
                        v.add(v1);
                    }

                    //Find range to display attendence percentage
                    String sDate = "", eDate = "";
                    System.out.println("final values  ::  " + finallist);

                    SimpleDateFormat format = new SimpleDateFormat("EEE_dd_MMM_yyyy");
                    sDate = format.format(dateFrom.getDate());
                    eDate = format.format(dateTo.getDate());
                    int flag = 0;
                    String range = "";

                    ArrayList<String> dates = new ArrayList<>();
                    for (int i = 0; i < metaData.getColumnCount(); i++) {
                        String columnName = metaData.getColumnName(i + 1);
                        if (i > 2) {
                            dates.add(columnName.trim());

                        }
                    }
                    if (!dates.contains(sDate) && !dates.contains(eDate)) {
                        JOptionPane.showMessageDialog(null, "Enter valid dates");
                    }

                    for (int i = 0; i < metaData.getColumnCount(); i++) {
                        String columnName = metaData.getColumnName(i + 1);
                        if (i > 2) {
                            if (columnName.equals(sDate)) {
                                flag = 1;
                                range = String.valueOf(i);
                            }
                            if (flag == 1 && !columnName.equals(eDate)) {

                            } else if (flag == 1) {

                                range += "," + i;
                            }

                        }
                    }

                    int s, e;
                    s = Integer.parseInt(range.split(",")[0]);
                    e = Integer.parseInt(range.split(",")[1]);
                    range = "";
                    for (int i = s; i <= e; i++) {
                        range += "," + i;
                    }

                    Vector valuePreAbs = new Vector();
                    Vector StudentName = new Vector();
                    for (int i = 0; i < v.size(); i++) {
                        Vector allvect = (Vector) v.get(i);
                        Vector v1 = new Vector();
                        Vector v2 = new Vector();
                        for (int j = 0; j < allvect.size(); j++) {
                            String get = (String) allvect.get(j);

//                        System.out.println("vetctor values  ::  " + get);
                            if (j > 2) {
                                if (range.contains(String.valueOf(j))) {
                                    v1.add(get);
                                }
                            } else {

                                v2.add(get);
                            }
                        }
                        StudentName.add(v2);
                        valuePreAbs.add(v1);
                    }

                    Vector pres = new Vector();
//                    System.out.println(StudentName + "vetctor values  ::  " + valuePreAbs);

                    Vector finalVale = new Vector();
                    for (int j = 0; j < valuePreAbs.size(); j++) {
                        Vector getVal = (Vector) valuePreAbs.get(j);
                        Vector vv = new Vector();
                        for (int ll = 0; ll < getVal.size(); ll++) {

                            if (getVal.get(ll).toString().equalsIgnoreCase("Present") || getVal.get(ll).toString().equalsIgnoreCase("Absent")) {
                                vv.add(getVal.get(ll));

                            }

                        }
                        finalVale.add(vv);
                    }

                    for (int j = 0; j < finalVale.size(); j++) {
                        double numerator = 0;
                        double avg = 0;
                        Vector v1 = new Vector();
                        Vector valll = (Vector) finalVale.get(j);
                        for (int i = 0; i < valll.size(); i++) {
                            if (valll.get(i).equals("Present")) {
                                numerator++;
                            } else {

                            }

                        }
                        avg = numerator / valll.size();
//                        System.out.println("avg : " + avg * 100);
                        long round = Math.round(avg * 100);
                        v1.add(round);
                        pres.add(v1);
//                    RowValue.add(v1);
//                        System.out.println("persent values v1 ::  " + v1);
                    }
//                    System.out.println("persent values  ::  " + pres);
                    Vector Finalvect = new Vector();
                    if (isflag) {

                        for (int i = 0; i < pres.size(); i++) {
                            Vector get = (Vector) pres.get(i);
                            Vector stName = (Vector) StudentName.get(i);
//                        if (ii==0) {

                            for (int j = 0; j < get.size(); j++) {
                                stName.add(get.get(j));
                            }
//                        }else{
//                           Finalvect.add(get.lastElement());
//                         }

                            Finalvect.add(stName);
                        }
                        isflag = false;
//                        System.out.println("final values  ::  " + Finalvect);
                        for (int i = 0; i < Finalvect.size(); i++) {
                            AllPerRecord.add(Finalvect.get(i));
                        }
                    } else {
                        for (int i = 0; i < pres.size(); i++) {
                            Vector get = (Vector) pres.get(i);
                            Vector get1 = (Vector) AllPerRecord.get(i);
                            for (int j = 0; j < get.size(); j++) {
                                get1.add(get.get(j));
                            }
                            if (!finallist.contains(get1)) {
                                finallist.add(get1);
                            }
                        }
                    }

                }

                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String columnName = metaData.getColumnName(i + 1);
                    if (i < 3) {

                        model.addColumn(columnName);
                        excelSheetDataColumn.add(columnName);

                    }
                }

                for (int i = 0; i < techlist.size(); i++) {
                    System.out.println("****** "+techlist.get(i));
                    model.addColumn(techlist.get(i));
                    excelSheetDataColumn.add(techlist.get(i));
                }

                for (int i = 0; i < finallist.size(); i++) {
                    model.addRow((Vector) finallist.get(i));
                    excelSheetDataRow.add(finallist.get(i));
                }
                con.close();
                tbShowAtt.setModel(model);
            } else {
                JOptionPane.showMessageDialog(null, "Please Select Subject !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnShowActionPerformed
    Vector excelSheetDataColumn = new Vector();
    Vector excelSheetDataRow = new Vector();
    private void btnGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenActionPerformed
        // TODO add your handling code here:

        String dept = lbDept.getText();
        String name = lbName.getText();
        String yearName = lbYear.getText();
        String shiftName = lbShift.getText();
//        System.out.println("str : " + str);
//        if (!sub.equals("Select Subject")) {
//            String folderNames = "";
//            String tbName = "";
////            if (str.equals("Subject Teacher")) {
////                System.out.println("yess");
////                String name = lbName.getText();
////                System.out.println("name :"+name); 
////                folderNames = name + "_" + sub + "_" + branchName + "_" + yearName + "_" + shiftName;
////                tbName = name + "_" + sub + "_" + branchName + "_" + yearName + "_" + shiftName;
////            } else {
//            System.out.println("tech : " + tech);
//            System.out.println("sub : " + sub);
//            System.out.println("branchName : " + branchName);
//            System.out.println("yearName : " + yearName);
//            System.out.println("shiftName : " + shiftName);
//            String subb = "";
//            if (sub.contains(" ")) {
//                subb = sub.replaceAll(" ", "\\_");
//            } else {
//                subb = sub;
//            }
//            System.out.println("subb :" + subb);
//            
//            folderNames = tech + "_" + subb + "_" + branchName + "_" + yearName + "_" + shiftName;
//            tbName = tech + "_" + subb + "_" + branchName + "_" + yearName + "_" + shiftName;
//            System.out.println(" tbName : " + tbName);
////            }
//            try {
//                con = dc.getConnection();
//                PreparedStatement ps = con.prepareStatement("select * from " + tbName);
//                ResultSet set = ps.executeQuery();
//                ResultSetMetaData metaData = set.getMetaData();
//                Vector columName = new Vector();
//                System.out.println("" + metaData.getColumnCount());
////                for (int i = 0; i < metaData.getColumnCount(); i++) {
////                    String columnName = metaData.getColumnName(i + 1);
////                    columName.add(columnName);
////                }
////                columName.add("Average Attendance");
//                Vector RowValue = new Vector();
//                Vector v2 = new Vector();
//                Vector v3 = new Vector();
//                Vector v4 = new Vector();
//                v2.add("NAME");
//                v2.add(tech);
//                v3.add("SUBJECT NAME");
//                v3.add(sub);
//                
//                RowValue.add(v2);
//                RowValue.add(v3);
//                for (int i = 0; i < metaData.getColumnCount(); i++) {
//                    String columnName = metaData.getColumnName(i + 1);
//                    v4.add(columnName);
//                }
//                v4.add("AVERAGE ATTENDANCE");
//                
//                RowValue.add(v4);
//                
//                while (set.next()) {
//                    ArrayList arrAvg = new ArrayList();
//                    Vector v1 = new Vector();
//                    
//                    for (int j = 0; j < metaData.getColumnCount(); j++) {
//                        
//                        String string = set.getString(j + 1);
////                        System.out.println("string " + string);
//                        v1.add(string);
//                        if (j > 2) {
//                            arrAvg.add(string);
//                        }
//                    }
////                    RowValue.add(v1);
//
//                    System.out.println("arrAvg :" + arrAvg);
//                    double numerator = 0;
//                    double denomenator = arrAvg.size();
//                    double avg = 0;
//                    
//                    for (int j = 0; j < arrAvg.size(); j++) {
//                        if (arrAvg.get(j).equals("Present")) {
//                            numerator++;
//                        }
//                    }
//                    avg = numerator / denomenator;
//                    System.out.println("avg : " + avg * 100);
//                    long round = Math.round(avg * 100);
//                    v1.add(round + "%");
//                    RowValue.add(v1);
//                }
//                File f=new File(System.getProperty("user.dir")+File.separator+"ATTENDANCE EXLE"+File.separator+branchName+File.separator+yearName+File.separator+shiftName+File.separator+sub.replaceAll("_", " "));
//                f.mkdirs();
////                System.out.println("RowValue :" + RowValue);
//                PoiWriteExcelFile excel = new PoiWriteExcelFile();
//                String CreateSheet = excel.CreateSheet(columName, RowValue, sub,tech);
//                JOptionPane.showMessageDialog(null, CreateSheet);
//                con.close();
//                
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Please Select Subject !!!");
//        }

        System.out.println("Column Data Excel :  " + excelSheetDataColumn);
        System.out.println("Row Data Excel :  " + excelSheetDataRow);
        PoiWriteExcelFile excel = new PoiWriteExcelFile();
        String CreateSheet = excel.CreateSheet1(excelSheetDataColumn, excelSheetDataRow, dept, yearName, shiftName, name);

        JOptionPane.showMessageDialog(null, CreateSheet);
    }//GEN-LAST:event_btnGenActionPerformed

    private void jcSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcSubjectActionPerformed
        // TODO add your handling code here:
//        String name;
//        String rollNo;
//        String last;
//
//        try {
//            if (Login.typeTeacher.equalsIgnoreCase("Subject Teacher")) {
//                model.setRowCount(0);
//                model.setColumnCount(0);
////            tbAttendeance1.removeAll();
////            tbAttendeance1.repaint();
////            model = new DefaultTableModel();
////            model.addColumn("Name");
////            model.addColumn("Last");
////            model.addColumn("Roll No");
////            model.addColumn("Present");
//                model.addColumn("Name");
//                model.addColumn("Last");
//                model.addColumn("Roll No");
//                model.addColumn("Present / Absent");
//
////                String txtBranch = (String) branch.getSelectedItem();
//                String txtBranch = lbDept.getText();
//                String txtYear = (String) year.getSelectedItem();
////                String txtShift = (String) shift.getSelectedItem();
//                String txtShift = lbShift.getText();
//                Vector v = new Vector();
////                con.close();
//                con = dc.getConnection();
//                PreparedStatement ps = con.prepareStatement("Select * from registrationtbl where department='" + txtBranch + "'&&shift='" + txtShift + "'&&year='" + txtYear + "'");
//                ResultSet set = ps.executeQuery();
//                while (set.next()) {
//                    Vector data = new Vector();
//                    name = set.getString("name");
//                    last = set.getString("last");
//                    rollNo = set.getString("roll");
//                    data.add(name);
//                    data.add(last);
//                    data.add(rollNo);
//                    v.add(data);
//                }
////            DefaultTableModel model = null;
//                con.close();
//                for (int i = 0; i < v.size(); i++) {
//                    Vector get = (Vector) v.get(i);
//                    model.addRow(get);
//                }
//                tbAttendeance1 = new JTable(model) {
//                    private static final long serialVersionUID = 1L;
//
//                    @Override
//                    public Class getColumnClass(int column) {
//                        switch (column) {
//                            case 0:
//                                return String.class;
//                            case 1:
//                                return String.class;
//                            case 2:
//                                return String.class;
//                            default:
//                                return Boolean.class;
//                        }
//                    }
//                };
//                tbAttendeance1.setPreferredScrollableViewportSize(tbAttendeance1.getPreferredSize());
//                JScrollPane scrollPane = new JScrollPane(tbAttendeance1);
//                pnltable.add(scrollPane);
//                pnltable.updateUI();
//                tbAttendeance1.updateUI();
//                scrollPane.updateUI();
//            } else {
////                pnltable.removeAll();
////                pnltable.add(table);
////                pnltable.updateUI();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_jcSubjectActionPerformed

    private void btnShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllActionPerformed
        // TODO add your handling code here:
        try {
//            tbAttendeance1.removeAll();
//            tbAttendeance1.updateUI();
            btnAtta.setVisible(false);
            btnAttendance.setVisible(false);
            model.setRowCount(0);
            model.setColumnCount(0);
            String Name = lbName.getText();
            String subject = (String) jcSubject.getSelectedItem();
            String Branc = (String) lbDept.getText();
            String ye = (String) year.getSelectedItem();
            String Shi = (String) shift.getSelectedItem();
            con = dc.getConnection();
            String repName = Name.replaceAll(" ", "_");
            String repSub = subject.replaceAll(" ", "_");
            String repBran = Branc.replaceAll(" ", "_");
            String repShif = Shi.replaceAll(" ", "_");
            String repYear = ye.replaceAll(" ", "_");
            String thpr = (String) jcTHPR.getSelectedItem();
            String tbName = repName + "_" + repSub + "_" + repBran + "_" + repYear + "_" + repShif + "_" + thpr;
            PreparedStatement ps = con.prepareStatement("Select * from " + tbName);
            ResultSet set = ps.executeQuery();
            ResultSetMetaData metaData = set.getMetaData();
            final int columnCount = metaData.getColumnCount();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                model.addColumn((String) metaData.getColumnName(i + 1));
            }
            Vector Data = new Vector();
            while (set.next()) {
                Vector v = new Vector();
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String string = set.getString(i + 1);
                    v.add(string);
                }
                Data.add(v);

            }
            for (int i = 0; i < Data.size(); i++) {
                model.addRow((Vector) Data.get(i));
            }

//            model.addColumn("Name");
//            model.addColumn("Roll");
            tbAttendeance1 = new JTable(model);//{
//                private static final long serialVersionUID = 1L;
//
//                @Override
//                public Class getColumnClass(int columnCount) {
//                    switch (columnCount) {
//                        case 0:
//                            return String.class;
//                        case 1:
//                            return String.class;
//                        case 2:
//                            return String.class;
//                        default:
//                            return String.class;
//                    }
//                }
//            };
//            tbAttendeance1.setPreferredScrollableViewportSize(tbAttendeance1.getPreferredSize());
            JScrollPane scrollPane = new JScrollPane(tbAttendeance1);
            pnltable.add(scrollPane);
            pnltable.updateUI();
            tbAttendeance1.updateUI();
            scrollPane.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Table Does Not Exist..");
        }
    }//GEN-LAST:event_btnShowAllActionPerformed

    private void jcTecherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcTecherActionPerformed

        String teacherName = (String) jcTecher.getSelectedItem();

        System.out.println("teacherName :" + teacherName);
        System.out.println("deptclass :" + deptclass);
        System.out.println("year1class :" + year1class);
        System.out.println("shift1class :" + shift1class);

        try {
            con = dc.getConnection();
            PreparedStatement ps12 = con.prepareStatement("select * from subject_teacher where department='" + deptclass + "'&&year='" + year1class + "'&&shift='" + shift1class + "'&&username='" + teacherName + "'");
            ResultSet sett = ps12.executeQuery();
            String subject = "";
            jcSubject.removeAllItems();
            while (sett.next()) {
//                username = sett.getString("username");
                subject = sett.getString("subject");

                if (subject.contains(",")) {
                    String[] split = subject.split("\\,");
                    for (int k = 0; k < split.length; k++) {
                        jcSubject.addItem(split[k]);
                    }
                } else {
                    jcSubject.addItem(subject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jcTecherActionPerformed

    private void jcTecherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcTecherItemStateChanged
    }//GEN-LAST:event_jcTecherItemStateChanged

    private void btnAttaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttaActionPerformed
        // TODO add your handling code here:
        String name;
        String rollNo;
        String last;
        btnShowAll.setVisible(false);

        try {
            if (Login.typeTeacher.equalsIgnoreCase("Subject Teacher")) {
                model.setRowCount(0);
                model.setColumnCount(0);
//            tbAttendeance1.removeAll();
//            tbAttendeance1.repaint();
//            model = new DefaultTableModel();
//            model.addColumn("Name");
//            model.addColumn("Last");
//            model.addColumn("Roll No");
//            model.addColumn("Present");
                model.addColumn("Name");
                model.addColumn("Last");
                model.addColumn("Roll No");
                model.addColumn("Absent");

//                String txtBranch = (String) branch.getSelectedItem();
                String txtBranch = lbDept.getText();
                String txtYear = (String) year.getSelectedItem();
//                String txtShift = (String) shift.getSelectedItem();
                String txtShift = lbShift.getText();
                Vector v = new Vector();
//                con.close();
                con = dc.getConnection();
                PreparedStatement ps = con.prepareStatement("Select * from registrationtbl where department='" + txtBranch + "'&&shift='" + txtShift + "'&&year='" + txtYear + "'");
                ResultSet set = ps.executeQuery();
                while (set.next()) {
                    Vector data = new Vector();
                    name = set.getString("name");
                    last = set.getString("last");
                    rollNo = set.getString("roll");
                    data.add(name);
                    data.add(last);
                    data.add(rollNo);
                    v.add(data);
                }
//            DefaultTableModel model = null;
                con.close();
                for (int i = 0; i < v.size(); i++) {
                    Vector get = (Vector) v.get(i);
                    model.addRow(get);
                }
                tbAttendeance1 = new JTable(model) {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public Class getColumnClass(int column) {
                        switch (column) {
                            case 0:
                                return String.class;
                            case 1:
                                return String.class;
                            case 2:
                                return String.class;
                            default:
                                return Boolean.class;
                        }
                    }
                };
                tbAttendeance1.setPreferredScrollableViewportSize(tbAttendeance1.getPreferredSize());
                JScrollPane scrollPane = new JScrollPane(tbAttendeance1);
                pnltable.add(scrollPane);
                pnltable.updateUI();
                tbAttendeance1.updateUI();
                scrollPane.updateUI();
            } else {
//                pnltable.removeAll();
//                pnltable.add(table);
//                pnltable.updateUI();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAttaActionPerformed

    private void btnHoDShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoDShowActionPerformed
        // TODO add your handling code here:
        try {
            boolean isflag = true;
            int ii = 1;
            table.setVisible(true);
            model = new DefaultTableModel();
//            String teach = "";
            String txtYear = "";

//                teach = (String) jcTecher.getSelectedItem();
            txtYear = year.getSelectedItem().toString();

//            String sub = (String) jcSubject.getSelectedItem();
//            String txtBranch = (String) branch.getSelectedItem();
            String txtBranch = lbDept.getText();
            table.updateUI();

//            String txtShift = (String) shift.getSelectedItem();
//            String txtShift = lbShift.getText();
            String branchName = txtBranch.replaceAll(" ", "_");
            String yearName = txtYear.replaceAll(" ", "_");
//            String shiftName = txtShift.replaceAll(" ", "_");
//            String subject = sub.replaceAll(" ", "_");
            Vector techlist = new Vector();
            Vector finallist = new Vector();

//            if (!sub.equals("Select Subject")) {
            con = dc.getConnection();
            PreparedStatement pre = con.prepareStatement("select tablename,techname,subject from tablerecode where dept='" + branchName + "'&&year='" + txtYear + "'");
            ResultSet setSele = pre.executeQuery();
            Vector taableNameData = new Vector();
            while (setSele.next()) {
                taableNameData.add(setSele.getString(1));
                String string = setSele.getString(3);
                String replaceAll = string.replaceAll("_", " ");
                techlist.add(replaceAll);
                

            }
            Vector AllPerRecord = new Vector();
            ResultSetMetaData metaData = null;
            for (int k = 0; k < taableNameData.size(); k++) {
                String tbName = taableNameData.get(k).toString();//teach + "_" + subject + "_" + branchName + "_" + yearName + "_" + shiftName.trim();
                PreparedStatement ps = con.prepareStatement("select * from " + tbName.trim());
                ResultSet set = ps.executeQuery();

                Vector v = new Vector();

                metaData = set.getMetaData();
//                    System.out.println("" + metaData.getColumnCount());
//                for (int i = 0; i < metaData.getColumnCount(); i++) {
//                    String columnName = metaData.getColumnName(i + 1);
//                    if (i < 3) {
//                        model.addColumn(columnName);
//                    }
//
//                }
//                model.addColumn(teach);
                while (set.next()) {
                    Vector v1 = new Vector();
                    for (int j = 0; j < metaData.getColumnCount(); j++) {

                        String string = set.getString(j + 1);
//                    System.out.println("columnName " + columnName);
                        v1.add(string);
                    }
                    v.add(v1);

                }
//                    System.out.println("" + v);
                Vector valuePreAbs = new Vector();
                Vector StudentName = new Vector();
                for (int i = 0; i < v.size(); i++) {
                    Vector allvect = (Vector) v.get(i);
                    Vector v1 = new Vector();
                    Vector v2 = new Vector();
                    for (int j = 0; j < allvect.size(); j++) {
                        String get = (String) allvect.get(j);

//                        System.out.println("vetctor values  ::  " + get);
                        if (j > 2) {
                            v1.add(get);
                        } else {
                            v2.add(get);
                        }
                    }
                    StudentName.add(v2);
                    valuePreAbs.add(v1);
                }
                Vector pres = new Vector();
//                    System.out.println(StudentName + "vetctor values  ::  " + valuePreAbs);
                for (int j = 0; j < valuePreAbs.size(); j++) {
                    double numerator = 0;
//                double denomenator = valuePreAbs.size();
                    double avg = 0;
                    Vector v1 = new Vector();
                    Vector valll = (Vector) valuePreAbs.get(j);
                    for (int i = 0; i < valll.size(); i++) {

                        if (valll.get(i).equals("Present")) {
                            numerator++;
                        }

                    }
                    avg = numerator / valll.size();
                        System.out.println("avg : " + avg * 100);
                    long round = Math.round(avg * 100);
                    v1.add(round);
                    pres.add(v1);
//                    RowValue.add(v1);
//                        System.out.println("persent values v1 ::  " + v1);
                }
//                    System.out.println("persent values  ::  " + pres);
                Vector Finalvect = new Vector();
                if (isflag) {

                    for (int i = 0; i < pres.size(); i++) {
                        Vector get = (Vector) pres.get(i);
                        Vector stName = (Vector) StudentName.get(i);
//                        if (ii==0) {

                        for (int j = 0; j < get.size(); j++) {
                            stName.add(get.get(j));
                        }
//                        }else{
//                           Finalvect.add(get.lastElement());
//                         }
                        if (!Finalvect.contains(stName)) {
                            Finalvect.add(stName);
                        }

                    }
                    isflag = false;
                    System.out.println("final values  ::  " + Finalvect);
                    for (int i = 0; i < Finalvect.size(); i++) {
                        AllPerRecord.add(Finalvect.get(i));
                    }
                } else {
                    for (int i = 0; i < pres.size(); i++) {
                        Vector get = (Vector) pres.get(i);
                        Vector get1 = (Vector) AllPerRecord.get(i);
                        System.out.println("get1 :"+get1);
                        for (int j = 0; j < get.size(); j++) {
                            System.out.println("get.get(j): "+get.get(j));
                            get1.add(get.get(j));
                        }
                        if (!finallist.contains(get1)) {
                            finallist.add(get1);
                        }
                    }
                }

            }
//                System.out.println("final values  ::  " + finallist);

            for (int i = 0; i < metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i + 1);
               
                if (i < 3) {
                    model.addColumn(columnName);
                }

            }
            for (int i = 0; i < techlist.size(); i++) {
                model.addColumn(techlist.get(i));
                System.out.println("techlist.get(i) :" + techlist.get(i));
            }

            for (int i = 0; i < finallist.size(); i++) {
                model.addRow((Vector) finallist.get(i));
                System.out.println("(Vector) finallist.get(i) :" + (Vector) finallist.get(i));
            }
            con.close();
            tbShowAtt.setModel(model);
//            } else {
//                JOptionPane.showMessageDialog(null, "Please Select Subject !!!");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnHoDShowActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox branch;
    private javax.swing.JButton btnAtta;
    private javax.swing.JButton btnAttendance;
    private javax.swing.JButton btnGen;
    private javax.swing.JButton btnHoDShow;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnShowAll;
    private org.jdesktop.swingx.JXDatePicker dateFrom;
    private org.jdesktop.swingx.JXDatePicker dateSelect;
    private org.jdesktop.swingx.JXDatePicker dateTo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jcSubject;
    private javax.swing.JComboBox jcTHPR;
    private javax.swing.JComboBox jcTecher;
    private javax.swing.JLabel lbDept;
    private javax.swing.JLabel lbFrom;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbShift;
    private javax.swing.JLabel lbTo;
    private javax.swing.JLabel lbYear;
    private javax.swing.JPanel pnlChange;
    private javax.swing.JPanel pnltable;
    private javax.swing.JComboBox shift;
    private javax.swing.JPanel table;
    private javax.swing.JTable tbAttendeance;
    private javax.swing.JTable tbShowAtt;
    private javax.swing.JComboBox year;
    // End of variables declaration//GEN-END:variables

    private void createTable(String tbName) throws SQLException {
        con.close();
        con = dc.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tbName
                + "  (name           VARCHAR(100),"
                + "   last            VARCHAR(100),"
                + "   roll          VARCHAR(100))";

        PreparedStatement stmt = con.prepareStatement(sqlCreate);
        stmt.executeUpdate();
        con.close();
    }

    private void AlterTable(String tbName) {
        try {
            con.close();
            con = dc.getConnection();
            SimpleDateFormat format = new SimpleDateFormat("EEE_dd_MMM_yyyy");
            Date d = dateSelect.getDate();
            String format1 = format.format(d);
            System.out.println("" + format1);
            String data = format1;
            String query = "ALTER TABLE `idcard`.`" + tbName + "` ADD COLUMN `" + data + "` VARCHAR(45) NULL";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();
            con.close();
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Attendance Allready Marked !!!");
        }
    }
}
