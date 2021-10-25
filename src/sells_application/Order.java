/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sells_application;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author apptech
 */
public class Order
{   
    JFrame frame;
    JPanel panel;
    JLabel lblcategory,lblproduct,lblQuantity,lblTotlePrice,lblOrder,lblprice;
    JComboBox cmbcategory,cmbproduct;
    JTextField txtTotlePrice,txtQuantity,txtprice,txtpcode;
    JButton btnOrder,btnCancel,btnFind;
    ResultSet rs,rs1;
    JOptionPane jop;
    
    public Order()
    {
         Sells_Database.loadJDBCDriverAndCreateConnection();
        
        Create();
    }
    
    private void Create()
    {
        frame = new JFrame("Order");
        
         panel=new javax.swing.JPanel();
                 
   Font f=new Font("ARIAL BLACK",Font.TYPE1_FONT,25);
   Font f1=new Font("ARIAL BLACK",Font.TYPE1_FONT,20);
   
   
       ImageIcon i2 = new ImageIcon("C:\\Users\\apptech\\Documents\\NetBeansProjects\\Sells_Application\\src\\sells_application\\pic\\find.png");
       Image debImage2=i2.getImage();
       Image modifieddebImage2=debImage2.getScaledInstance(45,45,Image.SCALE_DEFAULT);
       i2=new ImageIcon(modifieddebImage2);
       panel.setBounds(0, 0, 650, 550);
       
      panel.setLayout(null);
      lblOrder=new JLabel("Your Order");
      lblOrder.setFont(f);
      lblOrder.setForeground(Color.yellow);
      lblOrder.setBounds(250, 30, 180, 50);
      panel.add(lblOrder);
      
      lblcategory=new JLabel("Category");
      lblcategory.setFont(f1);
      lblcategory.setBounds(120, 80, 180,50);
      panel.add(lblcategory);


   
      
      cmbcategory=new JComboBox();
      cmbcategory.setFont(f1);
      cmbcategory.setBounds(280, 85, 180,40);
      panel.add(cmbcategory);
   cmbcategory.setForeground(Color.blue);
   cmbcategory.addItem("-------Select-------");
   cmbcategory.addItem("Fashion");
   cmbcategory.addItem("Grocery");
   cmbcategory.addItem("Beauty & Health");
   cmbcategory.addItem("Electronics");
   cmbcategory.addItem("TV,Mobiles,Computers");
      
      lblproduct=new JLabel("Products");
      lblproduct.setFont(f1);
      lblproduct.setBounds(120, 130, 180, 50);
      panel.add(lblproduct);
      
      cmbproduct=new JComboBox();
      cmbproduct.setFont(f1);
      cmbproduct.setBounds(280, 135, 180, 40);
      panel.add(cmbproduct);
      
      lblprice=new JLabel("Price");
      lblprice.setFont(f1);
      lblprice.setBounds(120, 180, 180, 50);
      panel.add(lblprice);
      txtprice=new JTextField(10);
      txtprice.setFont(f1);
      txtprice.disable();
      txtprice.setBounds(280, 185, 180, 40);
      panel.add(txtprice);
      
      lblQuantity=new JLabel("Quantity");
      lblQuantity.setFont(f1);
      lblQuantity.setBounds(120, 230, 180, 50);
      
      
      panel.add(lblQuantity);
      
      txtQuantity=new JTextField(10);
      txtQuantity.setFont(f1);
      txtQuantity.setBounds(280, 235, 180, 40);
      
        
      panel.add(txtQuantity);
      
      lblTotlePrice=new JLabel("Total Price");
      lblTotlePrice.setFont(f1);
      lblTotlePrice.setBounds(120, 280, 180, 50);
      panel.add(lblTotlePrice);
      
      txtTotlePrice=new JTextField(10);
      txtTotlePrice.setFont(f1);
      txtTotlePrice.disable();
      txtTotlePrice.setBounds(280, 285, 180, 40);
      panel.add(txtTotlePrice);
      
    
      
      btnOrder=new JButton("Order Now");
      btnOrder.setFont(f1);
      btnOrder.setBounds(120,395,170,50);
      panel.add(btnOrder);
     
      btnCancel=new JButton("Cancel");
      btnCancel.setFont(f1);
      btnCancel.setBounds(295,395,150,50);
      panel.add(btnCancel);
      
      txtpcode=new JTextField(20);
      
      cmbcategory.addItemListener(new ItemListener()
      {
          @Override
          public void itemStateChanged(ItemEvent ie) 
          {
            String category=cmbcategory.getSelectedItem().toString(); 
            rs=Sells_Database.getproductName(category);
            try{
              while(rs.next())
               {
                   cmbproduct.addItem(rs.getString("Product_Name"));
               
               }
              
               
               }
               catch(SQLException ex)
               {
                   System.out.println(ex);
               }
          }
          
          
      });
      
      cmbproduct.addItemListener(new ItemListener()
      {
          @Override
          
      public void itemStateChanged(ItemEvent ie)
      {
            String Name=cmbproduct.getSelectedItem().toString();
            
            try
               {
             rs=Sells_Database.getproductPrice(Name);
             
               if(rs.next())
               {
               txtprice.setText(rs.getString("Product_Price"));
               
               }
              
               
               }
               catch(SQLException ex)
               {
                   System.out.println(ex);
               }
            
            try
               {
                   
             rs1=Sells_Database.getproductCode(Name);
             
               if(rs1.next())
               {
                   
                 txtpcode.setText(rs1.getString("Product_Code"));
                 
               }
               
               }
            
               catch(SQLException ex)
               {
                   System.out.println(ex);
               }
            }
        
        
        });
        
      txtQuantity.addActionListener(new ActionListener()
      {
          @Override
           public void actionPerformed(ActionEvent e)
            {
                double Quantity=Double.parseDouble(txtQuantity.getText());
                double price=Double.parseDouble(txtprice.getText());
                double TotlePrice=Quantity*price;
                
                
               
                txtTotlePrice.setText(String.valueOf(TotlePrice));
            }
      });
      btnOrder.addActionListener(new ActionListener()
              {
                  
              @Override
            public void actionPerformed(ActionEvent e)
            {
                
               if(txtTotlePrice.getText().isEmpty())
               {
                   
                   JOptionPane.showMessageDialog(jop,"Please file the Field");
               }

               else
               {
                   
                                     
                   Integer Quntity=Integer.parseInt(txtQuantity.getText());
                   String Product_Name=cmbproduct.getSelectedItem().toString();
                   String Product_Code=txtpcode.getText();
                   
                   Sells_Database.calculate(Quntity,Product_Code);
                  
                   
                   JOptionPane.showMessageDialog(jop,"Your Order:"+Quntity+" "+Product_Name+"Sucessfull");
                   txtQuantity.setText("");
                   txtTotlePrice.setText("");
                   txtprice.setText("");
                   
               }
           }  
            
                  
             });
      

     
      
        frame.setVisible(true);
            frame.setSize(900,600);
            frame.setLocation(350,150);
        frame.setLocation(550,150);
        panel.setBackground( new Color(191, 238, 255) );
        frame.add(panel);
        
        
    }
 
    
}
