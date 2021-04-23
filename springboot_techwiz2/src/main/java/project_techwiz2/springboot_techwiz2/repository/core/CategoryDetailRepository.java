package project_techwiz2.springboot_techwiz2.repository.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project_techwiz2.springboot_techwiz2.model.core.Category_detail;

import java.util.List;

public interface CategoryDetailRepository extends JpaRepository<Category_detail,Integer> {
    @Query("SELECT c FROM Category_detail c WHERE  cate_id = ?1")
    List<Category_detail> getByCateId(int cateId);
}
