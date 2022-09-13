<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Nova Empresa</title>
</head>
<body>
<p style="font-family: 'Cascadia Code',serif; font-size: 20px;">
    <c:if test="${not empty empresa}">
        Empresa <span
            style="font-family: 'Cascadia Code',serif; font-size: 40px; font-weight: bolder">${empresa}</span>
        cadastrada com sucesso!
    </c:if>
    <c:if test="${empty empresa}">
        Nenhuma empresa cadastrada.
    </c:if>
</p>
</body>
</html>
