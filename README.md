# Sistema de Reservas

Um sistema backend desenvolvido em **Spring Boot** para gerenciar reservas de eventos, permitindo criar, consultar, atualizar e deletar reservas.

---

## Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **H2 / MySQL** (ou qualquer banco relacional)
- **Lombok** (para reduzir boilerplate)
- **MapStruct** (para mapeamento entre DTOs e entidades)
- **Jakarta Transaction** (para controle de transações)
- **REST API** com JSON

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
│   ├── ReservasRequestDto.java       # DTO para requisições
│   └── ReservasResponseDto.java      # DTO para respostas
├── mapper
│   └── ReservasMapper.java           # Conversão entre DTO e entidade
└── exception
    └── RecursoNaoEncontradoException.java # Exceção personalizada

Funcionalidades

Listar todas as reservas

Buscar reservas por data

Criar novas reservas

Editar reservas existentes

Excluir reservas

Validação para não permitir reservas duplicadas na mesma data

Endpoints da API
Método	Endpoint	Descrição	Request Body
GET	/reservas	Listar todas as reservas	-
GET	/reservas/buscar?data=	Buscar reservas por data	-
GET	/reservas/{id}	Buscar reserva por ID	-
POST	/reservas	Criar nova reserva	ReservasRequestDto
PUT	/reservas/{id}	Atualizar reserva existente	ReservasRequestDto
DELETE	/reservas/{id}	Deletar reserva	-
DTO Exemplo

ReservasRequestDto

{
  "nomeCliente": "João da Silva",
  "dataDaFesta": "2026-02-10",
  "descricaoEvento": "Festa de aniversário"
}

{
  "id": 1,
  "nomeCliente": "João da Silva",
  "dataDaFesta": "2026-02-10",
  "descricaoEvento": "Festa de aniversário"
}
