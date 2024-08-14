package com.example.vue_todo_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header {
    private LocalDateTime transactionTime;
    private String resultCode;
    private String desciption;
    //private T data;
    private Pagination pagination;

    /*public static <T> Header<T> OK() {
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .desciption("OK")
                .build();
    }*/

    // DATA OK
    /*public static <T> Header<T> OK(T data){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .desciption("OK")
                .data(data)
                .build();
    }*/

}
