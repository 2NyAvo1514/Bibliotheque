package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer>{

}
