package com.commercel.tshirt.Controller;

import com.commercel.tshirt.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private CategorieRepository categorieRepository;

    // Page d'accueil - Affiche toutes les catégories
    @GetMapping("/")
    public String accueil(Model model) {
        model.addAttribute("categories", categorieRepository.findAll());
        return "index"; // Redirige vers accueil.html
    }

}
