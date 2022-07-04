package sn.isi.parcinfo.service;

import sn.isi.parcinfo.entities.Ingenieur;

import java.util.List;

public interface IIngenieurService {
    public Ingenieur save(Ingenieur ingenieur);
    public Ingenieur update(Ingenieur ingenieur);
    public void remove(int id);
    public Ingenieur get(int id);
    public List<Ingenieur> getAll();
}
