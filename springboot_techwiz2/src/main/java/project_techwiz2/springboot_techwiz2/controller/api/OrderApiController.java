package project_techwiz2.springboot_techwiz2.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_techwiz2.springboot_techwiz2.config.exeption.ErrorDetails;
import project_techwiz2.springboot_techwiz2.config.exeption.ResourceNotFoundException;
import project_techwiz2.springboot_techwiz2.model.core.Orders;
import project_techwiz2.springboot_techwiz2.repository.core.OrderRepository;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@CrossOrigin(origins = "http://localhost:4200")
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

    @RequestMapping(path = "/status")
    public ResponseEntity<?> updateStatus(@PathVariable(value = "order_id")Integer order_id,@PathVariable(value = "status")Integer status)
    {
        try {
            Orders orders = orderRepository.findById(order_id).get();
            if (orders.getStatus()==1)
            {
                ErrorDetails errorDetails = new ErrorDetails();
                errorDetails.setTimestamp(new Date());
                errorDetails.setMessage("Status value invalid  ");
                return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
            }
            orders.setUpdated(new Date());
            orders.setStatus(status);
            orderRepository.save(orders);
            return new ResponseEntity<Orders>(orders,HttpStatus.OK);
        }catch (NoSuchElementException e)
        {}
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(new Date());
        errorDetails.setMessage("Update Status unsuccessful");
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "",method = RequestMethod.POST)
    public ResponseEntity<?> saveOrder(@Valid @RequestBody Orders orders)
    {
        try{
            orders.setCreated(new Date());
            orders.setUpdated(new Date());
            orderRepository.save(orders);
            return new ResponseEntity<Orders>(orders,HttpStatus.OK);
        }catch (NoSuchElementException e)
        {}
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(new Date());
        errorDetails.setMessage("Add new unsuccessful");
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }


}
