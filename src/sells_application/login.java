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
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author apptech
 */
public class login extends JFrame
{
    JPanel panel;
    JLabel lblUser,lblPassword,lbllogin,lblcomp,lbllab;
     JTextField txtUsername;
     JPasswordField txtpass;
     JButton btnlogin,btncancel;
     GridBagLayout gbl;
     GridBagConstraints gbc;
     JOptionPane jop;
     
    public login()
    {
        super("login");
        create();
    }
     private void create()
 {
     panel=new JPanel();
     
     
   Font f=new Font("ARIAL BLACK",Font.TYPE1_FONT,25);
   Font f2=new Font("ARIAL BLACK",Font.ROMAN_BASELINE,20);
     
      
       ImageIcon i3 = new ImageIcon("C:\\Users\\apptech\\Documents\\NetBeansProjects\\Sells_Application\\src\\sells_application\\pic\\login.png");
       Image debImage3=i3.getImage();
       Image modifieddebImage3=debImage3.getScaledInstance(180,180,185);
       i3=new ImageIcon(modifieddebImage3);
      
       
     
       ImageIcon i = new ImageIcon("C:\\Users\\apptech\\Documents\\NetBeansProjects\\Sells_Application\\src\\sells_application\\pic\\admin-icon.png");
       Image debImage=i.getImage();
       Image modifieddebImage=debImage.getScaledInstance(45,45,45);
       i=new ImageIcon(modifieddebImage);
      
       
       ImageIcon i2 = new ImageIcon("C:\\Users\\apptech\\Documents\\NetBeansProjects\\Sells_Application\\src\\sells_application\\pic\\password+icon.png");
       Image debImage2=i2.getImage();
       Image modifieddebImage2=debImage2.getScaledInstance(45,45,45);
       i2=new ImageIcon(modifieddebImage2);
    
        lblUser=new JLabel(i);
       // lblUser.setIcon(new ImageIcon("pic\\mg1.jpg"));
         
        lblPassword=new JLabel(i2);
        lblUser.setFont(f);
        lblPassword.setFont(f);
        
        lbllogin=new JLabel(i3);
        
        
        txtUsername=new JTextField(20);
        txtpass=new JPasswordField(20);
        txtUsername.setFont(f);
        txtpass.setFont(f);
       
        
        btnlogin=new JButton("LOG_IN");
        btnlogin.setFont(f);
        btncancel=new JButton("Cancel");
        btncancel.setFont(f);
     
     
     
      
        gbl = new GridBagLayout();
        gbc=new GridBagConstraints();
        
        panel=new JPanel();
        panel.setLayout(gbl);
        
      
        
        gbc.gridx=4;
        gbc.gridy=4;
        gbl.setConstraints(lbllogin, gbc);
        panel.add(lbllogin);
        
        gbc.gridx=2;
        gbc.gridy=6;
        gbl.setConstraints(lblUser, gbc);
        panel.add(lblUser);
        gbc.gridx=4;
        gbc.gridy=6;
        gbl.setConstraints(txtUsername, gbc);
        panel.add(txtUsername);
        
        gbc.gridx=2;
        gbc.gridy=8;
        gbl.setConstraints(lblPassword, gbc);
        panel.add(lblPassword);
        gbc.gridx=4;
        gbc.gridy=8;
        
        gbl.setConstraints(txtpass, gbc);
        panel.add(txtpass);
        gbc.gridx=2;
        gbc.gridy=10;
        gbl.setConstraints(btnlogin, gbc);
        panel.add(btnlogin);
        
        gbc.gridx=4;
        gbc.gridy=10;
        gbl.setConstraints(btncancel, gbc);
        panel.add(btncancel);
        
        //removes border
      //  btnCrAc.setBorder(BorderFactory.createEmptyBorder());
        //removes content area

      
        
        
         getRootPane().setDefaultButton(btnlogin);
         btnlogin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
             if(txtUsername.getText().isEmpty() || txtpass.getText().isEmpty())
            {
                
             JOptionPane.showMessageDialog(jop,"Please Enter the User_Name & Password");
            }
            else
             {
                String U_Name=txtUsername.getText();
                String password=txtpass.getText();
                
               // Database.LoginMatch(U_Name,password);
                 
               Sells_Menu obj=new Sells_Menu();
               
                txtUsername.setText("");
                txtpass.setText("");
             
             
             
              
              //dispose();
             }
            }});
         
             
         btncancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                int a=JOptionPane.showConfirmDialog(jop,"Are you sure?");
                if(a==JOptionPane.YES_OPTION)
                {
                    System.exit(100);
                } 
            } 
                
        });
         
        
          

            setVisible(true);
          setSize(900,600);
          setLocation(350,100);
      panel.setBackground( new Color(0, 200, 255) );

      
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          add(panel);
                   
 }
   
     
 
}
    

