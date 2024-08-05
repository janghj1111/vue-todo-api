package com.example.vue_todo_api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String contents;
    private String writer;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime writedate;
}
