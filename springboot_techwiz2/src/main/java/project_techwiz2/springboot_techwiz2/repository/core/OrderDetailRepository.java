package project_techwiz2.springboot_techwiz2.repository.core;

import org.springframework.data.jpa.repository.JpaRepository;
import project_techwiz2.springboot_techwiz2.model.core.Order_detail;

public interface OrderDetailRepository extends JpaRepository<Order_detail,Integer> {
}