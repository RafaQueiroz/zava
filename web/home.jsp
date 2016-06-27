<%-- 
    Document   : home
    Created on : 20/06/2016, 20:41:45
    Author     : 0369152
--%>

<%@page import="classes.DAO"%>
<%@page import="classes.Aluno"%>
<%@page import="classes.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>
<% 
    Aluno aluno = new Aluno();
    aluno = (Aluno) request.getAttribute("aluno");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/style.css"/>
        <title>Cursos | Home</title>
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
        <div class="container container-fluid">
            <h1>Olá <%=aluno.getNome()%></h1>
        </div>
    </body>
</html>
