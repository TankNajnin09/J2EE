/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dis_call_empno;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author KSC54
 */
public class Dis_call_empno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //17==>displays employee’s designation by providing empno using callable statement
         try{
             
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyb","root","");
            
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter empno for display records : ");
            int no=sc.nextInt();
             
            String query="{call display_emp_no(?)}";//name of procedure
            CallableStatement cst=con.prepareCall(query);
            cst.setInt(1,no);
            
            ResultSet rs=cst.executeQuery();
             System.out.println("\tDesignation\n");
             while(rs.next())
             {
                
                System.out.print("\t"+rs.getString(1));
                System.out.println("");
                     
             }
            
        }
        catch(Exception e)
        {
           System.out.println("Sorry"+e);
        }
        
    }
    
}
