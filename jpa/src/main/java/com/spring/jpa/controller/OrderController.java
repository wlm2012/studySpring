package com.spring.jpa.controller;

import com.spring.jpa.DO.Order;
import com.spring.jpa.repository.OrderRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderRepository orderRepository;

    @Transactional
    @RequestMapping("/lockOrder")
    public void lockOrder() throws InterruptedException {
        Order order = orderRepository.findByIdLock(1L);
        new Thread(() -> {
            Order order1 = orderRepository.findByIdLock(1L);
            order1.setUserId(2L);
            orderRepository.saveAndFlush(order1);
        }).start();

        order.setMenuId(2L);
        Thread.sleep(1000);
        orderRepository.saveAndFlush(order);
        Thread.sleep(1000);
    }
}
