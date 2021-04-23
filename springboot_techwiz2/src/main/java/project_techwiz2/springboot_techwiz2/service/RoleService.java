package project_techwiz2.springboot_techwiz2.service;

import project_techwiz2.springboot_techwiz2.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRole();
    Role insertRole(Role role);
    Role getRoleById(int id);
    boolean update(Role role);
    boolean saveRole(Role role);
}
