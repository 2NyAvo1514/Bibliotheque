package repository;

import entities.Tag;

import java.util.List;

import org.springframework.data.jpa.repository.*;
// import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Repository;

// @Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

    // @Query("SELECT * FROM taglivre tl join tag t on t.idTag = tl.idTag join livre l on l.idLivre = tl.idLivre WHERE l.idLivre = :idLivre")
    // List<Tag> findTagsByLivreId(@Param("idLivre") int idLivre);
}
