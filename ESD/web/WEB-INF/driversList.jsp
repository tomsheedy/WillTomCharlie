<%-- 
    Document   : driversList
    Created on : 30-Nov-2015, 16:15:27
    Author     : Charlie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function setDelete(reg) {
                document.getElementById('deletedReg').value = reg;
                alert(document.getElementById('deletedReg').value);

                document.myform.submit();
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Drivers List</title>

    </head>
    <body>
        <form action="DriversListController" name="myform" method="post">
            <h1>Drivers List</h1>

            <input id="deletedReg" name="deletedReg" type="hidden">

            <table border="1px">
                <tr>
                    <td><b>Name</b></td>
                    <td><b>Registration</b></td>
                </tr>
                <c:forEach items="${drivers}" var="driver">
                    <tr>
                        <td>${driver.getName()}</td>
                        <td>${driver.getRegistration()}</td>
                        <td><input type="button" value="Delete" name="deleteBtn" onclick="setDelete('${driver.getRegistration()}');" style="background-color: red; color: white; font-weight: bold" /></td>
                    </tr>
                </c:forEach>
            </table>

            <input type="submit" value="Add New" name="addBtn" onclick="DriversListController.addNew();" />
        </form>

    </body>
</html>
