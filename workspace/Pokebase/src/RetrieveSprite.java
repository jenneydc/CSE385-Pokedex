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


public class RetrieveSprite {

	public static void main(String[] args) throws Exception{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InputStream is = null;
		InputStream iss = null;
		OutputStream os = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:Pokebase.db");
			
			String query = "select pokemonid, picture, shinyPicture from sprites where pokemonid = 63";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()){
				int id = rs.getInt(1);
				byte[] pic = rs.getBytes(2);
				
				is = new ByteArrayInputStream(pic);
				
				
				File picture = new File("abra.png");
				FileOutputStream fos = new FileOutputStream(picture);
				
				
				// doesn't actually print anything out.... working on it
				is.read(pic);
				fos.write(pic);
			
				fos.close();
			}
			
		} finally{
			con.close();
		}

	}

}
