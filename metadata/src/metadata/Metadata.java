
package metadata;
import java.sql.*;

public class Metadata
{

   
    public static void main(String[] args) 
    {
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
