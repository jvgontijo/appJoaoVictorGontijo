# Sistema de Gerenciamento de Personagens de RPG

Este projeto é um Sistema de Gerenciamento de Personagens de RPG desenvolvido usando Java, Spring Boot e Angular. Ele permite que os usuários criem, personalizem e gerenciem personagens de RPG, além de integrar APIs externas para aprimorar a funcionalidade.

## Índice

- [Recursos](#recursos)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Instalação](#instalação)
- [Uso](#uso)
- [Documentação da API](#documentação-da-api)

## Recursos

- **Gerenciamento de Usuários e Personagens**: Usuários podem criar, editar e excluir personagens.
- **Personalização de Personagens**: Personalize personagens com armas, aparência e outros atributos.
- **Persistência de Dados**: A aplicação utiliza JPA e Hibernate para persistência de dados.
- **API RESTful**: O sistema expõe uma API RESTful para interagir com usuários e personagens.
- **Interface Front-End**: Um front-end em Angular que permite que os usuários interajam com o sistema através de uma interface amigável.
- **Integração com APIs Externas**: Integração com APIs externas usando OpenFeign para aprimorar a funcionalidade do sistema.

## Tecnologias Utilizadas

- **Backend**:
    - Java
    - Spring Boot
    - Spring Data JPA
    - Hibernate
    - OpenFeign (para integração com APIs externas)
    - PostgreSQL ou MongoDB (para banco de dados)

- **Frontend**:
    - Angular
    - TypeScript
    - HTML/CSS
    - Bootstrap (opcional, para estilização)

- **Outros**:
    - Maven (para gerenciamento de dependências)
    - Docker (opcional, para containerização)

## Instalação

### Configuração do Backend

1. Clone o repositório:
    ```bash
    git clone https://github.com/jvgontijo/appJoaoVictorGontijo.git
    cd appJoaoVictorGontijo
    ```

2. Instale as dependências necessárias:
    ```bash
    mvn clean install
    ```

3. Configure seu banco de dados (PostgreSQL/MongoDB):
    - Crie um banco de dados chamado `rpg_character_db`.
    - Atualize o `application.properties` com as credenciais do seu banco de dados.

4. Execute a aplicação Spring Boot:
    ```bash
    mvn spring-boot:run
    ```

### Configuração do Frontend

1. Clone o repositório do projeto Angular:
    ```bash
    git clone https://github.com/jvgontijo/appJoaoVictorGontijoFront.git
    cd appJoaoVictorGontijoFront
    ```

2. Instale as dependências do Angular:
    ```bash
    npm install
    ```

3. Execute a aplicação Angular:
    ```bash
    ng serve
    ```

## Uso

1. Acesse a aplicação navegando até `http://localhost:4200` no seu navegador.
2. Use o menu para navegar pelos diferentes recursos, como gerenciar usuários e personagens.
3. Interaja com os personagens através do front-end Angular ou diretamente via API RESTful.

## Documentação da API

A API permite o gerenciamento de usuários e personagens com os seguintes endpoints:

- **Endpoints de Usuário**:
    - `GET /users`: Recupera uma lista de usuários.
    - `GET /users/{id}`: Recupera um usuário específico pelo ID.
    - `POST /users`: Cria um novo usuário.
    - `PUT /users/{id}`: Atualiza um usuário existente.
    - `DELETE /users/{id}`: Exclui um usuário pelo ID.

- **Endpoints de Personagem**:
    - `GET /characters`: Recupera uma lista de personagens.
    - `GET /characters/{id}`: Recupera um personagem específico pelo ID.
    - `POST /characters`: Cria um novo personagem.
    - `PUT /characters/{id}`: Atualiza um personagem existente.
    - `DELETE /characters/{id}`: Exclui um personagem pelo ID.

