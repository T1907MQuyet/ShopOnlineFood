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
import project_techwiz2.springboot_techwiz2.model.core.Menu_detail;
import project_techwiz2.springboot_techwiz2.service.MenuDetailService;
import project_techwiz2.springboot_techwiz2.service.MenuService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/menuDetail")
public class MenuDetailController {
    @Autowired
    private MenuDetailService menuDetailService;
    @Autowired
    private MenuService menuService;

    @InitBinder
    public void InitBinder(WebDataBinder data)
    {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping(path = "")
    public String getMenuDetails(Model model)
    {
        Menu_detail menu_detail = new Menu_detail();
        return findPaginated(1,model,menu_detail);
    }

    @RequestMapping(path = "/saveMenuDetail",method = RequestMethod.POST)
    public String saveMenuDetail(@ModelAttribute("menuDetailNew")@Valid Menu_detail menu_detail, BindingResult result,Model model)
    {
        if (result.hasErrors())
        {
            return  findPaginated(1,model,menu_detail);
        }
        menu_detail.setCreated(new Date());
        menu_detail.setUpdated(new Date());

        boolean bl = menuDetailService.saveMenu(menu_detail);
        if (bl)
        {
            return "redirect:/admin/menuDetail?success=Add New menu detail detail success";
        }
        return "redirect:/admin/menuDetail?error=Add New menu detail detail error";
    }

    @RequestMapping("/deleteMenuDetail")
    public String deleteMenuDetail(@RequestParam("id")Integer id)
    {
        boolean bl = menuDetailService.deleteMenu(id);

        if (bl)
        {
            return "redirect:/admin/menuDetail?success=Delete menu detail detail success";
        }
        return "redirect:/admin/menuDetail?error=Delete menu detail detail error";

    }

    @RequestMapping(path = "/editMenuDetail")
    public String editMenuDetail(@RequestParam("id")Integer id,Model model)
    {
        Menu_detail menu_detail = menuDetailService.getMenuDetailById(id);
        List<Menu> listMenu = menuService.lisMenus();
        model.addAttribute("menDetailEdit",menu_detail);
        model.addAttribute("list",listMenu);
        return "admin/menuDetail/menuDetailEdit";
    }

    @RequestMapping(path = "/updateMenuDetail",method = RequestMethod.POST)
    public String updateMenuDetail(@ModelAttribute("menDetailEdit")Menu_detail menu_detail)
    {
        menu_detail.setUpdated(new Date());
        boolean bl = menuDetailService.updateMenu(menu_detail);
        if (bl)
        {
            return "redirect:/admin/menuDetail?success=Update menu detail detail success";
        }
        return "redirect:/admin/menuDetail?error=Update menu detail detail error";
    }



    @RequestMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo")int pageNo, Model model, Menu_detail menu_detail)
    {
        int pageSize = 10;
        List<Menu> listMenu = menuService.lisMenus();
        Page<Menu_detail> page = menuDetailService.findPaginated(pageNo,pageSize);
        List<Menu_detail> listMenuDetail = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("list",listMenuDetail);
        model.addAttribute("menuDetailNew",menu_detail);
        model.addAttribute("listMenu",listMenu);
        return "admin/menuDetail/menuDetailList";
    }
}
