package project_techwiz2.springboot_techwiz2.repository.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project_techwiz2.springboot_techwiz2.model.core.Category_detail;
import project_techwiz2.springboot_techwiz2.model.core.Orders;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
    @Query("SELECT c FROM Orders c WHERE  customer_id = ?1")
    List<Orders> getByCustomerId(int customerId);
}
