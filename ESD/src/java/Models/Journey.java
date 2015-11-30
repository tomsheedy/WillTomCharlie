/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Database.Properties;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author t2-sheedy
 */
public class Journey {

    private int ID;
    private String Destination;
    private int Distance;
    private int CustomerID;
    private String DriversRegistration;
    private Date Date;
    private Time Time;

    // <editor-fold desc="Constructor">
    public Journey() {

    }

    public Journey(int id) {
        this.ID = id;
        GetDetail();
    }

    public Journey(int id, String dest, int dist, int custID, String drivReg, Date date, Time time) {
        this.ID = id;
        this.Destination = dest;
        this.Distance = dist;
        this.CustomerID = custID;
        this.DriversRegistration = drivReg;
        this.Date = date;
        this.Time = time;
    }

    // </editor-fold>
    // <editor-fold desc="Properties">
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int Distance) {
        this.Distance = Distance;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getDriversRegistration() {
        return DriversRegistration;
    }

    public void setDriversRegistration(String DriversRegistration) {
        this.DriversRegistration = DriversRegistration;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public Time getTime() {
        return Time;
    }

    public void setTime(Time Time) {
        this.Time = Time;
    }

    // </editor-fold>
    // <editor-fold desc="GetDetail">
    public Journey GetDetail() {

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

                int id = -1;
                String dest = "";
                int dist = -1;
                int custID = -1;
                String drivReg = "";
                Date date = null;
                Time time = null;
                int rowCount = 0;

                while (rs.next()) {
                    rowCount = rowCount + 1;
                    id = rs.getInt("id");
                    dest = rs.getString("Destination");
                    dist = rs.getInt("Distance");
                    custID = rs.getInt("Customer.id");
                    drivReg = rs.getString("Drivers.Registration");
                    date = rs.getDate("Date");
                    time = rs.getTime("Time");
                }

                rs.close();
                state.close();
                con.close();

                if (rowCount == 1) {
                    return new Journey(id, dest, dist, custID, drivReg, date, time);
                } else {
                    return new Journey();
                }
            } else {
                return new Journey();
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }//tryerrr

        return new Journey();
    }

    // </editor-fold>
    // <editor-fold desc="List">
    public ArrayList<Journey> List() {

        ArrayList<Journey> results = new ArrayList<Journey>();

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

                int id = -1;
                String dest = "";
                int dist = -1;
                int custID = -1;
                String drivReg = "";
                Date date = null;
                Time time = null;
                int rowCount = 0;

                while (rs.next()) {
                    rowCount = rowCount + 1;
                    id = rs.getInt("id");
                    dest = rs.getString("Destination");
                    dist = rs.getInt("Distance");
                    custID = rs.getInt("Customer.id");
                    drivReg = rs.getString("Drivers.Registration");
                    date = rs.getDate("Date");
                    time = rs.getTime("Time");
                    results.add(new Journey(id, dest, dist, custID, drivReg, date, time));
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

    public String GetListQuery() {

        String dest = getDestination();
        int dist = getDistance();
        String distStr = "Distance";
        int custID = getCustomerID();
        String custIDStr = "Customers.id";
        String drivReg = getDriversRegistration();
        Date date = getDate();
        String dateStr = "";
        Time time = getTime();
        String timeStr = "";

        if (dest != null) {
        } else {
            dest = "";
        }
        if (drivReg != null) {
        } else {
            drivReg = "";
        }
        if (date != null) {
            dateStr = "'" + date.toString() + "'";
        } else {
        }
        if (time != null) {
            timeStr = "'" + time.toString() + "'";
        } else {
        }
        if (dist > 0) {
            distStr = Integer.toString(dist);
        } else {
        }
        if (custID > 0) {
            custIDStr = Integer.toString(custID);
        } else {
        }

        String query = "";
        query = query + "SELECT * FROM Journey";
        query = query + " WHERE Destination LIKE '%" + dest + "%'";
        query = query + " AND Distance = " + distStr;
        query = query + " AND Customer.id = " + custIDStr;
        query = query + " AND Drivers.Registration = '%" + drivReg + "%'";
        query = query + " AND Date = " + dateStr + "";
        query = query + " AND Time = " + timeStr + ";";

        return query;
    }

    public String GetWriteToDBQuery() {

        String dest = getDestination();
        int dist = getDistance();
        String distStr = "Distance";
        int custID = getCustomerID();
        String custIDStr = "Customers.id";
        String drivReg = getDriversRegistration();
        Date date = getDate();
        String dateStr = "";
        Time time = getTime();
        String timeStr = "";

        if (dest != null) {
        } else {
            dest = "";
        }
        if (drivReg != null) {
        } else {
            drivReg = "";
        }
        if (date != null) {
            dateStr = "'" + date.toString() + "'";
        } else {
        }
        if (time != null) {
            timeStr = "'" + time.toString() + "'";
        } else {
        }
        if (dist > 0) {
            distStr = Integer.toString(dist);
        } else {
        }
        if (custID > 0) {
            custIDStr = Integer.toString(custID);
        } else {
        }

        String query = "";
        query = query + "INSERT INTO Journey";
        query = query + " (Destination, Distance, Custromer.id, Drivers.Registration, Date, Time)";
        query = query + " VALUES";
        query = query + " ('" + dest + "'," + distStr + "," + custIDStr + ",'" + drivReg + "'," + dateStr + "," + timeStr + ");";

        return query;
    }

    public String GetUpdateQuery() {
        int id = getID();

        String dest = getDestination();
        int dist = getDistance();
        String distStr = "Distance";
        int custID = getCustomerID();
        String custIDStr = "Customers.id";
        String drivReg = getDriversRegistration();
        Date date = getDate();
        String dateStr = "";
        Time time = getTime();
        String timeStr = "";
        if (dest != null) {
        } else {
            dest = "";
        }
        if (drivReg != null) {
        } else {
            drivReg = "";
        }
        if (date != null) {
            dateStr = "'" + date.toString() + "'";
        } else {
        }
        if (time != null) {
            timeStr = "'" + time.toString() + "'";
        } else {
        }
        if (dist > 0) {
            distStr = Integer.toString(dist);
        } else {
        }
        if (custID > 0) {
            custIDStr = Integer.toString(custID);
        } else {
        }

        String query = "";
        if (id > 0) {

            query = query + "UPDATE Journey";
            query = query + " SET Destination = '" + dest + "', Distance = " + distStr + ", Custromer.id = " + custIDStr;
            query = query + ", Drivers.Registration = '" + drivReg + "', Date = " + dateStr + ", Time = " + timeStr + ";";
            query = query + " WHERE id = " + id + ";";

        }
        return query;
    }

    public String GetDeleteQuery() {

        String query = "";
        int id = getID();

        if (id > 0) {

            query = query + "DELETE FROM Journey";
            query = query + " WHERE id = " + id + ";";

        }

        return query;
    }

    public String GetDetailQuery() {

        int id = getID();

        String query = "";

        query = query + "SELECT * FROM Journey";
        query = query + " WHERE id = " + id + ";";

        return query;
    }

    // </editor-fold>
}
