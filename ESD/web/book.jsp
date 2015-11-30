<%-- 
    Document   : book
    Created on : 29-Nov-2015, 19:41:21
    Author     : a2-painter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book a Cab</title>
    <a href="index.jsp">Back</a>
</head>
<body>
    <h1>Book a Cab</h1>
    <br>
    <br>

    <form action="BookingController" method="post" name="booking_form">
        Name: <input type="text" name="name"><br>
        Address: <input type="text" name="address"><br>
        Destination: <input type="text" name="destination"><br><br>
        What time would you like it for?:<br>
        ASAP: <input type="checkbox" name="asap"><br>
        Time: <input type="text" name="time" disabled="false"><br>
        <input type="submit" value="Get Quote"/>
    </form>
    
    <<script src="link">
        if (document.booking_form.asap === true){
            document.booking_form.elements.time.disabled=true;
        }
        
    </script>
    
    <%%>
</body>
</html>
