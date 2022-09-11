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

- Páginas dinâmicas com JSP
  - Primeiro JSP
  - Sobre JSP
  - Sobre Scriptlet
  - Mais sobre Scriptlet
  - Despachando a requisição
  - RequestDispatcher
  - JSP para listar empresas
  - O que aprendemos?

- JSTL e Expression Language
  - Conhecendo Expression Language
  - Expression Language
  - Download do JSTL
  - Conhecendo JSTL
  - Sobre o JSTL
  - Resultado com forEach
  - Usando a taglib core
  - Mais forEach
  - Usando a taglib fmt
  - O que aprendemos?

- Redirecionando o fluxo
  - Quando o dispatcher não atende
  - Sobre o RequestDispatcher
  - Código de resposta HTTP
  - Redirecionamento pelo navegador
  - O Botão F5
  - Desafio: Código para redirecionamento
  - Qual redirecionamento?
  - O que aprendemos?

- Completando o CRUD
  - Apresentando as funcionalidades
  - O que é CRUD?
  - Removendo empresa
  - Maneira correta de identificação
  - Formulário de alteração
  - Alterando empresa
  - Achando o problema
  - O que aprendemos?

- Deploy da aplicação
  - Conhecendo o web.xml
  - Sobre o mapeamento
  - Inversão de controle
  - Inversão de quê?!
  - Fixando o funcionamento
  - Deploy da aplicação
  - Entendendo mais sobre deploy
  - O que aprendemos?
