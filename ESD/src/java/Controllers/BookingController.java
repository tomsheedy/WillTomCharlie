/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Demand;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author a2-painter
 */
public class BookingController extends HttpServlet {

    public BookingController() {
        //super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = 1;
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String destination = request.getParameter("destination");

        Demand demand = new Demand(id, name, address, destination);
        //java.util.Date utilDate = new java.util.Date
        Long seconds = 5l;
        Date date = new Date(seconds);
        Time time = new Time(seconds);

        demand.setDate(date);
        demand.setTime(time);
        demand.setStatus("Outstanding");

        demand.addBooking();

        Demand de;
        HttpSession session = request.getSession();

        de = new Demand();//, name, pass);
        ArrayList<Demand> results = de.list();
        String str = "[";
        for (Demand d : results) {
            str = " " + str + d.getName() + " - " + d.getAddress();
        }
        str = str + "]";
        session.setAttribute("str", str);

        response.sendRedirect("success.jsp");
    }
}
