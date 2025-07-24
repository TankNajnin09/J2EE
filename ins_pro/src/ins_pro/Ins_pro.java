/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ins_pro;
import java.sql.*;

/**
 *
 * @author KSC54
 */
public class Ins_pro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //15==>inserts a default record of an employee using a callable statement.(Procedure without parameter) 
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyb","root","");
            
            String query="{call insert_emp()}";//name of procedure
            CallableStatement cst=con.prepareCall(query);
            PreparedStatement pst=con.prepareStatement(query);
            pst.executeUpdate();
            
        }
        catch(Exception e)
        {
           System.out.println("Sorry"+e);
        }
        
    }
    
}
