<%@page import="classes.Professor"%>
<%@page import="classes.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Professor professor = new Professor();
    HttpSession httpSession = request.getSession(true);
    
    professor = (Professor) httpSession.getAttribute("professor");
    System.out.println(professor.getNome()+" "+professor.getId());

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" href="/Cursos/css/style.css"/>

        <title>Cursos</title>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-static-top">
            <div class="container-fluid">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <a class="navbar-brand" href="/Cursos/home.jsp">SGC</a>
              </div>
                
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cadastros<span class="caret"></span></a>
                      <ul class="dropdown-menu">
                        <li><a href="/Cursos/cadastro/cadastroAlunos.jsp">Alunos</a></li>
                        <li><a href="/Cursos/cadastro/cadastroCursos.jsp">Cursos</a></li>
                        <li><a href="/Cursos/cadastro/cadastroTurma.jsp">Turma</a></li>
                        <li><a href="/Cursos/cadastro/cadastroProfessor.jsp">Professor</a></li>
                        <li><a href="/Cursos/index.html">Sair</a></li>
                      </ul>
                    </li>
                  </ul>
              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="acessibility-menu">      
                
                  
                  
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
            <h1 class="logo">Cadastro de Cursos</h1>
            <div class="form"> 
                <form action="/Cursos/SvCadastraCurso" method="post" class="">
                    <label for="nome">Nome:</label>
                    <input type="text" name="nome">

                    <label for="cpf">Requisitos:</label>
                    <input type="text" name="requisitos">

                    <label for="nome">Carga Horaria</label>
                    <input type="number" name="cargaHoraria">

                    <label for="nome">Preço:</label>
                    <input type="number" name="preco">

                    <button type="submit" name="cadastra">Cadastrar</button>
                    
                </form>
            </div>
            
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="js/index.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    </body>
</html>
