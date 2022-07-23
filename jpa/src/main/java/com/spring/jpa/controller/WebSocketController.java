package com.spring.jpa.controller;


import com.spring.jpa.domain.dto.StudentDto;
import com.spring.jpa.domain.vo.StudentVo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class WebSocketController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public StudentVo greeting(StudentDto dto) {
        System.out.println("begin");
        try {
            Thread.sleep(1000); // simulated delay
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new StudentVo(dto.getId(), "wlm" , LocalDateTime.now());
    }
}
