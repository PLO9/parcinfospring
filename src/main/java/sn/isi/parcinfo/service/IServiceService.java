package sn.isi.parcinfo.service;

import sn.isi.parcinfo.entities.Services;

import java.util.List;

public interface IServiceService {
    public Services save(Services service);
    public Services update(Services service);
    public void remove(Services service);
    public Services get(int id);
    public List<Services> getAll();
}
