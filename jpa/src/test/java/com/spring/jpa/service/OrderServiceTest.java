package com.spring.jpa.service;

import com.spring.jpa.domain.entity.Order;
import com.spring.jpa.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@Import(OrderService.class)
public class OrderServiceTest {

    @Resource
    private OrderService orderService;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    public void testOrderService() {
        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(Order.builder().id(1L).menuId(1L).userId(1L).build()));
        Mockito.when(orderRepository.findById(2L)).thenReturn(Optional.of(Order.builder().id(2L).menuId(2L).userId(2L).build()));


        Order order = orderService.findOrder(1L);
        Assertions.assertEquals(1L, order.getMenuId());

        Assertions.assertEquals(2L, orderService.findOrder(2L).getMenuId());

    }
}
