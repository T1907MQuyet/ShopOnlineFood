package project_techwiz2.springboot_techwiz2.repository.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project_techwiz2.springboot_techwiz2.model.core.Menu_detail;

import java.util.List;

public interface MenuDetailRepository extends JpaRepository<Menu_detail,Integer> {
    List<Menu_detail> findAllByStatus(int status);
    @Query("SELECT m FROM Menu_detail m WHERE  menu_id = ?1")
    List<Menu_detail> getByMenuId(int menu_id);
}
