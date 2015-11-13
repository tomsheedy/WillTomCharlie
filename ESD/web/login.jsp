<%-- 
    Document   : login
    Created on : 13-Nov-2015, 15:53:40
    Author     : a2-painter
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="LoginController" method="post">
            Username: <input type="text" name="username">
            Password: <input type="password" name="password">
            <input type="submit" />
        </form>
    </body>
</html>
