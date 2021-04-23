package project_techwiz2.springboot_techwiz2.repository.core;

import org.springframework.data.jpa.repository.JpaRepository;
import project_techwiz2.springboot_techwiz2.model.core.Orders;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
}
