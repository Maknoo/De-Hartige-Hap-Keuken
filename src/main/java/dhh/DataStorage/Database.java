package dhh.DataStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    Connection con = null;
    PreparedStatement currentStatement = null;
    ResultSet result = null;
   
    String url = "jdbc:mysql://145.48.6.147:3306/ivp4a";
    String user = "root";
    String password = "10ec4u";
    
    
    public boolean openConnection()
    {
        try {
            con = DriverManager.getConnection(url, user, password);
            if(con != null)
                return true;
            else
                return false; 
        } 
        
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public void closeConnection()
    {
        try {
            con.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ResultSet executeSelectionStatement(String query)
    {
        result = null;
        
        try {
            currentStatement = con.prepareStatement(query);
            result = currentStatement.executeQuery();  
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
    
    public ResultSet executeInsertStatement(String query)
    {
        result = null;
        
        try {
            currentStatement = con.prepareStatement(query);
            result = currentStatement.executeQuery();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
    
    public int executeUpdateStatement(String query) //iemand moet hier nog ff naar kijken, hij kijkt nu hoeveel queries er geupdate zijn
    {
        int result = 0;
        
        try {
            currentStatement = con.prepareStatement(query);
            result = currentStatement.executeUpdate();  
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
    
    public ResultSet executeDeleteStatement(String query)
    {
        result = null;
        
        try {
            currentStatement = con.prepareStatement(query);
            result = currentStatement.executeQuery();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
}