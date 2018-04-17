import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class exo2 {
	
	private static void createTable(Statement enonce) throws SQLException
	{
		
		
		try{
			System.out.println("lol");
			int res1 = enonce.executeUpdate("CREATE TABLE Escales" 
					+ "(Num_escale INTEGER NOT NULL," 
					+ "Ville_escale VARCHAR(20),"  
					+ "Duree_escale_minimum VARCHAR(3)," 	
					+ "PRIMARY KEY (Num_escale)) "
			);
			
			System.out.print(res1);	
		}
		catch(java.sql.SQLSyntaxErrorException e){
			System.out.println("mdr");
			e.printStackTrace();
			enonce.executeUpdate("DROP TABLE Escales"); 	
		}			
	}


	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//chargement jdbc
				Class.forName("com.mysql.jdbc.Driver");
				Connection maCo = null;
				
			    try
	            {
			    	 maCo = DriverManager.getConnection("jdbc:mysql://192.168.22.48:3306/cspecq1", "cspecq1", "31031995");
	            }catch (Exception e) 
	            {
	                System.out.println("pas de co");
	            }
	            if(maCo!=null)
	            {
	                System.out.println("connecté!");
	            }

				
				//Connection à une bdd distante
				
				
				Statement enonce = maCo.createStatement();
				
				createTable(enonce);
				insertTable(enonce);

	}


	private static void insertTable(Statement enonce) {

		
		
		try {
			int res1 = enonce.executeUpdate("INSERT INTO Escales"  
					+ "(Num_escale,Ville_escale,Duree_escale_minimum)" 
					+ "VALUES" 
					+ "(1, 'Moscou', '5h')"
			);
			int res2 = enonce.executeUpdate("INSERT INTO Escales"  
					+ "(Num_escale,Ville_escale,Duree_escale_minimum)" 
					+ "VALUES" 
					+ "(2, 'Singapour', '5h')"
			);
			int res3 = enonce.executeUpdate("INSERT INTO Escales"  
					+ "(Num_escale,Ville_escale,Duree_escale_minimum)" 
					+ "VALUES" 
					+ "(3, 'Sydney', '4h')"
			);
			int res4 = enonce.executeUpdate("INSERT INTO Escales"  
					+ "(Num_escale,Ville_escale,Duree_escale_minimum)" 
					+ "VALUES" 
					+ "(4, 'Tahiti', '4h')"
			);
			int res5 = enonce.executeUpdate("INSERT INTO Escales"  
					+ "(Num_escale,Ville_escale,Duree_escale_minimum)" 
					+ "VALUES" 
					+ "(5, 'Honululu', '4h')"
			);
			int res6 = enonce.executeUpdate("INSERT INTO Escales"  
					+ "(Num_escale,Ville_escale,Duree_escale_minimum)" 
					+ "VALUES" 
					+ "(6, 'Los Angeles', '5h')"
			);
			int res7 = enonce.executeUpdate("INSERT INTO Escales"  
					+ "(Num_escale,Ville_escale,Duree_escale_minimum)" 
					+ "VALUES" 
					+ "(7, 'New York', '4h')"
			);
			int res8 = enonce.executeUpdate("INSERT INTO Escales"  
					+ "(Num_escale,Ville_escale,Duree_escale_minimum)" 
					+ "VALUES" 
					+ "(8, 'Beijing', '3h')"
			);
			int res9 = enonce.executeUpdate("INSERT INTO Escales"  
					+ "(Num_escale,Ville_escale,Duree_escale_minimum)" 
					+ "VALUES" 
					+ "(9, 'Lima', '3h')"
			);
			int res10 = enonce.executeUpdate("INSERT INTO Escales"  
					+ "(Num_escale,Ville_escale,Duree_escale_minimum)" 
					+ "VALUES" 
					+ "(10, 'London', '3h')"
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
