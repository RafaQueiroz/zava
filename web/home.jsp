<%-- 
    Document   : home
    Created on : 20/06/2016, 20:41:45
    Author     : 0369152
--%>

<%@page import="classes.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    Usuario usr = new Usuario();
    usr = (Usuario) request.getAttribute("usr");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Olá <%= usr.getEmail() %></h1>
    </body>
</html>
