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
import javax.servlet.http.Cookie;

/**
 *
 * @author KSC54
 */
public class cookie_servlet extends HttpServlet {

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
            String cknm=request.getParameter("txt_ck");
            
            Cookie all_ck[]=request.getCookies();//retrieve all cookie
            Cookie[] cookies = request.getCookies();
            boolean cookieFound = false;
            //out.println(cookienm);
            
             // Check if the target cookie exists
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cknm.equals(cookie.getName())) {
                        cookieFound = true;
                        out.println(cknm);
                        break;
                    }
                }
            }

            // If the cookie does not exist, create and add it to the response
            if (!cookieFound) {
                Cookie newCookie = new Cookie("cookienm",cknm);
                newCookie.setMaxAge(60); // 1 day
                response.addCookie(newCookie);
                out.println("<p>Cookie " +request.getParameter(cknm)+ " was not found. A new one has been created.</p>");
            } 
            else {
                out.println("<p>Cookie " +request.getParameter(cknm)+ " already exists.</p>");
            }

            out.println("<p><a href='display_cookie'>Click here for display all cookie</a></p>");
            
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
