# Java Servlet: programação web Java

### Steps:

- Fundamentos da Web e a API de Servlets Ver primeiro vídeo ✅
  - Primeiro projeto Java Web ✅
  - Finalmente, o primeiro servlet ✅
  - Como acessar? ✅
  - Sobre Servlet ✅
  - O que aprendemos? ✅
    - Apache Tomcat ou apenas Tomcat é um servidor web em Java
    - Tomcat entende o protocolo HTTP e roda por padrão no `http://localhost:8080`
    - O projeto Java faz parte da URL, no nosso caso: `http://localhost:8080/gerenciador`
    - Uma aplicação web Java pode ter páginas HTML
    - Uma servlet é um objeto Java que podemos chamar a partir de uma requisição HTTP
    - Para mapear a URL para uma servlet usamos a anotação `@WebServlet`
    - Uma servlet deve estender a classe `HttpServlet` e sobrescrever um determinado método (por exemplo, `service`)

- Trabalhando com POST e GET ✅
  - Enviando parâmetros ✅
  - Parâmetros da requisição ✅
  - Métodos GET e POST ✅
  - Formulário HTML ✅
  - Diferença entre GET e POST ✅
  - Apenas POST ✅
  - O método doPost ✅
  - Sobre o método service ✅
  - O que aprendemos? ✅
    - escrever uma servlet que atende apenas GET ou POST
    - ler parâmetros da requisição dentro da servlet
    - criar um formulário HTML usando as tags `form` e `input`
    - enviando os dados pelo formulário através do POST
    - diferença entre GET e POST

- Definindo o nosso modelo ✅
  - Definido modelo ✅
  - Instância de HttpServletRequest ✅
  - Qual método? ✅
  - Listando empresas com servlets ✅
  - Sobre modelagem ✅
  - O que aprendemos? ✅
    - Nessa aula preparamos o modelo da nossa aplicação. O modelo ou domínio são as classes que representam o mundo real, aquilo que o cliente ou usuário da aplicação define.
    - Para descobrir quais são as classes e funcionalidades do modelo o analista de requisitos conversa com o cliente e documenta cada funcionalidade.

- Páginas dinâmicas com JSP ✅
  - Primeiro JSP ✅
  - Sobre JSP ✅
  - Sobre Scriptlet ✅
  - Mais sobre Scriptlet ✅
  - Despachando a requisição ✅
  - RequestDispatcher ✅
  - JSP para listar empresas ✅
  - O que aprendemos? ✅
    - JSP significa Java Server Pages
    - JSP é uma página automaticamente processada pelo Tomcat
    - Para gerar HTML dinamicamente no JSP usamos Scriptlets
    - Um scriptlet `<% %>` é um código Java no HTML
    - Um scriptlet só funciona em uma página JSP
    - Usamos o `RequestDispatcher` para chamar um JSP a partir da servlet
    - Obtemos o `RequestDispatcher` a partir do `HttpServletRequest`
    - Usamos a requisição para colocar ou pegar um atributo `(setAttribute(.., ..)` ou `getAttribute(..))`

- JSTL e Expression Language ✅
  - Conhecendo Expression Language ✅
  - Expression Language ✅
  - Download do JSTL ✅
  - Conhecendo JSTL ✅
  - Sobre o JSTL ✅
  - Resultado com forEach ✅
  - Usando a taglib core ✅
  - Mais forEach ✅
  - Usando a taglib fmt ✅
  - O que aprendemos? ✅
    - Expression Language (EL) é uma linguagem simples e limitada para imprimir o resultado de uma expressão
    - EL usa a sintaxe de `${ .. }`
    - JSTL é a biblioteca padrão de tags
    - JSTL não vem com Tomcat e precisamos copiar um JAR
    - JSTL define 4 `taglibs`, as mais importantes são `core` e `fmt`
    - a taglib `core` serve para controle de fluxo, fmt para formatação
    - é preciso importar as taglib, `core` e `fmt` separadamente:
      ```
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>COPIAR CÓDIGO
      ``` 
    - JSTL e EL devem ser usados em conjunto
    - vimos várias tags do `core` como `c:if`, `c:forEach` e `c:url`
    - da fmt vimos a tag fmt:formatDate
    - JARs ficam na pasta `WEB-INF/lib` do projeto

- Redirecionando o fluxo ✅
  - Quando o dispatcher não atende ✅
  - Sobre o RequestDispatcher ✅
  - Código de resposta HTTP ✅
  - Redirecionamento pelo navegador ✅
  - O Botão F5 ✅
  - Desafio: Código para redirecionamento ✅
  - Qual redirecionamento? ✅
  - O que aprendemos? ✅
    - o problema de reenviar uma requisição
    - a diferença entre redirecionamento pelo cliente e servidor
    - para redirecionar pelo navegador usamos o método `response.sendRedirect("endereço")`
    - o código de resposta para redirecionamento HTTP é 30X (301 ou 302)

