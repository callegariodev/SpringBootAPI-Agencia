# Descrição
Este projeto é um sistema de gerenciamento desenvolvido em Java com Spring Boot, utilizando a arquitetura MVC. Ele oferece funcionalidades para cadastrar, listar e gerenciar informações de Pessoas, Usuários e Contas. A integração com um banco de dados PostgreSQL proporciona persistência segura e eficiente.

## Tecnologias Utilizadas
- Java
- Spring Boot
- PostgreSQL

# Estrutura do Projeto
A estrutura do projeto segue o padrão MVC, com os seguintes pacotes:
- `com.projetos.bancoapi.model`: Classes de entidade/modelo.
- `com.projetos.bancoapi.controller`: Controladores que lidam com as requisições HTTP.
- `com.projetos.bancoapi.repository`: Repositórios para interação com o banco de dados.
- `com.projetos.bancoapi.service`: Camada de serviço para lógica de negócios.
- `com.projetos.bancoapi.dto`: DTOs (Data Transfer Objects) para transferência de dados.

# Configuração do Banco de Dados
O projeto requer um banco de dados PostgreSQL. Configure as informações de conexão no arquivo `application.properties` no diretório `src/main/resources`.

## Instruções de Uso
1. Clone o repositório.
2. Configure as propriedades do banco de dados.
3. Compile e execute o projeto.
4. Acesse os endpoints da API para interagir com o sistema.

## Endpoints da API
- `GET /pessoa`: Retorna a lista de todas as pessoas cadastradas.
- `POST /pessoa`: Cria uma nova pessoa.
- `GET /usuario`: Retorna a lista de todos os usuários cadastrados.
- `POST /usuario`: Cria um novo usuário.
- `GET /contas`: Retorna a lista de todas as contas cadastradas.
- `POST /contas`: Cria uma nova conta.

# Autor
Caio Callegario

# Status do Projeto
Em desenvolvimento
