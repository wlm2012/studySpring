package com.spring.jpa.controller;


import com.spring.jpa.domain.vo.StudentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class WebSocketScheduledController {

    private final WebSocketController webSocketController;

    private final SimpMessagingTemplate messagingTemplate;

    // 无法返回websocket信息
//    @Scheduled(fixedDelay = 1000)
    public void scheduled() {
        webSocketController.greeting();
    }

    // 可以返回
    @GetMapping("/hello")
    public void greeting() {
/*        messagingTemplate.convertAndSendToUser(new StudentVo(2, "wlm", LocalDateTime.now()),
                "/queue/reply", greeting);*/
        messagingTemplate.convertAndSend("/topic/messages",
                new StudentVo(2, "wlm", LocalDateTime.now()));
    }


    // 可以返回
//    @Scheduled(fixedDelay = 1000)
    public void fixedDelay() {
        messagingTemplate.convertAndSend("/topic/messages",
                new StudentVo(2, "wlm", LocalDateTime.now()));
    }

/*    @Scheduled(fixedDelay = 3000)
    public void fix(){
        messagingTemplate.convertAndSendToUser();
    }*/

}
