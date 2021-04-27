package project_techwiz2.springboot_techwiz2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project_techwiz2.springboot_techwiz2.service.OrderService;


@Controller
@RequestMapping(path = "/admin")
public class WebController {
    @Autowired
    private OrderService orderService;

    @RequestMapping
    public String index(Model model)
    {
        //totalByMonth(model);
       // double total = 0;
//        List<Orders> list = orderService.getAllOrders();
//        for (Orders ord:list) {
//            total = total+ ord.getTotal_price();
//        }
//        model.addAttribute("total",total);
        return "admin/home";
    }

//    public double totalMoneyOrder(int month)
//    {
        double total = 0;
//        List<Orders> list = orderService.listOrderMonth(month);
//        for (Orders orders:list) {
//            total = total + orders.getTotal_price();
//        }
//        return total;
//    }

//    public void totalByMonth(Model model)
//    {
//        double january = totalMoneyOrder(1);
//        double february = totalMoneyOrder(2);
//        double march = totalMoneyOrder(3);
//        double april = totalMoneyOrder(4);
//        double may = totalMoneyOrder(5);
//        double june = totalMoneyOrder(6);
//        double july = totalMoneyOrder(7);
//        double august = totalMoneyOrder(8);
//        double september = totalMoneyOrder(9);
//        double october = totalMoneyOrder(10);
//        double november = totalMoneyOrder(11);
//        double december = totalMoneyOrder(12);
//        model.addAttribute("january",january);
//        model.addAttribute("february",february);
//        model.addAttribute("march",march);
//        model.addAttribute("april",april);
//        model.addAttribute("may",may);
//        model.addAttribute("june",june);
//        model.addAttribute("july",july);
//        model.addAttribute("august",august);
//        model.addAttribute("september",september);
//        model.addAttribute("october",october);
//        model.addAttribute("november",november);
//        model.addAttribute("december",december);
//    }
}
