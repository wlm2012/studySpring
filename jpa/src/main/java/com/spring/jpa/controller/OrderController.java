package com.spring.jpa.controller;

import com.spring.jpa.DO.Order;
import com.spring.jpa.repository.OrderRepository;
import com.spring.jpa.service.OrderService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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


    @RequestMapping("/CacheTest/{time}")
    @Transactional
    public void CacheTest(@PathVariable Long time) throws InterruptedException {
        Optional<Order> optionalOrder = orderRepository.findById(1L);
        Order order;
        if (optionalOrder.isPresent()) {
            order = optionalOrder.get();
            order.setMenuId(2L);
            Thread.sleep(time * 1000);
            orderRepository.save(order);
        }
    }

    @RequestMapping("/CacheTest1/{time}")
    @Transactional
    public void CacheTest1(@PathVariable Long time) throws InterruptedException {
        Optional<Order> optionalOrder = orderRepository.findById(1L);
        Order order;
        if (optionalOrder.isPresent()) {
            order = optionalOrder.get();
            order.setMenuId(2L);
            Thread.sleep(time);
            orderRepository.save(order);
        }
    }

    @RequestMapping("/array")
    public void arrayTest() {
        List<Order> all = orderRepository.findAll();
        for (Order order : all) {
            System.out.println(order);
        }
    }

    @RequestMapping("/add")
    public void addOrder(Order order) {
        System.out.println(order.toString());
        orderRepository.save(order);
    }


}
