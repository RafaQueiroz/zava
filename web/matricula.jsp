<%-- 
    Document   : matricula
    Created on : 26/06/2016, 13:38:33
    Author     : rafael
--%>
<%@page import="classes.Aluno"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Aluno aluno = new Aluno();
    HttpSession httpSession = request.getSession(true);
    
    aluno = (Aluno) httpSession.getAttribute("aluno");
    System.out.println(aluno.getNome()+" "+aluno.getId());

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/style.css"/>
        <title>Cursos</title>
    </head>
    <body>
        <sql:setDataSource
            var="datasource"
            driver="oracle.jdbc.driver.OracleDriver"
            url="jdbc:oracle:thin:@oracle.inf.poa.ifrs.edu.br:1521:XE"
            user="usr75"
            password="usr75"/>
        
        <sql:query dataSource="${datasource}" var="result">
            SELECT t.id,c.nome  
                FROM turmas t, cursos c 
                WHERE t.cursos_id = c.id
        </sql:query>
                
                
                
        <nav class="navbar navbar-default navbar-static-top">
            <div class="container-fluid">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <a class="navbar-brand" href="index.html">SGC</a>
              </div>

              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="acessibility-menu">      
                <ul>
                    <li><a href="matricula.jsp">Matricula</a></li>
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
            <h1>Matricula</h1>
            <h4><%= aluno.getNome()%>, selecione um curso para se matricular</h4>
            <div class="form">
                <form action="SvFazMatricula" method="post">

                    <select name="turma">
                        <option value="">Turma</option>
                        <c:forEach var="row" items="${result.rows}">        
                            <option value="${row.id}">${row.nome}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Matricular">
                </form>
            </div>
        </div>
        
    </body>
</html>
