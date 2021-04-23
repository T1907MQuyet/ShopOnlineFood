package project_techwiz2.springboot_techwiz2.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project_techwiz2.springboot_techwiz2.model.core.Product;
import project_techwiz2.springboot_techwiz2.repository.core.ProductRepository;

import java.util.List;

@RestController
@RequestMapping(path = "api/product")
public class ProductApiController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(path = "")
    public List<Product> getProduct()
    {
        List<Product> list = productRepository.findAll();
        return list;
    }
}
