import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertSprites {

	public static void main(String[] args) {
		
		Connection c = null;
		PreparedStatement ps = null;
		InputStream is = null;
		InputStream iss = null;
		
		File pic = new File("C:/Pokemon_Sprites/aerodactyl.png");
		File shinyPic = new File("C:/Pokemon_Sprites/aerodactyl (1).png");
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:Pokebase.db");
			
			is = new FileInputStream(pic);
			iss = new FileInputStream(shinyPic);
			
			ps = c.prepareStatement("insert into sprites (PokemonID, Picture, ShinyPicture) " + "values (?,?,?)");
			
			ps.setInt(1, 142);
			
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
