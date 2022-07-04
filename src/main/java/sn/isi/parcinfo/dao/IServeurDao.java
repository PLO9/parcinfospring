package sn.isi.parcinfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.parcinfo.entities.Serveur;

public interface IServeurDao extends JpaRepository<Serveur,Integer> {
}
