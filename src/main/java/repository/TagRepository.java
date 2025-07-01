package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer>{

}
