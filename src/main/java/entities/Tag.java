package entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTag")
    private Integer idTag;

    private String nomTag;

    @ManyToMany(mappedBy = "tags")
    private Set<Livre> livres = new HashSet<>();

    /* ----------  Constructeurs ---------- */

    public Tag() {}

    public Tag(String nomTag) {
        this.nomTag = nomTag;
    }

    /* ----------  Getters / Setters ---------- */

    public Integer getIdTag() { return idTag; }
    public void setIdTag(Integer idTag) { this.idTag = idTag; }

    public String getNomTag() { return nomTag; }
    public void setNomTag(String nomTag) { this.nomTag = nomTag; }

    public Set<Livre> getLivres() { return livres; }
    public void setLivres(Set<Livre> livres) { this.livres = livres; }

    @Override public String toString() { return nomTag; }
}
