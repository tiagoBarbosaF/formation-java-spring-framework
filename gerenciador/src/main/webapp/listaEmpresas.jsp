<%@ page import="javaservlet.gerenciador.model.Empresa" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Empresas</title>
</head>
<body>
    <h3>Lista de Empresas:</h3>
<ul>
    <%
        List<Empresa> listEmpresas = (List<Empresa>) request.getAttribute("listEmpresas");
        for (Empresa empresa : listEmpresas) {
    %>
    <li><%=empresa.getNome()%>
    </li>
    <%
        }
    %>
</ul>
</body>
</html>
