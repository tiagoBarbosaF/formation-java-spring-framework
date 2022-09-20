<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/entrada" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cadastro Nova empresa</title>
</head>
<body>
<c:import url="logout-parcial.jsp"/>
<form action="${linkEntradaServlet}" method="post">
    <label>Nome:
        <input type="text" name="nome"/>
    </label><br><br>
    <label>Data abertura:
        <input type="text" name="data">
    </label><br><br>
    <label>
        <input type="hidden" name="action" value="NovaEmpresa"/>
    </label>
    <input type="submit" value="Enviar">
</form>
</body>
</html>