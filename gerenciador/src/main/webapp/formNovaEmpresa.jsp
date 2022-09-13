<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/novaEmpresa" var="linkNovaEmpresa"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cadastro Nova empresa</title>
</head>
<body>
<form action="${linkNovaEmpresa}" method="post">
    <label>Nome:
        <input type="text" name="nome"/>
    </label><br><br>
    <label>Data abertura:
        <input type="text" name="data">
    </label><br><br>
    <input type="submit" value="Enviar">
</form>
</body>
</html>