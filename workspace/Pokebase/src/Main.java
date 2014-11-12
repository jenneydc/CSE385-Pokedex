
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) throws Exception	{
        
        StandardQueries std = new StandardQueries();
        
        /*
        ResultSet set = std.searchHabitat("Grasslands");
        
        while (set.next()) {
        	System.out.println(set.getString("Id"));
        }
        */
       
       
        SearchPanel pane = new SearchPanel(std);
        
        JFrame frame = new JFrame();
        frame.setContentPane(pane);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        
	}
	
	// Inserts all sprites and shiny sprites for pokemon 1 through 151 (bulbasaur through mew)
	public static void insertingSprites() {
		// makes new object to call the insert method
		InsertSprites is = new InsertSprites();
		// fills an array with values 1 through 151
		// index 0 is unused in order to match up index values with pokemon id number
		int[] pokemonIDs = new int[152];
		pokemonIDs[0] = -1;
		for (int i = 1; i < 152; i++)
			pokemonIDs[i] = i;
		// fills an array with all the pokemon names
		// index 0 is unused in order to match up index values with pokemon id number
		String[] pokemonNames = new String[] {"not a pokemon", "bulbasaur", "ivysaur", "venusaur", "charmander",
				"charmeleon", "charizard", "squirtle", "wartortle", "blastoise", "caterpie", "metapod", "butterfree",
				"weedle", "kakuna", "beedrill", "pidgey", "pidgeotto", "pidgeot", "rattata", "raticate", "spearow",
				"fearow", "ekans", "arbok", "pikachu", "raichu", "sandshrew", "sandslash", "nidoran-f", "nidorina",
				"nidoqueen", "nidoran-m", "nidorino", "nidoking", "clefairy", "clefable", "vulpix", "ninetales",
				"jigglypuff", "wigglytuff", "zubat", "golbat", "oddish", "gloom", "vileplume", "paras", "parasect",
				"venonat", "venomoth", "diglett", "dugtrio", "meowth", "persian", "psyduck", "golduck", "mankey",
				"primeape", "growlithe", "arcanine", "poliwag", "poliwhirl", "poliwrath", "abra", "kadabra", "alakazam",
				"machop", "machoke", "machamp", "bellsprout", "weepinbell", "victreebel", "tentacool", "tentacruel",
				"geodude", "graverler", "golem", "ponyta", "rapidash", "slowpoke", "slowbro", "magnemite", "magneton",
				"farfetchd", "doduo", "dodrio", "seel", "dewgong", "grimer", "muk", "shellder", "cloyster", "gastly",
				"haunter", "gengar", "onix", "drowzee", "hypno", "krabby", "kingler", "voltorb", "electrode", "exeggcute",
				"exeggutor", "cubone", "marowak", "hitmonlee", "hitmonchan", "lickitung", "koffing", "weezing", "rhyhorn",
				"rhydon", "chansey", "tangela", "kangaskhan", "horsea", "seadra", "goldeen", "seaking", "staryu", "starmie",
				"mr-mime", "scyther", "jynx", "electabuzz", "magmar", "pinsir", "tauros", "magikarp", "gyarados","lapras",
				"ditto", "eevee", "vaporeon", "jolteon", "flareon", "porygon", "omanyte", "omastar", "kabuto", "kabutops", "aerodactyl",
				"snorlax", "articuno", "zapdos", "moltres", "dratini", "dragonair", "dragonite", "mewtwo", "mew"};
		
		// does the actual inserting of sprites
		for (int i = 0; i < 152; i++){
			is.insert(pokemonIDs[i], pokemonNames[i]);
		}
	}
		
}


