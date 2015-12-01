/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Driver;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Charlie
 */
public class DriversListController extends HttpServlet {
    public DriversListController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        
        Driver driver = new Driver();
        drivers = driver.List();
        
        request.setAttribute("drivers", drivers);
        
        getServletContext().getRequestDispatcher("/WEB-INF/driversList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object regToDelete = request.getParameter("deletedReg");
        
        if (regToDelete != null && !"".equals(regToDelete)){
            ArrayList<Driver> drivers = new ArrayList<Driver>();
            Driver driver = new Driver();
            
            driver.setRegistration(regToDelete.toString());
            driver.Delete();
            driver.setRegistration("");
            drivers = driver.List();
            
            request.setAttribute("drivers", drivers);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/driversList.jsp").forward(request, response);
        
    }
    
//    public void addNew() {
//        System.out.println("Adding new!");
//    }
//    
//    public void setDelete(String reg) {
//        Driver driver = new Driver();
//        
//        driver.setRegistration(reg);
//        driver.Delete();
//    }
}
