package project_techwiz2.springboot_techwiz2.service;

import project_techwiz2.springboot_techwiz2.model.core.Product_menu_detail;

import java.util.List;

public interface ProductMenuDetailService {
    List<Product_menu_detail> lisProMenuDetailByMenu(int menuDetail_id);
    Product_menu_detail getProMenuDById(int id);
    boolean saveProMenuDetail(Product_menu_detail product_menu_detail);
    boolean updateProMenuDetail(Product_menu_detail product_menu_detail);
    boolean deleteProMenuDetail(int id);
    boolean getProMDByMDIdbyProId(int menu_detail_id,int product_id);
}
