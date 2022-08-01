package sn.isi.parcinfo.service;

import org.springframework.stereotype.Service;
import sn.isi.parcinfo.entities.Services;
import sn.isi.parcinfo.dao.IServiceDao;

import java.util.List;

@Service
public class ServiceService implements IServiceService{
    private IServiceDao iServiceDao;

    public ServiceService(IServiceDao iServiceDao) {
        this.iServiceDao = iServiceDao;
    }

    @Override
    public Services save(Services service) {
        return iServiceDao.save(service);
    }

    @Override
    public Services update(Services service) {
        Services servi = iServiceDao.findById(service.getId()).get();
        servi.setNom(service.getNom());
        servi.setPort(service.getPort());
        servi.setIngenieur(service.getIngenieur());
        servi.setServeur(service.getServeur());
        return iServiceDao.save(servi);
    }

    @Override
    public void remove(Services service) {
        iServiceDao.delete(iServiceDao.findById(service.getId()).get());

    }

    @Override
    public Services get(int id) {
        return iServiceDao.findById(id).get();
    }

    @Override
    public List<Services> getAll() {
        return iServiceDao.findAll();
    }
}
