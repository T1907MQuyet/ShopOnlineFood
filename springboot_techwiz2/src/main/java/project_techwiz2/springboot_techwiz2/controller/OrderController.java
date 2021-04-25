package project_techwiz2.springboot_techwiz2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import project_techwiz2.springboot_techwiz2.model.core.Order_detail;
import project_techwiz2.springboot_techwiz2.model.core.Orders;
import project_techwiz2.springboot_techwiz2.service.OrderDetailService;
import project_techwiz2.springboot_techwiz2.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    @InitBinder
    public void InitBinder(WebDataBinder data) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping(path = "")
    public String getAllOrder(Model model)
    {
        return findPaginated(1,model);
    }

    @RequestMapping(path = "detailOrder")
    public String detailOrder(@RequestParam("id")Integer id,Model model)
    {
        Orders orders = orderService.getOrderById(id);
        List<Order_detail> listOrderDetail = orderDetailService.getAllByOrderId(id);
        String btnbtnStatus = btnStatus(orders.getStatus());
        String valueStatus = statusH(orders.getStatus());
        model.addAttribute("order",orders);
        model.addAttribute("listOrderDetail",listOrderDetail);
        model.addAttribute("btnbtn",btnbtnStatus);
        model.addAttribute("trangThai",valueStatus);
        return "admin/order/orderDetail";
    }

    @RequestMapping(path = "updateStatusOrder",method = RequestMethod.POST)
    public String updateOrderStatus(@RequestParam("orderId")Integer orderId,@ModelAttribute("order")Orders orders)
    {
        int status = orders.getStatus();
        boolean bl = orderService.updateOrderStatus(orderId,orders.getStatus());
        if (bl) {
            return "redirect:/admin/order/detailOrder?id="+orderId+"&&success=Update order status success";
        }
        return "redirect:/admin/order/detailOrder?id="+orderId+"&&error=Update order status failed";
    }

    @RequestMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 10;
        Page<Orders> page = orderService.findPaginated(pageNo, pageSize);
        List<Orders> listOrder = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("list", listOrder);

        return "admin/order/orderList";
    }


    //trang thai don hang
    public String statusH(int status)
    {
        switch(status)
        {
            case 1:
                return "Đang Chờ";
            case 2:
                return "Đã Xác Nhận";
            case 3:
                return "Đang Vận Chuyển";
            case 4:
                return "Đã Hoàn Thành";
            case 5:
                return "Đã Hủy";
            default:
                return "Không Hợp Lệ";
        }
    }

    //mau sac cho trang thai
    public String btnStatus(int status)
    {

        switch(status)
        {
            case 1:
                return "btn-primary";
            case 2:
                return "btn-info";
            case 3:
                return "btn-success";
            case 4:
                return "btn-warning";
            case 5:
                return "btn-danger";
            default:
                return "btn-primary";
        }
    }
}
