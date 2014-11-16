import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Drew Jenney
 */
public class StandardQueries {
    
    Connection conn;
    
    public StandardQueries() throws ClassNotFoundException, SQLException {
        // register the driver 
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);
        String sDbUrl = "jdbc:sqlite:Pokebase.db";
        conn = DriverManager.getConnection(sDbUrl);
    }
    
    /* example of a query on the database
        Statement search = std.conn.createStatement();
        ResultSet Machoke = search.executeQuery(std.NameSearch+"'Machoke'");
        
        System.out.print(Machoke.getString("Name"));
        */
  
    /**
     * Searches the Pokemon table for the Pokemon with the specified name.
     * 
     * @param name		: the name of the Pokemon
     * @return
     */
    ResultSet searchName(String name) {
    	try {
    		Statement search = this.conn.createStatement();
        	String query = "SELECT * FROM Pokemon WHERE Name = " + "'" + name + "'";
        	
        	return search.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    /**
     * Searches the Pokemon table for the Pokemon with the specified number.
     * 
     * @param num		: the Pokemon number
     * @return
     */
    ResultSet searchNumber(int num) {
    	try {
    		Statement search = this.conn.createStatement();
        	String query = "SELECT * FROM Pokemon WHERE ID = " + num;
        	
        	return search.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    /**
     * Searches the Pokemon table for the Pokemon with the specified type.
     * 
     * @param type		: the Pokemon type
     * @return
     */
    ResultSet searchType(String type) {
    	try {
    		Statement search = this.conn.createStatement();
        	String query = "SELECT * "
        			+ "FROM Pokemon AS P, Types AS T "
        			+ "WHERE (P.Type1=T.TypeID OR P.Type2 = T.TypeID) AND "
        			+ "T.name = " + "'" + type + "'";
        	
        	return search.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    /**
     * Searches the Pokemon table for the Pokemon with the specified habitat.
     * 
     * @param type		: the Pokemon habitat
     * @return
     */
    ResultSet searchHabitat(String habitat) {
    	try {
    		Statement search = this.conn.createStatement();
        	String query = "SELECT * FROM Pokemon AS P, Habitats AS H "
        			+ "WHERE H.HabitatID = P.HabitatID "
        			+ "AND H.Name = " + "'" + habitat + "'";
        	
        	return search.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
}
