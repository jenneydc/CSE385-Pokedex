
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;


public class Main
{
	//dfhjkhh
	//Testing..1..2..3
	public static void main(String[] args) throws Exception
	{
        
        StandardQueries std = new StandardQueries();
        SearchPanel pane = new SearchPanel(std);
        
        JFrame frame = new JFrame();
        frame.setContentPane(pane);
        frame.pack();
        frame.setVisible(true);
        
	}

}
