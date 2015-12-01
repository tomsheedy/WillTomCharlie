<%-- 
    Document   : book
    Created on : 29-Nov-2015, 19:41:21
    Author     : a2-painter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            function disable() {
                if (document.getElementById('asap').checked) {
                    document.getElementById('hour').disabled = true;
                    document.getElementById('minute').disabled = true;
                    document.getElementById('day').disabled = true;
                    document.getElementById('month').disabled = true;
                    document.getElementById('year').disabled = true;
                } else {
                    document.getElementById('hour').disabled = false;
                    document.getElementById('minute').disabled = false;
                    document.getElementById('day').disabled = false;
                    document.getElementById('month').disabled = false;
                    document.getElementById('year').disabled = false;
                }
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book a Cab</title>
    <a href="index.jsp">Back</a>
</head>
<body>
    <h1>Book a Cab</h1>
    <br>

    <form action="BookingController" method="post" name="booking_form">
        Name: <input type="text" name="name"><br>
        Address: <input type="text" name="address"><br>
        Destination: <input type="text" name="destination"><br><br>
        When would you like it for?:<br>
        ASAP: <input type="checkbox" id="asap" onclick="disable();" name="asap"><br>
        Time:
        <input type="text" id="hour" maxlength="2" placeholder="HH" size="2" name="hour">:
        <input type="text" id="minute" maxlength="2" placeholder="MM" size="2" name="minute"><br>
        Date: 
        <input type="text" id="day" maxlength="2" placeholder="DD" size="2" name="day">/
        <input type="text" id="month" maxlength="2" placeholder="MM" size="2" name="month">/
        <input type="text" id="year" maxlength="4" placeholder="YYYY" size="4" name="year"><br><br>
        <input type="submit" value="Get Quote"/>
    </form>
</body>
</html>
