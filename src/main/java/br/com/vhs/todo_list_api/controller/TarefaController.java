package br.com.vhs.todo_list_api.controller;

import br.com.vhs.todo_list_api.DTO.TarefaDTO;
import br.com.vhs.todo_list_api.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TarefaController expõe os endpoints da API para manipulação das tarefas.
 * Utiliza o serviço TarefaService para implementar as operações de CRUD.
 */
@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    /**
     * Endpoint para criar uma nova tarefa.
     * 
     * @param tarefaDTO DTO com a descrição da tarefa.
     * @return A tarefa criada.
     */
    @PostMapping
    public TarefaDTO criarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        return tarefaService.criarTarefa(tarefaDTO);
    }

    /**
     * Endpoint para listar todas as tarefas.
     * 
     * @return Lista de todas as tarefas.
     */
    @GetMapping
    public List<TarefaDTO> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    /**
     * Endpoint para buscar uma tarefa por ID.
     * 
     * @param id ID da tarefa a ser buscada.
     * @return Tarefa encontrada ou 404 se não encontrada.
     */
    @GetMapping("/{id}")
    public TarefaDTO buscarTarefaPorId(@PathVariable Long id) {
        return tarefaService.buscarTarefaPorId(id);
    }

    /**
     * Endpoint para concluir uma tarefa.
     * 
     * @param id ID da tarefa a ser concluída.
     * @return A tarefa com o status atualizado para concluída.
     */
    @PutMapping("/{id}/concluir")
    public TarefaDTO concluirTarefa(@PathVariable Long id) {
        return tarefaService.concluirTarefa(id);
    }

    /**
     * Endpoint para deletar uma tarefa.
     * 
     * @param id ID da tarefa a ser deletada.
     * @return true se a tarefa foi deletada, false caso contrário.
     */
    @DeleteMapping("/{id}")
    public boolean deletarTarefa(@PathVariable Long id) {
        return tarefaService.deletarTarefa(id);
    }
}
