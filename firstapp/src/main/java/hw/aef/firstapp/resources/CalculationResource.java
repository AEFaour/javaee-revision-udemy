/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw.aef.firstapp.resources;

import hw.aef.firstappcore.Produit;
import hw.aef.firstappcore.Somme;
import hw.aef.firstappcore.SommeEtProduit;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author anas.faour
 */
@Path("/calculation")
public class CalculationResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/somme-et-produit")
    public SommeEtProduit sommeEtProduit(@QueryParam("nombre1") int nombre1, @QueryParam("nombre2") int nombre2) {

        int sommeNumerique = nombre1 + nombre2;
        int produitNumerique = nombre1 * nombre2;
        
        SommeEtProduit sommeEtProduit = new SommeEtProduit();
        Somme somme = new Somme();
        somme.setNumerique(sommeNumerique);
        somme.setTexte("douze");
        Produit produit = new Produit();
        produit.setNumerique(produitNumerique);
        produit.setTexte("trente-deux");
        sommeEtProduit.setSomme(somme);
        sommeEtProduit.setProduit(produit);

        return sommeEtProduit;

    }

}
