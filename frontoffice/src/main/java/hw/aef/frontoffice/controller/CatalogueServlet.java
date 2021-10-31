/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hw.aef.frontoffice.controller;

import hw.aef.core.entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anas.faour
 */
@WebServlet(name = "CatalogueServlet", urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        if (Catalogue.listOkWorks.isEmpty()) {
            Artist michelSardot = new Artist("Michel Sardot");
            Artist Loane = new Artist("Loane");
            Artist karenViard = new Artist("Karen Viard");

            Work jeVaisTaimer = new Work("Je vais t'aimer");
            Work mesChersParents = new Work("Mes Chers Parents");
            Work laFamilleBelier = new Work("La Famille Belier");

            jeVaisTaimer.setMainArtist(michelSardot);
            mesChersParents.setMainArtist(Loane);
            laFamilleBelier.setMainArtist(karenViard);

            jeVaisTaimer.setRelease(1975);
            mesChersParents.setRelease(2013);
            laFamilleBelier.setRelease(2014);

            jeVaisTaimer.setSummary("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit");
            mesChersParents.setSummary("At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti");
            laFamilleBelier.setSummary("ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis");

            Catalogue.listOkWorks.add(jeVaisTaimer);
            Catalogue.listOkWorks.add(mesChersParents);
            Catalogue.listOkWorks.add(laFamilleBelier);
        }

        out.print("<html><body><h1>Oeuvres au catalogue</h1>");
        for (Work work : Catalogue.listOkWorks) {

            out.println("<a href=\"work-details?id=" + work.getId() + "\">" + work.getTitle() + " (" + work.getRelease() + ")</a><BR/>");

        }
        out.print("</body></html>");
    }

}
