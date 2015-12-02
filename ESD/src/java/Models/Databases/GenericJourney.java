/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Databases;

/**
 *
 * @author h2-standal
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class GenericJourney extends DatabaseTables {

    // <editor-fold desc="Constructor">
    public GenericJourney() {
        columns = new ArrayList<String>();
        columnEntries = new ArrayList<String>();
        
        columns.add("ID");
        columns.add("Destination");
        columns.add("Distance");
        columns.add("Customer.id");
        columns.add("Drivers.Registration");
        columns.add("Date");
        columns.add("Time");
        
        table = "Journey";
    }



    // </editor-fold>
    public  String GetQuery() {
        String query = "SELECT * FROM " + table + " WHERE " + columns.get(0) + " =" + columnEntries.get(0) + "';";
        return "";
    }
    
    public String GetListQuery() {
        String query = "";
        query = query + "SELECT * FROM " + table + " WHERE Date LIKE '%2015-10-14%' ";
        
        for (String column : columns) {
            if(!column.equals("Date")){
                query = query + " AND '" + column + "' LIKE '%" + "" + "%'";
            }
        }
        return query;
    }
}

