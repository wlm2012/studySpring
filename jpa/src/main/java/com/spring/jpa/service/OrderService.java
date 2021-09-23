package com.spring.jpa.service;

import com.spring.jpa.DO.Order;
import com.spring.jpa.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Transactional
    public void OrderTest(){
        Order order1 = orderRepository.findByIdLock(1L);
        order1.setUserId(2L);
        orderRepository.saveAndFlush(order1);

    }
}
