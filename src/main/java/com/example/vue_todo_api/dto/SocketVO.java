package com.example.vue_todo_api.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data // getter setter 자동 생성
@AllArgsConstructor // 생성자를 자동생성
public class SocketVO {
    private String userName;
    private String content;
}