- Completando o CRUD ✅
  - Apresentando as funcionalidades ✅
  - O que é CRUD? ✅
  - Removendo empresa ✅
  - Maneira correta de identificação ✅
  - Formulário de alteração ✅
  - Alterando empresa ✅
  - Achando o problema ✅
  - O que aprendemos? ✅
    - Como implementar a remoção de empresas
    - Como implementar a edição de empresas
    - Qual atributo correto devemos utilizar para identificação dos elementos `(id)`
    - Como definir um `input` escondido
    - O que significa CRUD

- Deploy da aplicação ✅
  - Conhecendo o web.xml ✅
  - Sobre o mapeamento ✅
  - Inversão de controle ✅
  - Inversão de quê?! ✅
  - Fixando o funcionamento ✅
  - Deploy da aplicação ✅
  - Entendendo mais sobre deploy ✅
  - O que aprendemos? ✅
    - A importância do web.xml
    - O que é inversão de controle
    - Como o Tomcat trabalha por debaixo dos panos
    - Como inicializar o Tomcat na linha de comando
    - Como gerar o `WAR (Web ARchive)`
    - Como fazemos o deploy da nossa aplicação

---

# Java Servlet: autenticação, autorização, padrão MVC

### Steps:

- Criando o controlador ✅
  - Uma única servlet ✅
  - O que é servlet? ✅
  - Implementando o controlador ✅
  - Função do controlador ✅
  - Separando ações ✅
  - Qual camada? ✅
  - O que aprendemos? ✅
    - Reorganizamos a nossa aplicação em 3 pacotes: `acao`, `modelo` e `servlet`. Além disso, criamos uma servlet que recebe todas as requisições da aplicação (quase todas). A ideia é centralizar o acesso através dessa servlet, para ela decidir qual ação executar.
    - Para tal, usamos um parâmetro da requisição que define o nome da ação. Por isso, foi necessário alterar todos os links e formulários para enviar sempre esse parâmetro.

- O padrão MVC ✅
  - Centralizando o redirecionamento ✅
  - Refatorando todas as acoes ✅
  - Escondendo JSP ✅
  - O diretório WEB-INF ✅
  - Esconder JSPs? ✅
  - Melhorando o controlador ✅
  - Resumo sobre o padrão MVC ✅
  - Sobre o MVC ✅
  - O que aprendemos? ✅
    - MVC significa _Model-View-Controller_
    - MVC divide a aplicação em 3 camadas lógicas
    - Cada camada tem a sua responsabilidade
    - O controlador central e as ações fazem parte da camada _Controller_, que define o fluxo da aplicação
    - Os JSPs fazem parte da camada _View_, que define a “interface”
    - As classes do modelo fazem parte da camada _Model_, que encapsula as regras de negócio
    - MVC facilita a manutenção e evolução da aplicação
    - Os JSPs devem ficar "escondidos" na pasta **WEB-INF**, pois dependem da ação

- Formulário de login ✅
  - Preparando modelo e view ✅
  - Verificando o login ✅
  - O que mudou? ✅
  - Login funciona? ✅
  - Autenticação e autorização ✅
  - Para saber mais: O padrão JAAS ✅
  - Faça como eu fiz na aula ✅
  - O que aprendemos? ✅
    - A representar o usuário através de uma classe `Usuario`
    - A criar um formulário de login
    - A criar a ação para chamar o formulário
    - A criar a ação verificar o login e a senha

- HttpSession ✅
  - Trabalhando com sessão ✅
  - Detectando o problema ✅
  - A solução dos nossos problemas ✅
  - Testando o login ✅
  - Autorizando o acesso ✅
  - Implementando o logout ✅
  - Sabendo as diferenças ✅
  - Para saber mais: Timeout da sessão ✅
  - Faça como eu fiz na aula ✅
  - O que aprendemos? ✅
    - Por padrão, o navegador não envia nenhuma identificação sobre o usuário
    - Quando o Tomcat recebe uma nova requisição (sem identificação), gerará um ID
    - O ID fica salvo no cookie de nome `JSessionID`
    - O ID é um _hash_ (número aleatório)
    - O cookie é anexado à resposta HTTP
    - O navegador reenvia o cookie automaticamente nas próximas requisições
    - O Tomcat gera, além do ID, um objeto chamado `HttpSession`
    - A vida do objeto `HttpSession` fica atrelado ao ID
    - Para ter acesso à `HttpSession`, basta chamar `request.getSession()`
    - Usamos a `HttpSession` para guardar dados sobre o usuário (login, permissões, carrinho de compra)
    - A `HttpSession` tem um ciclo de vida e será automaticamente invalidada

