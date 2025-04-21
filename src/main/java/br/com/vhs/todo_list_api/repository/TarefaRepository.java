package br.com.vhs.todo_list_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vhs.todo_list_api.entity.Tarefa;

/**
 * O TarefaRepository é responsável pela comunicação com o banco de dados
 * utilizando Spring Data JPA. Ele realiza operações CRUD para a entidade Tarefa.
 */
@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	// Não é necessário adicionar métodos específicos, pois o JpaRepository já fornece
	// operações CRUD padrão (salvar, excluir, buscar por id, etc.)
}

