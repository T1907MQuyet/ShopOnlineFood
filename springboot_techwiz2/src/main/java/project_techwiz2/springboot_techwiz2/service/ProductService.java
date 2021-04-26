package project_techwiz2.springboot_techwiz2.service;

import org.springframework.data.domain.Page;
import project_techwiz2.springboot_techwiz2.model.core.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProduct();

    Product getProById(int pro_id);
    boolean saveProduct(Product product);
    boolean deleteProduct(int pro_id);
    boolean updateProduct(Product product);
    List<Product> lisProByCateDetail(int cate_id);
    Page<Product> findPaginated(int pageNo,int pageSize);
    Page<Product> findPaginatedShow(int pageNo,int pageSize);
    Page<Product> findPaginatedHidden(int pageNo,int pageSize);

    boolean checkProName(String pro_name,int cate_detail_id);

}
