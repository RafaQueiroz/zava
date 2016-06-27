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
        <link rel="stylesheet" href="../css/style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-static-top">
            <div class="container-fluid">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <a class="navbar-brand" href="index.html">SGC</a>
              </div>

              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="acessibility-menu">      
                <ul>
                    <li><a href="/Cursos/cadastro/cadastroAlunos.jsp">Cadastro de Alunos</a></li>
                    <li><a href="/Cursos/cadastro/cadastroProfessor.jsp">Cadastro de Professores</a></li>
                    <li><a href="/Cursos/cadastro/cadastroCursos.jsp">Cadastro de Curso</a></li>
                    <li><a href="/Cursos/cadastro/cadastroTurma.jsp">Cadastro de Turma</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Acessibilidade <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="javascript:aumentarFonte()" id="aumentarFonte">Aumentar fonte</a></li>
                      <li><a href="javascript:diminuirFonte()" id="diminuirFonte">Diminuir fonte</a></li>
                      <li><a href="javascript:tamanhoOriginal()" id="tamanhoOriginal">Tamanho original</a></li>
                      <li role="separator" class="divider"></li>
                      <li><a id="altoContraste" href="javascript:altoContraste()">Alto Contraste</a></li>
                    </ul>
                  </li>
                </ul>
              </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class="container">
            
        <h1>Cadastro de alunos</h1>
        <div class="form">
            <form action="../SvCadastraAluno" method="post" form="login-form">
                <label for="nome">Nome:</label>
                <input type="text" name="nome">

                <label for="cpf">Cpf:</label>
                <input type="text" name="cpf">

                <label for="nome">Email:</label>
                <input type="text" name="email">

                <label for="nome">Telefone:</label>
                <input type="text" name="telefone">

                <label for="nome">Data de Nascimento:</label>
                <input type="text" name="dataNascimento">

                <label for="nome">Senha:</label>
                <input type="text" name="senha">
                
                <input type="submit" value="Cadastrar" name="cadastra">
            </form>
        </div>
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="js/index.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    </body>
</html>
