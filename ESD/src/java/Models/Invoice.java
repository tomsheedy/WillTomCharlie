/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

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

}
