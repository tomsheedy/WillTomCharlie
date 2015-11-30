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

/**
 *
 * @author a2-painter
 */
public class BookingController extends HttpServlet {
    
    public BookingController(){
        //super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              
        int id = 1;
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String destination = request.getParameter("destination");
        
        Demand demand = new Demand(id, name, address, destination);
        //int id = 1;
        
        HttpSession session = request.getSession();
        session.setAttribute("username", name);
        session.setAttribute("destination", destination);
        //session.setAttribute("id", id);
        
        response.sendRedirect("success.jsp");
    }
}

