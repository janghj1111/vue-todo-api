package com.example.vue_todo_api.services;

import com.example.vue_todo_api.dto.BoardDto;
import com.example.vue_todo_api.entity.BoardEntity;
import com.example.vue_todo_api.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    /*
     * 게시글 리스트 조회
     * */
    public List<BoardDto> getBoardList() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> dtos = new ArrayList<>();

        for (BoardEntity item : boardEntities) {
            log.info("게시글 리스트 조회Service BoardEntity item");
            log.info(item.toString());
            BoardDto dto = BoardDto.builder()
                    .idx(item.getIdx())
                    .title(item.getTitle())
                    .contents(item.getContents())
                    .writer(item.getWriter())
                    //.writedate(LocalDateTime.from(LocalDate.parse(item.getWritedate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))))
                    // 이미 엔티티가 LocalDateTime 형식이라 쓸데없는 변환을 주고 있었음
                    .writedate(item.getWritedate())
                    .build();

            log.info(dto.toString());
            dtos.add(dto); // 배열에 추가
        }
        return dtos;
    }

    /*
     * 게시글 단일 조회
     * */
    public BoardDto getBoard(long id) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("게시글을 찾을 수 없음!"));
        log.info("게시글 단일 조회Service BoardEntity entity");
        log.info(entity.toString());
        BoardDto dto = BoardDto.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .writer(entity.getWriter())
                //.writedate(LocalDateTime.from(LocalDate.parse(entity.getWritedate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))))
                .writedate(entity.getWritedate())
                .build();

        log.info("게시글 단일 조회Service builder 후 dto");
        log.info(dto.toString());
        return dto;
    }

    /*
     * 게시글 추가
     * */
    public BoardEntity insertBoard(BoardDto boardDto) {
        BoardEntity entity = BoardEntity.builder()
                .title(boardDto.getTitle())
                .contents(boardDto.getContents())
                .writer(boardDto.getWriter())
                //.writedate(LocalDateTime.from(LocalDate.from(LocalDateTime.now())))
                .writedate(LocalDateTime.now())
                .build();

        return boardRepository.save(entity);
    }

    /*
     * 게시글 수정
     * */
    public BoardEntity updateBoard(BoardDto boardDto) {
        BoardEntity entity = boardRepository.findById(boardDto.getIdx())
                .orElseThrow(()-> new RuntimeException("게시물을 찾을 수 없음!!"));
        entity.setTitle(boardDto.getTitle());
        entity.setContents(boardDto.getContents());
        // entity.setWriteDate(LocalDate.from(LocalDateTime.now())); 수정한 날짜가 필요하지 않을까?
        return boardRepository.save(entity);
    }

    /*
     * 게시글 삭제
     * */
    public void deleteBoard(long id) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("게시물을 찾을 수 없음!!"));

    }
}
