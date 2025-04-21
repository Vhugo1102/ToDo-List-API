package br.com.vhs.todo_list_api.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * A classe Tarefa representa uma tarefa a ser realizada pelo usuário. Ela é uma
 * entidade JPA que será mapeada para uma tabela no banco de dados H2.
 */
@Entity
@Table(name = "tarefas") // Define o nome da tabela no banco
public class Tarefa {

	/**
	 * Identificador único da tarefa (chave primária). É gerado automaticamente pelo
	 * banco.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Descrição da tarefa. Não pode ser nula e tem no máximo 255 caracteres.
	 */
	@Column(nullable = false, length = 255)
	private String descricao;

	/**
	 * Status da tarefa (true = concluída, false = pendente).
	 */
	@Column(nullable = false)
	private boolean status;

	/**
	 * Data e hora em que a tarefa foi criada. Sempre obrigatória.
	 */
	@Column(name = "data_criacao", nullable = false)
	private LocalDateTime dataCriacao;

	/**
	 * Data e hora em que a tarefa foi concluída. Pode ser nula (caso a tarefa ainda
	 * não tenha sido finalizada).
	 */
	@Column(name = "data_conclusao")
	private LocalDateTime dataConclusao;

	// ========================
	// Construtores (Boas práticas)
	// ========================

	public Tarefa() {
		// Construtor padrão obrigatório para o JPA
	}

	/**
	 * Construtor com a descrição da tarefa.
	 * 
	 * Este construtor é utilizado para criar uma nova tarefa com valores padrão: -
	 * status: sempre inicia como 'false' (pendente), pois ainda não foi concluída.
	 * - dataCriacao: é preenchida automaticamente com a data e hora atual no
	 * momento da criação. - dataConclusao: começa como null, pois só será
	 * preenchida quando a tarefa for marcada como concluída.
	 * 
	 * Dessa forma, evitamos que o usuário ou sistema envie dados inconsistentes,
	 * como uma tarefa já concluída ao ser criada, ou datas fora de ordem.
	 * 
	 */
	public Tarefa(String descricao) {
		this.descricao = descricao;
		this.status = false;
		this.dataCriacao = LocalDateTime.now();
		this.dataConclusao = null;
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
