<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:catch var="e">
        <h1>Hello Will and Tom!</h1>
            
            
            
        <sql:setDataSource var="d" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://sql4.freemysqlhosting.net:3306/sql496387?zeroDateTimeBehavior=convertToNull"
     user="sql496387"  password="suZYe7WXvI" />

        <sql:query dataSource="${d}" var="r">
            SELECT * from Drivers;
        </sql:query>
        
            <p>rowcount[ <c:out value="${r.rowCount}"/> ]</p>

        
        
        <c:forEach var="row" items="${r.rows}">
            <p>- <c:out value="${row.Registration}"/></p> 
        </c:forEach>

</c:catch>
    </body>
</html>
