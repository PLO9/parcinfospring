package sn.isi.parcinfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.parcinfo.entities.Services;

public interface IServiceDao extends JpaRepository<Services,Integer> {
}
