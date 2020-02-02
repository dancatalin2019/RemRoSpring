package ro.remro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.remro.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {
    List<Client> findByCnpContaining(String cnp);


//    public void FindClientbyCMP(String c_cnp) {
//        Client clientt =entityManager.find(Client.class,c_cnp);
//        System.out.println("Clientul este : "+clientt);
//
//    }
//    public void DeleteClientbyCMP(String c_cnp) {
//        Client clientt =entityManager.find(Client.class,c_cnp);
//        entityManager.getTransaction().begin();
//        entityManager.remove(clientt);
//        entityManager.getTransaction().commit();
//
//
//    }
//    public void updateTelefon(String c_cnp,String newNumber) {
//        Client clientt =entityManager.find(Client.class,c_cnp);
//        entityManager.getTransaction().begin();
//        clientt.setC_nr_Telefon(newNumber);
//        entityManager.getTransaction().commit();
//
//
//    }
//    public void updateStreetClient(String c_cnp,String newStreet) {
//        Client clientt =entityManager.find(Client.class,c_cnp);
//        entityManager.getTransaction().begin();
//        clientt.setC_nr_Telefon(newStreet);
//        entityManager.getTransaction().commit();
//
//
//    }


//    public void someMethod() {
//        for (int i = 0; i< 25; i++) {
//            if(i == 4) {
//                //return;
//                //break;
//
//                continue;
//            }
//            System.out.println(i);
//        }
//        System.out.println("bla bla");
//    }

//
//    public List<Client> findCNP(String ccnp) {
//        Query query = entityManager.createQuery("SELECT c from Client c WHERE c.c_cnp LIKE :ccnp");
//        query.setParameter("ccnp", ccnp);
//        List<Client> clientsCNP = query.getResultList();
//        System.out.println(clientsCNP);
//
////        return entityManager.createQuery("SELECT r from Remorca r WHERE r.nr_Inmatriculare LIKE :nrInmatriculare")
////                .setParameter("nrInmatriculare", nrInmatriculare)
////                .getResultList();
//        return clientsCNP;
//    }


}
