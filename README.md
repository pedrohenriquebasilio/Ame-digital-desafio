# Ame Digital — Desafio Star Wars

Projeto desenvolvido para o desafio técnico da Ame Digital, com integração à [SWAPI](https://swapi.dev/) e persistência de dados locais.
A aplicação permite criar, listar, buscar, atualizar e deletar planetas inspirados no universo Star Wars.

## Stack

* Java 17
* Spring Boot
* Clean Architecture
* Flyway (migrations)
* MySQL (rodando via Docker)

## Endpoints

| Método | Rota             | Descrição                  |
| ------ | ---------------- | -------------------------- |
| GET    | `/planet/All`    | Lista todos os planetas    |
| GET    | `/planet/{id}`   | Busca planeta por **ID**   |
| GET    | `/planet/{name}` | Busca planeta por **Nome** |
| POST   | `/planet`        | Cria um novo planeta       |
| PUT    | `/planet`        | Atualiza um planeta        |
| DELETE | `/planet`        | Deleta um planeta          |

## Como rodar

1. Suba o banco MySQL com Docker:

```bash
docker run --name amedigital-db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=starwars -p 3306:3306 -d mysql:8.0
```

2. Rode a aplicação:

```bash
./mvnw spring-boot:run
```

O Flyway aplicará as migrations automaticamente no container.

## Arquitetura

* **UseCases** → Regras de negócio
* **Gateways** → Acesso a dados
* **Controllers** → Exposição dos endpoints
* **DTOs / Mappers** → Transporte e conversão de dados

## Contato

Desenvolvido por Pedro Henrique Basílio
[LinkedIn]([https://www.linkedin.com/in/pedrohenriquebasilio](https://www.linkedin.com/in/pedro-henrique-basilio/)) 
