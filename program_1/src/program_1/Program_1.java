/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program_1;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author KSC114
 */
public class Program_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try
        {
            Scanner sc = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyb","root","");
            
            //1==> insert a record of an employee 
            /*System.out.println("Insert Record : ");
            String query="insert into employee (empno,empnm,designation,city,salary,department) values (1001,'julian','Web Developer','Ahmedabad',74500,'IT')";
            String query="insert into employee (empno,empnm,designation,city,salary,department) values (1002,'Alian','HR Manager','Gandhinagar',49650,'HR')";
            String query="insert into employee (empno,empnm,designation,city,salary,department) values (1003,'estrada','Manager','Amreli',367100,'PR')";
            String query="insert into employee (empno,empnm,designation,city,salary,department) values (1004,'Nickolas','Manager','Surat',35100,'Finance')";
            String query="insert into employee (empno,empnm,designation,city,salary,department) values (1005,'Maima','Tax Accountant','Rajkot',86000,'Accounting')";
            
            if(query!=null)
            {
                System.out.println("Record Iserted...");
            }*/
            
            //2==>display all the records of employees
            //String query="select * from employee";
            
            //3==> display employees whose salary is greater than 50000
            //String query="select * from employee where salary>50000";
            
            //4==>display employees who are from the city 'Rajkot'
            //String query="select * from employee where city='Rajkot'";
            
            //5==> display employees whose name starts with 'A'
            //String query="select * from employee where empnm like 'A%'";
            
            //6==> display employees whose designation is manager
            //String query="select * from employee where designation='manager'";
            
            //7==> count the number of employees in the table
            //String query="select COUNT(*) from employee";
            
            //8==> display the employee with the highest salary
            //String query="select * from employee where salary=(select MAX(salary) from employee
            
            //9==>sort employee records by empnm
            //String query="select * from employee ORDER BY empnm ASC";
            
            //10==>displays the corresponding employee record
            /*System.out.print("Enter empno to display records : ");
            int no=sc.nextInt();
            String query="select * from employee where empno=?";*/
            
            //11==>displays the employee name along with their designation
            System.out.print("Enter department to display records : ");
            String dep=sc.next();
            String query="select empnm,designation,department from employee where department=?";
            
            PreparedStatement pst=con.prepareStatement(query);
           //pst.setInt(1,no);
            pst.setString(1, dep);
            
            //Statement st=con.createStatement();
           // st.executeUpdate(query);
            
           /* ResultSet rs=st.executeQuery(query);
            if (rs.next()) 
            {
                int total = rs.getInt(1);
                System.out.println("Total number of employees: " + total);
            }*/
            
            System.out.println("Display records : ");
            ResultSet rs=pst.executeQuery();
            System.out.println("EmpNm \t\t " + "Designation \t " + "Department \t\t ");
            while(rs.next())
            {
                System.out.println( rs.getString(1) +"\t\t" + rs.getString(2) +"\t\t" + rs.getString(3));
            }
            
            /*System.out.println("Display records : ");
            ResultSet rs=pst.executeQuery();
            System.out.println("EmpNo \t\t " + "EmpNm \t\t " + "Designation \t\t " + "City \t\t " + "Salary \t\t  " + "Department \t\t ");
            while(rs.next())
            {
                System.out.println(rs.getInt(1) +"\t\t" + rs.getString(2) +"\t\t" + rs.getString(3) +"\t\t" + rs.getString(4) +"\t\t" + rs.getInt(5) +"\t\t" + rs.getString(6) +"\t\t");
            }*/
        }
        catch(Exception e)
        {
            System.out.println("Sorry... " + e);
        }
        
    }
    
}
