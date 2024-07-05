package com.example.vue_todo_api.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor // 롬복의 기본생성자 어노테이션
@Builder
public class BoardDto implements Serializable {
    private Long idx;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime writedate;
}
