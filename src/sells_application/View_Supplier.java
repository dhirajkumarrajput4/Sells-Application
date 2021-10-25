/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sells_application;

import java.awt.Color;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


/**
 *
 * @author apptech
 */
public class View_Supplier 
{
    static JTable table; 
    
 JFrame frame;
 ResultSet rs;
 JPanel panel;
String Firm_Name,Name,Gender,DOB,Mobile,Email,Area,State,Nationality,s;
String[] columnNames={"FirmName","Distibutor_Name","Gender","DOB","Mobile","Email","Area","State","Nationality"};
public View_Supplier()
{
         frame = new JFrame("Supplier Report");
         frame.setBounds(200,100,1200, 600);
         frame.setLayout(null);
         frame.setVisible(true);
        Sells_Database.loadJDBCDriverAndCreateConnection();
        
         viewReport();
}
private void viewReport()
{
  
    panel=new JPanel();
   panel.setBackground(Color.blue);
        panel.setBounds(0, 0, 1200, 600);
        panel.setLayout(null);
       frame.add(panel);
 DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);

        table = new JTable();
        table.setBackground(Color.yellow);
       table.setModel(model);
        
    
         table.setRowHeight(30);
       

       JTableHeader tableHeader = table.getTableHeader();
      tableHeader.setBackground(Color.blue);
      tableHeader.setForeground(Color.white);
      
       table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(0,20,1200,400);

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
	panel.add(scroll);	
        
        
        			
//Data Retrival Code
 try {

        rs=Sells_Database.SupplierReport();
while (rs.next()) 
            {

                Name = rs.getString("Name");

                DOB = rs.getString("DOB");

                Firm_Name = rs.getString("Firm_Name");
                Gender=rs.getString("Gender");
                
                

                Mobile = rs.getString("Mobile");
                Email = rs.getString("Email");
                Area= rs.getString("Area");
                Nationality= rs.getString("Nationality");

                model.addRow(new Object[]{Firm_Name,Name,Gender,DOB,Mobile,Email,Area,State,Nationality});
                
            }
}
catch(SQLException ex)
{
System.out.println("Exception");
}
	
   
}  
}

