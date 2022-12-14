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
        - O banco de dados oferece um recurso chamado de `transação`, para juntar várias alterações como unidade de
          trabalho
            - Se uma alteração falha, nenhuma alteração é aplicada (é feito um _rollback_ da transação)
            - Todas as alterações precisam funcionar para serem aceites (é feito um `commit`)
        - `commit` e `rollback` são operações clássicas de transações
        - Para garantir o fechamento dos recursos, existe no Java uma cláusula _try-with-resources_
            - O recurso em questão deve usar a interface `Autoclosable`


- Escalabilidade com pool de conexões ✅
    - Download dos JARs ✅
    - O que é pool e datasource? ✅
    - Um único cliente ✅
    - Criando o pool de conexões ✅
    - Diversos clientes ✅
    - Testando o pool de conexões ✅
    - Pool com conexões ocupadas ✅
    - O que aprendemos? ✅
        - É boa prática usar um pool de conexões
        - Um _pool_ de conexões administra/controla a quantidade de conexões abertas
            - Normalmente tem um mínimo e máximo de conexões
        - Como existe uma interface que representa a conexão (`java.sql.Connection`), também existe uma interface que
          representa o pool de conexões (`javax.sql.DataSource`)
        - **C3PO** é uma implementação Java de um _pool_ de conexão


- Camada de persistência com DAO ✅
    - Criando o modelo Produto ✅
    - DAO com inserção do produto ✅
    - Vantagens do DAO ✅
    - Listando no ProdutoDAO ✅
    - DAO's e construtor ✅
    - O que aprendemos? ✅
        - Para cada tabela de domínio, temos uma classe de domínio
            - Por exemplo, a tabela `produtos` tem uma classe `Produto` associada
            - Objetos dessa classe representa um registro na tabela
        - Para acessar a tabela, usaremos um padrão chamado **_Data Access Object_** (**DAO**)
            - Para cada classe de domínio, existe um DAO. Por exemplo, a classe `Produto` possui um `ProdutoDao`
            - Todos os métodos JDBC relacionados com o produto devem estar encapsulados no `ProdutoDao`


- Evitando queries N + 1 ✅
    - Relacionamento entre tabelas ✅
    - Vantagens da chave estrangeira ✅
    - Modelo e o DAO de categorias ✅
    - Queries N + 1 ✅
    - Por que evitar queries N + 1? ✅
    - Usando Inner Join ✅
    - Informações relacionadas ✅
    - O que aprendemos? ✅
        - Que quando temos um relacionamento, é preciso ter cuidado para não cair no problema de queries `N + 1`
            - `N + 1` significa executar uma query e mais uma nova _query_ (`N`) para cada relacionamento
            - Queries `N + 1` podem gerar um problema no desempenho
            - Queries `N + 1` podem ser evitadas por joins no SQL
        - A criar a nossa própria camada de persistência


- Aplicação Desktop ✅
    - Apresentando a View de Produtos ✅
    - Apresentando as camadas da aplicação ✅
    - Download do novo projeto ✅
    - Conhecendo o projeto ✅
    - Implementando as controllers ✅
    - Revisando o projeto ✅
    - O que aprendemos? ✅
        - uma aplicação é escrita em camadas
            - camadas clássicas são _view, controller, modelo e persistência_
        - o fluxo entre as camadas segue a ordem:
        ```
        view <--> controller <--> persistenciaCOPIAR CÓDIGO
        ```
    - nesse curso focamos na camada de persistência
    - uma camada não deve deixar "vazar" detalhes da implementação (por exemplo, uma exceção como SQLException)
    - em outras formações você aprenderá como criar a view ou frontend para Android (mobile) ou web (html)