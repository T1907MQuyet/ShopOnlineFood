package project_techwiz2.springboot_techwiz2.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project_techwiz2.springboot_techwiz2.model.Role;
import project_techwiz2.springboot_techwiz2.model.User;
import project_techwiz2.springboot_techwiz2.model.User_roles;
import project_techwiz2.springboot_techwiz2.service.RoleService;
import project_techwiz2.springboot_techwiz2.service.UserRoleService;
import project_techwiz2.springboot_techwiz2.service.UserService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@Controller
@RequestMapping("/admin/roleUser")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @RequestMapping(path = "")
    public String getAllUserRole(Model model)
    {
        List<User_roles> list = userRoleService.getAllRole();
        List<User> listUser = userService.getAllUser();
        List<Role> listRole = roleService.getAllRole();
        User_roles userRolesNew = new User_roles();
        model.addAttribute("list",list);
        model.addAttribute("listUser",listUser);
        model.addAttribute("listRole",listRole);
        model.addAttribute("userRoleNew",userRolesNew);
        return "admin/userRole/listUserRole";
    }

    @RequestMapping(path = "/saveRoleUser",method = RequestMethod.POST)
    public String insertUserRole(@ModelAttribute("userRoleNew") User_roles user_roles)
    {
        boolean bl = userRoleService.saveRole(user_roles);
        if (bl)
        {
            return "redirect:/admin/roleUser?success";
        }
        return "redirect:/admin/roleUser?error";
    }

    @RequestMapping(path = "/editRoleUser")
    public String editRoleUser(@RequestParam("id")Integer roleUserId, Model model)
    {
        User_roles userRoles = userRoleService.getRoleById(roleUserId);
        List<User> listUser = userService.getAllUser();
        List<Role> listRole = roleService.getAllRole();
        model.addAttribute("userRolesEdit",userRoles);
        model.addAttribute("listUser",listUser);
        model.addAttribute("listRole",listRole);
        return "admin/userRole/editUserRole";
    }

    @RequestMapping(path = "/updateRoleUser",method = RequestMethod.POST)
    public String updateRoleUser(@ModelAttribute("userRolesEdit")User_roles user_roles)
    {
        User_roles userRoles = userRoleService.getRoleById(user_roles.getId());
        if (userRoles.getUserId().getEmail().equals("admin@localhost.com"))
        {
            return "redirect:/admin/roleUser?error";
        }
        boolean bl = userRoleService.editRole(user_roles);
        if (bl)
        {
            return "redirect:/admin/roleUser?success";
        }else{
            return "redirect:/admin/roleUser?error";
        }
    }

    @RequestMapping(path = "/deleteRoleUser")
    public String deleteRoleUser(@RequestParam("id")Integer roleUserId)
    {
        User_roles user_roles = userRoleService.getRoleById(roleUserId);
        if (user_roles.getUserId().getEmail().equals("admin@localhost.com"))
        {
            return "redirect:/admin/roleUser?error";
        }
        boolean bl = userRoleService.deleteRole(roleUserId);
        if (bl)
        {
            return "redirect:/admin/roleUser?success";
        }else{
            return "redirect:/admin/roleUser?error";

        }
    }

}
