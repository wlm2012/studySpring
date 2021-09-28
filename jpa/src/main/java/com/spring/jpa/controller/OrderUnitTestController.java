package com.spring.jpa.controller;

import com.spring.jpa.DO.Order;
import com.spring.jpa.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderUnitTestController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/testFindOrder/{id}")
    public Order testFindOrder(@PathVariable Long id) {
        return orderService.findOrder(id);
    }
}
