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
    
    //create statements
    
    String CreatePokemonTable = "CREATE TABLE POKEMON "
    + "(ID			INT			NOT NULL, "
    + "Name			VARCHAR(20)		NOT NULL, "
    + "Weight			DECIMAL			NOT NULL, "
    + "Height			DECIMAL			NOT NULL, "
    + "Type1			INT			NOT NULL, "
    + "Type2			INT, "
    + "HabitatID		INT			NOT NULL, "
    + "PRIMARY KEY(ID), "
    + "FOREIGN KEY(Type1) REFERENCES TYPES(TypeID), "
    + "FOREIGN KEY(Type2) REFERENCES TYPES(TypeID), "
    + "FOREIGN KEY(HabitatID) REFERENCES HABITATS(HabitatID) "
    + ")";

    String CreateTypeTable = "CREATE TABLE TYPES "
    + "TypeID			INT			NOT NULL, "
    + "Name			VARCHAR(20)		NOT NULL, "
    + "PRIMARY KEY(TypeID) "
    + ")";

    String CreateEvolutionTable = "CREATE TABLE EVOLUTIONS "
    + "(BabyID			INT			NOT NULL, "
    + "EvolvedID		INT			NOT NULL, "
    + "Method			VARCHAR(20)		NOT NULL, "
    + "PRIMARY KEY(BabyID, EvolvedID), "
    + "FOREIGN KEY(BabyID) REFERENCES POKEMON(ID), "
    + "FOREIGN KEY(EvolvedID) REFERENCES POKEMON(ID) "
    + ")";

    String CreateTypeRelations = "CREATE TABLE TYPERELATIONS "
    + "(AttackerTypeID		INT			NOT NULL, "
    + "DefenderTypeID		INT			NOT NULL, "
    + "Multiplier		DECIMAL			NOT NULL, "
    + "PRIMARY KEY(AttackerTypeID, DefenderTypeID), "
    + "FOREIGN KEY(AttackerTypeID) REFERENCES TYPES(TypeID), "
    + "FOREIGN KEY(DefenderTypeID) REFERENCES TYPES(TypeID) "
    + ")";

    String CreateTableSprites = "CREATE TABLE SPRITES "
    + "(PokemonID		INT			NOT NULL, "
    + "Picture			BLOB			NOT NULL, "
    + "ShinyPicture		BLOB, "
    + "PRIMARY KEY(PokemonID) "
    + ")";

    String CreateTableStats = "CREATE TABLE STATS "
    + "PokemonID		INT			NOT NULL, "
    + "HP			INT			NOT NULL, "
    + "Atk			INT			NOT NULL, "
    + "Def			INT 			NOT NULL, "
    + "SpAtk			INT			NOT NULL, "
    + "SpDef			INT			NOT NULL, "
    + "Spd			INT			NOT NULL, "
    + "PRIMARY KEY(PokemonID) "
    + ")";

    String CreateHabitatTable = "CREATE TABLE HABITATS "
    + "(HabitatID		INT			NOT NULL, "
    + "Name			VARCHAR(20)		NOT NULL, "
    + "Description		VARCHAR(50)		NOT NULL, "
    + "PRIMARY KEY(HabitatID) "
    + ")";
    
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
