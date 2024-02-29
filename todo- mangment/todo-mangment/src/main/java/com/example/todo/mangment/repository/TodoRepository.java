package com.example.todo.mangment.repository;

import com.example.todo.mangment.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
