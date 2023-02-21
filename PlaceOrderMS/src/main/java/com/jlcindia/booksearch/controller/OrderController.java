package com.jlcindia.booksearch.controller;

import com.jlcindia.booksearch.entity.Order;
import com.jlcindia.booksearch.entity.OrderInfo;
import com.jlcindia.booksearch.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin // CORS
@RestController
public class OrderController {
    static Logger log = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderService orderService;
    @PostMapping("/placeOrder")
    public void placeOrder(@RequestBody OrderInfo orderInfo) {
        log.info("---OrderController---placeOrder()-----");
        orderService.placeOrder(orderInfo);
    }
    @GetMapping("/myorders/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable String userId){
        log.info("---OrderController---getOrdersByUserId()-----");
        List<Order> myoders= orderService.getOrdersByUserId(userId);
        return myoders;
    }
}