// Author: Kyle Busdieker
// Purpose: Retrieves a pokemon sprite or shiny sprite from the Pokebase database as a byte[]

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class RetrieveSprite {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	InputStream is = null;
	InputStream iss = null;
	OutputStream os = null;
	byte[] sprite = null;
	byte[] shinySprite = null;
	
	// Retrieves a pokemon's sprite from the Pokebase database as a byte[]
	public byte[] retrieveSprite (int pokemonID) throws Exception{
	
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:Pokebase.db");
			
			String query = "select picture from sprites where pokemonid = " + pokemonID;
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()){
				sprite = rs.getBytes(1);
			}
			
			return sprite;
			
		} finally{
			con.close();
		}

	}
	
	// Retrieves a pokemon's shiny sprite from the Pokebase database as byte[]
	public byte[] retrieveShinySprite (int pokemonID) throws Exception {
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:Pokebase.db");
			
			String query = "select shinypicture from sprites where pokemonid = " + pokemonID;
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				shinySprite = rs.getBytes(1);
			}
			
			return shinySprite;
		} finally{
			con.close();
		}
	}

}
