package repository;

import entities.Tag;
import org.springframework.data.jpa.repository.*;
// import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Repository;

// import java.util.List;

// @Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

    // @Query("SELECT t FROM Tag t JOIN t.livres l WHERE l.idLivre = :idLivre")
    // List<Tag> findTagsByLivreId(@Param("idLivre") int idLivre);
}
