
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main
{
	//dfhjkhh
	//Testing..1..2..3
	public static void main(String[] args) throws Exception
	{
            // register the driver 
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);
        String sDbUrl = "jdbc:sqlite:Pokebase.db";
        Connection conn = DriverManager.getConnection(sDbUrl);
        
        StandardQueries std = new StandardQueries();
        
        Statement search = conn.createStatement();
        ResultSet Machoke = search.executeQuery(std.NameSearch+"'Machoke'");
        
        System.out.print(Machoke.getString("Name"));
        
	}

}
