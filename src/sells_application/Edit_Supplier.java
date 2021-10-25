/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sells_application;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author apptech
 */
public class Edit_Supplier extends JFrame{
    
       JLabel lblFirm,lblName,lblDOB,lblMail,lblMobile,lblArea,lblState,lblNationlity,lblSRF;
       JPanel panel;
       JTextField txtName,txtDOB,txtMail,txtMobile,txtArea,txtState,txtNationlity;
       
       JButton btnSave,btnCancel;
       GridBagConstraints gbc;
       GridBagLayout gbl;
       JOptionPane jop;
       JComboBox cmbFirm;
       ResultSet rs,rs1,rs2,rs3;
      
       Font f=new Font("ARIAL BLACK",Font.ROMAN_BASELINE,16);
       public Edit_Supplier()
       {
             super("Moddify Supplier");
     Sells_Database.loadJDBCDriverAndCreateConnection();
        
        Moddify_Screen();
        
        
        
        
        cmbFirm.addItem("Select Firm Name");
        cmbFirm.setForeground(Color.blue);
        try
        {
      rs=Sells_Database.get_Supllier_Firm();
        while(rs.next())
        {
            cmbFirm.addItem(rs.getString("Firm_Name"));
        }
            rs.close();
        }
            catch(SQLException ex)
        {
           System.out.println(ex);
        }
        
        
        
        
        
        
       }
       
