package project_techwiz2.springboot_techwiz2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import project_techwiz2.springboot_techwiz2.model.core.Category;
import project_techwiz2.springboot_techwiz2.service.CategoryService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @InitBinder
    public void InitBinder(WebDataBinder data) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping(path = "")
    public String getCategories(Model model) {
        Category category = new Category();

        return findPaginated(1, model, category);
    }

    @RequestMapping(path = "saveCate", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("cateNew") @Valid Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return findPaginated(1, model, category);
        }
        category.setCreated(new Date());
        boolean bl = categoryService.saveCate(category);
        if (bl) {
            return "redirect:/admin/category?success=Add New category success";
        }
        return "redirect:/admin/category?error=Add New category failed";
    }

    @RequestMapping(path = "editCate")
    public String editCategory(@RequestParam("id") Integer id, Model model) {
        Category category = categoryService.getCateById(id);
        model.addAttribute("cateEdit", category);
        return "admin/category/editCate";

    }

    @RequestMapping(path = "updateCategory", method = RequestMethod.POST)
    public String updateCategory(@ModelAttribute("cateEdit") Category category) {
        boolean bl = categoryService.updateCate(category);
        if (bl) {
            return "redirect:/admin/category?success=Update category success";
        }
        return "redirect:/admin/category?error=Update category failed";
    }

    @RequestMapping(path = "deleteCate")
    public String deleteCategory(@RequestParam("id") Integer id) {
        boolean bl = categoryService.deleteCate(id);
        if (bl) {
            return "redirect:/admin/category?success=Delete category success";
        }
        return "redirect:/admin/category?error=Delete category failed";
    }

    @RequestMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model, Category category) {
        int pageSize = 10;
        Page<Category> page = categoryService.findPaginated(pageNo, pageSize);
        List<Category> listCategory = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("list", listCategory);
        model.addAttribute("cateNew", category);
        return "admin/category/cateList";
    }


}
