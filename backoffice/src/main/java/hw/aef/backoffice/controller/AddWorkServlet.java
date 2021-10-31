/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hw.aef.backoffice.controller;

import hw.aef.core.entity.Artist;
import hw.aef.core.entity.Catalogue;
import hw.aef.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
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
@WebServlet(name = "AddWorkServlet", urlPatterns = {"/add-work"})
public class AddWorkServlet extends HttpServlet {

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        boolean success = true;

        String title = request.getParameter("title");
        String release = request.getParameter("release");
        String genre = request.getParameter("genre");
        String summary = request.getParameter("summary");
        String mainArtist = request.getParameter("artist");

        Work work = new Work();
        Artist artist = new Artist(mainArtist);
        work.setTitle(title);
        work.setGenre(genre);
        try {
            work.setRelease(Integer.parseInt(release));
        } catch (NumberFormatException e) {
            success = false;
        }

        work.setSummary(summary);
        work.setMainArtist(artist);

        Optional<Work> optionalWork = Catalogue.listOkWorks.stream().filter(
                w -> w.getMainArtist().getName() == work.getMainArtist().getName()).findAny();
        if (optionalWork.isPresent()) {
            success = false;
        }
        
         RequestDispatcher disp = null;
        if (success) {
            Catalogue.listOkWorks.add(work);
            request.setAttribute("identifiantDoeuvre", work.getId());
            disp = request.getRequestDispatcher("/work-added-success");
            disp.forward(request, response);
        } else {
            disp = request.getRequestDispatcher("/work-added-failure");
            disp.forward(request, response);
        }

    }

}
