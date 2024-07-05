package com.example.vue_todo_api.controller;

import com.example.vue_todo_api.dto.BoardDto;
import com.example.vue_todo_api.entity.BoardEntity;
import com.example.vue_todo_api.services.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class BoardController {
    private final BoardService boardService;

    /*
    * 게시글 리스트 조회
    * */
    @GetMapping("/board/list")
    public List<BoardDto> boardList() {
        return boardService.getBoardList();
    }

    /*
     * 게시글 단일 조회
     * */
    @GetMapping("/board/{id}")
    public BoardDto getBoard(@PathVariable long id) {
        return boardService.getBoard(id);
    }

    /*
     * 게시글 추가
     * */
    @PostMapping("/board")
    public BoardEntity insertBoard(@RequestBody BoardDto boardDto) {
        return boardService.insertBoard(boardDto);
    }

    /*
     * 게시글 수정
     * */
    @PatchMapping("/board")
    public BoardEntity updateBoard(@RequestBody BoardDto boardDto) {
        return boardService.updateBoard(boardDto);
    }

    /*
     * 게시글 삭제
     * */
    @DeleteMapping("/board/{id}")
    public void deleteBoard(@PathVariable long id) {
        boardService.deleteBoard(id);
    }


}
