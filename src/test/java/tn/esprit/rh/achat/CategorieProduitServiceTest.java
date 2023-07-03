package tn.esprit.rh.achat;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.services.ICategorieProduitService;
import java.util.List;


@SpringBootTest




public class CategorieProduitServiceTest {

    @Autowired
    private ICategorieProduitService produitService;


    private static TestEntityManager entityManager;

    @Test

    public void testRetrieveAllCategorieProduit(){
       for(int i=0;i<10;i++){

           CategorieProduit cp = new CategorieProduit(1L+i,"produit"+i,"libelle"+i,null);
              produitService.addCategorieProduit(cp);
       }
        List<CategorieProduit> listCategorieProduits = produitService.retrieveAllCategorieProduits();
  // Assertions.assertEquals(10, listCategorieProduits.size());
       Assertions.assertFalse(listCategorieProduits.isEmpty());
     listCategorieProduits.forEach(cp -> {
         produitService.deleteCategorieProduit(cp.getIdCategorieProduit());
       });
    }
    @Test
    void testRetrieveCategorieProduit(){
        CategorieProduit cp = new CategorieProduit();
        cp.setCodeCategorie("produit11");
        cp.setLibelleCategorie("libelle11");
        CategorieProduit addedCategorieProduit = produitService.addCategorieProduit(cp);
        CategorieProduit retrivedCategorieProduit = produitService.retrieveCategorieProduit(addedCategorieProduit.getIdCategorieProduit());
//        Assertions.assertEquals(insertedCategorieProduit.getIdCategorieProduit(), retrivedCategorieProduit.getIdCategorieProduit());
//        Assertions.assertFalse(retrivedCategorieProduit.getCodeCategorie().isEmpty());

        Assertions.assertEquals(retrivedCategorieProduit.getCodeCategorie(),"produit11");
        produitService.deleteCategorieProduit(addedCategorieProduit.getIdCategorieProduit());
   }
    @Test

     void testaddCategorieProduit(){
          CategorieProduit cp = new CategorieProduit();
          cp.setCodeCategorie("produit11");
            cp.setLibelleCategorie("libelle11");
            CategorieProduit addedCategorieProduit = produitService.addCategorieProduit(cp);

            Assertions.assertFalse(addedCategorieProduit.getCodeCategorie().isEmpty());
            Assertions.assertEquals(addedCategorieProduit.getCodeCategorie(),"produit11");
            CategorieProduit retrivedCategorieProduit = produitService.retrieveCategorieProduit(addedCategorieProduit.getIdCategorieProduit());
            Assertions.assertEquals(addedCategorieProduit.getIdCategorieProduit(), retrivedCategorieProduit.getIdCategorieProduit());
            Assertions.assertFalse(retrivedCategorieProduit.getCodeCategorie().isEmpty());
            Assertions.assertEquals(retrivedCategorieProduit.getCodeCategorie(),"produit11");
        produitService.deleteCategorieProduit(addedCategorieProduit.getIdCategorieProduit());
    }
    @Test

     void testdeleteCategorieProduit(){
        CategorieProduit cp = new CategorieProduit();
        cp.setCodeCategorie("produitDelete");
        cp.setLibelleCategorie("libelleDelete");
        CategorieProduit addedCategorieProduit = produitService.addCategorieProduit(cp);

        produitService.deleteCategorieProduit(addedCategorieProduit.getIdCategorieProduit());
        CategorieProduit deletdCategorieProduct=   produitService.retrieveCategorieProduit(addedCategorieProduit.getIdCategorieProduit());
       Assertions.assertEquals(deletdCategorieProduct,null);

    }
    @Test
  void testUpdateCategorieProduit(){
        CategorieProduit cp = new CategorieProduit();
        cp.setCodeCategorie("produitToBeUpdated");
        cp.setLibelleCategorie("libelleToBeUpdated");
        CategorieProduit addedCategorieProduit = produitService.addCategorieProduit(cp);
        CategorieProduit updatedCategorieProduit = produitService.updateCategorieProduit(addedCategorieProduit);
        Assertions.assertEquals(updatedCategorieProduit.getCodeCategorie(),"produitToBeUpdated");
        Assertions.assertEquals(updatedCategorieProduit.getLibelleCategorie(),"libelleToBeUpdated");
  }


}
