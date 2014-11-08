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

	public static void main(String[] args) throws Exception{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InputStream is = null;
		InputStream iss = null;
		OutputStream os = null;
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:Pokebase.db");
			
			String query = "select pokemonid, picture, shinyPicture from sprites where pokemonid = 114";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()){
				int id = rs.getInt(1);
				byte[] pic = rs.getBytes(2);
				
				is = new ByteArrayInputStream(pic);
				
				BufferedImage dbImage = ImageIO.read(is);
				
				frame.getContentPane().setLayout(new FlowLayout());
				frame.getContentPane().add(new JLabel(new ImageIcon(dbImage)));
				frame.pack();
				
			}
			
		} finally{
			con.close();
		}

	}

}
