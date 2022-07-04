package sn.isi.parcinfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.parcinfo.entities.Ingenieur;

public interface IIngenieurDao extends JpaRepository<Ingenieur,Integer> {
}
