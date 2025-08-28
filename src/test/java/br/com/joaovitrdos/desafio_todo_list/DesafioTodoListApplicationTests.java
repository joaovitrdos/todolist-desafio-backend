package br.com.joaovitrdos.desafio_todo_list;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.joaovitrdos.desafio_todo_list.entity.Todo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class DesafioTodoListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoListSuccess() {
		var todo = new Todo("todo 1", "desc todo 1", false, 2);

		webTestClient
			    .post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(todo.getNome())
				.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
	}

	@Test
	void testCreateTodoListFailure(){

        webTestClient
                .post()
                .uri("/todos")
                .bodyValue(
                    new Todo("", "",false, 0)
                ).exchange()
                .expectStatus().isBadRequest();
	}

}
