package com.example.todo.mangment.controller;

import com.example.todo.mangment.dto.Tododto;
import com.example.todo.mangment.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;

    //Build Add REST API
    @PostMapping
    public ResponseEntity<Tododto> addTodo(@RequestBody Tododto tododto){

         Tododto savedTodo = todoService.addTodo(tododto);
         return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    //Get Todo Rest Api
    @GetMapping("{id}")

    public ResponseEntity<Tododto> getTodo(@PathVariable("id") Long todoId){
       Tododto tododto =   todoService.getTodo(todoId);
       return new ResponseEntity<>(tododto, HttpStatus.OK);
    }

    //Update Todo Rest API
    @PutMapping("{id}")
    public ResponseEntity<Tododto> updateTodo (@RequestBody  Tododto tododto, @PathVariable ("id") Long todoId){
       Tododto updatedTodo = todoService.updateTodo(tododto, todoId);
       return ResponseEntity.ok(updatedTodo);


    }
    //Buid Delete Rest Api
@DeleteMapping("{id}")
    public ResponseEntity<String> deletedTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo delete sucessfully");
    }

    //Build complete Todo REST API
    @PatchMapping("{id}")
    public ResponseEntity<Tododto> completeTodo(@PathVariable ("id") Long todoId){
         Tododto updatedTodo = todoService.complteteTodo(todoId);
         return ResponseEntity.ok(updatedTodo);
    }

}
