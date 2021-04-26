package project_techwiz2.springboot_techwiz2.service;

import org.springframework.data.domain.Page;
import project_techwiz2.springboot_techwiz2.model.core.Category_detail;

import java.util.List;

public interface CategoryDetailService {
    List<Category_detail> lisCategoryDetails();
    List<Category_detail> listCateDetailStatus(int status);
    Category_detail getCateDetailById(int cate_id);
    boolean saveCate(Category_detail category_detail);
    boolean deleteCate(int cate_id);
    boolean updateCate(Category_detail category_detail);
    boolean checkCateDetailName(String cate_detail_nem,int cate_id);
    Page<Category_detail> findPaginated(int pageNo, int pageSize);
}
