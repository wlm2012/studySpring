package com.spring.jpa.service;

import com.spring.jpa.DO.Order;
import com.spring.jpa.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;


@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Transactional
    public void OrderTest() {
        Order order1 = orderRepository.findByIdLock(1L);
        order1.setUserId(2L);
        orderRepository.saveAndFlush(order1);

    }

    public Order findOrder(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElseGet(() -> Order.builder().id(2L).menuId(2L).userId(2L).build());
    }



}
