<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dados do Contato</title>
        <link rel="stylesheet" href="./css/estilo.css">
        <style>
            .container {
                display: flex;
                gap: 20px;
            }

            form {
                border: 1px solid #ccc;
                padding: 15px;
                border-radius: 5px;
            }
        </style>
    </head>

    <%
        String acao     = request.getParameter("acao");
        String id       = request.getParameter("id");
        String cpf       = request.getParameter("cpf");
        String nome     = request.getParameter("nome");
        String email    = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        
        if (id == null) {
            nome = "";
            cpf = "";
            email = "";
            telefone = "";
        }if(nome==null && cpf==null){
            
        }
    %>

    <body>
        <h3>Dados do Contato</h3>
        <div class="container">
            <!-- Formulário de Contato -->
            <form action="HospedeSrv" method="POST">
                <input type="hidden" name="acao" value="<%=acao %>" />
                <input type="hidden" name="id" value="<%=id %>" />
                
                <table border="0">
                    <tbody>
                        <tr>
                            <td>Nome: </td>
                            <td><input type="text" name="nome" value="<%=nome %>" /></td>
                        </tr>
                        <td>Cpf: </td>
                            <td><input type="text" name="cpf" value="<%=cpf %>" /></td>
                        </tr>
                        <tr>
                            <td>Email: </td>
                            <td><input type="text" name="email" value="<%=email %>" /></td>
                        </tr>
                        <tr>
                            <td>Telefone: </td>
                            <td><input type="text" name="telefone" value="<%=telefone %>" /></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" value="Gravar" />
                <input type="reset" value="Limpar" />
            </form>
        </div>
    </body>
</html>
