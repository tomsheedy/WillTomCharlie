/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import static Controllers.Authenticator.GetQuery;
import Database.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author t2-sheedy
 */
public class Driver {

    private String Registration;
    private String Name;
    private String Password;

    // <editor-fold desc="Constructor">
    public Driver() {

    }

    public Driver(String reg) {
        this.Registration = reg;
        GetDetail();
    }

    public Driver(String reg, String name, String pass) {
        this.Registration = reg;
        this.Name = name;
        this.Password = pass;
    }

    // </editor-fold>
    // <editor-fold desc="Properties">
    public String getRegistration() {
        return Registration;
    }

    public void setRegistration(String Registration) {
        this.Registration = Registration;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    // </editor-fold>
    // <editor-fold desc="GetDetail">
    public Driver GetDetail() {
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

    // </editor-fold>
    // <editor-fold desc="List">
    public ArrayList<Driver> List() {

        ArrayList<Driver> results = new ArrayList<Driver>();

        Connection con;
        Statement state;
        ResultSet rs;

        Properties p;
        p = new Properties();

        try {

            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetListQuery();

            if (!"".equals(query)) {

                rs = state.executeQuery(query);

                String reg = "";
                String name = "";
                String pass = "";

                while (rs.next()) {
                    reg = rs.getString("Registration");
                    name = rs.getString("Name");
                    pass = rs.getString("password");
                    Driver d = new Driver(reg, name, pass);
                    results.add(d);
                }

                rs.close();
                state.close();
                con.close();

                return results;
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
        };
        return results;
    }

    // </editor-fold>
    // <editor-fold desc="WriteToDB">
    public boolean WriteToDB() {

        Connection con;
        Statement state;

        Properties p;
        p = new Properties();
        
        boolean result = false;
        

        try {

            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetWriteToDBQuery();

            state.executeUpdate(query);
            
            result = true;
            
            state.close();
            con.close();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        };
        return result;
    }

    // </editor-fold>
    // <editor-fold desc="Update">
    public boolean Update() {

        Connection con;
        Statement state;

        Properties p;
        p = new Properties();

        try {

            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetUpdateQuery();

            if (!"".equals(query)) {

                state.executeUpdate(query);

                state.close();
                con.close();

                return true;
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
        };
        return false;
    }

    // </editor-fold>
    // <editor-fold desc="Delete">
    public boolean Delete() {
        Connection con;
        Statement state;
        Properties p;
        p = new Properties();

        try {
            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetDeleteQuery();

            if (!"".equals(query)) {
                state.executeUpdate(query);
                state.close();
                con.close();

                return true;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        
        return false;
    }
    // </editor-fold>
    // <editor-fold desc="DB">

    public String GetLogInQuery(String username, String password) {
        String query = "SELECT * FROM Drivers WHERE Registration = '" + username + "' AND password = '" + password + "';";
        return query;
    }

    public String GetListQuery() {

        String reg = getRegistration();
        String nam = getName();
        String pas = getPassword();

        if (reg != null) {
        } else {
            reg = "";
        }
        if (nam != null) {
        } else {
            nam = "";
        }
        if (pas != null) {
        } else {
            pas = "";
        }

        String query = "";
        query = query + "SELECT * FROM Drivers";
        query = query + " WHERE Registration LIKE '%" + reg + "%'";
        query = query + " AND Name LIKE '%" + nam + "%'";
        query = query + " AND password LIKE '%" + pas + "%';";

        return query;
    }

    public String GetWriteToDBQuery() {

        String reg = getRegistration();
        String nam = getName();
        String pas = getPassword();

        if (reg != null) {
        } else {
            return "";
        }
        if (nam != null) {
        } else {
            nam = "";
        }
        if (pas != null) {
        } else {
            pas = "";
        }

        String query = "";

        query = query + "INSERT INTO Drivers";
        query = query + " (Registration, Name, password)";
        query = query + " VALUES";
        query = query + " ('" + reg + "','" + nam + "','" + pas + "');";

        return query;
    }

    public String GetUpdateQuery() {

        String reg = getRegistration();
        String nam = getName();
        String pas = getPassword();

        if (reg != null) {
        } else {
            return "";
        }
        if (nam != null) {
        } else {
            nam = "";
        }
        if (pas != null) {
        } else {
            pas = "";
        }

        String query = "";

        query = query + "UPDATE Drivers";
        query = query + " SET Registration = '" + reg + "', Name = '" + nam + "', password = '" + pas + "'";
        query = query + " WHERE Registration = '" + reg + "';";

        return query;
    }

    public String GetDeleteQuery() {

        String reg = getRegistration();

        if (reg != null) {
        } else {
            return "";
        }

        String query = "";

        query = query + "DELETE FROM Drivers";
        query = query + " WHERE Registration = '" + reg + "';";

        return query;
    }

    // </editor-fold>
    // <editor-fold desc="Custom">
    public boolean LogIn() {

        Connection con;
        Statement state;
        ResultSet rs;

        Properties p;
        p = new Properties();

        try {

            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetLogInQuery(getRegistration(), getPassword());
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
    // </editor-fold>

}
