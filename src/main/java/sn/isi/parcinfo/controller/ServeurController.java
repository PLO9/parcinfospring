package sn.isi.parcinfo.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sn.isi.parcinfo.dao.IServeurDao;
import sn.isi.parcinfo.entities.Role;
import sn.isi.parcinfo.entities.Serveur;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
public class ServeurController {
    private IServeurDao serveurDao;

    @PostMapping("/serveur/save")
    public String save(Serveur serveur){
        return "serveur/save";
    }

    @GetMapping("/serveur/edit/{id}")
    public String edit(@PathVariable int id){return "serveur/edit";
    }

    @GetMapping("/serveur/list")
    public String list(Model model){
        List<Serveur> serveurs = new ArrayList<>();
        serveurs = serveurDao.findAll();
        model.addAttribute("serveursListe",serveurs);
        return "serveur/list";
    }
}
