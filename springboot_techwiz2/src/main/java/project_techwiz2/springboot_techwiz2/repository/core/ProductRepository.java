package project_techwiz2.springboot_techwiz2.repository.core;

import org.springframework.data.jpa.repository.JpaRepository;
import project_techwiz2.springboot_techwiz2.model.core.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
