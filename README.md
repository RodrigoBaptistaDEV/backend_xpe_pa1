Com base nos controladores e nas configurações que você forneceu, aqui está um esqueleto de README que descreve seu projeto Java Spring Boot:

---

# Mentorias Globally

Este é um projeto backend desenvolvido em Java utilizando o framework Spring Boot. O sistema oferece funcionalidades para gerenciar mentores, mentorias e usuários, com autenticação e autorização implementadas usando Spring Security e JWT.

## Funcionalidades

- **Gerenciamento de Mentores**: Listagem paginada de mentores e busca por ID.
- **Autenticação de Usuários**: Login e cadastro de usuários, com geração de tokens JWT.
- **Gerenciamento de Mentorias**: Criação de mentorias e listagem paginada por usuário ou mentor, filtradas por mês e ano.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Security com JWT**
- **PostgreSQL**
- **Hibernate (JPA)**
- **Swagger/OpenAPI**

## Requisitos

- Java 17+
- Maven 3.x
- PostgreSQL

## Instalação

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/mentorias-globally.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd mentorias-globally
   ```

3. Configure o banco de dados PostgreSQL no arquivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/globally
   spring.datasource.username=seu-usuario
   spring.datasource.password=sua-senha
   ```

4. Execute o projeto com o Maven:

   ```bash
   mvn spring-boot:run
   ```

## Endpoints Principais

### Mentores

- **GET** `/mentores`: Retorna uma lista paginada de mentores.
- **GET** `/mentores/{id}`: Busca um mentor por ID.

### Usuários

- **POST** `/usuarios/login`: Autentica um usuário e retorna um token JWT.
- **POST** `/usuarios/cadastro`: Registra um novo usuário.

### Mentorias

- **POST** `/mentorias`: Cria uma nova mentoria.
- **GET** `/mentorias/user/{userId}`: Lista mentorias de um usuário, com paginação.
- **GET** `/mentorias/mentor/{mentorId}/{year}/{month}`: Lista mentorias de um mentor filtradas por mês e ano, com paginação.

## Autenticação e Autorização

Este projeto utiliza **JWT (JSON Web Token)** para autenticação. Após efetuar login com as credenciais do usuário, um token é retornado e deve ser usado para acessar os endpoints protegidos, utilizando o seguinte cabeçalho:

```http
Authorization: Bearer {token}
```

## Variáveis de Ambiente

O segredo para gerar os tokens JWT pode ser configurado através de uma variável de ambiente `JWT_SECRET`. Se não for definida, o sistema usará o valor padrão `12345678`.

## Documentação da API

O Swagger UI está disponível para facilitar a exploração e o teste dos endpoints:

```
http://localhost:8080/swagger-ui.html
```
