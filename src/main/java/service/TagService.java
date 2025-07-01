package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import entities.Tag;
import repository.TagRepository;

@Service
@Transactional(readOnly = true)
public class TagService {

    private final TagRepository tagRepository;

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

    @Transactional
    public void deleteTagById(int id) {
        tagRepository.deleteById(id);
    }
}
