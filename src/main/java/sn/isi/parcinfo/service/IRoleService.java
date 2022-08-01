package sn.isi.parcinfo.service;

import sn.isi.parcinfo.entities.Role;

import java.util.List;

public interface IRoleService {
    public Role save(Role role);
    public Role update(Role role);
    public void remove(Role role);
    public Role get(int id);
    public List<Role> getAll();
}
