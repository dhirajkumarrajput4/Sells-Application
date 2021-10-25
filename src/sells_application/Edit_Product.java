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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author apptech
 */
public class Edit_Product extends JFrame
{
     JLabel lblHeading, lblselect,lblchooseDV,lblcategory,lblProduct_Code,lblProduct_Name,lblProduct_Price,lblQuantity,lblmgf_Date,lblexp_Date;
      JPanel panel;
      JTextField txtProduct_Name,txtProduct_Price,txtQuantity,txtmgf_Date,txtexp_Date;
       
      JButton btnAdd;
      JRadioButton dist,vend;
      ButtonGroup bg;
      GridBagConstraints gbc;
      GridBagLayout gbl;
      JOptionPane jop;
      JComboBox cmbchooseDV,cmbcategory,cmbProduct_Code;
      ResultSet rs;
      
      public Edit_Product()
      {
          
          
          super("Edit product");
          Sells_Database.loadJDBCDriverAndCreateConnection();
          Product();
          cmbProduct_Code.addItem("Select Product Code");
        cmbProduct_Code.setForeground(Color.blue);
        try
        {
      rs=Sells_Database.get_Product_Code();
        while(rs.next())
        {
            cmbProduct_Code.addItem(rs.getString("Product_Code"));
        }
            rs.close();
        }
            catch(SQLException ex)
        {
           System.out.println(ex);
        }
        
        
                   cmbchooseDV.addItem("------------------Select-------------------");
                   cmbchooseDV.setForeground(Color.blue);
                   if(vend.isSelected())
                   {
                      
                       
                       vend.addItemListener(new ItemListener()
                       {
                        @Override
                         public void itemStateChanged(ItemEvent ie)
                         {
                          
                     try
                     {
                          cmbchooseDV.removeAllItems();
                       rs=Sells_Database.getFirm();
                        while(rs.next())
                         {
                           cmbchooseDV.addItem(rs.getString("Firm_Name"));
                         }
                         rs.close();
                     }
                     catch(SQLException ex)
                     {
                        System.out.println(ex);
                     }
                         }
                       });
                          
                                                   
                           
                     
                   }
                   
                   else
                   {
                       
                       
                        dist.addItemListener(new ItemListener()
                       {
                           
                        @Override
                         public void itemStateChanged(ItemEvent ie)
                         {
                       try
                        {
                            cmbchooseDV.removeAllItems();
                        rs=Sells_Database.get_Supllier_Firm();
                        while(rs.next())
                         {
                           cmbchooseDV.addItem(rs.getString("Firm_Name"));
                         }
                         rs.close();
                        }
                      catch(SQLException ex)
                     {
                        System.out.println(ex);
                     }
                      
                           }                            
                        });
                      
                        
                   } 
         
      }
      
     
    
