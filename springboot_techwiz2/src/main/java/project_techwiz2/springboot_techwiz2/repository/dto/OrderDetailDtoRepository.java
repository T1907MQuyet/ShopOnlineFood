package project_techwiz2.springboot_techwiz2.repository.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project_techwiz2.springboot_techwiz2.model.dto.Order_detailDto;

import java.util.List;

public interface OrderDetailDtoRepository extends JpaRepository<Order_detailDto,Integer> {
    @Query("SELECT c FROM Order_detailDto c WHERE  order_id = ?1")
    List<Order_detailDto> getByOrderId(int orderId);
}
