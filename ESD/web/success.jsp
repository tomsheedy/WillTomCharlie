<%-- 
    Document   : success.jsp
    Created on : 13-Nov-2015, 16:13:50
    Author     : a2-painter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success Page</title>
    </head>
    <body>
        <h1>Login success!</h1>
        ID = ${sessionScope.id}<br/>
        user = ${sessionScope.username}<br/>
        pass = ${sessionScope.password}
        <!--Welcome $[requestScope['user'].username].-->
    </body>
</html>
