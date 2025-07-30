/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author KSC54
 */
public class stud_data extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            try
            {
                int rno=Integer.parseInt(request.getParameter("txt_rno"));
                int sem=Integer.parseInt(request.getParameter("txt_sem"));
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyb","root","");
                
                String query="insert into student(rollno,firstname,lastname,course,semester) values (?,?,?,?,?)";
               // int rno=Integer.parseInt(request.getParameter(txt_rno));
                PreparedStatement pst=con.prepareStatement(query);
                pst.setInt(1, rno);
                pst.setString(2, request.getParameter("txt_fnm"));
                pst.setString(3, request.getParameter("txt_lnm"));
                pst.setString(4, request.getParameter("txt_course"));
                pst.setInt(5, sem);
                
                 pst.executeUpdate();
                 
                 if(con!=null)
                 {
                    out.println("Inserted Successfully...\n\n"); 
                 }
                 
                 String table="select *from student";//desplay all 
             ResultSet r_s=pst.executeQuery(table);
             out.println("<table border=1>");
             out.println("<tr><th>Roll No</th><th>First Name</th><th>Last Name</th><th>Course</th><th>Semester</th></tr>");
             while(r_s.next())
             {
                 out.print("<tr><td>" + r_s.getInt(1) + "</td>");
                 out.print("<td>" + r_s.getString(2) + "</td>");
                 out.print("<td>" +r_s.getString(3) + "</td>");
                 out.print("<td>" +r_s.getString(4) + "</td>");
                 out.print("<td>" +r_s.getInt(5) + "</td></tr>");
                 out.println("");
             }
                
            }
            catch(Exception e)
            {
                out.println("Sorry..." + e);
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
