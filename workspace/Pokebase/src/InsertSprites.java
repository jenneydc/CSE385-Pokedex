// Author: Kyle Busdieker
// Purpose: Allows you to insert an image of a pokemon sprite into the Pokebase database


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertSprites {
	
	Connection c = null;
	PreparedStatement ps = null;
	InputStream is = null;
	InputStream iss = null;
	File pic = null;
	File shinyPic = null;
	int ID;
	String Name;
	
	// Used to insert an image file into the Pokebase database
	public void insert(int pokemonID, String pokemonName){
		
		ID = pokemonID;
		Name = pokemonName;
		
		pic = new File("C:/Pokemon_Sprites/" + Name + ".png");
		shinyPic = new File("C:/Pokemon_Sprites/" + Name +  " (1).png");
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:Pokebase.db");
			
			is = new FileInputStream(pic);
			iss = new FileInputStream(shinyPic);
			
			ps = c.prepareStatement("insert into sprites (PokemonID, Picture, ShinyPicture) " + "values (?,?,?)");
			
			ps.setInt(1, ID);
			
			ps.setBinaryStream(2, is, (int) (pic.length()));
			ps.setBinaryStream(3, iss, (int) (shinyPic.length()));
			
			ps.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) is.close();
				if (ps != null) ps.close();
				if (c != null) c.close();
			} catch (Exception e) {}
		}

	}

}
