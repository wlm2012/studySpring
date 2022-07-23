package com.spring.jpa.controller;


import com.spring.jpa.domain.dto.StudentDto;
import com.spring.jpa.domain.vo.StudentVo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public StudentVo greeting(StudentDto dto) {
        System.out.println("begin");
        try {
            Thread.sleep(1000); // simulated delay
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new StudentVo(dto.getId(),"wlm");
    }
}
