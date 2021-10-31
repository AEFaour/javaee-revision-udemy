/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw.aef.backoffice.resources;

import hw.aef.core.entity.*;
import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author anas.faour
 */
@Path("/catalogue")
public class CatalogueResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/liste")
    public Set<Work> liste(){
        
        if(Catalogue.listOkWorks.isEmpty()){
        Artist michelSardot = new Artist("Michel Sardot");
        Artist Loane = new Artist("Loane");
        Artist karenViard= new Artist("Karen Viard");
        
        Work jeVaisTaimer= new Work("Je vais t'aimer");
        Work mesChersParents= new Work("Mes Chers Parents");
        Work laFamilleBelier= new Work("La Famille Belier");
        
        jeVaisTaimer.setMainArtist(michelSardot);
        mesChersParents.setMainArtist(Loane);
        laFamilleBelier.setMainArtist(karenViard);
        
        jeVaisTaimer.setRelease(1975);
        mesChersParents.setRelease(2013);
        laFamilleBelier.setRelease(2014);
        
        jeVaisTaimer.setSummary("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit");
        mesChersParents.setSummary("At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti");
        laFamilleBelier.setSummary("ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis");
        
        jeVaisTaimer.setId(1);
        mesChersParents.setId(2);
        laFamilleBelier.setId(3);
        
        Catalogue.listOkWorks.add(jeVaisTaimer);
        Catalogue.listOkWorks.add(mesChersParents);
        Catalogue.listOkWorks.add(laFamilleBelier);
        }  
        
        return Catalogue.listOkWorks;
    }
    
}
