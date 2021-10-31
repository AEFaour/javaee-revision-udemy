/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hw.aef.firstapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw.aef.firstappcore.Produit;
import hw.aef.firstappcore.Somme;
import hw.aef.firstappcore.SommeEtProduit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anas.faour
 */
@WebServlet(name = "Somme", urlPatterns = {"/somme"})
public class SommeServlet extends HttpServlet {

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

        String nombre1 = request.getParameter("nombre1");
        String nombre2 = request.getParameter("nombre2");
        try {
            int sommeNumerique = Integer.parseInt(nombre1) + Integer.parseInt(nombre2);
            int produitNumerique = Integer.parseInt(nombre1) * Integer.parseInt(nombre2);
            String format = request.getParameter("format");

            if (format != null && format.equals("pdf")) {
                request.setAttribute("somme", sommeNumerique);
                RequestDispatcher disp = request.getRequestDispatcher("/pdf");
                disp.forward(request, response);
            } else {
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                ObjectMapper mapper = new ObjectMapper();
                SommeEtProduit sommeEtProduit = new SommeEtProduit();
                Somme somme = new Somme();
                somme.setNumerique(sommeNumerique);
                somme.setTexte("douze");
                Produit produit = new Produit();
                produit.setNumerique(produitNumerique);
                produit.setTexte("trente-deux");
                sommeEtProduit.setSomme(somme);
                sommeEtProduit.setProduit(produit);
                
                mapper.writeValue(out, sommeEtProduit);
//                String message = "{ \"somme\" : { \"numerique\" : " + somme + " , \"texte\" : \"douze\"},"
//                        + " \"produit\" : {\"numerique\" : " + produit + " , \"texte\" : \"trente-six\"}}";
//
//                out.print(message);
            }
        } catch (NumberFormatException e) {
            RequestDispatcher disp = request.getRequestDispatcher("/unexpected-error");
            disp.forward(request, response);
        }

    }

}
