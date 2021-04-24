package project_techwiz2.springboot_techwiz2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import project_techwiz2.springboot_techwiz2.model.core.Menu;
import project_techwiz2.springboot_techwiz2.service.MenuService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @InitBinder
    public void InitBinder(WebDataBinder data)
    {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping(path = "")
    public String getMenus(Model model)
    {
        Menu menu = new Menu();
        return findPaginated(1,model,menu);
    }

    @RequestMapping(path = "saveMenu",method = RequestMethod.POST)
    public String saveMenu(@ModelAttribute("menuNew")@Valid Menu menu, BindingResult result,Model model)
    {
        if (result.hasErrors())
        {
            return findPaginated(1,model,menu);
        }
        menu.setCreated(new Date());
        menu.setUpdated(new Date());
        boolean bl = menuService.saveMenu(menu);
        if (bl)
        {
            return "redirect:/admin/menu?success=Add New menu success";
        }
        return "redirect:/admin/menu?success=Add New menu failed";
    }

    @RequestMapping(path = "editMenu")
    public String editMenu(@RequestParam("id")Integer id,Model model)
    {
        Menu menu = menuService.getMenyById(id);
        model.addAttribute("menuEdit",menu);
        return "admin/menu/menuEdit";
    }

    @RequestMapping(path = "updateMenu",method = RequestMethod.POST)
    public String updateMenu(@ModelAttribute("menuEdit")Menu menu)
    {
        menu.setUpdated(new Date());
        boolean bl = menuService.updateMenu(menu);
        if (bl)
        {
            return "redirect:/admin/menu?success=Update menu success";
        }
        return "redirect:/admin/menu?error=Update menu failed";
    }

    @RequestMapping(path = "deleteMenu")
    public String deleteMenu(@RequestParam("id")Integer id)
    {
        boolean bl = menuService.deleteMenu(id);
        if (bl)
        {
            return "redirect:/admin/menu?success=Delete menu success";
        }
        return "redirect:/admin/menu?error=Delete menu failed";
    }

    @RequestMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo")int pageNo, Model model, Menu menu)
    {
        int pageSize = 10;
        Page<Menu> page = menuService.findPaginated(pageNo,pageSize);
        List<Menu> listMenu = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("list",listMenu);
        model.addAttribute("menuNew",menu);
        return "admin/menu/menuList";
    }


}
