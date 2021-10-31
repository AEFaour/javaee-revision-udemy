/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hw.aef.firstapp.controller;

import hw.aef.firstappcore.Livre;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "SelectionLivreServlet", urlPatterns = {"/selection-livre"})
public class SelectionLivreServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        String numeroSession =  session.getId();
        String identifiantLivre = request.getParameter("id");
        
       List<Livre> liste = (List<Livre>)session.getAttribute("listelivres");
       
       if(liste == null) {
           liste = new ArrayList<>();
           session.setAttribute("listelivres", liste);
       }
        
        Livre livre = new Livre();
        livre.setNumeroLivre(Integer.parseInt(identifiantLivre));
        liste.add(livre);
        PrintWriter out = response.getWriter();
        out.printf("<html><body> Merci d'avoir choisi le livre %s </br>", identifiantLivre);
        out.print("<a href=\"choix-du-livre.html\">Cliquez ici pour ajouter un autre livre</a></br>");
        out.print("<a href=\"payer-livre.html\">Cliquez ici pour payer </a></body></html>");
    }

}
