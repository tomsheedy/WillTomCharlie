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
import java.sql.Statement;
import java.sql.Time;

/**
 *
 * @author t2-sheedy
 */
public class PriceList {
    
    public int PriceListID;
    public int Distance;
    public double Price;

    public PriceList() {
    }
    
    

    public int getPriceListID() {
        return PriceListID;
    }

    public void setPriceListID(int PriceListID) {
        this.PriceListID = PriceListID;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int Distance) {
        this.Distance = Distance;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    
    
    
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
    
    public String GetWriteToDBQuery() {

        int dist = getDistance();
        double price = getPrice();
        
        String query = "";
        query = query + "INSERT INTO PriceList";
        query = query + " (`Distance`, `Price`)";
        query = query + " VALUES";
        query = query + " (" + dist + "," + price + ");";

        return query;
    }

    // </editor-fold>
    
    
}
