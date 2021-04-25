package project_techwiz2.springboot_techwiz2.service;

import org.springframework.data.domain.Page;
import project_techwiz2.springboot_techwiz2.model.core.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> getAllOrders();
    Orders getOrderById(int id);
    boolean updateOrderStatus(int id,int status);
    Page<Orders> findPaginated(int pageNo, int pageSize);

}