       private void Moddify_Screen()
       {
          panel=new JPanel();
          
        
        
        
        
        
   Font f=new Font("ARIAL BLACK",Font.TYPE1_FONT,25);
   Font f2=new Font("ARIAL BLACK",Font.ROMAN_BASELINE,14);
   Font t=new Font("ARIAL BLACK",Font.ITALIC,14);      
     
      
      
   lblSRF=new JLabel("Supplier Registration Form");
   lblSRF.setFont(f);
 
   lblFirm=new JLabel("Firm Name");
   lblFirm.setFont(f2);
   cmbFirm=new JComboBox();
   cmbFirm.setFont(t);
 
   
   lblName=new JLabel("Name");
   txtName=new JTextField(20);
   txtName.setFont(t);
   lblName.setFont(f2);
      
    lblDOB=new JLabel("DOB");
   lblDOB.setFont(f2);
   txtDOB=new JTextField(20);
   txtDOB.setFont(t);
  
  
   
   lblMobile=new JLabel("Mobile");
   lblMobile.setFont(f2);
   txtMobile=new JTextField(20);
   txtMobile.setFont(t);
   
   lblMail=new JLabel("Email");
   lblMail.setFont(f2);
   txtMail=new JTextField(20);
   txtMail.setFont(t);
   
   lblArea=new JLabel("Area");
   lblArea.setFont(f2);
   txtArea=new JTextField(20);
   txtArea.setFont(t);
   
   lblState=new JLabel("State");
   lblState.setFont(f2);
   txtState=new JTextField(20);
   txtState.setFont(t);
   
   
   lblNationlity=new JLabel("Nationlity");
   lblNationlity.setFont(f2);
   txtNationlity=new JTextField(20);
   txtNationlity.setFont(t);   
     
      
      
      btnSave=new JButton("SAVE");        //constructor of JButton class
      btnSave.setFont(f2);
      btnCancel=new JButton("CANCEL"); 
      btnCancel.setFont(f2);
      
        
        
       gbl = new GridBagLayout();
        gbc=new GridBagConstraints();
                                          //create panel obj
                                           //create panel obj
        panel.setLayout(gbl);
        
        gbc.gridx=0;
        gbc.gridy=0;
        gbl.setConstraints(lblFirm, gbc);
        panel.add(lblFirm);                //adding panel emp Name
        gbc.gridx=1;
        gbc.gridy=0;
        gbl.setConstraints(cmbFirm, gbc);
        panel.add(cmbFirm);
       
        gbc.gridx=0;
        gbc.gridy=1;
        gbl.setConstraints(lblName,gbc);
        panel.add(lblName);
        gbc.gridx=1;
        gbc.gridy=1;
        gbl.setConstraints(txtName,gbc);
        panel.add(txtName);
       
        gbc.gridx=0;
        gbc.gridy=2;
        gbl.setConstraints(lblDOB, gbc);
        panel.add(lblDOB);
        gbc.gridx=1;
        gbc.gridy=2;
        gbl.setConstraints(txtDOB,gbc);
        panel.add(txtDOB);
       
        gbc.gridx=0;
        gbc.gridy=3;
        gbl.setConstraints(lblMobile,gbc);
        panel.add(lblMobile);
        gbc.gridx=1;
        gbc.gridy=3;
        gbl.setConstraints(txtMobile, gbc);
        panel.add(txtMobile);
       
        gbc.gridx=0;
        gbc.gridy=4;
        gbl.setConstraints(lblMail,gbc);
        panel.add(lblMail);
        gbc.gridx=1;
        gbc.gridy=4;
        gbl.setConstraints(txtMail, gbc);
        panel.add(txtMail);
       
        gbc.gridx=0;
        gbc.gridy=5;
        gbl.setConstraints(lblArea,gbc);
        panel.add(lblArea);
        gbc.gridx=1;
        gbc.gridy=5;
        gbl.setConstraints(txtArea,gbc);
        panel.add(txtArea);
        
       gbc.gridx=0;
       gbc.gridy=6;
       gbl.setConstraints(lblState,gbc);
       panel.add(lblState);
       gbc.gridx=1;
       gbc.gridy=6;
       gbl.setConstraints(txtState,gbc);
       panel.add(txtState);
      
       gbc.gridx=0;
       gbc.gridy=7;
       gbl.setConstraints(lblNationlity,gbc);
       panel.add(lblNationlity);
       gbc.gridx=1;
       gbc.gridy=7;
       gbl.setConstraints(txtNationlity,gbc);
       panel.add(txtNationlity);
       
       gbc.gridx=0;
       gbc.gridy=8;
       gbl.setConstraints(btnSave,gbc);
       panel.add(btnSave);
       gbc.gridx=1;
       gbc.gridy=8;
       gbl.setConstraints(btnCancel, gbc);
       panel.add(btnCancel);
       
       
       cmbFirm.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent ie) {
            String FirmName=cmbFirm.getSelectedItem().toString();
            try
               {
             rs=Sells_Database.getSupplierDetails(FirmName);
               if(rs.next())
               {
               txtName.setText(rs.getString("Name"));
               txtDOB.setText(rs.getString("DOB"));
               txtMobile.setText(rs.getString("Mobile"));
               txtMail.setText(rs.getString("Email"));
               txtArea.setText(rs.getString("Area"));
               txtState.setText(rs.getString("State"));
               txtNationlity.setText(rs.getString("Nationality"));
               }
              
               rs.close();
               }
               catch(SQLException ex)
               {
                   System.out.println(ex);
               }
            }
        
        
        });
        
       
       
       
       btnSave.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               if( txtName.getText().isEmpty() || txtDOB.getText().isEmpty() || txtMobile.getText().isEmpty() || txtMail.getText().isEmpty() || txtArea.getText().isEmpty()|| txtNationlity.getText().isEmpty())
               {
                   JOptionPane.showMessageDialog(jop,"Please Fills the All fields");
               }
               else
               {
                   String Firm_Name=cmbFirm.getSelectedItem().toString();
                   String name=txtName.getText();
                   String dob=txtDOB.getText();
                   String mobile=txtMobile.getText();
                   String mail=txtMail.getText();
                   String area=txtArea.getText();
                   String state=txtState.getText();
                   String nationality=txtNationlity.getText();
                   
                   
                   
              Sells_Database.updateSupplier(name, dob, mobile, mail, area, state, nationality,Firm_Name);
                
                
                 
                 txtName.setText("");
                 txtDOB.setText("");
                 txtMobile.setText("");
                
                 txtMail.setText("");
                 txtArea.setText("");
                 txtState.setText("");
                 txtNationlity.setText("");
                  // dispose();
               }
           }
           
       });
       
      btnCancel.addActionListener(new ActionListener()
      {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int a=JOptionPane.showConfirmDialog(jop,"Are you sure?");
                if(a==JOptionPane.YES_OPTION)
                {
                    dispose();
                } 
            } 
                
        });
        
      setVisible(true);
            setSize(900,600);
            setLocation(350,150);
            panel.setBackground( new Color(191, 238, 255) );
      add(panel);
      
    
}
}