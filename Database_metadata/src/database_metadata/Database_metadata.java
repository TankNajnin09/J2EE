/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database_metadata;

import java.sql.*;

/**
 *
 * @author KSC54
 */
public class Database_metadata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         try
        {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyb","root","");
            
            //20==> connect to a database and retrieve metadata
            DatabaseMetaData dmd=con.getMetaData();
            System.out.println("Driver Name : " + dmd.getDriverName());
            System.out.println("Driver Version : " + dmd.getDriverVersion());
            System.out.println("Product Name : " + dmd.getDatabaseProductName());
            System.out.println("Product Version : " + dmd.getDatabaseProductVersion());
        }
        catch(Exception e)
        {
            System.out.println("Sorry"+e);
        }
        
    }
    
}
