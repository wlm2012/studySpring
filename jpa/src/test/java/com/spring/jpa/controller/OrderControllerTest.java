package com.spring.jpa.controller;

import com.spring.jpa.domain.entity.Order;
import com.spring.jpa.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Slf4j
@WebMvcTest(OrderUnitTestController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void testOrder() throws Exception {
        Mockito.when(orderService.findOrder(1L)).thenReturn(Order.builder().id(1L).userId(1L).menuId(1L).build());
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get("/testFindOrder/1").accept(MediaType.APPLICATION_JSON))
                .andDo(s-> System.out.println(s.getRequest().getContentAsString()))
                .andDo(s-> System.out.println(s.getRequest().getContentAsString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(1L))
                .andReturn()
                .getResponse();
        log.info(response.getContentAsString());

    }
}
