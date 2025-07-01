package entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Livre")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLivre")
    private Integer idLivre;

    private String titre;

    private String isbn;

    private String auteur;

    private String editionLivre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "TagLivre",
        joinColumns = @JoinColumn(name = "idLivre"),
        inverseJoinColumns = @JoinColumn(name = "idTag")
    )
    private Set<Tag> tags = new HashSet<>();

    /* ----------  Constructeurs ---------- */

    public Livre() {}

    public Livre(String titre, String isbn, String auteur, String editionLivre) {
        this.titre = titre;
        this.isbn = isbn;
        this.auteur = auteur;
        this.editionLivre = editionLivre;
    }

    /* ----------  Getters / Setters ---------- */

    public Integer getIdLivre() { return idLivre; }
    public void setIdLivre(Integer idLivre) { this.idLivre = idLivre; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    public String getEditionLivre() { return editionLivre; }
    public void setEditionLivre(String editionLivre) { this.editionLivre = editionLivre; }

    public Set<Tag> getTags() { return tags; }
    public void setTags(Set<Tag> tags) { this.tags = tags; }

    /* ----------  utilitaires ---------- */

    @Override public String toString() { return titre + " (" + isbn + ")"; }
}
