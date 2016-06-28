<%-- 
    Document   : cadastroTurma
    Created on : 26/06/2016, 00:56:16
    Author     : rafael
--%>
<%@page import="classes.Professor"%>
<%@page import="classes.Aluno"%>
<%
    Professor professor = new Professor();
    HttpSession httpSession = request.getSession(true);
    
    professor = (Professor) httpSession.getAttribute("professor");
    System.out.println(professor.getNome()+" "+professor.getId());

%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <h1 class="logo">Cadastro de Turmas</h1>

        <sql:setDataSource
            var="datasource"
            driver="oracle.jdbc.driver.OracleDriver"
            url="jdbc:oracle:thin:@oracle.inf.poa.ifrs.edu.br:1521:XE"
            user="usr75"
            password="usr75"/>
        
        <sql:query dataSource="${datasource}" var="result">
            SELECT * FROM cursos 
        </sql:query>
        <sql:query dataSource="${datasource}" var="professores">
            SELECT * FROM instrutores 
        </sql:query>
            <div class="form">
                
                    <form action="/Cursos/SvCadastraTurma" method="post">
                    <label>Data de Inicio:</label>
                    <input type="date" name="dataInicio">
                    <label>Data de Fim:</label>
                    <input type="date" name="dataFim">
                    <select name="curso">
                        <option value="">Curso</option>
                        <c:forEach var="row" items="${result.rows}">
                            <option value="${row.id}">${row.nome}</option>
                        </c:forEach>
                    </select>
                    <select name="professor">
                        <option value="">Professor</option>
                        <c:forEach var="row" items="${professores.rows}">
                            <option value="${row.id}">${row.nome}</option>
                        </c:forEach>
                    </select>
                    <label>Carga Horaria:</label>
                    <input type="number" name="cargaHoraria">
                    
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
