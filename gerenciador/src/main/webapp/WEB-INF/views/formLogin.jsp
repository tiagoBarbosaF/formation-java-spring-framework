<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/entrada" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cadastro Nova empresa</title>
</head>
<body>
<form action="${linkEntradaServlet}" method="post">
    <label>Login:
        <input type="text" name="login"/>
    </label><br><br>
    <label>Senha:
        <input type="password" name="senha">
    </label><br><br>
    <label>
        <input type="hidden" name="action" value="Login"/>
    </label>
    <input type="submit" value="Enviar">
</form>
</body>
</html>