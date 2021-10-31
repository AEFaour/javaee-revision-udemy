/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hw.aef.frontoffice.controller;

import hw.aef.core.entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anas.faour
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/addToCart"})
public class AddToCartServlet extends HttpServlet {

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
        String idAsString = request.getParameter("identifiant");
        long idAsLong = Long.parseLong(idAsString);

        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new ShoppingCart();
            request.getSession().setAttribute("cart", cart);
        }


        Optional<Work> optionalWork = Catalogue.listOkWorks.stream().filter(work -> work.getId() == idAsLong).findAny();
        if (optionalWork.isPresent()) {
            cart.getItems().add(optionalWork.get());
        }
        
        PrintWriter out = response.getWriter();
        
        out.printf("<html><body>Oeuvre ajouté au caddie %s <br/>", cart.getItems().size());
        out.print("<a href=\"catalogue\"> Retour au catalogue </a> </html></body>");

    }
}
