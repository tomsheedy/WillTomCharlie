<%-- 
    Document   : customersList
    Created on : 30-Nov-2015, 19:36:57
    Author     : Charlie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers List</title>
    </head>
    <body>
        <h1>Customers List</h1>
        
        <table border="1px">
            <tr>
                <td><b>ID</b></td>
                <td><b>Name</b></td>
                <td><b>Address</b></td>
            </tr>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.getID()}</td>
                    <td>${customer.getName()}</td>
                    <td>${customer.getAddress()}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
