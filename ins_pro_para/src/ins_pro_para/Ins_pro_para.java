/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ins_pro_para;
import java.sql.*;

/**
 *
 * @author KSC54
 */
public class Ins_pro_para {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //16==> inserts a record of an employee using a callable statement. (Procedure with Parameter)  
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyb","root","");
            
            String query="{call insert_emp_para(?,?,?,?,?,?)}";//name of procedure
            CallableStatement cst=con.prepareCall(query);
            
            cst.setInt(1,10);
            cst.setString(2,"himali");
            cst.setString(3,"manager");
            cst.setString(4,"surat");
            cst.setInt(5,50000);
            cst.setString(6,"account");
            cst.executeUpdate();
            String table="select *from employee";
            PreparedStatement pst=con.prepareStatement(table);
            ResultSet rs=cst.executeQuery(table);
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
