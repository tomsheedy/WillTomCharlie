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
            <li><a href="DriversListController">List Drivers [2] Charlie</a><ul><li>Add New [7]</li><li>Remove [9]</li></ul></li>
            <li><a href="CustomersListController">List Customers [2] Charlie</a></li>
            <li><a href="PrepareJobsController">Prepare Jobs [3] Tom</a></li>
            <li><a href="ReportController">Daily Report [4] Hakon</a></li>
            <li><a href="#">List Daily Customers [5] Hakon</a></li>
            <li><a href="#">Create Customer Invoice [8] Tom</a></li>
            <li><a href="#">Change Destination Price [10]</a></li>
        </ul>
    </body>
</html>
