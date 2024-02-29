package com.example.todo.mangment.service;

import com.example.todo.mangment.dto.Tododto;

import java.util.List;

public interface TodoService {

    Tododto addTodo(Tododto tododto);
    Tododto getTodo(Long id);
//    List<Tododto> getAllTodos();

    Tododto updateTodo(Tododto tododto, Long id);

    void deleteTodo(Long id);

    Tododto complteteTodo(Long id);




}
