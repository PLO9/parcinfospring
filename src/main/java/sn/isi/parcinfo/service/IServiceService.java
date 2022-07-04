package sn.isi.parcinfo.service;

import sn.isi.parcinfo.entities.Serveur;
import sn.isi.parcinfo.entities.Service;

import java.util.List;

public interface IServiceService {
    public Service save(Service service);
    public Service update(Service service);
    public void remove(Service service);
    public Service get(int id);
    public List<Service> getAll();
}
