<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="javaservlet.gerenciador.model.Empresa" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Lista Empresas</title>
</head>
<body>
<c:if test="${not empty empresa}">
    Empresa <span
        style="font-family: 'Cascadia Code',serif; font-size: 40px; font-weight: bolder">${empresa}</span>
    cadastrada com sucesso!
</c:if>
<br>
<h3>Lista de Empresas:</h3>
<jsp:useBean id="empresas" scope="request" type="java.util.List"/>
<c:forEach items="${empresas}" var="empresa">
    <li>
            ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
        <a href="entrada?action=MostraEmpresa&id=${empresa.id}" type="button">Edita</a>
        <a href="entrada?action=RemoveEmpresa&id=${empresa.id}" type="button">Remove</a>
    </li>
</c:forEach>
</body>
</html>
