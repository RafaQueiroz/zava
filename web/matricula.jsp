<%-- 
    Document   : matricula.jsp
    Created on : 25/06/2016, 22:26:29
    Author     : rafael
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="classes.Curso"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var=""></c:set>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="cadastroForm">
                <form>
                    <select>
                        <c:forEach var="curso" items="${listaCursos}">
                            <option value="${curso.getId()}">${curso.getNome()}</option>
                        </c:forEach> 
                    </select>
                    
                    <input type="bubmit" value="confirmar">
                </form>
            </div>
        </div>
    </body>
</html>
