/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sells_application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author apptech
 */
public class Add_Vender extends JFrame
{
    JLabel lblSRF,lblName,lblGender,lblFirm,lblDOB,lbldate,lblMobile,lblMail,lblArea,lblState,lblNationlity;
     JTextField txtName,txtDOB,txtFirm,txtMobile,txtMail,txtArea,txtState,txtNationlity;
     JButton btnRegister;
     JRadioButton Male,Female;
     GridBagLayout gbl;
     GridBagConstraints gbc;
     JPanel panel;
     JOptionPane jop;
     ButtonGroup bg;
    public Add_Vender()
    {
        super("Ragistration Form");
        Sells_Database.loadJDBCDriverAndCreateConnection();
        
        CreateForm();
    }
    private void CreateForm()
    {
   Font f=new Font("ARIAL BLACK",Font.TYPE1_FONT,25);
   Font f2=new Font("ARIAL BLACK",Font.ROMAN_BASELINE,14);
   Font t=new Font("ARIAL BLACK",Font.ITALIC,14);
   
   
   lblSRF=new JLabel("Supplier Registration Form");
   lblSRF.setFont(f);
 
   lblFirm=new JLabel("Firm Name");
   lblFirm.setFont(f2);
   txtFirm=new JTextField(20);
   txtFirm.setFont(t);
   
   lblName=new JLabel("Distibutor Name");
   txtName=new JTextField(20);
   txtName.setFont(t);
   lblName.setFont(f2);
   
   lblGender=new JLabel("Gender");
   Male=new JRadioButton("  Male ");
   Male.setFont(f2);
   Male.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
   Male.setOpaque(false);
Male.setContentAreaFilled(false);
Male.setBorderPainted(false);
  
   Female=new JRadioButton("Female");
   Female.setFont(f2);
   Female.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
   Female.setOpaque(false);
Female.setContentAreaFilled(false);
Female.setBorderPainted(false);
   bg=new ButtonGroup();
   bg.add(Male);
   bg.add(Female);
   lblGender.setFont(f2);
   
   lblDOB=new JLabel("DOB");
   lblDOB.setFont(f2);
   txtDOB=new JTextField(20);
   txtDOB.setFont(t);
  
   lbldate=new JLabel("DD/MM/YYYY");
   lbldate.setFont(f2);
   
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
   
   btnRegister=new JButton("Register Now");
   btnRegister.setFont(f2);
   
   
    gbl = new GridBagLayout();
    gbc=new GridBagConstraints();
    
    panel=new JPanel();
    panel.setLayout(gbl);
    
    
    gbc.gridx=2;
    gbc.gridy=1;
    gbl.setConstraints(lblSRF, gbc);
    panel.add(lblSRF);
   
    gbc.gridx=0;
    gbc.gridy=2;
    gbl.setConstraints(lblFirm, gbc);
    panel.add(lblFirm);
    gbc.gridx=2;
    gbc.gridy=2;
    gbl.setConstraints(txtFirm, gbc);
    panel.add(txtFirm);
    
    gbc.gridx=0;
    gbc.gridy=3;
    gbl.setConstraints(lblName, gbc);
    panel.add(lblName);
    gbc.gridx=2;
    gbc.gridy=3;
    gbl.setConstraints(txtName, gbc);
    panel.add(txtName);
    
    gbc.gridx=0;
    gbc.gridy=4;
    gbl.setConstraints(lblGender, gbc);
    panel.add(lblGender);
    gbc.gridx=2;
    gbc.gridy=4;
    gbl.setConstraints(Male, gbc);
    panel.add(Male);
    gbc.gridx=2;
    gbc.gridy=5;
    gbl.setConstraints(Female, gbc);
    panel.add(Female);
    
    gbc.gridx=0;
    gbc.gridy=6;
    gbl.setConstraints(lblDOB, gbc);
    panel.add(lblDOB);
    gbc.gridx=2;
    gbc.gridy=6;
    gbl.setConstraints(txtDOB, gbc);
    panel.add(txtDOB);
    gbc.gridx=2;
    gbc.gridy=7;
    gbl.setConstraints(lbldate, gbc);
    panel.add(lbldate);
    
    gbc.gridx=0;
    gbc.gridy=7;
    gbl.setConstraints(lblMobile, gbc);
    panel.add(lblMobile);
    gbc.gridx=2;
    gbc.gridy=7;
    gbl.setConstraints(txtMobile, gbc);
    panel.add(txtMobile);
    
    gbc.gridx=0;
    gbc.gridy=8;
    gbl.setConstraints(lblMail, gbc);
    panel.add(lblMail);
    gbc.gridx=2;
    gbc.gridy=8;
    gbl.setConstraints(txtMail, gbc);
    panel.add(txtMail);
    
    gbc.gridx=0;
    gbc.gridy=9;
    gbl.setConstraints(lblArea, gbc);
    panel.add(lblArea);
    gbc.gridx=2;
    gbc.gridy=9;
    gbl.setConstraints(txtArea, gbc);
    panel.add(txtArea);
    
    gbc.gridx=0;
    gbc.gridy=10;
    gbl.setConstraints(lblState, gbc);
    panel.add(lblState);
    gbc.gridx=2;
    gbc.gridy=10;
    gbl.setConstraints(txtState, gbc);
    panel.add(txtState);
    
    gbc.gridx=0;
    gbc.gridy=11;
    gbl.setConstraints(lblNationlity, gbc);
    panel.add(lblNationlity);
    gbc.gridx=2;
    gbc.gridy=11;
    gbl.setConstraints(txtNationlity, gbc);
    panel.add(txtNationlity);
    
    gbc.gridx=2;
    gbc.gridy=12;
    gbl.setConstraints(btnRegister, gbc);
    panel.add(btnRegister);
    
   
            
    
         getRootPane().setDefaultButton(btnRegister);
         
         btnRegister.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                if( Male.isSelected()|| Female.isSelected() )
                {
                
             if(txtName.getText().isEmpty() || txtDOB.getText().isEmpty()|| txtMobile.getText().isEmpty()|| txtMail.getText().isEmpty()|| txtArea.getText().isEmpty()|| txtNationlity.getText().isEmpty())
            {
             JOptionPane.showMessageDialog(jop,"Please Fill the All Field");
             jop.setBackground(new Color(0, 200, 255) );
            }
            else
             {
                 if(Male.isSelected())
                 {
                 String Firm_Name=txtFirm.getText().trim();
                String Name=txtName.getText().trim();
                String DOB=txtDOB.getText().trim();
                String Gender=Male.getText().trim();
                String Mobile=txtMobile.getText().trim();
                String Email=txtMail.getText().trim();
                String Area=txtArea.getText().trim();
                String State=txtState.getText().trim();
                String Nation=txtNationlity.getText().trim();
                                                if(Firm_Name.isEmpty()||Name.isEmpty()||DOB.isEmpty()||Gender.isEmpty()||Mobile.isEmpty()||Email.isEmpty()||Area.isEmpty()||Nation.isEmpty())
                                                {
                                                    JOptionPane.showMessageDialog(jop,"Please Fill the Correct Value");
                                                }
                 
                 
                
                Sells_Database.Add_Vender(Firm_Name, Name, Gender, DOB, Mobile, Email, Area, State, Nation);
                 }
                 else
                 {
                 String Firm_Name=txtFirm.getText().trim();
                String Name=txtName.getText().trim();
                String DOB=txtDOB.getText().trim();
                String Gender=Female.getText().trim();
                String Mobile=txtMobile.getText().trim();
                String Email=txtMail.getText().trim();
                String Area=txtArea.getText().trim();
                String State=txtState.getText().trim();
                String Nation=txtNationlity.getText().trim();
                                                if(Firm_Name.isEmpty()||Name.isEmpty()||DOB.isEmpty()||Gender.isEmpty()||Mobile.isEmpty()||Email.isEmpty()||Area.isEmpty()||Nation.isEmpty())
                                                {
                                                    JOptionPane.showMessageDialog(jop,"Please Fill the Correct Value");
                                                }
                 
                
                Sells_Database.Add_Vender(Firm_Name, Name, Gender, DOB, Mobile, Email, Area, State, Nation);
                 }
                txtFirm.setText("");
                txtName.setText("");
                txtDOB.setText("");
                txtMobile.setText("");
                txtMail.setText("");
                txtState.setText("");
                txtArea.setText("");
                txtNationlity.setText("");
             
             }
                }
                else
                {
             JOptionPane.showMessageDialog(jop,"Please Please select Gender");
           
                }
            }});
         
             
    
    
      

            setVisible(true);
            setSize(900,600);
            setLocation(350,150);
            panel.setBackground( new Color(191, 238, 255) );
            add(panel);
    
            
           
           
           
   
    }
    
}
