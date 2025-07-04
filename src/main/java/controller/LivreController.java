/*package controller;

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
    @RequestMapping("/livres")
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

        return "redirect:/livres" + id;
    }
}*/
/*package controller;

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
@RequestMapping("/livres")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @Autowired
    private TagService tagService;

    // Affiche tous les livres
    @GetMapping
    public String showAllLivres(Model model) {
        List<Livre> livres = livreService.getAllLivres();
        model.addAttribute("livres", livres);
        return "list"; // fichiers livrés dans templates/livres/list.html
    }

    // Affiche le formulaire de création
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("livre", new Livre());
        return "create"; // fichiers livrés dans templates/livres/create.html
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
        //     return "livres/create";
        // }

        Livre livre = new Livre(titre, isbn, auteur, editionLivre);
        livreService.saveLivre(livre);
        return "redirect:/";
    }

    // Voir les détails d’un livre
    @GetMapping("/{id}")
    public String viewLivre(@PathVariable int id, Model model) {
        Livre livre = livreService.getLivreById(id);
        if (livre == null) {
            model.addAttribute("error", "Livre introuvable");
            return "livres/error";
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
*/
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
import java.util.Set;

@Controller
public class LivreController {

    @Autowired
    private LivreService livreService;

    @Autowired
    private TagService tagService;

    // Page d’accueil -> WEB-INF/views/home.jsp
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // Liste des livres -> WEB-INF/views/list.jsp
    @GetMapping("/livres")
    public String showAllLivres(Model model) {
        List<Livre> livres = livreService.getAllLivres();
        model.addAttribute("livres", livres);
        return "list";
    }

    // Formulaire de création -> WEB-INF/views/create.jsp
    @GetMapping("/livres/new")
    public String showCreateForm(Model model) {
        model.addAttribute("livre", new Livre());
        return "create";
    }

    // Enregistrement du livre
    @PostMapping("/livres/save")
    public String saveLivre(HttpServletRequest request, Model model) {
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        String editionLivre = request.getParameter("editionLivre");
        String isbn = request.getParameter("isbn");

        Livre livre = new Livre(titre, isbn, auteur, editionLivre);
        livreService.saveLivre(livre);
        return "redirect:/livres";
    }

    // Détails d’un livre -> WEB-INF/views/detail.jsp
    @GetMapping("/livres/{id}")
    public String viewLivre(@PathVariable("id") int id, Model model) {
        Livre livre = livreService.getLivreById(id);
        // Set<Tag> tags = tagService.getTagsByLivreId(id);

        if (livre == null) {
            model.addAttribute("error", "Livre introuvable");
            return "error"; // WEB-INF/views/error.jsp
        }
        // livre.setTags(tags);
        model.addAttribute("livre", livre);
        return "detail";
    }

    // Associer un tag
    @PostMapping("/livres/{id}/add-tag")
    public String addTagToLivre(@PathVariable("id") int id, HttpServletRequest request) {
        int tagId = Integer.parseInt(request.getParameter("tagId"));
        Livre livre = livreService.getLivreById(id);
        Tag tag = tagService.getTagById(tagId);

        if (livre != null && tag != null) {
            livre.getTags().add(tag);
            livreService.saveLivre(livre);
        }

        return "redirect:/livres/" + id;
    }
}
