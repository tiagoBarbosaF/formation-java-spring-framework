# Persistência com JPA: Hibernate — Parte 01

### Steps:

- Introdução à JPA ✅
  - JDBC e seus problemas ✅
  - Desvantagens do JDBC ✅
  - Hibernate e JPA ✅
  - Diferença entre Hibernate e JPA ✅
  - Criando um projeto com JPA ✅
  - O que aprendemos? ✅
    - As desvantagens de se utilizar o JDBC para acessar bancos de dados em Java;
    - A história de criação do Hibernate e da JPA;
    - Como criar uma aplicação Maven e adicionar o Hibernate como dependência?

- Configurações e EntityManager ✅
  - Arquivo persistence.xml ✅
  - Persistence Unit ✅
  - Mapeando uma entidade ✅
  - Entidades da JPA ✅
  - Persistindo uma entidade ✅
  - Transação ✅
  - O que aprendemos? ✅
    - Como configurar a JPA via arquivo `persistence.xml`;
    - Como mapear entidades JPA;
    - Como utilizar o `EntityManager` para persistir entidades no banco de dados.

- Mapeando entidades ✅
  - Organizando o código ✅
  - Mais mapeamentos ✅
  - Tipos de atributos ✅
  - Mapeando relacionamentos ✅
  - Cardinalidade do relacionamento ✅
  - O que aprendemos? ✅
    - Como escrever uma classe `DAO` utilizando a JPA;
    - Como mapear atributos do tipo Enum em uma entidade;
    - Como mapear um relacionamento entre entidades.


- Ciclo de vida de uma entidade ✅
  - Estados no insert da entidade ✅
  - Estados no update da entidade ✅
  - Método merge ✅
  - Estados no delete da entidade ✅
  - Removendo uma entidade ✅
  - O que aprendemos? ✅
    - Como funciona o ciclo de vida de entidades JPA;
    - As transições de estados de uma entidade ao ser persistida;
    - As transições de estados de uma entidade ao ser atualizada;
    - As transições de estados de uma entidade ao ser removida.


- Consultas com JPQL ✅
  - Consultando entidades ✅
  - Consultas com filtros ✅
  - Consultas com JPQL ✅
  - Limitando dados de uma consulta ✅
  - Carregando parte da entidade ✅
  - O que aprendemos? ✅
    - Como realizar consultas com o método `find` do `Entity Manager`;
    - Como realizar consultas JPQL;
    - Como filtrar dados em consultas JPQL;
    - Como retornar apenas parte de uma entidade em uma consulta JPQL?

 ---

# Java e JPA: consultas avançadas, desempenho e modelos complexos — Parte 02

### Steps

- Mais relacionamentos ✅
  - Mapeando novas entidades ✅
  - Relacionamentos many-to-many ✅
  - Relacionamentos bidirecionais ✅
  - Parâmetro mappedBy ✅
  - Teste do relacionamento bidirecional ✅
  - Parâmetro cascade ✅
  - O que aprendemos? ✅
    - A mapear novas entidades na aplicação conforme a modelagem do banco de dados;
    - A mapear um relacionamento com cardinalidade _muitos-para-muitos_;
    - A mapear um relacionamento bidirecional;
    - Como persistir entidades que possuam relacionamentos bidirecionais.


- Consultas avançadas ✅
  - Consultas com funções de agregação ✅
  - Consultas para relatórios ✅
  - Consultas com select new ✅
  - Gerando relatórios ✅
  - Utilizando Named Queries ✅
  - Vantagens das named queries ✅
  - O que aprendemos? ✅
    - A realizar consultas utilizando funções de agregação, tais como `min`, `max`, `avg` e `sum`;
    - Como escrever consultas de _relatórios_ utilizando JPQL;
    - Como utilizar o recurso `select new` em consultas JPQL;
    - A realizar consultas utilizando _named queries_.

- Desempenho de consultas ✅
  - Entendendo Lazy e Eager ✅
  - Consultas com Join Fetch ✅
  - Consultas com Lazy e Eager ✅
  - Vantagens do join fetch ✅
  - O que aprendemos? ✅
    - Como funcionam as estratégias _EAGER_ e _LAZY_, em consultas de entidades que possuem relacionamentos;
    - Por que a JPA pode lançar a exception `LazyInitializationException` em determinadas situações;
    - As boas práticas no carregamento de entidades com relacionamentos;
    - Como realizar consultas planejadas com o recurso _join fetch_?

- Criteria API ✅
  - Consultas com parâmetros dinâmicos ✅
  - Consulta dinâmica ✅
  - Consultas com Criteria API ✅
  - Desvantagens da Criteria API ✅
  - O que aprendemos? ✅
    - Como realizar consultas JPQL com parâmetros opcionais;
    - Como funciona a Criteria API da JPA;
    - Como realizar uma consulta com parâmetros opcionais via Criteria API.

- Outros tópicos
  - Simplificando entidades com Embeddable
  - Mapeamento de herança
  - Herança entre entidades
  - Mapeamento de chaves compostas
  - Utilizando chave composta
  - O que aprendemos?