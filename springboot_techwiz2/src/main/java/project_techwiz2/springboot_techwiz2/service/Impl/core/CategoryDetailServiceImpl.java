package project_techwiz2.springboot_techwiz2.service.Impl.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project_techwiz2.springboot_techwiz2.model.core.Category_detail;
import project_techwiz2.springboot_techwiz2.repository.core.CategoryDetailRepository;
import project_techwiz2.springboot_techwiz2.service.CategoryDetailService;

import java.util.List;

@Service
public class CategoryDetailServiceImpl implements CategoryDetailService {
    @Autowired
    private CategoryDetailRepository categoryDetailRepository;

    @Override
    public List<Category_detail> lisCategoryDetails() {
        try{
            List<Category_detail> list = categoryDetailRepository.getAllCateStatus();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category_detail> listCateDetailStatus(int status) {
        try{
            List<Category_detail> list = categoryDetailRepository.findAllByStatus(status);
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category_detail getCateDetailById(int cate_id) {
        try{
            Category_detail category_detail = categoryDetailRepository.findById(cate_id).get();
            return category_detail;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveCate(Category_detail category_detail) {
        try{
            categoryDetailRepository.save(category_detail);
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
            Category_detail category_detail = categoryDetailRepository.findById(cate_id).get();
            category_detail.setStatus(3);
            categoryDetailRepository.save(category_detail);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCate(Category_detail category_detail) {
        try{
            categoryDetailRepository.save(category_detail);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkCateDetailName(String cate_detail_nem,int cate_id) {
        Category_detail category_detail = categoryDetailRepository.findByCateDetailName(cate_detail_nem,cate_id);
        if (category_detail==null)
        {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Page<Category_detail> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.categoryDetailRepository.findPaginateCateStatus(pageable);
    }
}
