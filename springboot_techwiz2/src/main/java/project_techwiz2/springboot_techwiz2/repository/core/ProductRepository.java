package project_techwiz2.springboot_techwiz2.repository.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project_techwiz2.springboot_techwiz2.model.core.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByStatus(int status);
    @Query("SELECT p FROM Product p WHERE  cate_detail_id = ?1 AND status=1 ORDER BY priority ASC")
    List<Product> getProByCate(int cate_id);

    @Query("SELECT p FROM Product p WHERE  cate_detail_id = ?1 AND status=1")
    List<Product> findAllByCategory_detail(int cate_id);

    @Query("SELECT p FROM Product p WHERE status = 1 OR status = 2")
    List<Product> getAllProductStatus();


    @Query("SELECT p FROM Product p WHERE status = 1 OR status = 2")
    Page<Product> findPaginateProductStatus(Pageable pageable);

    @Query("SELECT p FROM Product p WHERE status = 1 ")
    Page<Product> findPaginateProStatusShow(Pageable pageable);

    @Query("SELECT p FROM Product p WHERE status = 2 ")
    Page<Product> findPaginateProStatusHidden(Pageable pageable);

}
