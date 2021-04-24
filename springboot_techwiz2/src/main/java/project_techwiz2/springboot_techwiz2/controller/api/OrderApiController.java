package project_techwiz2.springboot_techwiz2.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_techwiz2.springboot_techwiz2.config.exeption.ResourceNotFoundException;
import project_techwiz2.springboot_techwiz2.model.core.Orders;
import project_techwiz2.springboot_techwiz2.repository.core.OrderRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/orders")
public class OrderApiController {
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(path = "")
    public List<Orders> getAllOrder()
    {
        List<Orders> list = orderRepository.findAll();
        return list;
    }

    @RequestMapping(path = "/customer")
    public List<Orders> getOrderByCustomer(@RequestParam("customer_id")Integer customer_id)
    {
        List<Orders> list = orderRepository.getByCustomerId(customer_id);
        return list;
    }


    @RequestMapping(path = "/{id}")
    public Orders getOrderById(@PathVariable(value = "id")Integer id)
    {
        Orders orders = orderRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id :"+id));
        return orders;
    }


    @RequestMapping(path = "",method = RequestMethod.POST)
    public ResponseEntity<?> saveOrder(@Valid @RequestBody Orders orders)
    {
        return null;
    }


}
