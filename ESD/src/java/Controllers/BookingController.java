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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        String asap = request.getParameter("asap");
        Boolean now;
        if (asap != null){
            now = true;
        }else{
            now = false;
        }

        Demand demand = new Demand(id, name, address, destination);

        java.sql.Date date = new java.sql.Date(1L);
        java.sql.Time time = new java.sql.Time(1l);

        if (now) {
            time = new Time(System.currentTimeMillis());
            date = new Date(System.currentTimeMillis());
            demand.setDate(date);
            demand.setTime(time);
        } else{
            String timeStr = request.getParameter("hour") + ":"
                    + request.getParameter("minute") + ":00";
            String dateStr = request.getParameter("year") + "/"
                    + request.getParameter("month") + "/"
                    + request.getParameter("day");

            /*
             Create SQL Date object from String
             */
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

            try {
                java.util.Date utilDate = sdf.parse(dateStr);
                date = new java.sql.Date(utilDate.getTime());
            } catch (ParseException ex) {
                System.out.println(ex);
            }

            /*
             Create SQL Date object from String
             */
            /*
             Create SQL Time object from String
             */
            SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");

            //time.valueOf(timeStr);
            
            try {
                
                long ms = sdfTime.parse(timeStr).getTime();
                time = new Time(ms);
            } catch (ParseException ex) {
                System.out.println(ex);
            }

            /*
             Create SQL Time object from String
             */
            demand.setDate(date);
            demand.setTime(time);
        }

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
