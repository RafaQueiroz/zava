<%-- 
    Document   : matricula
    Created on : 26/06/2016, 13:38:33
    Author     : rafael
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <sql:query dataSource="${datasource}" var="data">
            SELECT TO_CHAR
                (SYSDATE, 'MM/DD/YY') "NOW"
                 FROM DUAL
        </sql:query>

        <h1>Matricula</h1>
        <div class="cadastroForm">
            <form action="SvMatricula" method="post">
                
                <select name="turma">
                    <option value="">Turma</option>
                    <c:forEach var="row" items="${result.rows}">        
                        <option value="${row.id}">${row.nome}</option>
                    </c:forEach>
                </select>
                <label>Data Matricula</label>
                <input type="text" value="${data.now}">
            </form>
        </div>
    </body>
</html>
