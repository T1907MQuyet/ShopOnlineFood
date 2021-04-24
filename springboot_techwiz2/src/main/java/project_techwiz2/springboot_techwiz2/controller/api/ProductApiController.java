package project_techwiz2.springboot_techwiz2.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project_techwiz2.springboot_techwiz2.config.exeption.ResourceNotFoundException;
import project_techwiz2.springboot_techwiz2.model.dto.ProductDto;
import project_techwiz2.springboot_techwiz2.repository.core.ProductRepository;
import project_techwiz2.springboot_techwiz2.repository.dto.ProductDtoRepository;


import java.util.List;

@RestController
@RequestMapping(path = "api/product")
public class ProductApiController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDtoRepository productDtoRepository;

    @RequestMapping(path = "")
    public List<ProductDto> getProduct()
    {
        List<ProductDto> list = productDtoRepository.findAll();
        return list;
    }

    @RequestMapping(path = "/category")
    public List<ProductDto> getProductByCate(@RequestParam("cate_id")Integer cate_id)
    {
        List<ProductDto> list = productDtoRepository.getProByCate(cate_id);
        return list;
    }


    @RequestMapping(path = "/{id}")
    public ProductDto getProById(@PathVariable(value = "id")Integer id)
    {
        ProductDto productDto = productDtoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id :"+id));
        return productDto;
    }





}
