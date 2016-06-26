<%-- 
    Document   : home
    Created on : 20/06/2016, 20:41:45
    Author     : 0369152
--%>

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
        <title>JSP Page</title>
    </head>
    <body>
         <div class="menu">
            <ul>
                <li><a href="SvMatricula">Fazer Matricula</a></li>
            </ul>
                
        </div>
        <h1>Olá <%= aluno.getNome() %></h1>
    </body>
</html>
