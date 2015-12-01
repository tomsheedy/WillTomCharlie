/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Databases.*;
import Models.Driver;
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
public class ReportController extends HttpServlet {
    public ReportController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<DatabaseTables> tableEntries;
        
        DatabaseTables DB = new GenericJourney();
        
        tableEntries = DB.List();
        System.out.println(tableEntries.get(0).getEntry().get(0));
        System.out.println(tableEntries.get(0).getEntry().get(1));
        System.out.println(tableEntries.get(0).getEntry().get(2));
        
        request.setAttribute("table", tableEntries);
        getServletContext().getRequestDispatcher("/WEB-INF/TableList.jsp").forward(request, response);
    }
    
    
}


