package project_techwiz2.springboot_techwiz2.repository.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project_techwiz2.springboot_techwiz2.model.core.Product_menu_detail;

import java.util.List;

public interface ProductMenuDetailRepository extends JpaRepository<Product_menu_detail,Integer> {
    @Query("SELECT p FROM Product_menu_detail p WHERE  menu_detail_id = ?1 ")
    List<Product_menu_detail> getProMenuByMenu(int menu_id);

    @Query("SELECT p FROM Product_menu_detail p WHERE  menu_detail_id = ?1 AND product_id = ?2 ")
    Product_menu_detail getProMDByMenuByPro(int menu_id,int pro_id);
}
