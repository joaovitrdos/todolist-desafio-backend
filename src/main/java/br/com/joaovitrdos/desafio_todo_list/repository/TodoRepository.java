package br.com.joaovitrdos.desafio_todo_list.repository;

import br.com.joaovitrdos.desafio_todo_list.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
