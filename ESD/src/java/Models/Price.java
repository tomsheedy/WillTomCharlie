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
 * @author h2-standal
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Price {

    private int ID;
    private int Distance;
    private int Price;

    // <editor-fold desc="Constructor">
    public Price() {

    }

    public Price(int distance) {
        this.Distance = distance;
        GetDetail();
    }

    public Price(int distance, int name, int price) {
        this.ID = distance;
        this.Distance = name;
        this.Price = price;
    }
    
    public int getID() {
        return ID;
    }
               
    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int Distance) {
        this.Distance = Distance;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }


    // </editor-fold>
    // <editor-fold desc="GetDetail">
    public Price GetDetail() {
        if (!"".equals(getDistance())) {
            Connection con;
            Statement state;
            ResultSet rs;

            Properties p;
            p = new Properties();

            try {

                Class.forName(p.Driver());
                con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
                state = con.createStatement();
                String query = GetDetailQuery();
                if (query.length() > 0) {

                    rs = state.executeQuery(query);

                    int distance = -1;
                    int priceID = -1;
                    int price = -1;
                    int rowCount = 0;

                    while (rs.next()) {
                        rowCount = rowCount + 1;
                        distance = rs.getInt("PriceListID");
                        priceID = rs.getInt("Distance");
                        price = rs.getInt("Price");
                    }

                    rs.close();
                    state.close();
                    con.close();

                    if (rowCount == 1) {
                        return new Price(distance, priceID, price);
                    } else {
                        return new Price();
                    }
                } else {
                    return new Price();
                }

            } catch (Exception e) {
                System.err.println("Error: " + e);
            }//tryerrr
        }
        return new Price();
    }

    // </editor-fold>
    // <editor-fold desc="List">
    public ArrayList<Price> List() {

        ArrayList<Price> results = new ArrayList<Price>();

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

                int distance = -1;
                int priceID = -1;
                int price = -1;

                while (rs.next()) {
                    distance = rs.getInt("Registration");
                    priceID = rs.getInt("Name");
                    price = rs.getInt("password");
                    Price d = new Price(distance, priceID, price);
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
        };
        return false;
    }
    // </editor-fold>
    // <editor-fold desc="DB">

    public String GetLogInQuery(String username, String password) {
        String query = "SELECT * FROM Drivers WHERE Registration = '" + username + "' AND password = '" + password + "';";
        return query;
    }

    public String GetListQuery() {

//        int distance = getDistance();
//        int priceID = getID();
//        int price= getPrice();
//
//        if (distance != null) {
//        } else {
//            distance = "";
//        }
//        if (priceID != null) {
//        } else {
//            priceID = "";
//        }
//        if (price != null) {
//        } else {
//            price= "";
//        }
//
//        String query = "";
//        query = query + "SELECT * FROM Drivers";
//        query = query + " WHERE Registration LIKE '%" + distance + "%'";
//        query = query + " AND Name LIKE '%" + priceID + "%'";
//        query = query + " AND password LIKE '%" + price+ "%';";

        //return query;
        return "";
    }

    public String GetWriteToDBQuery() {

//        String distance = getDistance();
//        String priceID = getID();
//        String price= getPrice();
//
//        if (distance != null) {
//        } else {
//            return "";
//        }
//        if (priceID != null) {
//        } else {
//            priceID = "";
//        }
//        if (price != null) {
//        } else {
//            price= "";
//        }
//
//        String query = "";
//
//        query = query + "INSERT INTO Drivers";
//        query = query + " (Registration, Name, password)";
//        query = query + " VALUES";
//        query = query + " ('" + distance + "','" + priceID + "','" + price+ "');";

        //return query;
        return "";

    }

    public String GetUpdateQuery() {

//        String distance = getDistance();
//        String priceID = getID();
//        String price = getPrice();
//
//        if (distance != null) {
//        } else {
//            return "";
//        }
//        if (priceID != null) {
//        } else {
//            priceID = "";
//        }
//        if (price != null) {
//        } else {
//            price = "";
//        }
//
//        String query = "";
//
//        query = query + "UPDATE Drivers";
//        query = query + " SET Registration = '" + distance + "', Name = '" + priceID + "', password = '" + price + "'";
//        query = query + " WHERE Registration = '" + distance + "';";

        //return query;
        return "";

    }

    public String GetDeleteQuery() {

//        String distance = getID();
//
//        if (distance != null) {
//        } else {
//            return "";
//        }
//
//        String query = "";
//
//        query = query + "DELETE FROM PriceList";
//        query = query + " WHERE ID = '" + getID() + "';";
//
//        return query;
        return "";
    }

    public String GetDetailQuery() {

        int distance = getDistance();

        String query = "";

        query = query + "SELECT * FROM PriceList";
        query = query + " WHERE Distance = '" + distance + "';";

        return query;
    }
    // </editor-fold>
    // <editor-fold desc="Custom">
//    public boolean LogIn() {
//
//        Connection con;
//        Statement state;
//        ResultSet rs;
//
//        Properties p;
//        p = new Properties();
//
//        try {
//
//            Class.forName(p.Driver());
//            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
//            state = con.createStatement();
//            String query = GetLogInQuery(getRegistration(), getPassword());
//            if (query.length() > 0) {
//
//                rs = state.executeQuery(query);
//
//                String distance = "";
//                String priceID = "";
//                String pass = "";
//                int rowCount = 0;
//
//                while (rs.next()) {
//                    rowCount = rowCount + 1;
//                    distance = rs.getString("Registration");
//                    priceID = rs.getString("Name");
//                    pass = rs.getString("password");
//                }
//
//                rs.close();
//                state.close();
//                con.close();
//
//                if (rowCount == 1) {
//                    return true;//new Price(distance, name, pass);
//                } else {
//                    return false;//new Price();
//                }
//            } else {
//                return false;//new Price();
//            }
//
//        } catch (Exception e) {
//            System.err.println("Error: " + e);
//            return false;//new Price();
//        }//tryerrr
//
//    }
    // </editor-fold>

}
    