- Aplicando filtros ✅
  - Primeiro filtro ✅
  - Filter x Servlet ✅
  - Filtro de autorização ✅
  - Ordem de execução ✅
  - Anotações x web.xml ✅
  - Onde está o problema? ✅
  - Para saber mais: Interceptor ou Filter ✅
  - Faça como eu fiz na aula ✅
  - O que aprendemos? ✅
    - Um Filter e Servlet são bem-parecidos
    - Comparado com Servlet, o Filter consegue parar o fluxo
    - Para escrever um filtro, devemos implementar a interface `javax.servlet.Filter`
    - Para mapear o filtro, usamos a anotação `@WebFilter` ou o **web.xml**
    - Vários filtros podem funcionar numa cadeia (um, chama o próximo, mas todos são independentes)
    - Para definir a ordem de execução, devemos mapear os filtros no **web.xml**
    - Um filtro recebe como parâmetro, do método `doFilter`, um `ServletRequest` e um `ServletResponse`
    - Ambos, `ServletRequest` e `ServletResponse`, são interfaces mais genéricas do que `HttpServletRequest` e `HttpServletResponse`
    - Para chamar o próximo filtro na cadeia, usamos o objeto `FilterChain`

- Introdução ao Web Services ✅
  - O que é um Web Service? ✅
  - Serviço com JSON ✅
  - Retornar HTML? ✅
  - Serviço com XML ✅
  - Cliente do serviço ✅
  - Bibliotecas ✅
  - O que aprendemos? ✅
    - Que um _web service_ usa HTML, JSON ou XML como retorno
    - Que um _web service_ oferece alguma funcionalidade para seu cliente
    - Que um _web service_ é útil quando precisa oferecer uma funcionalidade para cliente diferentes
    - Que para o _web service_ não importa se o cliente foi escrito em Java, C# ou outra linguagem, pois usamos um protocolo e formatos independentes da plataforma
    - Como gerar JSON no código Java através de GSON
    - Como gerar XML no código Java através de XStream
    - Como escrever um web service através de um HttpServlet
    - Como criar um cliente HTTP a partir do código Java, usando a biblioteca `Apache HttpClient`
    - Como gerar JSON ou XML a partir do cabeçalho `Accept` da requisição

- Deploy no Jetty ✅
  - Servlet Container Jetty ✅
  - Observando as diferenças ✅
  - Especificação das Servlets ✅
  - Funcionamento de um Servlet Container ✅
  - O que aprendemos? ✅
    - A disponibilizar a nossa aplicação no _servlet_ container **Jetty**
    - Que Servlet é uma especificação
    - Que a especificação Servlet faz parte do Java EE/Jakarta EE
    - Que, ao usar Servlet, programamos independentemente do servidor/container
    - A diferença entre servlet container e application server

---

# Maven: gerenciamento de dependências e build de aplicação Java

### Steps:

- Conhecendo o Maven ✅
  - Build e dependências em uma aplicação Java ✅
  - Ferramentas de build ✅
  - Instalação do Maven ✅
  - Utilização do Maven ✅
  - O que aprendemos? ✅
    - As dificuldades de se realizar manualmente o build de uma aplicação Java;
    - As dificuldades de se gerenciar manualmente as dependências de uma aplicação Java;
    - O que é o Maven;
    - Como instalar e executar o Maven.

- Projetos com Maven ✅
  - Criando um projeto com Maven ✅
  - GroupId de um projeto com Maven ✅
  - Estrutura de um projeto com Maven ✅
  - Source folders ✅
  - Adicionando Maven a um projeto existente ✅
  - Projeto sem Maven ✅
  - O que aprendemos? ✅
    - A criar uma aplicação com Maven;
    - A entender a estrutura de diretórios de uma aplicação com Maven;
    - A migrar uma aplicação para o Maven.


- Dependências no Maven ✅
  - Gerenciando dependências no Maven ✅
  - Pesquisando por dependências ✅
  - Repositório central ✅
  - Alterando o repositório remoto de dependências ✅
  - Repositórios remotos ✅
  - O que aprendemos? ✅
    - Como declarar as dependências de uma aplicação;
    - Como pesquisar por dependências no repositório central do Maven;
    - Como configurar outros repositórios remotos.

- Build no Maven ✅
  - Processo de build no Maven ✅
  - Goals do Maven ✅
  - Gerando o artefato do build ✅
  - Empacotando a aplicação ✅
  - O que aprendemos? ✅
    - A realizar o build da aplicação com Maven;
    - A utilizar o comando `mvn nome-do-goal` para realizar o build;
    - Alguns goals do Maven, como `compile`, `test` e `package`;
    - A personalizar o artefato de build gerado pelo Maven.

- Outros recursos ✅
  - Plugins ✅
  - Plugins do Maven ✅
  - Proxy ✅
  - Módulos ✅
  - Modularização de projetos ✅
  - Projeto separado em módulos ✅
  - O que aprendemos? ✅
    - A utilizar plugins do Maven;
    - A como configurar um _proxy_ no Maven;
    - A como configurar uma aplicação modularizada no Maven.