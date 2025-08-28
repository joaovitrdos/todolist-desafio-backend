package br.com.joaovitrdos.desafio_todo_list.controller;

import br.com.joaovitrdos.desafio_todo_list.entity.Todo;
import br.com.joaovitrdos.desafio_todo_list.service.TodosServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")

public class TodoController {
    private TodosServices todosServices;

    public TodoController(TodosServices todosServices) {
        this.todosServices = todosServices;
    }

    @PostMapping
    public List<Todo> create(@Valid @RequestBody Todo todo) {
        return todosServices.create(todo);
    }

    @GetMapping
    List<Todo> list(){
        return  todosServices.list();
    }

    @PutMapping("{id}")
    public List<Todo> update(@Valid @PathVariable Long id, @RequestBody Todo todo) {
        return todosServices.update(id, todo);
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id) {
        return  todosServices.delete(id);
    }
}