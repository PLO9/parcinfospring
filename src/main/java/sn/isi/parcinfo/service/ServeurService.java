package sn.isi.parcinfo.service;

import org.springframework.stereotype.Service;
import sn.isi.parcinfo.dao.IServeurDao;
import sn.isi.parcinfo.entities.Serveur;

import java.util.List;

@Service
public class ServeurService implements IServeurService{

    private IServeurDao iServeurDao;

    public ServeurService(IServeurDao iServeurDao) {
        this.iServeurDao = iServeurDao;
    }

    @Override
    public Serveur save(Serveur serveur) {
        return iServeurDao.save(serveur);
    }

    @Override
    public Serveur update(Serveur serveur) {
        Serveur serv = iServeurDao.findById(serveur.getId()).get();
        serv.setAdrIp(serveur.getAdrIp());
        serv.setNom(serveur.getNom());
        serv.setIngenieur(serveur.getIngenieur());
        return iServeurDao.save(serv);
    }

    @Override
    public void remove(Serveur serveur) {
        iServeurDao.delete(iServeurDao.findById(serveur.getId()).get());

    }

    @Override
    public Serveur get(int id) {
        return iServeurDao.findById(id).get();
    }

    @Override
    public List<Serveur> getAll() {
        return iServeurDao.findAll();
    }
}
