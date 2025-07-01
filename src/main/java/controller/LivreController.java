
package controller;

import entities.Livre;
import entities.Tag;
import service.LivreService;
import service.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LivreController {

    @Autowired
    private LivreService livreService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String welcomePage() {
        return "home";  // retournera /WEB-INF/views/home.jsp
    }

    // Affiche tous les livres
    @GetMapping("/livres")
    public String showAllLivres(Model model) {
        List<Livre> livres = livreService.getAllLivres();
        model.addAttribute("livres", livres);
        return "list"; // fichiers livrés dans templates/livres/list.html
    }

    // Affiche le formulaire de création
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("livre", new Livre());
        return "livres/create"; // fichiers livrés dans templates/livres/create.html
    }

    // Enregistre un nouveau livre
    @PostMapping("/save")
    public String saveLivre(HttpServletRequest request, Model model) {
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        String editionLivre = request.getParameter("editionLivre");
        String isbn = null;
        // try {
        //     isbn = Long.parseLong(request.getParameter("isbn"));
        // } catch (Exception e) {
        //     model.addAttribute("error", "ISBN invalide !");
        //     return "create";
        // }

        Livre livre = new Livre(titre, isbn, auteur, editionLivre);
        livreService.saveLivre(livre);
        return "redirect:/livres";
    }

    // Voir les détails d’un livre
    @GetMapping("/{id}")
    public String viewLivre(@PathVariable int id, Model model) {
        Livre livre = livreService.getLivreById(id);
        if (livre == null) {
            model.addAttribute("error", "Livre introuvable");
            return "error";
        }
        model.addAttribute("livre", livre);
        return "detail"; // fichiers livrés dans templates/livres/detail.html
    }

    // Associer un tag à un livre via formulaire
    @PostMapping("/{id}/add-tag")
    public String addTagToLivre(@PathVariable int id, HttpServletRequest request) {
        int tagId = Integer.parseInt(request.getParameter("tagId"));
        Livre livre = livreService.getLivreById(id);
        Tag tag = tagService.getTagById(tagId);

        if (livre != null && tag != null) {
            livre.getTags().add(tag);
            livreService.saveLivre(livre);
        }

        return "redirect:/" + id;
    }
}
