package sn.isi.parcinfo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sn.isi.parcinfo.dao.IIngenieurDao;
import sn.isi.parcinfo.entities.Ingenieur;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
public class IngenieurController {
    private IIngenieurDao ingenieurDao;

    @PostMapping("/ingenieur/save")
    public String save(Ingenieur ingenieur){
        return "ingenieur/save";
    }

    @GetMapping("/ingenieur/edit/{id}")
        public String edit(@PathVariable int id){
        return "ingenieur/edit";
    }

    @GetMapping("/ingenieur/list")
    public String list (Model model){
        List<Ingenieur> ingenieurs = new ArrayList<>();
        ingenieurs = ingenieurDao.findAll();
        model.addAttribute("ingenieurListe",ingenieurs);
        return "ingenieur/list";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/accueil")
    public String accueil(){
        return "accueil";
    }

}
