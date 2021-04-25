package project_techwiz2.springboot_techwiz2.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_techwiz2.springboot_techwiz2.model.core.Product_menu_detail;
import project_techwiz2.springboot_techwiz2.repository.core.ProductMenuDetailRepository;
import project_techwiz2.springboot_techwiz2.service.ProductMenuDetailService;

import java.util.List;

@Service
public class ProductMenuDetailServiceImpl implements ProductMenuDetailService {
    @Autowired
    private ProductMenuDetailRepository productMenuDetailRepository;

    @Override
    public List<Product_menu_detail> lisProMenuDetailByMenu(int menuDetail_id) {
        try{
            List<Product_menu_detail> list = productMenuDetailRepository.getProMenuByMenu(menuDetail_id);
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product_menu_detail getProMenuDById(int id) {
        try{
            Product_menu_detail product_menu_detail = productMenuDetailRepository.findById(id).get();
            return product_menu_detail;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveProMenuDetail(Product_menu_detail product_menu_detail) {
        try{
            productMenuDetailRepository.save(product_menu_detail);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProMenuDetail(Product_menu_detail product_menu_detail) {
        try{
            productMenuDetailRepository.save(product_menu_detail);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProMenuDetail(int id) {
        try{
            productMenuDetailRepository.deleteById(id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean getProMDByMDIdbyProId(int menu_detail_id, int product_id) {
        try{
            Product_menu_detail product_menu_detail = productMenuDetailRepository.getProMDByMenuByPro(menu_detail_id,product_id);
            if (product_menu_detail==null)
            {
                return false;
            }
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
