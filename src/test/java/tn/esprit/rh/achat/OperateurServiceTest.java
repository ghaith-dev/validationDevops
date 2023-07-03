package tn.esprit.rh.achat;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.ICategorieProduitService;
import tn.esprit.rh.achat.services.IOperateurService;

import java.util.List;


@SpringBootTest




public class OperateurServiceTest {

    @Autowired
    private IOperateurService operateurService;




    @Test

    public void testRetrieveAllOperateur(){
       for(int i=0;i<10;i++){

           Operateur op = new Operateur(1L+i,"test1"+i,"test1"+i,"test",null);
              operateurService.addOperateur(op);
       }
        List<Operateur> listOperateur = operateurService.retrieveAllOperateurs();

       Assertions.assertFalse(listOperateur.isEmpty());
        listOperateur.forEach(op -> {
            operateurService.deleteOperateur(op.getIdOperateur());
       });
    }
    @Test
    void testRetrieveOperateur(){
        Operateur op = new Operateur();
        op.setNom("test11");
        op.setPrenom("test11");
        Operateur addedOperateur = operateurService.addOperateur(op);
        Operateur retrivedOperateur = operateurService.retrieveOperateur(addedOperateur.getIdOperateur());
        Assertions.assertEquals(retrivedOperateur.getIdOperateur(),addedOperateur.getIdOperateur());


        Assertions.assertEquals(retrivedOperateur.getNom(),"test11");
        operateurService.deleteOperateur(addedOperateur.getIdOperateur());
   }
    @Test

     void testAddOperateur(){
          Operateur op = new Operateur();
          op.setPrenom("test1");
            op.setNom("test11");
            Operateur addedOperateur = operateurService.addOperateur(op);


            Assertions.assertEquals(addedOperateur.getNom(),"test11");
            Operateur retrivedOperateur = operateurService.retrieveOperateur(addedOperateur.getIdOperateur());
            Assertions.assertEquals(addedOperateur.getIdOperateur(), retrivedOperateur.getIdOperateur());
            Assertions.assertFalse(retrivedOperateur.getNom().isEmpty());
            Assertions.assertEquals(retrivedOperateur.getPrenom(),"test1");
        operateurService.deleteOperateur(addedOperateur.getIdOperateur());
    }
    @Test

     void testDeleteOperateur(){
        Operateur OP = new Operateur();
        OP.setNom("deleteTest");
        OP.setPrenom("DeleteTest");
        Operateur addedOperateur = operateurService.addOperateur(OP);

        operateurService.deleteOperateur(addedOperateur.getIdOperateur());
        Operateur deletdOperateur=   operateurService.retrieveOperateur(addedOperateur.getIdOperateur());
       Assertions.assertEquals(deletdOperateur,null);

    }
    @Test
  void testUpdateOperateur(){
        Operateur op = new Operateur();
        op.setPrenom("op1");
        op.setNom("op10");
        Operateur addedOperateur = operateurService.addOperateur(op);
        op.setNom("done");
        Operateur updatedOperateur = operateurService.updateOperateur(addedOperateur);
        Assertions.assertEquals(updatedOperateur.getNom(),"done");
        Assertions.assertEquals(updatedOperateur.getPrenom(),"op1");
  }


}
