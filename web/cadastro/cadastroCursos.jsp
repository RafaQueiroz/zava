<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cursos</title>
    </head>
    <body>
        <h1>Cadastro de Cursos</h1>
        <div class="cadastroForm">
            <form action="../SvCadastraCurso" method="post">
                <label for="nome">Nome:</label>
                <input type="text" name="nome">

                <label for="cpf">Requisitos:</label>
                <input type="text" name="requisitos">

                <label for="nome">Carga Horaria</label>
                <input type="number" name="cargaHoraria">

                <label for="nome">Preço:</label>
                <input type="number" name="preco">

                
                <input type="submit" value="Cadastrar" name="cadastra">
            </form>
        </div>
    </body>
</html>
