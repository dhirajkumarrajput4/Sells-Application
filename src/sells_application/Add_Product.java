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
public class Add_Product extends JFrame 
{
      JLabel lblHeading, lblselect,lblchooseDV,lblcategory,lblProduct_Code,lblProduct_Name,lblProduct_Price,lblQuantity,lblmgf_Date,lblexp_Date;
      JPanel panel;
      JTextField txtProduct_Code,txtProduct_Name,txtProduct_Price,txtQuantity,txtmgf_Date,txtexp_Date;
       
      JButton btnAdd;
      JRadioButton dist,vend;
      ButtonGroup bg;
      GridBagConstraints gbc;
      GridBagLayout gbl;
      JOptionPane jop;
      JComboBox cmbchooseDV,cmbcategory;
      ResultSet rs,rs1,rs2,rs3;
    
    public Add_Product()
    {
    super("Add Product in Stock");
    Sells_Database.loadJDBCDriverAndCreateConnection();
    Product();
    
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
   
   lblHeading=new JLabel("Add Product in Stock");
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
   cmbcategory.setForeground(Color.blue);
   cmbcategory.addItem("------------------Select-------------------");
   cmbcategory.addItem("Fashion");
   cmbcategory.addItem("Grocery");
   cmbcategory.addItem("Beauty & Health");
   cmbcategory.addItem("Electronics");
   cmbcategory.addItem("TV,Mobiles,Computers");
   cmbcategory.setFont(t);
   
   lblProduct_Name=new JLabel("Product Name");
   lblProduct_Name.setFont(f2);
   txtProduct_Name=new JTextField(20);
   txtProduct_Name.setFont(t);
   
   
   lblProduct_Code=new JLabel("Product Code");
   lblProduct_Code.setFont(f2);
   txtProduct_Code=new JTextField(20);
   txtProduct_Code.setFont(t);
  
   
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
   
   btnAdd=new JButton("Add Product");
   btnAdd.setFont(t);
   
   panel.setLayout(gbl);
   
   gbc.gridx=1;
   gbc.gridy=0;
   gbl.setConstraints(lblHeading, gbc);
   panel.add(lblHeading);
   
   gbc.gridx=0;
   gbc.gridy=1;
   gbl.setConstraints(lblselect, gbc);
   panel.add(lblselect);
   gbc.gridx=1;
   gbc.gridy=1;
   gbl.setConstraints(dist, gbc);
   panel.add(dist);
   gbc.gridx=1;
   gbc.gridy=2;
   gbl.setConstraints(vend, gbc);
   panel.add(vend);
   
   
   gbc.gridx=0;
   gbc.gridy=3;
   gbl.setConstraints(lblchooseDV, gbc);
   panel.add(lblchooseDV);
   gbc.gridx=1;
   gbc.gridy=3;
   gbl.setConstraints(cmbchooseDV, gbc);
   panel.add(cmbchooseDV);
   
   gbc.gridx=0;
   gbc.gridy=4;
   gbl.setConstraints(lblcategory, gbc);
   panel.add(lblcategory);
   gbc.gridx=1;
   gbc.gridy=4;
   gbl.setConstraints(cmbcategory, gbc);
   panel.add(cmbcategory);
   
   
   gbc.gridx=0;
   gbc.gridy=5;
   gbl.setConstraints(lblProduct_Code, gbc);
   panel.add(lblProduct_Code);
   gbc.gridx=1;
   gbc.gridy=5;
   gbl.setConstraints(txtProduct_Code, gbc);
   panel.add(txtProduct_Code);
   
   gbc.gridx=0;
   gbc.gridy=6;
   gbl.setConstraints(lblProduct_Name, gbc);
   panel.add(lblProduct_Name);
   gbc.gridx=1;
   gbc.gridy=6;
   gbl.setConstraints(txtProduct_Name, gbc);
   panel.add(txtProduct_Name);
   
   gbc.gridx=0;
   gbc.gridy=7;
   gbl.setConstraints(lblProduct_Price, gbc);
   panel.add(lblProduct_Price);
   gbc.gridx=1;
   gbc.gridy=7;
   gbl.setConstraints(txtProduct_Price, gbc);
   panel.add(txtProduct_Price);
   
   gbc.gridx=0;
   gbc.gridy=8;
   gbl.setConstraints(lblQuantity, gbc);
   panel.add(lblQuantity);
   gbc.gridx=1;
   gbc.gridy=8;
   gbl.setConstraints(txtQuantity, gbc);
   panel.add(txtQuantity);
   
   gbc.gridx=0;
   gbc.gridy=9;
   gbl.setConstraints(lblmgf_Date, gbc);
   panel.add(lblmgf_Date);
   gbc.gridx=1;
   gbc.gridy=9;
   gbl.setConstraints(txtmgf_Date, gbc);
   panel.add(txtmgf_Date);
   
   gbc.gridx=0;
   gbc.gridy=10;
   gbl.setConstraints(lblexp_Date, gbc);
   panel.add(lblexp_Date);
   gbc.gridx=1;
   gbc.gridy=10;
   gbl.setConstraints(txtexp_Date, gbc);
   panel.add(txtexp_Date);
   
   gbc.gridx=1;
   gbc.gridy=11;
   gbl.setConstraints(btnAdd, gbc);
   panel.add(btnAdd);
   
           
          getRootPane().setDefaultButton(btnAdd);
         btnAdd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                String SV;
                
                if( vend.isSelected()|| dist.isSelected() )
                {
                    
                    if(vend.isSelected())
                    {
                        SV=vend.getText();
                    }
                    else
                    {
                        SV=dist.getText();
                    }
                   
              if(cmbchooseDV.getSelectedItem().toString().equals("------------------Select-------------------"))
              {
                  JOptionPane.showMessageDialog(jop,"Please Choose Firm");
              }
              
              if(cmbcategory.getSelectedItem().toString().equals("------------------Select-------------------"))
              {
                JOptionPane.showMessageDialog(jop,"Please Choose Product Category");  
              }
             if(txtProduct_Name.getText().isEmpty() || txtProduct_Code.getText().isEmpty()|| txtProduct_Price.getText().isEmpty()|| txtQuantity.getText().isEmpty()|| txtmgf_Date.getText().isEmpty()|| txtexp_Date.getText().isEmpty())
            {
             JOptionPane.showMessageDialog(jop,"Please Fill the All Field");
             
            }
             else 
             {
               String Recieve_From=SV; 
                String Firm_Name=cmbchooseDV.getSelectedItem().toString();
                String Category=cmbcategory.getSelectedItem().toString();
                String Product_Code=txtProduct_Code.getText().trim();
                String Product_Name=txtProduct_Name.getText().trim();
                Double Price=Double.parseDouble(txtProduct_Price.getText().trim());
                Double Quantity=Double.parseDouble(txtQuantity.getText().trim());
                String Mgf=txtmgf_Date.getText();
                String Exp=txtexp_Date.getText();
                                    if(Product_Code.isEmpty()||Product_Name.isEmpty())
                                    {
                                        JOptionPane.showMessageDialog(jop,"Please Enter a Valid name");
                                    }
                Sells_Database.Add_Product(Product_Code, Product_Name, Price, Quantity, Mgf, Exp, Category, Recieve_From, Firm_Name);
                 }
                
                txtProduct_Code.setText("");

                txtProduct_Name.setText("");
                txtProduct_Price.setText("");
                txtQuantity.setText("");
                txtmgf_Date.setText("");
                txtexp_Date.setText("");
                
             
             }
                else
                {
                    JOptionPane.showMessageDialog(jop,"Please Select Veder or Supplier");
                }
                
               
            }});
         
      

            setVisible(true);
            setSize(900,600);
            setLocation(350,150);
            panel.setBackground( new Color(191, 238, 255) );
            add(panel);
       
         
         
   
         
            
    }
    
}