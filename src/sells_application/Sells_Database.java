/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sells_application;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author apptech
 */
public class Sells_Database
{
    static Connection con;
    static Statement stmt;
    static PreparedStatement pstmt,pstmt1,pstmt2;
    static ResultSet rs;
   static JOptionPane jop; 
   
   
   
      public static void loadJDBCDriverAndCreateConnection()
    {
         try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Sells_Application","sa","password@123");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex);
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
    }
      
      // Vender Details
      
    public static void Add_Vender(String firm_name,String name,String gender,String dob,String mobile, String mail,String area,String state,String nationality)
     {
         try
         {
            pstmt=con.prepareStatement("insert into Vender values(?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1,firm_name);
            pstmt.setString(2,name);
            pstmt.setString(3,gender);
            pstmt.setString(4,dob);
            pstmt.setString(5,mobile);
            pstmt.setString(6,mail);
            pstmt.setString(7,area);
            pstmt.setString(8,state);
            pstmt.setString(9,nationality);
            pstmt.executeUpdate();
            pstmt.close();
            
            JOptionPane.showMessageDialog(jop,"Successfully Saved");
            
         }
         
       catch(SQLException ex)
       {
         System.out.println(ex);
     }
     
  
}
       public static ResultSet getFirm()
    {
       try
       {
            pstmt=con.prepareStatement("Select Firm_Name from Vender");
            rs=pstmt.executeQuery();
             
          
           
           
       }
       catch(SQLException ex)
       {
           System.out.println(ex);
       }
       return rs;
    }
       
        public static void updateVender(String name,String dob,String mobile, String mail,String area,String state,String nationality,String Firm_Name)
      {
           try
        {
           pstmt=con.prepareStatement("update Vender set Name=?,DOB=?,Mobile=?,Email=?,Area=?,State=?,Nationality=? where Firm_Name=?");
            pstmt.setString(1,name);
            
            pstmt.setString(2,dob);
            pstmt.setString(3,mobile);
            pstmt.setString(4,mail);
            pstmt.setString(5,area);
            pstmt.setString(6,state);
            pstmt.setString(7,nationality);
            pstmt.setString(8,Firm_Name);
            pstmt.executeUpdate();
            pstmt.close();
           
           JOptionPane.showMessageDialog(jop,"Data is UPDATED");
            
            
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
      }
        
        
        
   public static ResultSet getVenderDetails(String FirmName)    
      {
          try
       {
          pstmt=con.prepareStatement("Select Name,DOB,Mobile,Email,Area,State,Nationality from Vender where Firm_Name=?");
          pstmt.setString(1, FirmName);
         rs= pstmt.executeQuery();
           
           
       }
       catch(SQLException ex)
       {
           System.out.println(ex);
       }
       return rs;
      }
   
   
   
   
   
   
   // Supplier database details
   
    public static void Add_Supplier(String firm_name,String name,String gender,String dob,String mobile, String mail,String area,String state,String nationality)
     {
         try
         {
            pstmt=con.prepareStatement("insert into Supplier values(?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1,firm_name);
            pstmt.setString(2,name);
            pstmt.setString(3,gender);
            pstmt.setString(4,dob);
            pstmt.setString(5,mobile);
            pstmt.setString(6,mail);
            pstmt.setString(7,area);
            pstmt.setString(8,state);
            pstmt.setString(9,nationality);
            pstmt.executeUpdate();
            pstmt.close();
            
            JOptionPane.showMessageDialog(jop,"Successfully Saved");
            
         }
         
       catch(SQLException ex)
       {
         System.out.println(ex);
     }
     
  
}
       public static ResultSet get_Supllier_Firm()
    {
       try
       {
            pstmt=con.prepareStatement("Select Firm_Name from Supplier");
            rs=pstmt.executeQuery();
             
          
           
           
       }
       catch(SQLException ex)
       {
           System.out.println(ex);
       }
       return rs;
    }
       
        public static void updateSupplier(String name,String dob,String mobile, String mail,String area,String state,String nationality,String Firm)
      {
           try
        {
           pstmt=con.prepareStatement("update Supplier set Name=?,DOB=?,Mobile=?,Email=?,Area=?,State=?,Nationality=? where Firm_Name=?");
            pstmt.setString(1,name);
            
            pstmt.setString(2,dob);
            pstmt.setString(3,mobile);
            pstmt.setString(4,mail);
            pstmt.setString(5,area);
            pstmt.setString(6,state);
            pstmt.setString(7,nationality);
            pstmt.setString(8,Firm);
            pstmt.executeUpdate();
            pstmt.close();
           
           JOptionPane.showMessageDialog(jop,"Data is UPDATED");
            
            
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
      }
        
        
        
   public static ResultSet getSupplierDetails(String FirmName)    
      {
          try
       {
          pstmt=con.prepareStatement("Select Name,DOB,Mobile,Email,Area,State,Nationality from Supplier where Firm_Name=?");
          pstmt.setString(1, FirmName);
         rs= pstmt.executeQuery();
           
           
       }
       catch(SQLException ex)
       {
           System.out.println(ex);
       }
       return rs;
      }
   
   
   
   
   
   // Product Details Database
   
  
   
     
    public static void Add_Product(String Product_Code,String Product_Name ,Double Product_Price,Double Product_Quantity,String Mgf_Date, String Exp_Date,String Product_Category,String Received_From,String Firm_Name)
     {
         try
         {
            pstmt=con.prepareStatement("insert into Product values(?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1,Product_Code);
            pstmt.setString(2,Product_Name);
            pstmt.setDouble(3,Product_Price);
            pstmt.setDouble(4,Product_Quantity);
            pstmt.setString(5,Mgf_Date);
            pstmt.setString(6,Exp_Date);
            pstmt.setString(7,Product_Category);
            pstmt.setString(8,Received_From);
            pstmt.setString(9,Firm_Name);
            pstmt.executeUpdate();
            pstmt.close();
            
            JOptionPane.showMessageDialog(jop,"Successfully Added");
            
         }
         
       catch(SQLException ex)
       {
         System.out.println(ex);
     }
     
   
   
   
   
     }

       public static ResultSet get_Product_Code()
    {
       try
       {
            pstmt=con.prepareStatement("Select Product_Code from Product");
            rs=pstmt.executeQuery();
             
          
           
           
       }
       catch(SQLException ex)
       {
           System.out.println(ex);
       }
       return rs;
    }
public static ResultSet get_Product_Details(String P_Code)    
      {
          try
       {
          pstmt=con.prepareStatement("Select Product_Name,Product_Price,Product_Quantity,Mgf_Date,Exp_Date,Product_Category,Receved_From,Firm_Name from product where Product_Code=?");
         pstmt.setString(1, P_Code);
         rs= pstmt.executeQuery();
           
           
       }
       catch(SQLException ex)
       {
           System.out.println(ex);
       }
       return rs;
      }
   
   
           public static ResultSet VenderReport()
           {
            try 
            {

            stmt = con.createStatement();

         rs = stmt.executeQuery("select * from Vender");
         
            
            }

     catch(SQLException ex)
    {
    System.out.println(ex);
    }
       return rs;
           }
   
           public static ResultSet SupplierReport()
           {
            try 
            {

            stmt = con.createStatement();

         rs = stmt.executeQuery("select * from Supplier");
         
            
            }

     catch(SQLException ex)
    {
    System.out.println(ex);
    }
       return rs;
           }
           public static ResultSet Products_Report()
           {
            try 
            {

            stmt = con.createStatement();

         rs = stmt.executeQuery("select * from Product");
         
            
            }

     catch(SQLException ex)
    {
    System.out.println(ex);
    }
       return rs;
           }
           
           
         public static ResultSet getproductName(String Category)    
      {
          try
       {
          pstmt=con.prepareStatement("Select Product_Name from product where Product_Category=?");
          pstmt.setString(1, Category);
         rs= pstmt.executeQuery();
           
           
       }
       catch(SQLException ex)
       {
           System.out.println(ex);
       }
       return rs;
      }
         
         public static ResultSet getproductPrice(String Product_Name)    
      {
          try
       {
          pstmt=con.prepareStatement("Select Product_Price from product where Product_Name=?");
          pstmt.setString(1, Product_Name);
         rs= pstmt.executeQuery();
           
           
       }
       catch(SQLException ex)
       {
           System.out.println(ex);
       }
       return rs;
      }
     
         
         
          public static void calculate(Integer Quantity,String Product_Code)
  {
      try
      {
          pstmt1=con.prepareStatement("insert into calculate(Pcode,Quantity) values(?,?)");
         
          pstmt1.setString(1,Product_Code);
          pstmt1.setInt(2,Quantity);
          pstmt1.executeUpdate();
          pstmt2=con.prepareStatement("Select Product_Quantity from Product where Product_Code=?");
          pstmt2.setString(1,Product_Code);
          rs=pstmt2.executeQuery();
          rs.next();    //move cursor one step ahead by default beahind
          pstmt=con.prepareStatement("update Product set Product_Quantity=(?) where Product_Code=(?)");
          Quantity=rs.getInt("Product_Quantity")-Quantity;
          pstmt.setInt(1,Quantity);
          pstmt.setString(2,Product_Code);
          pstmt.executeUpdate();
         
      }
  
   catch(SQLException ex)
   {
       System.out.println(ex);
   }
  
  }
          
          public static ResultSet getproductCode(String Product_Name)    
      {
          try
       {
          pstmt=con.prepareStatement("Select Product_Code from product where Product_Name=?");
          pstmt.setString(1, Product_Name);
         rs= pstmt.executeQuery();
           
           
       }
       catch(SQLException ex)
       {
           System.out.println(ex);
       }
       return rs;
      }  
          
            public static void updateProduct(String Firm_Name,String Product_Name,String Product_Price, String Quantity,String MgfDate,String ExpDate,String Recieve,String Product_Code)
      {
           try
        {
           pstmt=con.prepareStatement("update Product set Product_Name=?,Product_Price=?,Product_Quantity=?,Mgf_Date=?,Exp_Date=?,Receved_From=?,Firm_Name=? where Product_Code=?");
            pstmt.setString(1,Product_Name);
            
            pstmt.setString(2,Product_Price);
            pstmt.setString(3,Quantity);
            pstmt.setString(4,MgfDate);
            pstmt.setString(5,ExpDate);
            pstmt.setString(6,Recieve);
            pstmt.setString(7,Firm_Name);
            pstmt.setString(8,Product_Code);
            
            pstmt.executeUpdate();
            pstmt.close();
           
           JOptionPane.showMessageDialog(jop,"Data is UPDATED");
            
            
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
      }
        
        
}
