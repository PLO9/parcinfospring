package sn.isi.parcinfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.parcinfo.entities.Service;

public interface IServiceDao extends JpaRepository<Service,Integer> {
}
