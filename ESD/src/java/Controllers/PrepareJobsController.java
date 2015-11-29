/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.LoginResult;
import Models.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author t2-sheedy
 */
public class PrepareJobsController extends HttpServlet {

    public PrepareJobsController() {
        super();
    }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dc","Dickcheese");
        
    }
}
