package com.spring.jpa.controller;

import com.spring.jpa.DO.Order;
import com.spring.jpa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EntityTestController {

    private OrderRepository orderRepository;

    @Autowired
    public EntityTestController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //如果在一个事务内，entity改变后，即使没有保存，也会在数据库中更新
    @Transactional
    @RequestMapping("/entity")
    public void test() {
        Optional<Order> optionalOrder = orderRepository.findById(1L);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setMenuId(10086L);
        }
    }


    @RequestMapping("/entity1")
    public void test1() {
        Optional<Order> optionalOrder = orderRepository.findById(1L);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setMenuId(10086L);
        }
    }
}
