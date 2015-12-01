<%-- 
    Document   : DailyCustomer
    Created on : 30-Nov-2015, 21:23:03
    Author     : h2-standal
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daily Report</title>
    </head>
    <body>
        <h1>Daily report</h1>
        
        <table border="1px">
            <tr>
                <td><b>Name</b></td>
                <td><b>Address</b></td>
                <td><b>ID</b></td>

            </tr>
            <c:forEach items="${table}" var="customer">
                <tr>
                    <td>${customer.getEntry().get(0)}</td>
                    <td>${customer.getEntry().get(1)}</td>
                    <td>${customer.getEntry().get(2)}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

