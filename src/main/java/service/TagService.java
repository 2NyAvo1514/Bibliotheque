package service;

import entities.Tag;
import repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class TagService {

    private final TagRepository tagRepository ;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    /* ----------  CRUD  ---------- */

    @Transactional
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag getTagById(int id) {
        return tagRepository.findById(id).orElse(null);
    }

    // public Set<Tag> getTagsByLivreId(int idLivre) {
    //     List<Tag> tags = tagRepository.findTagsByLivreId(idLivre);
    //     return new HashSet<>(tags);  // Conversion en Set
    // }

    @Transactional
    public void deleteTagById(int id) {
        tagRepository.deleteById(id);
    }
}
