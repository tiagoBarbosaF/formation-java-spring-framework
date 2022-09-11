<%
    String nomeEmpresa = (String) request.getAttribute("empresa");
    System.out.println(nomeEmpresa);
%>
<html>
<head>
    <title>Nova Empresa</title>
</head>
<body>
<p style="font-family: 'Cascadia Code',serif; font-size: 20px;">
    Empresa <span
        style="font-family: 'Cascadia Code',serif; font-size: 40px; font-weight: bolder"><%=nomeEmpresa%></span>
    cadastrada com sucesso!
</p>
</body>
</html>
