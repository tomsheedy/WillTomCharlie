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
public class Authenticator {

    public static LoginResult Authenticate(String loginType, String username, String password) {

        Connection con;
        Statement state;
        ResultSet rs;

        Properties p;
        p = new Properties();

        try {

            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetQuery(loginType, username, password);
            if (query.length() > 0) {

                rs = state.executeQuery(query);

                String loggedInID = "";
                String pkColumnLabel = GetPKLoginLabel(loginType);
                int rowCount = 0;

                while (rs.next()) {
                    rowCount = rowCount + 1;
                    loggedInID = rs.getString(pkColumnLabel);
                }

                rs.close();
                state.close();
                con.close();

                if (rowCount == 1) {
                    return new LoginResult(loginType, loggedInID, "Success");
                } else {
                    return new LoginResult(loginType, "", "Fail");
                }
            } else {
                return new LoginResult(loginType, "", "Fail");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
            return new LoginResult(loginType, "", "Fail");
        }//try

    }

    public static String GetQuery(String loginType, String username, String password) {
        String query = "";
        String usernameName = "";
        String passwordName = "";

        if (loginType.toLowerCase() == "drivers") {
            usernameName = "Registration";
            passwordName = "password";
            query = "SELECT * FROM " + loginType + " WHERE " + usernameName + " = '" + username + "' AND " + passwordName + " = '" + password + "';";

        } else if (loginType.toLowerCase() == "customer") {
            usernameName = "Name";
            query = "SELECT * FROM " + loginType + " WHERE " + usernameName + " = '" + username + "'";
        }
        return query;
    }

    public static String GetPKLoginLabel(String loginType) {

        if (loginType.toLowerCase() == "drivers") {
            return "Registration";
        } else if (loginType.toLowerCase() == "customer") {
            return "id";
        }
        return "";
    }

}
