package project_techwiz2.springboot_techwiz2.repository.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project_techwiz2.springboot_techwiz2.model.core.Category_detail;

import java.util.List;

public interface CategoryDetailRepository extends JpaRepository<Category_detail,Integer> {
    List<Category_detail> findAllByStatus(int status);

    @Query("SELECT c FROM Category_detail c WHERE  cate_id = ?1")
    List<Category_detail> getByCateId(int cateId);

    @Query("SELECT c FROM Category_detail c WHERE status = 1 OR status = 2")
    List<Category_detail> getAllCateStatus();

    @Query("SELECT c FROM Category_detail c WHERE status = 1 OR status = 2")
    Page<Category_detail> findPaginateCateStatus(Pageable pageable);

    @Query("SELECT c FROM Category_detail c WHERE cate_detail_name = ?1 AND cate_id = ?2")
    Category_detail findByCateDetailName(String catename,int cate_id);

}
