<%-- 
    Document   : admin
    Created on : 29-Nov-2015, 20:15:24
    Author     : t2-sheedy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admin Menu</h1>
        <p>Welcome user ${sessionScope.id}</p>
        <ul>
            <li><a href="#">List Drivers [2]</a><ul><li>Add New [7]</li><li>Remove [9]</li></ul></li>
            <li><a href="#">List Customers [2]</a></li>
            <li><a href="#">Prepare Jobs [3]</a></li>
            <li><a href="#">Daily Report [4]</a></li>
            <li><a href="#">List Daily Customers [5]</a></li>
            <li><a href="#">Create Customer Invoice [8]</a></li>
            <li><a href="#">Change Destination Price [10]</a></li>
        </ul>
    </body>
</html>
