<%-- 
    Document   : cadastroAlunos
    Created on : 23/06/2016, 21:28:44
    Author     : 0369152
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Curso</title>
    </head>
    <body>
        <h1>Cadastro de Professores</h1>
        <div class="cadastraFrom">
            <form action="../SvCadastraProfessor" method="post">
                <label for="nome">Nome:</label>
                <input type="text" name="nome">

                <label for="cpf">Certificados:</label>
                <input type="textarea" name="certificados">

                <label for="nome">Email:</label>
                <input type="text" name="email">
                
                <label for="nome">Valor Hora:</label>
                <input type="number" name="valorHora">

                <label for="nome">Senha:</label>
                <input type="text" name="senha">
                
                <input type="submit" value="Cadastrar" name="cadastra">
            </form>
        </div>
    </body>
</html>
