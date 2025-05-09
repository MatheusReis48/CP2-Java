# Projeto Checkpoint 2 - API de Brinquedos (Spring Boot)

Este projeto implementa uma API RESTful para gerenciar um cadastro de brinquedos, utilizando Spring Boot, Spring Data JPA e Oracle Database, conforme solicitado no Checkpoint 2.

## Estrutura do Projeto

O projeto segue a estrutura padrão do Maven para aplicações Spring Boot

## Pré-requisitos

*   Java JDK 17 ou superior
*   Maven 3.6 ou superior
*   Acesso ao banco de dados Oracle
*   Postman (ou similar) para testar os endpoints da API


## Configuração

1.  **Clonar o Repositório:**
    ```bash
    # Se estiver usando Git
    git clone <url_do_repositorio_github>
    cd projeto-brinquedos
    ```
    Ou descompacte o arquivo .zip fornecido.

2.  **Configurar Banco de Dados:**
    *   Abra o arquivo `src/main/resources/application.properties`.
        ```properties
        spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL 
        spring.datasource.username= xxxxx
        spring.datasource.password= xxxxx
        ```
    *   Certifique-se de que a tabela `TDS_TB_BRINQUEDOS` exista no seu schema Oracle

3.  **Dependências Maven:**
    *   O Maven deve baixar as dependências automaticamente ao abrir o projeto na IDE ou ao executar um comando Maven (`mvn compile`). Se necessário, execute:
    ```bash
    mvn clean install
    ```

## Executando a Aplicação

Você pode executar a aplicação de algumas formas:

*   **Pela IDE:** Localize a classe `BrinquedosApplication.java` e execute-a como uma aplicação Java.
*   **Via Maven:** No terminal, na raiz do projeto, execute:
    ```bash
    mvn spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080` 

## Testando com o Postman

Os seguintes endpoints estão disponíveis:

1.  **Criar um Novo Brinquedo (POST)**
    *   **URL:** `POST http://localhost:8080/brinquedos`
    *   **Headers:** `Content-Type: application/json`
    *   **Body (raw - JSON):**
        ```json
        {
            "nome": "Carrinho de Controle Remoto",
            "tipo": "Eletrônico",
            "classificacao": "+6",
            "tamanho": "Médio",
            "preco": 150.75
        }
        ```
    *   **Resposta Esperada (Sucesso - 201 Created):** O objeto do brinquedo criado, incluindo o `id` gerado.

2.  **Listar Todos os Brinquedos (GET)**
    *   **URL:** `GET http://localhost:8080/brinquedos`
    *   **Resposta Esperada (Sucesso - 200 OK):** Uma lista (array JSON) de todos os brinquedos cadastrados. Se não houver brinquedos, retorna 204 No Content.

3.  **Buscar Brinquedo por ID (GET)**
    *   **URL:** `GET http://localhost:8080/brinquedos/{id}` (substitua `{id}` pelo ID do brinquedo desejado, ex: `http://localhost:8080/brinquedos/1`)
    *   **Resposta Esperada (Sucesso - 200 OK):** O objeto JSON do brinquedo correspondente ao ID.
    *   **Resposta Esperada (Não Encontrado - 404 Not Found):** Se o ID não existir.
