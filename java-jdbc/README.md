# Java e JDBC: trabalhando com um banco de dados

### Steps:

- Introdução ao JDBC e o padrão Factory ✅
  - Ambiente e versões ✅
  - Usando um banco de dados ✅
  - API e interfaces ✅
  - Download do JAR ✅
  - A primeira conexão ✅
  - Exceção ao recuperar a conexão ✅
  - O que aprendemos? ✅
    - Para acessar o banco de dados, precisamos de um **_driver_**
      - Um _driver_ nada mais é do que uma biblioteca (JAR)
    - **JDBC** significa _Java DataBase Conectivity_
      - JDBC define uma camada de abstração entre a sua aplicação e o driver do banco de dados
      - Essa camada possui, na sua grande maioria, interfaces que o driver implementa
    - Para abrir uma conexão, devemos usar o método `getConnection`, da classe `DriverManager`
      - O método `getConnection` recebe uma string de conexão JDBC, que define a URL, usuário, senha, etc


- Executando comandos SQL no Java
  - Listagem com Statement
  - Connection, Statement e ResultSet
  - Criando a ConnectionFactory
  - Factory Pattern
  - Inserindo com Statement
  - Retorno do método execute()
  - Removendo dados
  - O que aprendemos?


- Evitando SQL Injection
  - Usando PreparedStatement
  - Sobre o PreparedStatement
  - Listagem e remoção
  - Trocando o Statement
  - O que aprendemos?


- Controle de transação
  - Assumindo o controle
  - JDBC e transações
  - Lidando com commit e rollback
  - Auto-Commit
  - Usando o try-with-resources
  - Try com recursos e o close
  - O que aprendemos?


- Escalabilidade com pool de conexões
  - Download dos JARs
  - O que é pool e datasource?
  - Um único cliente
  - Criando o pool de conexões
  - Diversos clientes
  - Testando o pool de conexões
  - Pool com conexões ocupadas
  - O que aprendemos?


- Camada de persistência com DAO
  - Criando o modelo Produto
  - DAO com inserção do produto
  - Vantagens do DAO
  - Listando no ProdutoDAO
  - DAO's e construtor
  - O que aprendemos?


- Evitando queries N + 1
  - Relacionamento entre tabelas
  - Vantagens da chave estrangeira
  - Modelo e o DAO de categorias
  - Queries N + 1
  - Por que evitar queries N + 1?
  - Usando Inner Join
  - Informações relacionadas
  - O que aprendemos?


- Aplicação Desktop
  - Apresentando a View de Produtos
  - Apresentando as camadas da aplicação
  - Download do novo projeto
  - Conhecendo o projeto
  - Implementando as controllers
  - Revisando o projeto
  - O que aprendemos?