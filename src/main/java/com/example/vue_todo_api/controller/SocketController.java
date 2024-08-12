package com.example.vue_todo_api.controller;


import com.example.vue_todo_api.dto.SocketVO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {

    // "/receive"를 메시지를 받을 endpoint로 설정합니다.
    @MessageMapping("/receive")

    // "/send"를 메시지를 받을 endpoint로 설정합니다.
    @SendTo("/send")

    // SocketHandler는 1) "/recive"에서 메시지를 받고 2) "/send"로 메시지를 보내줍니다.
    // 정의한 SocketVO를 1) 인자값, 2) 반환값으로 사용합니다.
    public SocketVO SocketHandler(SocketVO socketVO) {
        String userName = socketVO.getUserName();
        String content = socketVO.getContent();

        // 생성자로 반환값을 생성합니다.
        SocketVO result = new SocketVO(userName, content);
        return result;
    }
}
