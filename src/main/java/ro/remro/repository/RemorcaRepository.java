package ro.remro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.remro.model.Remorca;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public interface RemorcaRepository extends JpaRepository<Remorca, String> {
    List<Remorca> findByCarNumberContaining(String carNumber);

//
//
//    public List<Remorca> findByName(String nrInmatriculare) {
//        Query query = entityManager.createQuery("SELECT r from Remorca r WHERE r.nr_Inmatriculare LIKE :nrInmatriculare");
//        query.setParameter("nrInmatriculare", nrInmatriculare);
//        List<Remorca> remorcibyname = query.getResultList();
//        System.out.println(remorcibyname);
//
////        return entityManager.createQuery("SELECT r from Remorca r WHERE r.nr_Inmatriculare LIKE :nrInmatriculare")
////                .setParameter("nrInmatriculare", nrInmatriculare)
////                .getResultList();
//        return remorcibyname;
//    }
//    public void FindRemorcabyNrInmatriculare(String nr_Inmatriculare) {
//        Remorca remorca =entityManager.find(Remorca.class,nr_Inmatriculare);
//        System.out.println("Remorca este : "+remorca);
//
//    }
//    public void DeleteRemorcabyNrInmatriculare(String nr_Inmatriculare) {
//        Remorca remorcas =entityManager.find(Remorca.class,nr_Inmatriculare);
//        entityManager.getTransaction().begin();
//        entityManager.remove(remorcas);
//        entityManager.getTransaction().commit();
//
//
//    }


}
