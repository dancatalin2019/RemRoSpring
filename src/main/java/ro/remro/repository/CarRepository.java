package ro.remro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.remro.model.Car;
import ro.remro.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {

//   List<Client> findByName(String serieBuletin)


}
