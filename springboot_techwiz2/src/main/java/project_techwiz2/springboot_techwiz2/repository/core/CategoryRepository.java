package project_techwiz2.springboot_techwiz2.repository.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project_techwiz2.springboot_techwiz2.model.core.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAllByStatus(int status);

    @Query("SELECT c FROM Category c WHERE status = 1 OR status = 2")
    List<Category> findActiveCateStatus();

    @Query("SELECT c FROM Category c WHERE status = 1 OR status = 2")
    Page<Category> findPaginateCateStatus(Pageable pageable);
}
