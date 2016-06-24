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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de alunos</h1>
        <div class="cadastraAluno">
            <form action="SvCadastraFuncionario" action="post">
                <label for="nome">Nome:</label>
                <input type="text" name="nome">

                <label for="cpf">Cpf:</label>
                <input type="text" name="cpf">

                <label for="nome">Email:</label>
                <input type="text" name="email">

                <label for="nome">Telefone:</label>
                <input type="text" name="telefone">

                <label for="nome">Data de Nascimento:</label>
                <input type="date" name="dataNascimento">

                <label for="nome">Senha:</label>
                <input type="text" name="senha">
                
                <input type="submit" value="Cadastrar" name="cadastra">
            </form>
        </div>
    </body>
</html>
