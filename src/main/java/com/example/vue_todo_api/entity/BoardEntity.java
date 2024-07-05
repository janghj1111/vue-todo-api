package com.example.vue_todo_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

//@ToString
//@Getter

@Data
@AllArgsConstructor
@NoArgsConstructor // 롬복의 기본생성자 어노테이션
@Builder
@Table(name="BOARD")
@Entity // DB가 해당 객체를 인식하도록 붙임. (해당 클래스명으로 테이블을 만들라는 뜻.)
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB ID 자동생성 전략
    // @Column(name = "user_name", nullable = false, length = 50) // 열에 대한 세부 설정을 지정
    private Long idx;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime writedate;
}
