package sn.isi.parcinfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.parcinfo.entities.Role;

public interface IRoleDao extends JpaRepository<Role,Integer> {
}
