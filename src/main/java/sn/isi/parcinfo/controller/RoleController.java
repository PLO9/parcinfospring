package sn.isi.parcinfo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sn.isi.parcinfo.dao.IRoleDao;
import sn.isi.parcinfo.entities.Role;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Controller
public class RoleController {

    private IRoleDao roleDao;
    @PostMapping("/role/save")
    public String save(Role role){
        return "role/save";
    }

    @GetMapping("/role/edit/{id}")
    public String edit(@PathVariable int id){
        return "role/edit";
    }

    @GetMapping("/role/list")
    public String list(Model model){
        List<Role> roles = new ArrayList<>();
        roles = roleDao.findAll();
        model.addAttribute("rolesListe",roles);
        return "role/list";
    }
}