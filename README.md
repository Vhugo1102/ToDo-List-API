# 📌 ToDo List API - Java Spring Boot

Este projeto é uma API REST simples de gerenciamento de tarefas (ToDo List), desenvolvida em **Java 21** com **Spring Boot** e banco de dados **H2** em memória. Ideal para fins educacionais e como exemplo de CRUD com camadas bem definidas.

---

## 📁 Estrutura do Projeto

- `controller` - Define os endpoints da API.
- `service` - Contém a lógica de negócio.
- `repository` - Comunicação com o banco de dados.
- `entity` - Mapeamento das entidades JPA.
- `DTO` - Objeto de transferência de dados.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Banco de Dados H2
- Maven

---

## 🔧 Como executar o projeto

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/ToDo-List-API.git
```

2. Acesse o diretório do projeto:
```bash
cd ToDo-List-API
```

3. Execute o projeto com o Maven:
```bash
./mvnw spring-boot:run
```

4. Acesse o sistema pelo navegador ou ferramenta como Postman/Insomnia:
```
http://localhost:8080/api/tarefas
```

5. Acesse o console do banco H2 (opcional):
```
http://localhost:8080/h2-console
```
**JDBC URL:** `jdbc:h2:mem:testdb`

---

## 📌 Endpoints para Testes

### ▶️ Criar tarefa
**POST** `/api/tarefas`
```json
{
  "descricao": "Estudar Spring Boot"
}
```

---

### 📋 Listar todas as tarefas
**GET** `/api/tarefas`

---

### 🔍 Buscar tarefa por ID
**GET** `/api/tarefas/{id}`
Exemplo: `/api/tarefas/1`

---

### ✔️ Marcar tarefa como concluída
**PUT** `/api/tarefas/{id}/concluir`
Exemplo: `/api/tarefas/1/concluir`

---

### 🗑️ Deletar tarefa
**DELETE** `/api/tarefas/{id}`
Exemplo: `/api/tarefas/1`

---

## ✅ Funcionalidades

- Criar uma tarefa
- Listar todas as tarefas
- Buscar tarefa por ID
- Marcar tarefa como concluída
- Deletar tarefa

---

## 📄 Exemplo de JSON de resposta
```json
{
  "id": 1,
  "descricao": "Estudar Spring Boot",
  "status": true,
  "dataCriacao": "2025-04-21T10:30:00",
  "dataConclusao": "2025-04-21T15:00:00"
}
```

---

## 📚 Créditos
Projeto desenvolvido por Vitor Hugo como parte dos estudos em Java Web e Spring Boot.



