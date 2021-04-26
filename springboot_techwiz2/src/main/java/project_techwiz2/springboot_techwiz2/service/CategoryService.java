package project_techwiz2.springboot_techwiz2.service;

import org.springframework.data.domain.Page;
import project_techwiz2.springboot_techwiz2.model.core.Category;

import java.util.List;

public interface CategoryService {
    List<Category> lisCategories();
    List<Category> listCateByStatus(int status);
    Category getCateById(int cate_id);
    boolean saveCate(Category category);
    boolean updateCate(Category category);
    boolean deleteCate(int cate_id);
    boolean checkCateName(String cate_name);
    Page<Category> findPaginated(int pageNo,int pageSize);
}
