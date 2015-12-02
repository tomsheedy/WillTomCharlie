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
public class Invoice {

    public int CustomerID;
    public String CustomerName;
    public String DriverRegistration;
    public String DriverName;
    public String Pickup;
    public String Dropoff;
    public String Time;
    public String Date;
    public int Price;

    public int getCustomerID() {
        return CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getDriverRegistration() {
        return DriverRegistration;
    }

    public String getDriverName() {
        return DriverName;
    }

    public String getPickup() {
        return Pickup;
    }

    public String getDropoff() {
        return Dropoff;
    }

    public String getTime() {
        return Time;
    }

    public String getDate() {
        return Date;
    }

    public int getPrice() {
        return Price;
    }

    public Invoice(int CustomerID, String CustomerName, String DriverRegistration, String DriverName, String Pickup, String Dropoff, String Time, String Date, int Price) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.DriverRegistration = DriverRegistration;
        this.DriverName = DriverName;
        this.Pickup = Pickup;
        this.Dropoff = Dropoff;
        this.Time = Time;
        this.Date = Date;
        this.Price = Price;
    }


    public Invoice() {

    }

    public Invoice GetInvoice(int JourneyID) {
        Connection con;
        Statement state;
        ResultSet rs;

        Properties p;
        p = new Properties();

        try {

            Class.forName(p.Driver());
            con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
            state = con.createStatement();
            String query = GetQuery(JourneyID);
            if (query.length() > 0) {

                rs = state.executeQuery(query);

                int CustomerID = -1;
                String CustomerName = "";
                String DriverRegistration = "";
                String DriverName = "";
                String Pickup = "";
                String Dropoff = "";
                String Time = "";
                String Date = "";
                int Price = -1;
                
                int rowCount = 0;

                while (rs.next()) {
                    rowCount = rowCount + 1;
                    CustomerID = rs.getInt("CustomerID");
                    CustomerName = rs.getString("CustomerName");
                    DriverRegistration = rs.getString("DriverRegistration");
                    DriverName = rs.getString("DriverName");
                    Pickup = rs.getString("Pickup");
                    Dropoff = rs.getString("Dropoff");
                    Time = rs.getString("Time");
                    Date = rs.getString("Date");
                    Price = rs.getInt("Price");
                }

                rs.close();

                state.close();

                con.close();

                if (rowCount == 1) {
                    return new Invoice(CustomerID, CustomerName, DriverRegistration, DriverName, Pickup, Dropoff, Time, Date, Price);
                }
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }//tryerrr
        return null;
    }

    public String GetQuery(int JourneyID) {

        String query = "";
        query = "SELECT `Customer`.`id` as `CustomerID`,\n"
                + "`Customer`.`Name` as `CustomerName`,\n"
                + "`Drivers`.`Registration` as `DriverRegistration`,\n"
                + "`Drivers`.`Name` as `DriverName`,\n"
                + "`Customer`.`Address` as `Pickup`,\n"
                + "`Journey`.`Destination` as `Dropoff`,\n"
                + "`Journey`.`Time` as `Time`,\n"
                + "`Journey`.`Date` as `Date`,\n"
                + "`Journey`.`Distance` as `Price`\n"
                + "\n"
                + "FROM `Journey`\n"
                + "INNER JOIN `Customer`\n"
                + "ON `Customer`.`id` = `Journey`.`Customer.id`\n"
                + "INNER JOIN `Drivers`\n"
                + "ON `Drivers`.`Registration` = `Journey`.`Drivers.Registration`\n"
                + "WHERE `Journey`.`id` = " + JourneyID + ";";

        return query;
    }

}
