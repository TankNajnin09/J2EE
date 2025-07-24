
package crud_1;
import java.sql.*;
import java.util.Scanner;

public class Crud_1 
{
    public static void main(String[] args)
   //int p_id;String p_name; int p_price; String p_quality; 
    {
        int p_id;String p_name; int p_price; String p_quality; 
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","");
            System.out.println("1.insert");
            System.out.println("2.update");
            System.out.println("3.delete");
            System.out.println("4.select");
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("p_id");
                    p_id=sc.nextInt();
                    System.out.println("p_name");
                    p_name=sc.next();
                    System.out.println("p_price");
                    p_price=sc.nextInt();
                    System.out.println("p_quality");
                    p_quality=sc.next();
                    String query="insert into product(p_id,p_name,p_price,p_quality) values(?,?,?,?)";
                    PreparedStatment pst_i=con.prepareStatment(insert);
                    pst_i.setInt(1,p_id);
                    pst_i.setString(2,p_name);
                    pst_i.setInt(3,p_price);
                    pst_i.setInt(4,p_quality);
                    ps_i.executeUpdate();
                    break
                    
                 case 2:
                    System.out.println("p_id");
                    p_id=sc.nextInt();
                    System.out.println("p_name");
                    p_name=sc.next();
                    System.out.println("p_price");
                    p_price=sc.nextInt();
                    System.out.println("p_quality");
                    p_quality=sc.next();
                    String Update="Update product set p_name=?,p_price=?,p_quality=? where p_id=?";
                    PreparedStatment pst_u=con.prepareStatment(Update);
                    pst_u.setInt(1,p_id);
                    pst_u.setString(2,p_name);
                    pst_u.setInt(3,p_price);
                    pst_u.setInt(4,p_quality);
                    ps_u.executeUpdate();
                    break
                            
                  case 3:
                     System.out.println("p_id:");
                      p_id=sc.nextInt();
                      String delete="delete from product where p_id=?";
                      PreparedStatement pst_d=con.prepareStatement(delete);
                      pst_d.setInt(1,p_id);
                      pst_d.executeUpdate();
                      break
                              
                   case 4:
                       String select="select*from product";
                       PreparedStatment pst_s=con.prepareStatment(select);
                       ResultSet rs=pst_s.executeQuery();
                       System.out.println("p_id \t p_name \t p_price \t p_quality");
                       
                       while(rs.next())
                       {
                           System.out.println(rs.getInt(1));
                           System.out.println(rs.getString(2));
                           System.out.println(rs.getInt(3));
                           System.out.println(rs.getString(4));
                           
                       }
                       break
                               
                       
                     
            }
        }
        catch(Exception e)
        {
          System.out.println("sorry" +e);
        }
       
    }
    
}
