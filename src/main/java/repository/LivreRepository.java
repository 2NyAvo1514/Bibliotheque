package repository;

import entities.Livre;
import org.springframework.data.jpa.repository.*;
// import org.springframework.stereotype.Repository;

// @Repository
public interface LivreRepository extends JpaRepository<Livre, Integer> {

}
