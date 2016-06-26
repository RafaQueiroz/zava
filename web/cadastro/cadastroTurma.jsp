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
        <title>Cursos</title>
    </head>
    <body>
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
            <div class="cadastroForm">
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
        
    </body>
</html>
