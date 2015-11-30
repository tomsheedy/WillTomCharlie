<%-- 
    Document   : success.jsp
    Created on : 13-Nov-2015, 16:13:50
    Author     : a2-painter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>page</title>
    </head>
    <body>
        <form action="PrepareJobsController" method="post">
            <table>
                <thead><th>ID</th><th>Name</th><th>Address</th><th>Destination</th><th>Date</th><th>Time</th><th>Driver</th></thead>
                <tbody>
                    <c:forEach items="${demands}" var="demand">
                        <tr>
                            <td>${demand.getId()}</td><td><input type="hidden" name="CustomerName${demand.getId()}" value="${demand.getName()}">${demand.getName()}</td><td><input type="hidden" name="CustomerAddress${demand.getId()}" value="${demand.getAddress()}">${demand.getAddress()}</td><td>${demand.getDestination()}</td><td>${demand.getDate()}</td><td>${demand.getTime()}</td>
                            <td>
                                <select name="DemandID${demand.getId()}">
                                    <c:forEach items="${drivers}" var="driver">
                                        <option value="${driver.getRegistration()}">
                                            ${driver.getName()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <input type="submit" ><br/><br/><hr/><br/><br/>
            <table>
                <thead><th>id</th><th>CustomerID</th><th>Driver Reg</th><th>Destination</th></thead>
                <tbody>
                    <c:forEach items="${journeys}" var="journey">
                        <tr>
                            <td>${journey.getID()}</td><td>${journey.getCustomerID()}</td><td>${journey.getDriversRegistration()}</td><td>${journey.getDestination()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <hr/>
            Invoices:<br/>                 
            <c:forEach items="${invoices}" var="invoice">
                <span><b>Customer ID</b> : ${invoice.getCustomerID()}</span><br/>
                <span><b>Customer Name</b> : ${invoice.getCustomerName()}</span><br/>
                <span><b>Driver Name</b> : ${invoice.getDriverName()}</span><br/>
                <span><b>Driver Registration</b> : ${invoice.getDriverRegistration()}</span><br/>
                <span><b>Pickup</b> : ${invoice.getPickup()}</span><br/>
                <span><b>Dropoff</b> : ${invoice.getDropoff()}</span><br/>
                <span><b>Time</b> : ${invoice.getTime()}</span><br/>
                <span><b>Date</b> : ${invoice.getDate()}</span><br/>
                <span><b>Cost/Distance</b> : ${invoice.getPrice()}</span><br/><br/>
            </c:forEach>
        </form>
    </body>
</html>
