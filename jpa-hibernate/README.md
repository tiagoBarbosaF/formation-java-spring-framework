# Persistência com JPA: Hibernate

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
    - Como retornar apenas parte de uma entidade em uma consulta JPQL.