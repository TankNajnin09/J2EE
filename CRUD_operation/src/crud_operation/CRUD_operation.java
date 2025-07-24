/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crud_operation;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author KSC54
 */
public class CRUD_operation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         try
        {
            //19 => performs CRUD operation on product table
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter record for edit in table : \n");
            System.out.print("Product ID =");
            String pid=sc.nextLine();
            System.out.print("Product Name =");
            String pronm=sc.nextLine();
            System.out.print("Price=");
            int price =sc.nextInt();
            System.out.print("Quatity=");
            int quan=sc.nextInt();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyb","root","");
            
            //Insert Record
            String query="insert into product(pid,productname,price,quantity) values (?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(query);
             pst.setString(1, pid);
             pst.setString(2, pronm);
             pst.setInt(3, price);
             pst.setInt(4, quan);
             pst.executeUpdate();
            
            //Update Record
            /*String query="update product set productname=?,price=?,quantity=? where pid=?";
            
            PreparedStatement pst=con.prepareStatement(query);
             pst.setString(1, pronm);
             pst.setInt(2, price);
             pst.setInt(3, quan);
             pst.setString(4, pid);
             pst.executeUpdate();*/
             
            //Delete Record
          /*  String query="delete from product where pid=?";
            
            PreparedStatement pst=con.prepareStatement(query);
             pst.setString(1, pid);
             pst.executeUpdate();
            
             //Display Record
             String table="select *from product";//desplay all data
             //PreparedStatement pst=con.prepareStatement(table);
             ResultSet r_s=pst.executeQuery(table);
             System.out.println("PID\t\tProductName\tPrice\t\tQuantity\n");
             while(r_s.next())
             {
                 System.out.print(r_s.getString(1));
                 System.out.print("\t\t" +r_s.getString(2));
                 System.out.print("\t\t" +r_s.getInt(3));
                 System.out.print("\t\t" +r_s.getInt(4));
                 System.out.println("");
             }
             
        }
        catch(Exception e)
        {
            System.out.println("Sorry..." + e);
        }
        
    }
    
}
