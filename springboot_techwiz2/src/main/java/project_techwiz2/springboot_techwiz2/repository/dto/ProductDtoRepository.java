package project_techwiz2.springboot_techwiz2.repository.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project_techwiz2.springboot_techwiz2.model.core.Product;
import project_techwiz2.springboot_techwiz2.model.dto.ProductDto;

import java.util.List;

public interface ProductDtoRepository extends JpaRepository<ProductDto,Integer> {
    @Query("SELECT p FROM ProductDto p WHERE  cate_detail_id = ?1 AND status=1 ORDER BY priority ASC")
    List<ProductDto> getProByCate(int cate_id);
}
