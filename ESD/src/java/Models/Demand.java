/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Database.Properties;
import java.sql.*;

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
            String query = "";
        } catch (Exception e) {

        }

    }
    
    private String getInsertQuery(){
        String query = "";
        
        String name = getName();
        String address = getAddress();
        String destination = getDestination();
        Date date = getDate();
        Time time = getTime();
        
        query = query + "INSERT INTO Demands";
        query = query + " (Name, Address, Destination, Date, Time, Status)";
        query = query + " VALUES";
        query = query + " ('" + name + "','" + address + "');";
        
        return query;
    }

}
