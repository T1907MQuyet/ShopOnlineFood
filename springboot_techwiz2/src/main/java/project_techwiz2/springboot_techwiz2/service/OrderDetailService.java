package project_techwiz2.springboot_techwiz2.service;

import project_techwiz2.springboot_techwiz2.model.core.Order_detail;

import java.util.List;

public interface OrderDetailService {
    List<Order_detail> getAllByOrderId(int orderId);
}
