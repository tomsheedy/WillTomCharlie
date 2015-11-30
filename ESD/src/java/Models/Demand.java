/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Database.Properties;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author a2-painter
 */
public class Demand {

    private int id;
    private String name;
    private String address;
    private String destination;
    private Date date;
    private Time time;
    private String status;

    public Demand(int id, String name, String address, String destination) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.destination = destination;
    }
    
    public Demand(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addBooking() {
        Connection con;
        Statement state;

        Properties p = new Properties();

        try {
            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = getInsertQuery();

            state.executeUpdate(query);
            state.close();
            con.close();
        } catch (Exception e) {

        }

    }

    public ArrayList<Demand> list() {

        ArrayList<Demand> results = new ArrayList<Demand>();

        Connection con;
        Statement state;
        ResultSet rs;

        Properties p = new Properties();

        try {

            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetListQuery();

            if (!"".equals(query)) {

                rs = state.executeQuery(query);

                int id = -1;
                String nam = "";
                String add = "";
                String destination = "";

                while (rs.next()) {
                    nam = rs.getString("Name");
                    add = rs.getString("Address");
                    destination = rs.getString("Destination");

                    Demand d = new Demand(id, nam, add, destination);
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

    private String getInsertQuery() {
        String query = "";

        String nam = getName();
        String add = getAddress();
        String dest = getDestination();
        Date dt = getDate();
        Time tim = getTime();
        String status = getStatus();

        query = query + "INSERT INTO Demands";
        query = query + " (Name, Address, Destination, Date, Time, Status)";
        query = query + " VALUES";
        query = query + " ('" + nam + "','" + add + "','" + dest + "'"
                + ",'" + dt + "','" + tim + "','" + status + "');";

        return query;
    }

    public String GetListQuery() {

        String nam = getName();
        String add = getAddress();

        if (nam != null) {
        } else {
            nam = "";
        }
        if (add != null) {
        } else {
            add = "";
        }

        String query = "";
        query = query + "SELECT * FROM Demands";
        query = query + " WHERE Name LIKE '%" + nam + "%'";
        query = query + " AND Address LIKE '%" + add + "%';";

        return query;
    }

}
