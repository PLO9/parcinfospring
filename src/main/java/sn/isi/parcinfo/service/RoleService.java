package sn.isi.parcinfo.service;

import org.springframework.stereotype.Service;
import sn.isi.parcinfo.dao.IRoleDao;
import sn.isi.parcinfo.entities.Role;

import java.util.List;

@Service
public class RoleService implements IRoleService{
    private IRoleDao iRoleDao;

    public RoleService(IRoleDao iRoleDao) {
        this.iRoleDao = iRoleDao;
    }

    @Override
    public Role save(Role role) {
        return iRoleDao.save(role);
    }

    @Override
    public Role update(Role role) {
        Role rol = iRoleDao.findById(role.getId()).get();
        rol.setNom(role.getNom());
        return iRoleDao.save(rol);
    }

    @Override
    public void remove(Role role) {
        iRoleDao.delete(iRoleDao.findById(role.getId()).get());
    }

    @Override
    public Role get(int id) {
        return iRoleDao.findById(id).get();
    }

    @Override
    public List<Role> getAll() {
        return iRoleDao.findAll();
    }
}
