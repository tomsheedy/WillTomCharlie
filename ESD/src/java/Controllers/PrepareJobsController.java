/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.LoginResult;
import Models.Customer;
import Models.Driver;
import Models.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author t2-sheedy
 */
public class PrepareJobsController extends HttpServlet {

    public PrepareJobsController() {
        //super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nam = "sdfsdfsd";
            String add = "dsdsfsdf";
            
            Customer newCust;
            newCust = new Customer();
            newCust.setName(nam);
            newCust.setAddress(add);
            newCust.WriteToDB();

            Customer cust;
            HttpSession session = request.getSession();

            cust = new Customer();//, name, pass);
            ArrayList<Customer> results = cust.List();
            String str = "[";
            for (Customer d : results) {
                str = str + d.getName();
            }
            str = str + "]";
            session.setAttribute("str", str);

            response.sendRedirect("success.jsp");

        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }

    }
}
