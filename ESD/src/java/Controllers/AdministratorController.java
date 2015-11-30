/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Database.LoginResult;
import Database.Properties;
import java.sql.*;

/**
 *
 * @author t2-sheedy
 */
public class AdministratorController {
    

    public static boolean produceDailyReport () {

        int errr = 0;
        Connection con;
        Statement state;
        ResultSet rs;
        String today = "";
                
        Properties p;
        p = new Properties();
        try {

            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetQuery();
            if (query.length() > 0) {

                rs = state.executeQuery(query);

                int rowCount = 0;

                while (rs.next()) {
                    rowCount = rowCount + 1;
                    today += rs.getString("Registration");
                }

                rs.close();
                state.close();
                con.close();

                if (rowCount == 1) {
                    //return new LoginResult(loggedInID, "Success");
                } else {
                    //return new LoginResult("", "Fail 53");
                }
            } else {
                //return new LoginResult("", "Fail 56");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
            //return new LoginResult("", "Fail 62: " + e + " /// " + errr);
        }//tryerrr
        System.out.println(today);
        return true;
    }

    public static String GetQuery() {
        String date = "2015-11-02";
        String query = "SELECT * FROM Demands WHERE Date = '" + date;
       return query;
    }

}
