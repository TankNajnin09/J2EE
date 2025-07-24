/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first_program;
 import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author KSC115
 */
public class First_program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            Scanner sc=new Scanner(System.in);
            /*System.out.print("First Name=");
            String firstname=sc.nextLine();
            System.out.print("Last Name=");
            String lastname=sc.nextLine();
            System.out.print("Course=");
            String course =sc.nextLine();
            System.out.print("Semester=");
            int semester=sc.nextInt();
            
            System.out.print("Enter rollno where you change data : ");
            int rno=sc.nextInt();*/
            
            System.out.print("Enter rollno where you delete data : ");
            int rno=sc.nextInt();
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyb","root","");
           
            //12==> inserts a record of a student by using Prepared Statement
            //String query="insert into student(firstname,lastname,course,semester) values (?,?,?,?)";
            
            //13==>updates a record of a student by using Prepared Statement
            //String query="update student set firstname=?,lastname=?,course=?,semester=? where rollno=?";
            
            //14==> delete a record of a student whose rollno is given by the user
            String query="delete from student where rollno=?";
            
            PreparedStatement pst=con.prepareStatement(query);
             /*pst.setString(1, firstname);
             pst.setString(2, lastname);
             pst.setString(3, course);
             pst.setInt(4, semester);*/
             
             pst.setInt(1,rno);
             
             pst.executeUpdate();
             String table="select *from student";//desplay all 
             ResultSet r_s=pst.executeQuery(table);
             System.out.println("Rollno\t\tfirstname\tLastname\tCourses\t\tSemester\n");
             while(r_s.next())
             {
                 System.out.print(r_s.getInt(1));
                  System.out.print("\t\t" +r_s.getString(2));
                 System.out.print("\t\t" +r_s.getString(3));
                 System.out.print("\t\t" +r_s.getString(4));
                 System.out.print("\t\t" +r_s.getInt(5));
                 System.out.println("");
             }
             
             
        }
        catch(Exception e)
        {
            System.out.println("Sorry"+e);
        }
    }
    
}
