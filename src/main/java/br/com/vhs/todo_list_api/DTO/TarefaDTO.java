package br.com.vhs.todo_list_api.DTO;

import java.time.LocalDateTime;

/**
 * A classe TarefaDTO (Data Transfer Object) é usada para transferir dados da entidade Tarefa
 * entre as camadas da aplicação e/ou para o cliente (como uma aplicação Angular).
 * 
 * Ela ajuda a expor somente os dados necessários, evitando expor a entidade diretamente,
 * o que melhora a segurança e desacopla o modelo de domínio da representação externa.
 */
public class TarefaDTO {

    private Long id;
    private String descricao;
    private boolean status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;

    // ========================
    // Construtores
    // ========================

    public TarefaDTO() {
        // Construtor padrão
    }

    /**
     * Construtor completo usado para criar o DTO com todos os dados da tarefa.
     */
    public TarefaDTO(Long id, String descricao, boolean status, LocalDateTime dataCriacao, LocalDateTime dataConclusao) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.dataConclusao = dataConclusao;
    }

    // ========================
    // Getters e Setters
    // ========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}
