# Desafio Anota Ai - API de Gerenciamento de Produtos e Categorias com Integração AWS SNS

Esta aplicação foi desenvolvida para gerenciar um catálogo de produtos e categorias em MongoDB, com funcionalidades de CRUD e integração com o serviço Amazon SNS para publicação de mensagens sobre atualizações de catálogo.

## Funcionalidades

1. **Gerenciamento de Categorias**: Endpoints REST para criar, ler, atualizar e deletar categorias.
2. **Gerenciamento de Produtos**: Endpoints REST para criar, ler, atualizar e deletar produtos.
3. **Integração com AWS SNS**: Publicação de mensagens sobre atualizações de categorias para um tópico SNS configurado.
4. **Mapeamento de Objetos**: Uso do ModelMapper para conversão entre entidades e DTOs.
5. **Manejo de Exceções**: Tratamento de erros com respostas personalizadas.
6. **Banco de Dados MongoDB**: Armazenamento de informações de produtos e categorias.

## Estrutura do Projeto

### 1. Configurações
A aplicação contém várias configurações essenciais:

- **Configuração AWS (SNSConfig)**: Configura o cliente Amazon SNS para publicação de mensagens.
- **Configuração do ModelMapper (MapperConfig)**: Facilita a conversão entre entidades e DTOs.
- **Configuração MongoDB (MongoDBConfig)**: Define a conexão com o banco de dados MongoDB.

### 2. Camada de Controle (Controllers)
Responsável pelos endpoints REST:

- **CategoryController**: Gerencia as operações de CRUD de categorias.
- **ProductController**: Gerencia as operações de CRUD de produtos.

### 3. Camada de Serviço (Services)
Contém a lógica de negócios:

- **CategoryService**: Manipula as operações de categorias, como busca, criação e atualização. Publica uma mensagem no SNS quando uma categoria é alterada.
- **ProductService**: Manipula operações de produtos como busca, criação e atualização.

### 4. Camada de Manipulação de Exceções (Handlers)
Oferece tratamento customizado para exceções comuns:

- **CategoryNotFoundException**: Lança uma exceção caso uma categoria não seja encontrada.
- **ProductNotFoundException**: Lança uma exceção caso um produto não seja encontrado.

### 5. Camada de Mapeamento (Mappers)
Mapeia as entidades para DTOs e vice-versa:

- **CategoryMapper**: Mapeia entre `Category` e `CategoryDTO`.
- **ProductMapper**: Mapeia entre `Product` e `ProductDTO`.

### 6. Repositórios
Define a interface para interação com o banco de dados MongoDB:

- **CategoryRepository**: Repositório para operações com a coleção de categorias.
- **ProductRepository**: Repositório para operações com a coleção de produtos.

### 7. Integração AWS
Usa o serviço Amazon SNS para publicar notificações sobre mudanças nas categorias.

- **AWSService**: Publica mensagens em um tópico SNS especificado.

## Endpoints

### Categorias
- `GET /api/category`: Retorna todas as categorias.
- `GET /api/category/{id}`: Retorna uma categoria específica.
- `POST /api/category`: Cria uma nova categoria.
- `PUT /api/category/{id}`: Atualiza uma categoria existente.
- `DELETE /api/category/{id}`: Deleta uma categoria.

### Produtos
- `GET /api/products`: Retorna todos os produtos.
- `GET /api/products/{id}`: Retorna um produto específico.
- `POST /api/products`: Cria um novo produto.
- `PUT /api/products/{id}`: Atualiza um produto existente.
- `DELETE /api/products/{id}`: Deleta um produto.

## Configuração do Projeto

### Pré-requisitos

- **Java 17**
- **MongoDB**: Execute um container MongoDB no localhost.
- **AWS SNS**: Configuração de credenciais no AWS para acesso ao serviço SNS.

### Executando a Aplicação

1. **Clonar o Repositório**
   ```bash
   git clone https://github.com/seu-usuario/seu-projeto.git
   cd seu-projeto
   ```

2. **Configurar o MongoDB**
    - Para usar o MongoDB localmente com Docker:
      ```bash
      docker run -d -p 27017:27017 --name mongodb -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=example mongo
      ```

3. **Configurar as Credenciais AWS**
    - Atualize a classe `TokenManager` com suas credenciais AWS (chaves de acesso e região).

4. **Compilar e Executar**
   ```bash
   ./mvnw spring-boot:run
   ```

## Desenvolvimento

### 1. Configuração de AWS SNS
A configuração `SNSConfig` inicializa o cliente AWS SNS com `BasicAWSCredentials` e usa um tópico SNS configurado para publicar mensagens.

### 2. Configuração do Banco de Dados MongoDB
`MongoDBConfig` configura a conexão com o MongoDB usando um `MongoTemplate` para facilitar operações no banco de dados.

### 3. Lógica de Negócios e Serviços
Cada serviço manipula as entidades e chama os mappers para conversão entre entidades e DTOs.

### 4. Integração com ModelMapper
A configuração `MapperConfig` define um `ModelMapper` para conversão automática de objetos, reduzindo o código necessário para manipulação de DTOs.

### 5. Tratamento de Exceções
`ControllerErrorHandler` captura exceções customizadas para produtos e categorias e retorna mensagens de erro amigáveis e status HTTP adequados.

## Observações

Este projeto serve como um exemplo de integração de Spring Boot com AWS SNS e MongoDB, implementando operações de CRUD e um mecanismo de notificação para atualizações de catálogo. É adequado para sistemas de e-commerce e gerenciamento de conteúdo onde a escalabilidade e integração com serviços AWS são requisitos importantes.

