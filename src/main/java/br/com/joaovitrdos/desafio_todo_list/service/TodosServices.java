package br.com.joaovitrdos.desafio_todo_list.service;

import br.com.joaovitrdos.desafio_todo_list.entity.Todo;
import br.com.joaovitrdos.desafio_todo_list.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class TodosServices {
    private TodoRepository todoRepository;

    public TodosServices(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
       todoRepository.save(todo);
       return list();
    }

    public List<Todo> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "prioridade")
                .and(Sort.by(Sort.Direction.ASC, "nome"));
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo) {
            todoRepository.save(todo);
            return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }
}
