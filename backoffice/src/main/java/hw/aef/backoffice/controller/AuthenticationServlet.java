/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hw.aef.backoffice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anas.faour
 */
@WebServlet(name = "AuthenticationServlet", urlPatterns = {"/login"})
public class AuthenticationServlet extends HttpServlet {

    /**
     *
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     *
     * methods.
     *
     *
     *
     * @param request servlet request
     *
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     *
     * @throws IOException if an I/O error occurs
     *
     */
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String login = request.getParameter("login");

        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        out.print("<html><body>");

        if (login.equals("aef") && password.equals("123456") || login.equals("caroline") && password.equals("123456")) {
            out.print("<a href=\"home.jsp\">Accés à la plage d'acceuil</a>");
            HttpSession session = request.getSession();
            session.setAttribute("login", login);
        } else {
            out.print("Login / mot de passe erronés."
                    + "<a href=\"login.html\">Nouvelle tentative</a>");

        }

        out.print("</body></html>");

    }

}
