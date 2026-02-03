# Sistema de Reservas 🗓️

[![Java](https://img.shields.io/badge/Java-17+-blue)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-green)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14-blue)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

Um **sistema backend REST** desenvolvido em **Spring Boot** para gerenciar reservas de eventos, permitindo criar, consultar, atualizar e deletar reservas com validação de datas.

---

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- MapStruct
- Jakarta Transaction
- REST API JSON
- CORS habilitado para front-end

---

## Estrutura do Projeto

```text
com.example.Sistema_de_reservas
├── controller
│   └── ReservasController.java       # Endpoints REST
├── service
│   └── ReservasService.java          # Lógica de negócio
├── repository
│   └── ReservasRepository.java       # Acesso ao banco de dados
├── model
│   └── Reservas.java                 # Entidade Reserva
├── dto
│   ├── ReservasRequestDto.java       # DTO de requisição
│   └── ReservasResponseDto.java      # DTO de resposta
├── mapper
│   └── ReservasMapper.java           # Conversão entre DTO e entidade
└── exception
    └── RecursoNaoEncontradoException.java # Exceção personalizada

Funcionalidades

✅ Listar todas as reservas

✅ Buscar reservas por data

✅ Criar novas reservas

✅ Atualizar reservas existentes

✅ Deletar reservas

⚠️ Validação para evitar reservas duplicadas na mesma data

Endpoints da API
Método	Endpoint	Descrição	Body (JSON)
GET	/reservas	Listar todas as reservas	-
GET	/reservas/buscar?data=	Buscar reservas por data	-
GET	/reservas/{id}	Buscar reserva por ID	-
POST	/reservas	Criar nova reserva	ReservasRequestDto
PUT	/reservas/{id}	Atualizar reserva existente	ReservasRequestDto
DELETE	/reservas/{id}	Deletar reserva	-
Exemplo de DTOs

ReservasRequestDto

{
  "nomeCliente": "João da Silva",
  "dataDaFesta": "2026-02-10",
  "descricaoEvento": "Festa de aniversário"
}


ReservasResponseDto

{
  "id": 1,
  "nomeCliente": "João da Silva",
  "dataDaFesta": "2026-02-10",
  "descricaoEvento": "Festa de aniversário"
}

Testando a API
Com cURL

Criar reserva

curl -X POST http://localhost:8080/reservas \
-H "Content-Type: application/json" \
-d '{"nomeCliente":"João da Silva","dataDaFesta":"2026-02-10","descricaoEvento":"Festa de aniversário"}'


Listar todas

curl http://localhost:8080/reservas


Buscar por data

curl http://localhost:8080/reservas/buscar?data=2026-02-10


Atualizar reserva

curl -X PUT http://localhost:8080/reservas/1 \
-H "Content-Type: application/json" \
-d '{"nomeCliente":"João Atualizado","dataDaFesta":"2026-02-11","descricaoEvento":"Nova festa"}'


Deletar reserva

curl -X DELETE http://localhost:8080/reservas/1

Como Rodar o Projeto com PostgreSQL

Clonar o repositório:

git clone https://github.com/seu-usuario/sistema-de-reservas.git
cd sistema-de-reservas


Configurar o banco em application.properties ou application.yml:

spring.datasource.url=jdbc:postgresql://localhost:5432/reservasdb
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect


Rodar o projeto:

./mvnw spring-boot:run


Acessar a API em:
http://localhost:8080/reservas

Observações Técnicas

MapStruct para mapeamento entre DTOs e entidades

@Transactional para garantir consistência nas operações de banco

Validação de datas para evitar conflitos de reservas

CORS habilitado (@CrossOrigin(origins = "*")) para integração com front-end
