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
    + "Picture			IMAGE			NOT NULL, "
    + "ShinyPicture		IMAGE, "
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
    
    //search queries
    String NameSearch = "SELECT * "
            + "FROM Pokemon "
            + "WHERE Name = ";
    
    String TypeSearch = "SELECT * "
            + "FROM Pokemon AS P, Type AS T "
            + "WHERE (P.Type1=T.TypeID OR P.Type2 = T.TypeID) AND "
            + "T.TypeID = T.TypeName AND T.TypeName = ";
    
    String HabitatSearch = "SELECT * "
            + "FROM Pokemon AS P, Habitat AS H "
            + "WHERE H.HabitatID = P.HabitatID AND H.HabitatName = ";
    
    String NumberSearch = "SELECT * "
            + "FROM Pokemon "
            + "WHERE ID = ";
    
    
    
}