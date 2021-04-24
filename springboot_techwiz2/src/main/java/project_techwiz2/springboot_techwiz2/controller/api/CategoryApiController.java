package project_techwiz2.springboot_techwiz2.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_techwiz2.springboot_techwiz2.model.core.Category;
import project_techwiz2.springboot_techwiz2.repository.core.CategoryRepository;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "api/category")
public class CategoryApiController {
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(path = "")
    public List<Category> getCategory()
    {
        List<Category> list = categoryRepository.findAll();
        return list;
    }

    @RequestMapping(path = "/status")
    public List<Category> getCateByStatus(@RequestParam("status")Integer status)
    {
        List<Category> list = categoryRepository.findAllByStatus(status);
        return list;
    }

    @RequestMapping(path = "",method = RequestMethod.POST)
    public Category saveCategory(@Valid @RequestBody Category category)
    {
        category.setCreated(new Date());
        return this.categoryRepository.save(category);
    }

}
