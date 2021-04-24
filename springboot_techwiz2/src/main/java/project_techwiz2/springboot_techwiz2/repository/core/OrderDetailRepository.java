package project_techwiz2.springboot_techwiz2.repository.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project_techwiz2.springboot_techwiz2.model.core.Order_detail;
import project_techwiz2.springboot_techwiz2.model.core.Orders;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<Order_detail,Integer> {
    @Query("SELECT c FROM Order_detail c WHERE  order_id = ?1")
    List<Order_detail> getByOrderId(int orderId);
}
