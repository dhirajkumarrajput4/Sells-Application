/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sells_application;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author apptech
 */
public class Sells_Menu extends JFrame
{
   int index;
   JPanel panel,panel1;
   
   JOptionPane jop;
   JLabel lblWelcomeText;

   
   public Sells_Menu()
        {
         super("Wellcome");
         createMenu();
         
        }
   
   
   
   Font f=new Font("ARIAL BLACK",Font.TYPE1_FONT,25);
   Font f2=new Font("ARIAL BLACK",Font.ROMAN_BASELINE,20);
   
   private void createMenu()
   {
    panel1=new JPanel();
        
     lblWelcomeText=new JLabel("WELCOME TO CUSTOMER APPLICATION");
     lblWelcomeText.setFont(new Font("ARIAL BLACK",Font.BOLD,40));
    JMenuBar menubar=new JMenuBar();
    
    
    menubar.setBackground(Color.ORANGE);
    JMenu menu1=new JMenu("Product"); //1st menu
    menu1.setFont(f);
    
    JMenuItem i1=new JMenuItem("Add Product");
    i1.setFont(f);
    i1.setBackground(Color.LIGHT_GRAY);
    i1.addActionListener((ActionEvent e) ->
    {
        
    Add_Product obj=new Add_Product();
    
    });
    JMenuItem i2=new JMenuItem("Edit Products");
    i2.setFont(f);
    i2.setBackground(Color.LIGHT_GRAY);
     i2.addActionListener((ActionEvent e) ->
    {
      Edit_Product obj=new Edit_Product();
        
        
        
    }); 
     JMenuItem i3=new JMenuItem("View Product");
     i3.setFont(f);
     i3.setBackground(Color.LIGHT_GRAY);
     i3.addActionListener((ActionEvent e) ->
    {
      View_Products obj=new View_Products();
    });
     
    menu1.add(i1);      //add items in menu
    menu1.add(i2);
    menu1.add(i3);
    
    JMenu menu2=new JMenu("Vender"); 
    menu2.setFont(f);               //2nd menu
    
    JMenuItem i21=new JMenuItem("Add Vender");
    i21.setBackground(Color.LIGHT_GRAY);
    i21.setFont(f);
    i21.addActionListener((ActionEvent e) ->
    {
        
      Add_Vender obj=new Add_Vender();
    });
    
    JMenuItem i22=new JMenuItem("Edit Vender");
    i22.setBackground(Color.LIGHT_GRAY);
    i22.setFont(f);
    i22.addActionListener((ActionEvent e) ->
    {
        
      Edit_Vender obj=new Edit_Vender();
    });
   
    JMenuItem i23=new JMenuItem("View Vender");
    i23.setBackground(Color.LIGHT_GRAY);
    i23.setFont(f);
    i23.addActionListener((ActionEvent e) ->
    {
      View_Vender obj=new View_Vender();
    });
    
    menu2.add(i21);
    menu2.add(i22);
    menu2.add(i23);
   
    JMenu menu3=new JMenu("Supplier");
    menu3.setFont(f);
    JMenuItem i31=new JMenuItem("Add Supplier");
    i31.setBackground(Color.LIGHT_GRAY);
    i31.setFont(f);
    i31.addActionListener((ActionEvent e) ->
    {
        
     Add_Suppllier obj=new Add_Suppllier();
    });
    JMenuItem i32=new JMenuItem("Edite Supplier");
    i32.setBackground(Color.LIGHT_GRAY);
    i32.setFont(f);
    i32.addActionListener((ActionEvent e) ->
    {
        
      Edit_Supplier obj1=new Edit_Supplier();
    });
    JMenuItem i33=new JMenuItem("View Supplier");
    i33.setBackground(Color.LIGHT_GRAY);
    i33.setFont(f);
    i33.addActionListener((ActionEvent e) ->
    {
      View_Supplier obj=new View_Supplier();
    });
    menu3.add(i31);
    menu3.add(i32);
    menu3.add(i33);
    
    
     
    JMenu menu4=new JMenu("Stock");
    menu4.setFont(f);
    JMenuItem i41=new JMenuItem("Stock");
    i41.setBackground(Color.LIGHT_GRAY);
    i41.setFont(f);
    i41.addActionListener((ActionEvent e) ->
    {
       View_Products obj=new View_Products();
    });
    
    menu4.add(i41);
    
   JMenu menu5=new JMenu("Order");
    menu5.setFont(f);
    JMenuItem i51=new JMenuItem("Order Product");
    i51.setBackground(Color.LIGHT_GRAY);
    i51.setFont(f);
    i51.addActionListener((ActionEvent e) ->
    {
      Order obj=new Order();
    });
    menu5.add(i51);
    
//   JMenu menu6=new JMenu("Report");
//    menu6.setFont(f);
//    JMenuItem i61=new JMenuItem("Report");
//    i61.setBackground(Color.LIGHT_GRAY);
//    i61.setFont(f);
//    i61.addActionListener((ActionEvent e) ->
//    {
//        index=4;
//     // Edit_All obj=new Edit_All(index);
//    });
//    menu6.add(i61);

    JMenu menu7=new JMenu("Exit");
    menu7.setFont(f);
    
    menu7.addMouseListener(new MouseListener()
          {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) 
            {
               
            }

            @Override
            public void mouseReleased(MouseEvent e) 
            {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) 
            {
              
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
              
            }
            
            
        });
    

    menubar.add(menu1);     //Add menu in MenuBar
      menubar.add(menu2);
        menubar.add(menu3);
        menubar.add(menu4);
        menubar.add(menu5);
//        menubar.add(menu6);
        menubar.add(menu7);
        setJMenuBar(menubar);
          
          
   
    setVisible(true);
    
     Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
     setSize(screenSize.width,screenSize.height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
          int w= getWidth();
          int h=getHeight();
     
          ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("sells_application/pic/backgrondMenu.png"));
          Image img1=img.getImage().getScaledInstance(w, h,Image.SCALE_SMOOTH);
          ImageIcon img2=new ImageIcon(img1);
          JLabel lab=new JLabel(img2);
          panel1.add(lab);
          panel1.add(lblWelcomeText);    
          add(panel1);      
       
    
     
         
   }

}
