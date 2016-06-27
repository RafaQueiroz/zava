<%-- 
    Document   : cadastroTurma
    Created on : 26/06/2016, 00:56:16
    Author     : rafael
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/style.css"/>
        <title>Cursos</title>
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
        <h1>Cadastro de Turmas</h1>

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
                
                    <form action="../SvCadastraTurma" method="post">
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
                    
                    <input type="submit" value="Cadastrar">
                </form>
                
            </div>    
        </div>>
    </body>
</html>
