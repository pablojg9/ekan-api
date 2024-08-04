# Projeto Spring Boot com H2 Database e JWT Authentication

Este é um projeto de exemplo desenvolvido com Spring Boot que utiliza H2 Database, autenticação JWT, e MapStruct para mapeamento de DTOs. O projeto inclui um conjunto de endpoints para gerenciamento de beneficiários e autenticação de usuários.

## Requisitos

- JDK 21
- Maven 3.8.6 ou superior

### Recomendações
**Executar**: `mvn clean install`

## Estrutura do Projeto

### Diretórios Principais

- `src/main/java`: Contém o código-fonte da aplicação.
- `src/main/resources`: Contém arquivos de configuração e scripts SQL.
- `src/test/java`: Contém testes de unidade e de integração.

### Entidades

- `Beneficiary`: Representa um beneficiário no sistema com atributos como nome, email, data de nascimento, etc.
- `Documento`: Representa um documento associado ao beneficiário.

### DTOs

O projeto utiliza DTOs para requisições e respostas, facilitando a transferência de dados entre o cliente e o servidor.

- `BeneficiaryRequestRecord`: DTO para criar ou atualizar um beneficiário.
- `BeneficiaryResponseRecord`: DTO para o response com dados do beneficiário.

- `DocumentRequestRecord`: DTO para criar ou atualizar um documento.
- `DocumentResponseRecord`: DTO para o response com dados do documento.

- `AuthRequestRecord`: DTO para colocar no corpo da requisição o `username` e `password`.
- `AuthResponseRecord`: DTO para o response do token.


### Swagger UI
- **URL do Swagger**:
  ``` http://localhost:8080/swagger-ui/index.html```


### Autenticação JWT

Após cadastrar um beneficiário, é necessário autenticar o usuário através do endpoint `/auth` para obter um token JWT. Este token deve ser utilizado nos headers das requisições subsequentes aos outros endpoints.

- **Header de Autenticação**:
  ```http
  Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJla2FuIiwiZXhwIjoxNzIyNzMxOTYxLCJyb2xlcyI6WyJVU0VSIl19.uwGIOG8TiGO5ZNl-k1mmZaeg7LY40a6pWdAt4THFJa0


### Endpoints

1. **Cadastro de Beneficiários**

    - **POST /beneficiaries/save**
        - Cadastra um novo beneficiário.
        - Exemplo de endpoint
            ````
            http://localhost:8080/beneficiarys/save
            ````
        - Exemplo de corpo da requisição:
          ```json
            {
               "username": "username",
               "senha": "password",
               "nome": "name",
               "telefone": "123456789",
               "dataNascimento": "24/09/2024",
               "tipoDocumento": 1
           }
           
          ```

        - Exemplo de resposta:
           ```json
               {
                  "id": "df3ff974-f6cc-48c0-adc9-f9c38c2dcf03",
                  "username": "pablog9",
                  "senha": "$2a$10$a/4xZ/yvvB.OV0xXIKsFbeSTZEIE9OT7LJezw.G8OyATB9zkOMi8a",
                  "nome": "pablo",
                  "telefone": "1199624225",
                  "dataNascimento": "2024-09-24T00:00:00",
                  "dataInclusao": "2024-08-03T21:05:32.410066",
                  "dataAtualizacao": "2024-08-03T21:05:32.410066",
                  "documentos": [
                      {
                         "tipoDocumento": 1,
                         "descricao": "documento 1",
                         "dataInclusao": "2024-08-03T20:47:51.881357",
                         "dataAtualizacao": "2024-08-03T20:47:51.881357"
                      }
                  ]
              } 
           ```



2. **Autenticação**

    - **POST /auth**
        - Autentica um usuário e retorna um token JWT.
        - Exemplo do Endpoint:
           ````
             http://localhost:8080/auth 
           ````
        - Exemplo de corpo da requisição:
          ```json
          {
            "username": "username",
            "password": "password"
          }
          ```
        - Exemplo de resposta:
          ```json
          {
             "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJla2FuIiwiZXhwIjoxNzIyNzMxOTYxLCJyb2xlcyI6WyJVU0VSIl19.uwGIOG8TiGO5ZNl-k1mmZaeg7LY40a6pWdAt4THFJa0",
             "expires_in": 1722731961
          }
          ```
3. **Procurar um Beneficiário através do seu ID**

    - **GET /{id}**
        - Como parâmetro colocar o UUID.
        - Exemplo do endpoint:
          ```
          http://localhost:8080/beneficiarys/71059817-e344-4ffe-a35d-0c2eb0789633
          ```
        - Exemplo de resposta:
          ```json
          {
             "id": "71059817-e344-4ffe-a35d-0c2eb0789633",
             "username": "pablog9",
             "senha": "123456",
             "nome": "pablo teste",
             "telefone": "1199624225",
             "dataNascimento": "2024-09-24T00:00:00",
             "dataInclusao": null,
             "dataAtualizacao": "2024-08-03T20:11:24.282603",
             "documentos": []
           }
          ```

3. **Atualização de Beneficiários**

    - **PUT /beneficiaries/{id}**
        - Atualiza informações específicas de um beneficiário.
        - Exemplo do endpoint / Colocar o corpo da requisição.
          ````
          localhost:8080/beneficiarys/6aaafa8e-4b52-4cc5-813b-71ce19472d09
          ````
        - Exemplo de corpo da requisição:
          ```json
          {
             "id": "6aaafa8e-4b52-4cc5-813b-71ce19472d09",
             "username": "pablog9",
             "senha": "$2a$10$1QxNsRb8T8cDh1JrIduYL.0iW91L9pDcyfAK2Mvb0EY96ZcpNAwzS",
             "nome": "pablo teste",
             "telefone": "1199624225",
             "dataNascimento": "2024-09-24T00:00:00",
             "dataInclusao": null,
             "dataAtualizacao": null,
              "documentos": []
           }
          ```

4. **delete de Beneficiário por seu ID**

    - **DELETE /beneficiaries/{id}**
        - deleta as informações específicas de um beneficiário.
        - Exemplo do endpoint
         ````
            http://localhost:8080/beneficiarys/6aaafa8e-4b52-4cc5-813b-71ce19472d09
         ````
        - Retorno:
           ```
            No content 204
            ```