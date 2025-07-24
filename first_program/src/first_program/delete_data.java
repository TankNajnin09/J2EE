/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first_program;
import java.sql.*;

/**
 *
 * @author KSC115
 */
public class delete_data {
     public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyb","root","");
            String query="delete from student";
             Statement st=con.createStatement();
             st.executeUpdate(query);
             /*String table="select *from student";
             ResultSet r_s=st.executeQuery(table);
             while(r_s.next())
             {
                 System.out.println("Id:" +r_s.getInt(1));
                  System.out.println("firstname:" +r_s.getString(2));
                 System.out.println("lastname:" +r_s.getString(3));
                 System.out.println("course:" +r_s.getString(4));
                 System.out.println("semester:" +r_s.getString(5));
             }*/
        }
        catch(Exception e)
        {
            System.out.println("Sorry"+e);
        }
    }
    
}
