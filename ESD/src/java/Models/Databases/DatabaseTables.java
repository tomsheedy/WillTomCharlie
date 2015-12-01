/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Databases;

import Database.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author t2-sheedy
 */
public class DatabaseTables {

    ArrayList<String> columns;
    ArrayList<String> entries;
    String table;

    // <editor-fold desc="Constructor">
    public DatabaseTables() {
        columns = new ArrayList<String>();
        entries = new ArrayList<String>();
    }

    public DatabaseTables(String reg) {
        this.entries.add(reg);
        //GetDetail();
    }

    public DatabaseTables(ArrayList<String> entry) {
        this.entries = entry;
    }

    // </editor-fold>
    // <editor-fold desc="Properties">
    public ArrayList<String> getEntry() {
        return entries;
    }

    public void setVariables(ArrayList<String> entry) {
        this.entries = entry;
    }

//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String Name) {
//        this.Name = Name;
//    }
//
//    public String getPassword() {
//        return Password;
//    }
//
//    public void setPassword(String Password) {
//        this.Password = Password;
//    }

    // </editor-fold>
    // <editor-fold desc="GetDetail">
    public DatabaseTables GetDetail() throws SQLException {
        if (!entries.isEmpty()) {
            Connection con;
            Statement state;
            ResultSet rs;
            String query = "";
            
            Properties p;
            p = new Properties();

            try {

                Class.forName(p.Driver());
                con = DriverManager.getConnection(p.URL(), p.Username(), p.Password());
                state = con.createStatement();
                query = GetQuery();
                if (query.length() > 0) {

                    rs = state.executeQuery(query);

                    String reg = "";
                    String name = "";
                    String pass = "";
                    int rowCount = 0;


                    for(String column:columns){
                        entries.add(rs.getString(column));
                    }

                    rs.close();
                    state.close();
                    con.close();

                    if (!entries.isEmpty()) {
                        setVariables(entries);
                        return new DatabaseTables(entries);
                    } else {
                        return new DatabaseTables();
                    }
                
                } else {
                    return new DatabaseTables();
                }

            } catch (Exception e) {
                System.err.println("Error: " + e);
            }//tryerrr
        }
        return new DatabaseTables();
    }

    // </editor-fold>
    // <editor-fold desc="List">
    public ArrayList<DatabaseTables> List() {

        ArrayList<DatabaseTables> results = new ArrayList<DatabaseTables>();

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

            if  (query.length() > 0){

                rs = state.executeQuery(query);

                String reg = "";
                String name = "";
                String pass = "";

                while (rs.next()) {
                    entries.clear();

                    for (String label : columns) {
                        entries.add(rs.getString(label));
                    }
//                    entries.add(rs.getString(label));
//                    entries.add(name = rs.getString("Name"));
//                    entries.add(pass = rs.getString("password"));
                    DatabaseTables d = new DatabaseTables(entries);
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

//    public String GetListQuery() {
//
////        String reg = getRegistration();
////        String nam = getName();
////        String pas = getPassword();
//
////        if (reg != null) {
////        } else {
////            reg = "";
////        }
////        if (nam != null) {
////        } else {
////            nam = "";
////        }
////        if (pas != null) {
////        } else {
////            pas = "";
////        }
//
//        String query = "";
//        query += "SELECT * FROM " + table;
//        query += query + " WHERE " + "Date" + " LIKE '%" + "2015-10-14" + "%'";
//        
//        for(int i = 1; i < columns.size(); i++) {
//            query = query + " AND " + columns.get(i) + "LIKE '%" + entries.get(i) + "%'";
//        }
//        
//        
//        
////        query = query + " WHERE Registration LIKE '%" + reg + "%'";
////        query = query + " AND Name LIKE '%" + nam + "%'";
////        query = query + " AND password LIKE '%" + pas + "%';";
//
//        return query;
//    }

    public String GetWriteToDBQuery() {


        String query = "";

        query = query + "INSERT INTO " +table;
        query = query + " (" + columns.get(0) +", " + columns.get(1) + ", " + columns.get(2) + ")";
        query = query + " VALUES";
        query = query + " (" + entries.get(0) +", " + entries.get(1) + ", " + entries.get(2) + ")";

        return query;
    }

    public String GetUpdateQuery() {

//        String reg = getRegistration();
//        String nam = getName();
//        String pas = getPassword();
//
//        if (reg != null) {
//        } else {
//            return "";
//        }
//        if (nam != null) {
//        } else {
//            nam = "";
//        }
//        if (pas != null) {
//        } else {
//            pas = "";
//        }

        String query = "";

        query = query + "UPDATE " +table;
        //query = query + " SET " + columns.get(0) + "= '" + entries.get(0) + "', " + columns.get(1) + "= '" + entries.get(1) + "', " + columns.get(2) + "= '" + entries. + ")";
        for (int i = 1; i < columns.size(); i++) {
            query += "', " + columns.get(i) + "= '" + entries.get(i);
        }
        //query = query + " SET Registration = '" + reg + "', Name = '" + nam + "', password = '" + pas + "'";
        query += "'";

        query = query + " WHERE columns.get(0) = '" + entries.get(0) + "';";

        return query;
    }

    public String GetDeleteQuery() {


//        if (reg != null) {
//        } else {
//            return "";
//        }

        String query = "";

        query = query + "DELETE FROM " +table;
        query = query + " WHERE " + columns.get(0) + " = '" + entries.get(0) + "';";

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
            String query = GetLogInQuery("admin", "adminadmin");
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
    public String GetQuery() {
        String query = "SELECT * FROM " + table + " WHERE " + columns.get(0) + " =" + entries.get(0) + "';";
        return query;
    }
    
    public String GetListQuery() {
        String query = "";
        query = query + "SELECT * FROM " + table + " WHERE Date LIKE '%2015-10-14%' ";
        
        for (String column : columns) {
            if(!column.equals("Date")){
                query = query + " AND '" + column + "' LIKE '%" + "" + "%'";
            }
        }
        query += ";";
//        query = query + " WHERE Registration LIKE '%" + reg + "%'";
//        query = query + " AND Name LIKE '%" + nam + "%'";
//        query = query + " AND password LIKE '%" + pas + "%';";
        return query;
    }

}