    private void Product()
    {
        panel=new JPanel();
         gbl=new GridBagLayout();
         gbc=new GridBagConstraints();
         
       
         
   Font f=new Font("ARIAL BLACK",Font.TYPE1_FONT,25);
   Font f2=new Font("ARIAL BLACK",Font.ROMAN_BASELINE,14);
   Font t=new Font("ARIAL BLACK",Font.ITALIC,14);
   
   lblHeading=new JLabel("Edite Product in Stock");
   lblHeading.setForeground(Color.green);
   lblHeading.setFont(f);
   
   lblselect=new JLabel("Receeved By");
   lblselect.setFont(f2);
    dist=new JRadioButton("Supplier");
   dist.setFont(f2);

   dist.setOpaque(false);
dist.setContentAreaFilled(false);
dist.setBorderPainted(false);
  
   vend=new JRadioButton("  Vender " );
   vend.setFont(f2);
  
   vend.setOpaque(false);
vend.setContentAreaFilled(false);
vend.setBorderPainted(false);

   bg=new ButtonGroup();
   bg.add(dist);
   bg.add(vend);
   
   lblchooseDV=new JLabel("Select Firm");
   lblchooseDV.setFont(f2);
   cmbchooseDV=new JComboBox();
   cmbchooseDV.setFont(t);
   
   lblcategory=new JLabel("Select Product Catergory");
   lblcategory.setFont(f2);
   cmbcategory=new JComboBox();
   cmbcategory.setFont(t);
   
   lblProduct_Name=new JLabel("Product Name");
   lblProduct_Name.setFont(f2);
   txtProduct_Name=new JTextField(20);
   txtProduct_Name.setFont(t);
   
   
   lblProduct_Code=new JLabel("Product Code");
   lblProduct_Code.setFont(f2);
   cmbProduct_Code=new JComboBox();
   cmbProduct_Code.setFont(t);
   
   lblProduct_Price=new JLabel("Product Price");
   lblProduct_Price.setFont(f2);
   txtProduct_Price=new JTextField(20);
   txtProduct_Price.setFont(t);
   
   lblQuantity=new JLabel("Product Quantity");
   lblQuantity.setFont(f2);
   txtQuantity=new JTextField(20);
   txtQuantity.setFont(t);
   
   
   lblmgf_Date=new JLabel("Mgf Date");
   lblmgf_Date.setFont(f2);
   txtmgf_Date=new JTextField(20);
   txtmgf_Date.setFont(t);
   
   
   lblexp_Date=new JLabel("Exp Date");
   lblexp_Date.setFont(f2);
   txtexp_Date=new JTextField(20);
   txtexp_Date.setFont(t);
   
   btnAdd=new JButton("Update");
   btnAdd.setFont(t);
   
   panel.setLayout(gbl);
   
   gbc.gridx=1;
   gbc.gridy=0;
   gbl.setConstraints(lblHeading, gbc);
   panel.add(lblHeading);
   
   gbc.gridx=0;
   gbc.gridy=1;
   gbl.setConstraints(lblProduct_Code, gbc);
   panel.add(lblProduct_Code);
   gbc.gridx=1;
   gbc.gridy=1;
   gbl.setConstraints(cmbProduct_Code, gbc);
   panel.add(cmbProduct_Code);
   
   
   gbc.gridx=0;
   gbc.gridy=2;
   gbl.setConstraints(lblselect, gbc);
   panel.add(lblselect);
   gbc.gridx=1;
   gbc.gridy=2;
   gbl.setConstraints(dist, gbc);
   panel.add(dist);
   gbc.gridx=1;
   gbc.gridy=3;
   gbl.setConstraints(vend, gbc);
   panel.add(vend);
   
   
   gbc.gridx=0;
   gbc.gridy=4;
   gbl.setConstraints(lblchooseDV, gbc);
   panel.add(lblchooseDV);
   gbc.gridx=1;
   gbc.gridy=4;
   gbl.setConstraints(cmbchooseDV, gbc);
   panel.add(cmbchooseDV);
   

   
   gbc.gridx=0;
   gbc.gridy=5;
   gbl.setConstraints(lblProduct_Name, gbc);
   panel.add(lblProduct_Name);
   gbc.gridx=1;
   gbc.gridy=5;
   gbl.setConstraints(txtProduct_Name, gbc);
   panel.add(txtProduct_Name);
   
   gbc.gridx=0;
   gbc.gridy=6;
   gbl.setConstraints(lblProduct_Price, gbc);
   panel.add(lblProduct_Price);
   gbc.gridx=1;
   gbc.gridy=6;
   gbl.setConstraints(txtProduct_Price, gbc);
   panel.add(txtProduct_Price);
   
   gbc.gridx=0;
   gbc.gridy=7;
   gbl.setConstraints(lblQuantity, gbc);
   panel.add(lblQuantity);
   gbc.gridx=1;
   gbc.gridy=7;
   gbl.setConstraints(txtQuantity, gbc);
   panel.add(txtQuantity);
   
   gbc.gridx=0;
   gbc.gridy=8;
   gbl.setConstraints(lblmgf_Date, gbc);
   panel.add(lblmgf_Date);
   gbc.gridx=1;
   gbc.gridy=8;
   gbl.setConstraints(txtmgf_Date, gbc);
   panel.add(txtmgf_Date);
   
   gbc.gridx=0;
   gbc.gridy=9;
   gbl.setConstraints(lblexp_Date, gbc);
   panel.add(lblexp_Date);
   gbc.gridx=1;
   gbc.gridy=9;
   gbl.setConstraints(txtexp_Date, gbc);
   panel.add(txtexp_Date);
   
   gbc.gridx=1;
   gbc.gridy=10;
   gbl.setConstraints(btnAdd, gbc);
   panel.add(btnAdd);
   
   cmbProduct_Code.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent ie) {
            String P_Code=cmbProduct_Code.getSelectedItem().toString();
            try
               {
             rs=Sells_Database.get_Product_Details(P_Code);
               if(rs.next())
               {
               txtProduct_Name.setText(rs.getString("Product_Name"));
               txtProduct_Price.setText(rs.getString("Product_Price"));
               txtQuantity.setText(rs.getString("Product_Quantity"));
               txtmgf_Date.setText(rs.getString("Mgf_Date"));
               txtexp_Date.setText(rs.getString("Exp_Date"));
               cmbchooseDV.setSelectedItem(rs.getString("Firm_Name"));
               if(vend.getText().equals(rs.getString("Receved_From")))
                   vend.setSelected(true);
               else if(dist.getText().equals(rs.getString("Receved_From")))
               dist.setSelected(true);
               
               }
              
               rs.close();
               }
               catch(SQLException ex)
               {
                   System.out.println(ex);
               }
            }
        
        
        });
        
           
          getRootPane().setDefaultButton(btnAdd);
         btnAdd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(txtProduct_Name.getText().isEmpty()|| txtProduct_Price.getText().isEmpty()|| txtQuantity.getText().isEmpty()|| txtmgf_Date.getText().isEmpty()|| txtexp_Date.getText().isEmpty() )
             {         
             JOptionPane.showMessageDialog(jop,"Filled the all Field");
             jop.setBackground(new Color(0, 200, 255));
             }
             else
                {   
                    String Product_Code=cmbProduct_Code.getSelectedItem().toString();
                    String Firm_Name=cmbchooseDV.getSelectedItem().toString();
                    String Product_Name=txtProduct_Name.getText();
                    String Product_Price=txtProduct_Price.getText();
                    String Quantity=txtQuantity.getText();
                    String MgfDate=txtmgf_Date.getText();
                    String ExpDate=txtexp_Date.getText();
                    String Recieve;
                    if(vend.isSelected())
                    {
                         Recieve=vend.getText();
                    }
                    else
                    {
                         Recieve=dist.getText();
                    }
                    
                   Sells_Database.updateProduct(Firm_Name, Product_Name, Product_Price, Quantity, MgfDate,ExpDate,Recieve,Product_Code);
             
            
                    
                
            
                 
                txtProduct_Name.setText("");
                
                txtProduct_Price.setText("");
                txtQuantity.setText("");
                txtmgf_Date.setText("");
                txtexp_Date.setText("");
             
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
