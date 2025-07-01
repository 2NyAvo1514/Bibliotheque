package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import entities.Livre;
import repository.LivreRepository;

@Service
@Transactional(readOnly = true)
public class LivreService {

    private final LivreRepository livreRepository;

    @Autowired
    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    /* ----------  CRUD  ---------- */

    @Transactional
    public Livre saveLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Livre getLivreById(int id) {
        return livreRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteLivreById(int id) {
        livreRepository.deleteById(id);
    }
}
