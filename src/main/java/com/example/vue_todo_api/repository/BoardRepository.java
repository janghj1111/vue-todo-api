package com.example.vue_todo_api.repository;

import com.example.vue_todo_api.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
