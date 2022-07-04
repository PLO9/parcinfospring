package sn.isi.parcinfo.service;

import org.springframework.stereotype.Service;
import sn.isi.parcinfo.dao.IIngenieurDao;
import sn.isi.parcinfo.entities.Ingenieur;

import java.util.List;

@Service
public class IngenieurService implements IIngenieurService {

    private IIngenieurDao iIngenieurDao;

    public IngenieurService(IIngenieurDao iIngenieurDao) {
        this.iIngenieurDao = iIngenieurDao;
    }

    @Override
    public Ingenieur save(Ingenieur ingenieur) {
        return iIngenieurDao.save(ingenieur);
    }

    @Override
    public Ingenieur update(Ingenieur ingenieur) {
        Ingenieur ing = iIngenieurDao.findById(ingenieur.getId()).get();
        ing.setNom(ingenieur.getNom());
        ing.setPrenom(ingenieur.getPrenom());
        ing.setEmail(ingenieur.getEmail());
        ing.setPassword(ingenieur.getPassword());
        return iIngenieurDao.save(ing);
    }

    @Override
    public void remove(int id) {
        iIngenieurDao.delete(iIngenieurDao.findById(id).get());
    }

    @Override
    public Ingenieur get(int id) {
        return iIngenieurDao.findById(id).get();
    }

    @Override
    public List<Ingenieur> getAll() {
        return iIngenieurDao.findAll();
    }
}
