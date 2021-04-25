package project_techwiz2.springboot_techwiz2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project_techwiz2.springboot_techwiz2.model.ClImage;
import project_techwiz2.springboot_techwiz2.model.core.Category;
import project_techwiz2.springboot_techwiz2.model.core.Category_detail;
import project_techwiz2.springboot_techwiz2.model.core.Product;
import project_techwiz2.springboot_techwiz2.service.CategoryDetailService;
import project_techwiz2.springboot_techwiz2.service.CdService;
import project_techwiz2.springboot_techwiz2.service.ProductService;

import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/admin/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryDetailService categoryDetailService;
    @Autowired
    private CdService cdService;

    @InitBinder
    public void InitBinder(WebDataBinder data)
    {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping("")
    public String getProducts(Model model)
    {
        return findPaginated(1,model);
    }

    @RequestMapping("/insertProduct")
    public String insertPro(Model model)
    {
        Product product = new Product();
        List<Category_detail> listCateDetail = categoryDetailService.lisCategoryDetails();
        model.addAttribute("proNew",product);
        model.addAttribute("listCateDetail",listCateDetail);
        return "admin/product/insertProduct";
    }

    @RequestMapping(value = "/savePro",method = RequestMethod.POST)
    public String savePro(@ModelAttribute("proNew")@Valid Product product, BindingResult result,Model model,@RequestParam("file_avatar") MultipartFile multipartFile)throws IOException
    {
        if (result.hasErrors())
        {
            List<Category_detail> listCateDetail = categoryDetailService.lisCategoryDetails();
            model.addAttribute("listCateDetail",listCateDetail);
            model.addAttribute("proNew",product);
            return "admin/product/insertProduct";
        }
        Map resultCd = cdService.upload(multipartFile);
        ClImage clImage = new ClImage((String)resultCd.get("secure_url"));
        product.setImage(clImage.getUrl());
        boolean bl = productService.saveProduct(product);
        if(bl)
        {
            return "redirect:/admin/product?success=Add New product success";
        }
        return "redirect:/admin/product?error=Add New product error";
    }



    @RequestMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo")int pageNo, Model model)
    {
        int pageSize = 1;
        List<Category_detail> listCateDetail = categoryDetailService.lisCategoryDetails();
        Page<Product> page = productService.findPaginated(pageNo,pageSize);
        List<Product> listProduct = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("list",listProduct);
        model.addAttribute("listCateDetail",listCateDetail);
        return "admin/product/productList";
    }


}
