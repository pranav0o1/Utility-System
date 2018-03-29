/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author tulajaram
 */
import java.awt.*;    
import javax.swing.*;    
import javax.swing.table.*;    
   
public class TableTest extends JFrame    
{    
public TableTest()    
{        
   
String[] columnNames = {"checkbox","Description"};  
 
Object[][] data =    
{    
{new javax.swing.JCheckBox() , "test"},  
};    
   
DefaultTableModel model = new DefaultTableModel(data, columnNames);    
JTable table = new JTable( model )    
{    
// Returning the Class of each column will allow different    
// renderers to be used based on Class    
public Class getColumnClass(int column)    
{    
return getValueAt(0, column).getClass();    
}    
};    
   
table.setDefaultRenderer(Component.class, new MyCellRenderer()); 
 
table.setPreferredScrollableViewportSize(table.getPreferredSize());    
   
JScrollPane scrollPane = new JScrollPane( table );    
getContentPane().add( scrollPane );    
}    
   
class MyCellRenderer implements TableCellRenderer    
{    
public Component getTableCellRendererComponent(JTable table,    
Object value,    
boolean isSelected,    
boolean hasFocus,    
int row,    
int column)    
{    
Component com = (Component)value;    
return com;    
}    
   
}    
   
public static void main(String[] args)    
{    
TableTest frame = new TableTest();    
frame.setDefaultCloseOperation( EXIT_ON_CLOSE );    
frame.pack();    
frame.setVisible(true);    
}  
}