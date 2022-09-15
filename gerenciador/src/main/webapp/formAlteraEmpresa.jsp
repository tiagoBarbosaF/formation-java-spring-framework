<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/alteraEmpresa" var="alteraEmpresa"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cadastro Nova empresa</title>
</head>
<body>
<form action="${alteraEmpresa}" method="post">
    <label>Nome:
        <input type="text" name="nome" value="${empresa.nome}"/>
    </label><br><br>
    <label>Data abertura:
        <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
    </label><br><br>
    <label>
        <input type="hidden" name="id" value="${empresa.id}"/>
    </label>
    <input type="submit" value="Enviar"/>
</form>
</body>
</html>