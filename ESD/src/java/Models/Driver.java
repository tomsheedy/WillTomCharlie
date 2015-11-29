/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Database.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author t2-sheedy
 */
public class Driver {

    public static String Registration;
    public static String Name;
    public static String Password;

    public Driver() {

    }

    public Driver(String reg) {
        this.Registration = reg;
        GetDriver();
    }
    
    public Driver(String reg, String name, String pass) {
        this.Registration = reg;
        this.Name = name;
        this.Password = pass;
    }

    public static String getRegistration() {
        return Registration;
    }

    public static void setRegistration(String Registration) {
        Driver.Registration = Registration;
    }

    public static String getName() {
        return Name;
    }

    public static void setName(String Name) {
        Driver.Name = Name;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String Password) {
        Driver.Password = Password;
    }

    
    
    
    public static boolean LogIn() {

        Connection con;
        Statement state;
        ResultSet rs;

        Properties p;
        p = new Properties();

        try {

            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetQuery(getRegistration(), getPassword());
            if (query.length() > 0) {

                rs = state.executeQuery(query);

                String reg = "";
                String name = "";
                String pass = "";
                int rowCount = 0;

                while (rs.next()) {
                    rowCount = rowCount + 1;
                    reg = rs.getString("Registration");
                    name = rs.getString("Name");
                    pass = rs.getString("password");
                }

                rs.close();
                state.close();
                con.close();

                if (rowCount == 1) {
                    return true;//new Driver(reg, name, pass);
                } else {
                    return false;//new Driver();
                }
            } else {
                return false;//new Driver();
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
            return false;//new Driver();
        }//tryerrr

    }

    public static String GetQuery(String username, String password) {
        String query = "SELECT * FROM Drivers WHERE Registration = '" + username + "' AND password = '" + password + "';";
        return query;
    }

    public static Driver GetDriver() {
        if (!"".equals(getRegistration())) {
            Connection con;
            Statement state;
            ResultSet rs;

            Properties p;
            p = new Properties();

            try {

                Class.forName(p.Driver());
                con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
                state = con.createStatement();
                String query = GetQuery(getRegistration(), getPassword());
                if (query.length() > 0) {

                    rs = state.executeQuery(query);

                    String reg = "";
                    String name = "";
                    String pass = "";
                    int rowCount = 0;

                    while (rs.next()) {
                        rowCount = rowCount + 1;
                        reg = rs.getString("Registration");
                        name = rs.getString("Name");
                        pass = rs.getString("password");
                    }

                    rs.close();
                    state.close();
                    con.close();

                    if (rowCount == 1) {
                        return new Driver(reg, name, pass);
                    } else {
                        return new Driver();
                    }
                } else {
                        return new Driver();
                }

            } catch (Exception e) {
                System.err.println("Error: " + e);
            }//tryerrr
                    }
        return new Driver();
    }

}
