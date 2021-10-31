/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw.aef.firstapp.resources;

import hw.aef.firstappcore.Livre;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author jnesis
 */
@Path("/livre")
public class LivreResource {

    private static List<Livre> catalogue = new ArrayList<>();

    static {
        Livre livre1 = new Livre();
        livre1.setNumeroLivre(1);
        livre1.setNom("Les miséroïdes");
        Livre livre2 = new Livre();
        livre2.setNumeroLivre(2);
        livre2.setNom("Duel");
        catalogue.add(livre1);
        catalogue.add(livre2);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Livre> liste() {
        return catalogue;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{numero}")
    public Livre get(@PathParam("numero") int numero) {
        Livre livres=catalogue.stream().filter(livre -> livre.getNumeroLivre() == numero).findFirst().get();
        return livres;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response add(@FormParam("nom") String nom) {
        Livre livre = new Livre();
        livre.setNumeroLivre(catalogue.size() + 1);
        livre.setNom(nom);
        catalogue.add(livre);
        return Response.status(Response.Status.CREATED).entity(livre.getNumeroLivre()).build();
    }
    
    @DELETE
    @Path("/{numero}")
    public Response delete(@PathParam("numero") int numero) {
        catalogue.removeIf(livre -> livre.getNumeroLivre() == numero);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/{numero}")
    public Response modify(@PathParam("numero") int numero, @QueryParam("nom") String nom) {
        Livre livreAModifier = catalogue.stream().filter(livre -> livre.getNumeroLivre() == numero).findFirst().get();
        livreAModifier.setNom(nom);
        return Response.status(Response.Status.OK).build();
    }
}
