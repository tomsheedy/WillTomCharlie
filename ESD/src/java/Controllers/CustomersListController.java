/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Customer;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Charlie
 */
public class CustomersListController extends HttpServlet {
    public CustomersListController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        
        Customer customer = new Customer();
        customers = customer.List();
        
        request.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/WEB-INF/customersList.jsp").forward(request, response);
    }
}
