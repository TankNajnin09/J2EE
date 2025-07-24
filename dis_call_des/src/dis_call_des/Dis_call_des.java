/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dis_call_des;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author KSC54
 */
public class Dis_call_des {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //18==>displays all the records of employees whose designation is provided by the user using a callable statement
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyb","root","");
            
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter designation for display records : ");
            String des =sc.next();
            
            String query="{call display_emp(?)}";//name of procedure
            CallableStatement cst=con.prepareCall(query);
            cst.setString(1,des);
            
             ResultSet rs=cst.executeQuery();
           System.out.println("EmpNo \t\t " + "EmpNm \t\t " + "Designation \t\t " + "City \t\t " + "Salary \t\t  " + "Department \t\t ");
            while(rs.next())
            {
                System.out.println(rs.getInt(1) +"\t\t" + rs.getString(2) +"\t\t" + rs.getString(3) +"\t\t" + rs.getString(4) +"\t\t" + rs.getInt(5) +"\t\t" + rs.getString(6) +"\t\t");
            }
            
        }
        catch(Exception e)
        {
           System.out.println("Sorry"+e);
        }
        
        
    }
    
}
