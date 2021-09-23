package com.spring.jpa.controller;

import com.spring.jpa.DO.Order;
import com.spring.jpa.repository.OrderRepository;
import com.spring.jpa.service.OrderService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private OrderService orderService;

    @Transactional
    @RequestMapping("/lockOrder")
    public void lockOrder() throws InterruptedException {
        Order order = orderRepository.findByIdLock(1L);
        new Thread(() -> orderService.OrderTest()).start();

        order.setMenuId(2L);
        Thread.sleep(10000);
        orderRepository.saveAndFlush(order);
    }
}
