package com.spring.jpa.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest
public class OrderRepositoryTest {

    @Resource
    private OrderRepository orderRepository;

    @Test
    public void orderIn() {
        List<Long> strings = List.of(1L, 2L);
        System.out.println(orderRepository.findByUserIdIn1(strings));
    }
}
