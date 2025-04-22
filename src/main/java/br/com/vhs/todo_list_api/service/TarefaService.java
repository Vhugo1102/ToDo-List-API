package br.com.vhs.todo_list_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vhs.todo_list_api.DTO.TarefaDTO;
import br.com.vhs.todo_list_api.entity.Tarefa;
import br.com.vhs.todo_list_api.repository.TarefaRepository;

/**
 * TarefaService contém a lógica de negócios relacionada às tarefas. Ele
 * interage com o TarefaRepository para realizar operações de CRUD e processa os
 * dados para o TarefaDTO.
 */
@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	/**
	 * Cria uma nova tarefa no banco de dados.
	 */
	public TarefaDTO criarTarefa(TarefaDTO tarefaDTO) {
	    // Criando uma nova tarefa com base no DTO
	    Tarefa tarefa = new Tarefa(tarefaDTO.getDescricao());
	    
	    // Salvando a tarefa no banco
	    tarefa = tarefaRepository.save(tarefa);
	    
	    // Retornando o TarefaDTO com os dados da tarefa criada
	    return new TarefaDTO(tarefa.getId(), tarefa.getDescricao(), tarefa.isStatus(),
	            tarefa.getDataCriacao(), tarefa.getDataConclusao());
	}


	/**
	 * Lista todas as tarefas no banco de dados.
	 */
	public List<TarefaDTO> listarTarefas() {
		List<Tarefa> tarefas = tarefaRepository.findAll();
		List<TarefaDTO> tarefaDTOs = new ArrayList<>();

		for (Tarefa tarefa : tarefas) {
			tarefaDTOs.add(new TarefaDTO(tarefa.getId(), tarefa.getDescricao(), tarefa.isStatus(),
					tarefa.getDataCriacao(), tarefa.getDataConclusao()));
		}

		return tarefaDTOs;
	}

	/**
	 * Busca uma tarefa pelo ID.
	 */
	public TarefaDTO buscarTarefaPorId(Long id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);

		if (tarefa.isPresent()) {
			Tarefa t = tarefa.get();
			return new TarefaDTO(t.getId(), t.getDescricao(), t.isStatus(), t.getDataCriacao(), t.getDataConclusao());
		}

		return null;
	}

	/**
	 * Atualiza o status de uma tarefa para concluída.
	 * 
	 * id O ID da tarefa a ser atualizada. A tarefa atualizada.
	 */
	public TarefaDTO concluirTarefa(Long id) {
		Tarefa tarefa = tarefaRepository.findById(id).orElse(null);

		if (tarefa != null) {
			tarefa.setStatus(true);
			tarefa.setDataConclusao(java.time.LocalDateTime.now());
			tarefaRepository.save(tarefa);

			return new TarefaDTO(tarefa.getId(), tarefa.getDescricao(), tarefa.isStatus(), tarefa.getDataCriacao(),
					tarefa.getDataConclusao());
		}

		return null; // Retorna null caso a tarefa não seja encontrada
	}

	/**
	 * Deleta uma tarefa pelo ID.
	 * 
	 * id O ID da tarefa a ser deletada. Um valor booleano indicando se a tarefa foi
	 * deletada com sucesso.
	 */
	public boolean deletarTarefa(Long id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		if (tarefa.isPresent()) {
			tarefaRepository.delete(tarefa.get());
			return true;
		}
		return false;
	}
}
