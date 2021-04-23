package project_techwiz2.springboot_techwiz2.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_techwiz2.springboot_techwiz2.model.Role;
import project_techwiz2.springboot_techwiz2.repository.RoleRepository;
import project_techwiz2.springboot_techwiz2.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {
        try{
            List<Role> listRole = roleRepository.findAll();
            return  listRole;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role insertRole(Role role) {
        try{
            roleRepository.save(role);
            return role;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role getRoleById(int id) {
        try{
            Role role = roleRepository.findById(id).get();
            return  role;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Role role) {
        try{
            roleRepository.save(role);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveRole(Role role) {
        try{
            roleRepository.save(role);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
