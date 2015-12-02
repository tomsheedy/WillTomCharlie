/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Driver;
import Models.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author h2-standal
 */
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class DailyCustomers extends HttpServlet {
    public DailyCustomers() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Journey> journeys;
        
        Journey j = new Journey();
        ArrayList<Customer> dailyCustomers = new ArrayList<Customer>();
        journeys = j.ListByDate();
        ArrayList<Integer> iterations = new ArrayList<Integer>();
        
        int index = 0;
        for (Journey journey : journeys) {
            Customer c = new Customer(journey.getID());
            c = c.GetDetail();
            dailyCustomers.add(c);
            iterations.add(index);
            journey.calculatePricing(journey.getDistance());
            index++;
        }
        
        System.out.println(dailyCustomers.size());
        System.out.println(journeys.size());
        System.out.println(iterations.size());
        
        request.setAttribute("customers", dailyCustomers);
        request.setAttribute("journeys", journeys);
        request.setAttribute("iterations", iterations);
        
        getServletContext().getRequestDispatcher("/WEB-INF/dailyCustomers.jsp").forward(request, response);
    }
    
    
}


