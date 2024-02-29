package com.example.todo.mangment.service.impl;

import com.example.todo.mangment.dto.Tododto;
import com.example.todo.mangment.entity.Todo;
import com.example.todo.mangment.exception.ResourceNotFoundException;
import com.example.todo.mangment.repository.TodoRepository;
import com.example.todo.mangment.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;
    @Override
    public Tododto addTodo(Tododto tododto) {
        //converting Tododte into jpa
//

        Todo todo = modelMapper.map(tododto,Todo.class);

        //Todo jpa entity
        Todo saveTodo = todoRepository.save(todo);

        //covert saved todo Jpa object into tododto object
//
         Tododto savedTodoDto = modelMapper.map(saveTodo, Tododto.class);

        return savedTodoDto;
    }

    @Override
    public Tododto getTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found id"+id));
            return modelMapper.map(todo, Tododto.class);
    }

    @Override
    public Tododto updateTodo(Tododto tododto, Long id) {
         Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found"+id));

         todo.setTitle(tododto.getTitle());
         todo.setDescription(tododto.getDescription());
         todo.setCompleted(tododto.isCompleted());

         Todo updatedTodo =  todoRepository.save(todo);

        return modelMapper.map(updatedTodo, Tododto.class);
    }

    @Override
    public void deleteTodo(Long id) {
     Todo todo =    todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("To do not found "+id));
     todoRepository.deleteById(id);
    }

    @Override
    public Tododto complteteTodo(Long id) {
        Todo todo =  todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id"));

       todo.setCompleted(Boolean.TRUE);
       Todo updateTodo =  todoRepository.save(todo);

        return modelMapper.map(updateTodo, Tododto.class);
    }


}




