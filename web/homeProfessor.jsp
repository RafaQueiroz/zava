<%-- 
    Document   : home
    Created on : 20/06/2016, 20:41:45
    Author     : 0369152
--%>

<%@page import="classes.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>
<% 
    Professor professor = new Professor();
    professor = (Professor) request.getAttribute("professor");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div class="menu">
            <ul>
                <li><a href="./cadastraUsuario.jsp">Cadastro de usuarios</a></li>
                <li><a href="./cadastraInstrutores.jsp">Cadastro de Instrutores</a></li>
                <li><a href="./cadastroCurso.jsp">Cadastro de Curso</a></li>
                <li><a href="./cadastroTurma.jsp">Cadastro de Turma</a></li>
            </ul>
                
        </div>
        <h1>Olá <%= professor.getNome() %></h1>
    </body>
</html>
