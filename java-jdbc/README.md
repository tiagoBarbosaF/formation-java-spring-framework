# Java e JDBC: trabalhando com um banco de dados

> Obs.: O projeto contém o arquivo de `docker-compose` configurado para utilizar o `MySql`. 
> 
Utilize o comando abaixo para subir o container com o banco de dados:
- Subir o container:
  ```
  docker compose up
  ```
- Desligar o container:
  ```
  docker compose down
  ```

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


- Executando comandos SQL no Java ✅
  - Listagem com Statement ✅
  - Connection, Statement e ResultSet ✅
  - Criando a ConnectionFactory ✅
  - Factory Pattern ✅
  - Inserindo com Statement ✅
  - Retorno do método execute() ✅
  - Removendo dados ✅
  - O que aprendemos? ✅
    - Para simplificar e encapsular a criação da conexão, devemos usar uma classe `ConnectionFactory`
      - A classe `ConnectionFactory` segue o padrão de criação _Factory Method_
      - O _Factory Method_ encapsula a criação de um objeto
    - Para executar um comando SQL, podemos usar a interface `java.sql.Statement`
      - O método `execute` envia o comando para o banco de dados
      - Dependendo do comando SQL, podemos recuperar a chave primária ou os registros selecionados


- Evitando SQL Injection ✅
  - Usando PreparedStatement ✅
  - Sobre o PreparedStatement ✅
  - Listagem e remoção ✅
  - Trocando o Statement ✅
  - O que aprendemos? ✅
    - Ao executar SQL como `Statement`, temos um risco de segurança, chamado **_SQL Injection_**
      - _SQL Injection_ nada mais é do que passar um novo comando SQL como parâmetro
    - Para evitar _SQL Injection_, devemos usar a interface `PreparedStatement`
      - Diferentemente do `Statement`, o `PreparedStatement` trata (_sanitiza_) cada parâmetro do comando SQL

- Controle de transação ✅
  - Assumindo o controle ✅
  - JDBC e transações ✅
  - Lidando com commit e rollback ✅
  - Auto-Commit ✅
  - Usando o try-with-resources ✅
  - Try com recursos e o close ✅
  - O que aprendemos? ✅
    - O banco de dados oferece um recurso chamado de `transação`, para juntar várias alterações como unidade de trabalho
      - Se uma alteração falha, nenhuma alteração é aplicada (é feito um _rollback_ da transação)
      - Todas as alterações precisam funcionar para serem aceites (é feito um `commit`)
    - `commit` e `rollback` são operações clássicas de transações
    - Para garantir o fechamento dos recursos, existe no Java uma cláusula _try-with-resources_
      - O recurso em questão deve usar a interface `Autoclosable`


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