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

/**
 *
 * @author KSC54
 */
public class operation_servlet extends HttpServlet {

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
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet operation_servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet operation_servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            
            int num1=Integer.parseInt(request.getParameter("txt_no1"));
            int num2=Integer.parseInt(request.getParameter("txt_no2"));

            try
            {
                out.println("Perform Operations : \n\n");
                if(request.getParameter("rd_btn")==null)
                {
                     out.println("Operation not selected. Please <a href='index.html'>try again</a>.");
                }
                else if(request.getParameter("rd_btn").equals("Addition"))
                {
                   //out.println(request.getParameter("txt_no1"));
                    int sum=num1+num2;
                    out.println("Addition of enterd numbers = " + sum);
                }
                else if(request.getParameter("rd_btn").equals("Subtraction"))
                {
                   int sub=num1-num2;
                   out.println("Subtraction of enterd numbers = " + sub);
                }
                else if(request.getParameter("rd_btn").equals("Multiplication"))
                {
                    int mul=num1*num2;
                    out.println("Multiplication of enterd numbers = " + mul);
                }
                else if(request.getParameter("rd_btn").equals("Division"))
                {
                    if(num2 == 0) 
                    {
                        out.println("Error: Division by zero!");
                    } 
                    else 
                    {
                        int div = num1 / num2;
                        out.println("Division of enterd numbers = " + div);
                    }
                }
                else
                {
                    out.print("out.println(\"Invalid operation selected. Please <a href='index.html'>try again</a>.\");");
                }
            }
            catch(Exception e)
            {
                out.print("<a href='index.html'>");
                out.print("Operation does not selected...</a>");
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
