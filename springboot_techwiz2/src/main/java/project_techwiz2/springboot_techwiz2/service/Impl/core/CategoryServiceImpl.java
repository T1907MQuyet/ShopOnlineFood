package project_techwiz2.springboot_techwiz2.service.Impl.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import project_techwiz2.springboot_techwiz2.model.core.Category;
import project_techwiz2.springboot_techwiz2.repository.core.CategoryRepository;
import project_techwiz2.springboot_techwiz2.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> lisCategories() {
        try{
            List<Category> list = categoryRepository.findActiveCateStatus();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category getCateById(int cate_id) {
        try{
            Category category = categoryRepository.findById(cate_id).get();
            return category;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveCate(Category category) {
        try{
            categoryRepository.save(category);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCate(Category category) {
        try{
            categoryRepository.save(category);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCate(int cate_id) {
        try{
            Category category = categoryRepository.findById(cate_id).get();
            category.setStatus(3);
            categoryRepository.save(category);
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<Category> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,Sort.by("status"));
        return this.categoryRepository.findPaginateCateStatus(pageable);
    }
}
