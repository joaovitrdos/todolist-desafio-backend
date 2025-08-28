package br.com.joaovitrdos.desafio_todo_list.controller;

import br.com.joaovitrdos.desafio_todo_list.entity.Todo;
import br.com.joaovitrdos.desafio_todo_list.service.TodosServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")

public class TodoController {
    private TodosServices todosServices;

    public TodoController(TodosServices todosServices) {
        this.todosServices = todosServices;
    }

    @PostMapping
    List<Todo> create(@RequestBody Todo todo) {
        return  todosServices.create(todo);
    }
    @GetMapping
    List<Todo> list(){
        return  todosServices.list();
    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo){
        return  todosServices.update(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id) {
        return  todosServices.delete(id);
    }
}
