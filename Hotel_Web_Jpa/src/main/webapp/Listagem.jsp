<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Contatos</title>
    </head>

    <%
        String listaHTML = request.getParameter("lista");
    %>

    <body>
        <br>
        <br>
    <center>
        <table border="1">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Email</th>
                    <th>Telefone</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%=listaHTML%>
            </tbody>
            
        </table>
            <button onclick="window.location.href='index.html'">Voltar</button>
            <button onclick="window.location.href='Quartos.html'">Quartos</button>
    </center>
</body>
</html>
