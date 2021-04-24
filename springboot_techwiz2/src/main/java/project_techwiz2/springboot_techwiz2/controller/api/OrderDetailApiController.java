package project_techwiz2.springboot_techwiz2.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_techwiz2.springboot_techwiz2.config.exeption.ErrorDetails;
import project_techwiz2.springboot_techwiz2.config.exeption.ResourceNotFoundException;
import project_techwiz2.springboot_techwiz2.model.dto.Order_detailDto;
import project_techwiz2.springboot_techwiz2.repository.core.OrderDetailRepository;
import project_techwiz2.springboot_techwiz2.repository.dto.OrderDetailDtoRepository;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/orderDetail")
public class OrderDetailApiController {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailDtoRepository orderDetailDtoRepository;

    @RequestMapping(path = "")
    private List<Order_detailDto> getOrderDetail()
    {
        List<Order_detailDto> list = orderDetailDtoRepository.findAll();
        return list;
    }

    @RequestMapping(path = "/byOrder")
    private List<Order_detailDto> getByOrder(@RequestParam("order_id")Integer orderId)
    {
        List<Order_detailDto> list = orderDetailDtoRepository.getByOrderId(orderId);
        return list;
    }

    @RequestMapping(path = "",method = RequestMethod.POST)
    private ResponseEntity<?> saveOrderDetail(@Valid @RequestBody Order_detailDto order_detail)
    {
        try{
            orderDetailDtoRepository.save(order_detail);
            return new ResponseEntity<Order_detailDto>(order_detail,HttpStatus.OK);

        }catch (NoSuchElementException e)
        {

        }
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(new Date());
        errorDetails.setMessage("Add new unsuccessful");
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/{id}")
    public Order_detailDto getById(@PathVariable(value = "id")Integer id)
    {
        Order_detailDto order_detailDto = orderDetailDtoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with id :"+id));
        return order_detailDto;
    }
}
