<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="Login" method="POST">
        <table>
            <tr>
                <td>CPF:</td>
                <td><input type="text" name="cpf" required /></td>
            </tr>
            <tr>
                <td>Nome:</td>
                <td><input type="text" name="nome" required /></td>
            </tr>
        </table>
        <input type="submit" value="Entrar" />
        <input type="reset" value="Limpar" />
    </form>
</body>
</html>
