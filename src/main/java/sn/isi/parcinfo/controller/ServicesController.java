package sn.isi.parcinfo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sn.isi.parcinfo.dao.IServiceDao;
import sn.isi.parcinfo.entities.Ingenieur;
import sn.isi.parcinfo.entities.Services;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
public class ServicesController {
    private IServiceDao serviceDao;

    @PostMapping("/services/save")
    public String save(Services services){
        return "services/save";
    }

    @GetMapping("/services/edit/{id}")
    public String edit(@PathVariable int id){
        return "services/edit";
    }

    @GetMapping("/services/list")
    public String list(Model model){

        List<Services> services = new ArrayList<>();
        services = serviceDao.findAll();
        model.addAttribute("servicesListe",services);

        return "services/list";
    }
}
