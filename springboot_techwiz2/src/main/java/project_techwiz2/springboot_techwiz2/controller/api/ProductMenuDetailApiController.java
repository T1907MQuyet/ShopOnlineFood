package project_techwiz2.springboot_techwiz2.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project_techwiz2.springboot_techwiz2.model.core.Product_menu_detail;
import project_techwiz2.springboot_techwiz2.model.dto.Product_menu_detailDto;
import project_techwiz2.springboot_techwiz2.repository.core.ProductMenuDetailRepository;
import project_techwiz2.springboot_techwiz2.repository.dto.ProductMenuDetailDtoRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "api/proMenuDetail")
public class ProductMenuDetailApiController {
    @Autowired
    private ProductMenuDetailRepository productMenuDetailRepository;

    @Autowired
    private ProductMenuDetailDtoRepository productMenuDetailDtoRepository;

    @RequestMapping(path = "")
    public List<Product_menu_detailDto> getAll()
    {
        List<Product_menu_detailDto> list = productMenuDetailDtoRepository.findAll();
        return list;
    }


    @RequestMapping(path = "/menuDetail")
    public List<Product_menu_detailDto> getProDetailByMenu(@RequestParam("menu_id")Integer menu_detail_id)
    {
        List<Product_menu_detailDto> list = productMenuDetailDtoRepository.getProMenuByMenu(menu_detail_id);
        return list;
    }
}
