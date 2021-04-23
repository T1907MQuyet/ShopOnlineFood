package project_techwiz2.springboot_techwiz2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project_techwiz2.springboot_techwiz2.model.Role;
import project_techwiz2.springboot_techwiz2.model.User;
import project_techwiz2.springboot_techwiz2.model.User_roles;
import project_techwiz2.springboot_techwiz2.service.RoleService;
import project_techwiz2.springboot_techwiz2.service.UserRoleService;
import project_techwiz2.springboot_techwiz2.service.UserService;

import java.util.List;

@Controller
@RequestMapping(path = {"/","/admin"})
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserRoleService userRoleService;
    @RequestMapping("")
    public String home(Model model)
    {
        return "admin/home";
    }
    @RequestMapping(path = "/login")
    public String loginAdmin()
    {
        boolean bl = checkUser();
        if (bl==false)
        {
            createUserAdmin();
        }

        return "admin/user/login";
    }

    public boolean checkUser()
    {
        String userEmail = "admin@localhost.com";
        List<User> list = userService.getAllUser();
        for (User us: list) {
            if (us.getEmail().equals(userEmail))
            {
                return true;
            }
        }
        return false;

    }

    public void createUserAdmin()
    {
        Role role = new Role();
        role.setId(1);
        role.setName("USER");
         Role roleComplete =   roleService.insertRole(role);
        Role role2 = new Role();
        role2.setId(2);
        role2.setName("ADMIN");
        Role role2Complete = roleService.insertRole(role2);

        User userAdmin = new User();
        userAdmin.setUsername("admin");
        userAdmin.setEmail("admin@localhost.com");
        userAdmin.setPassword("123456");
        User userAdminComplete = userService.saveUser(userAdmin);

        User_roles ur = new User_roles();
        ur.setRoleId(roleComplete);
        ur.setUserId(userAdminComplete);
        userRoleService.saveRole(ur);
        User_roles ur2 = new User_roles();
        ur2.setRoleId(role2Complete);
        ur2.setUserId(userAdminComplete);
        userRoleService.saveRole(ur2);
    }

}
