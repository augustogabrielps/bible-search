# BibleSearch API

A BibleSearch é uma API RESTful desenvolvida em **Java + Spring Boot** que permite realizar buscas e listagens de versículos bíblicos, com suporte a:

- 🔍 Busca por versículo específico (livro, capítulo, versículo)
- 📚 Listagem de todos os livros da Bíblia
- 🗝️ Busca por palavra-chave com paginação
- 📖 Retorno completo de um capítulo

---

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.4
- Spring Web
- Spring Data JPA
- PostgreSQL (ou MySQL)
- Maven

---

## Estrutura do Projeto

```
bibleSearch
├── controller/
│   ├── BibleController.java
│   └── BookController.java
├── model/
│   ├── Books.java
│   └── Verses.java
├── repository/
│   ├── BookRepository.java
│   └── VerseRepository.java
└── configuration/
    └── CorsConfig.java
```

---

## Endpoints Disponíveis

### 🔹 Buscar versículo específico
```
GET /api/bible/{bookId}/{chapter}/{verse}
```

### 🔹 Buscar capítulo inteiro
```
GET /api/bible/{bookId}/{chapter}
```

### 🔹 Buscar por palavra-chave
```
GET /api/bible/search?query=amor&page=0&size=10
```

### 🔹 Listar todos os livros da Bíblia
```
GET /api/book/all
```

---

## Configuração

### 1. Clone o projeto
```bash
git clone https://github.com/seu-usuario/bibleSearch.git
```

### 2. Configure o banco de dados

Atualize o arquivo `application.properties` com as credenciais do seu banco:

```properties
spring.datasource.url=jdbc:<SGBD>://localhost:<porta>/<nome-do-banco>
spring.datasource.username=<seu-usuario>
spring.datasource.password=<sua-senha>
spring.jpa.hibernate.ddl-auto=none


### 3. Rode a aplicação
```bash
./mvnw spring-boot:run
```

---

## CORS

CORS está habilitado para permitir requisições do frontend (por padrão, `localhost:3000`) via `CorsConfig.java`.

---

## Próximos passos

- Implementar filtros por livro no frontend
- Melhorar suporte a traduções bíblicas
- Adicionar sistema de favoritos e autenticação (futuramente)

---


**Augusto Gabriel**  
[GitHub](https://github.com/augustogabrielps)
