package project_techwiz2.springboot_techwiz2.service.Impl.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_techwiz2.springboot_techwiz2.model.core.Order_detail;
import project_techwiz2.springboot_techwiz2.repository.core.OrderDetailRepository;
import project_techwiz2.springboot_techwiz2.service.OrderDetailService;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<Order_detail> getAllByOrderId(int orderId) {
        try{
            List<Order_detail> list = orderDetailRepository.getByOrderId(orderId);
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
