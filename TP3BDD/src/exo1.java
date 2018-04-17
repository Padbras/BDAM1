import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class exo1 {

	
	private static void insertTable(Statement enonce) throws SQLException
	{
		enonce.executeUpdate("ALTER SESSION set NLS_DATE_FORMAT = 'HH24:MI'");
		
		int res1 = enonce.executeUpdate("INSERT INTO vol"  
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('AF118', '08:30', '10:57','Paris','Athens')"
		);
		
		int res2 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "( 'AF212','09:21','14:10','Paris','Moscow') "
		);
		
		
		int res3 = enonce.executeUpdate("INSERT INTO vol"  
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('AF178','12:56','14:15','Paris','London') "
		);
		int res4= enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('AF010','07:53','14:19','Paris',' New York') "
		);
		int res5 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('AF012','07:58','20:10','Paris','Los Angeles') "
		);
		int res6 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('AF001','22:10','12:00','Paris','Tahiti') "
		);
		int res7 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('SA854','22:00','10:14','Singapore','Athens') "
		);
		
		int res8 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('AA111','15:45','21:10','Beijing','Singapore') "
		);
		
		int res9 = enonce.executeUpdate("INSERT INTO vol"  
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('SA012','07:57','11:26','Sydney','Singapore') "
		);
		int res10 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('AF109','07:39','14:10','Tahiti','Sydney') "
		);
		int res11 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('AA517','23:57','07:12','Honolulu','Tokyo') "
		);
		int res12 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('JA014','15:35','19:00','Tokyo','Beijing') "
		);
		int res13 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('JA115','21:26','10:10','Los Angeles', 'Tokyo') "
		);
		int res14 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('AA015','20:50','07:00','New York', 'Lima') "
		);
		int res15 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('AA515','07:20','12:38', 'Lima', 'Los Angeles') "
		);
		int res16 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('AA516','15:20','21:38', 'Beijing','Athens') "
		);
		int res17 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('AF218','21:12','09:16','Beijing','Paris') "
		);
		int res18 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('AA118','07:15','13:10','New York', 'Paris') "
		);
		int res19 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('TA215','08:00','10:10','Tunis','Paris') "
		);
		int res20 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('OA005','14:20','17:00','Athens','Paris') "
		);
		int res21 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('PA022','10:12','23:55','Lima','Paris') "
		);
		int res22 = enonce.executeUpdate("INSERT INTO vol" 
				+ "( NumVol,Heure_depart,Heure_arrive,Ville_depart,Ville_arrivee )" 
				+ "VALUES" 
				+ "('AF002','15:52','00:12','Tokyo','Paris') "
		);
		
	}

	private static void createTable(Statement enonce) throws SQLException
	{
		
		try{
			int res1 = enonce.executeUpdate("CREATE TABLE vol" 
					+ "(NumVol VARCHAR(8)," 
					+ "Heure_depart DATE," 
					+ "Heure_arrive DATE," 
					+ "Ville_depart VARCHAR(20)," 
					+ "Ville_arrivee VARCHAR(20)," 	
					+ "PRIMARY KEY (NumVol)) "
			);
			
			System.out.print(res1);
			
		}
		catch(java.sql.SQLSyntaxErrorException e){
			e.printStackTrace();
			enonce.executeUpdate("DROP TABLE vol"); 	
		}			
	}
	

	public static void displaySelect(ResultSet resultat) throws SQLException
	{
		ResultSetMetaData rsmd = resultat.getMetaData();
		
		int nbColonnes = rsmd.getColumnCount();
		String entete = ""; 
		
		for(int i = 1; i <= nbColonnes; i++) 
		{
			String nomCol = rsmd.getColumnName(i);
			entete += nomCol + "\t";
			
		}
		
		System.out.println(entete);
		
		System.out.println(resultat.next());
		
		while(resultat.next())
		{
			
			for(int i = 1; i <= nbColonnes; i++) 
			{
				
				// pour un belle affichage une nintendo switch !!
				String nom = rsmd.getColumnName(i);
				System.out.print(resultat.getString(nom) + "\t");	
				
				
			}
			System.out.println("");
		}	
	}
	
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url="jdbc:oracle:thin:\"cspecq1\"/31031995@192.168.22.60:1521:orcl2";

        Connection maCo=null;

        try
        {
            maCo = DriverManager.getConnection(url);
        }catch (Exception e) 
        {
            System.out.println("pas de co");
        }
        if(maCo!=null)
        {
            System.out.println("connecté!");
        }


        
        Statement enonce = maCo.createStatement();
        createTable(enonce);
        insertTable(enonce);
        
        ResultSet result = enonce.executeQuery("SELECT * FROM vol");  
        
        displaySelect(result);
	}

}
