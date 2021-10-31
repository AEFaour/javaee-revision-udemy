/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hw.aef.frontoffice.controller;

import hw.aef.core.entity.Catalogue;
import hw.aef.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anas.faour
 */
@WebServlet(name = "WorkDetailsServlet", urlPatterns = {"/work-details"})
public class WorkDetailsServlet extends HttpServlet {

    /**
     *
     * Handles the HTTP <code>GET</code> method.
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

//Java 8 stream
//Work work=Catalogue.listOkWorks.stream().filter(w -> w.getId()==Long.parseLong(id)).findFirst().get();
        Work work = null;

        for (Work nextWork : Catalogue.listOkWorks) {
            if (nextWork.getId() == Long.parseLong(id)) {
                work = nextWork;
                break;
            }
        }

        request.setAttribute("work", work);
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/work-details.jsp");
        disp.forward(request, response);
      
    }

}
