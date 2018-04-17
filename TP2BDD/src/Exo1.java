import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exo1 {
	
	
	
	
	private static void createTable(Statement enonce) throws SQLException
	{
		
		try{
			int res1 = enonce.executeUpdate("CREATE TABLE groupes" 
					+ "( idgroupe NUMBER NOT NULL," 
					+ "nomgroupe VARCHAR(50) default NULL," 
					+ "commentairegroupe VARCHAR(150) default NULL," 
					+ "PRIMARY KEY(idgroupe)) "
			);
			
			int res2 = enonce.executeUpdate("CREATE TABLE personnes" 
					+ "( idpersonne NUMBER NOT NULL," 
					+ "nompersonne VARCHAR(50) default NULL," 
					+ "prenompersonne VARCHAR(50) default NULL," 
					+ "datenaisspersonne DATE default NULL, "
					+ "coeffpersonne NUMBER default NULL, "
					+ "PRIMARY KEY(idpersonne)) "
			);
			
			int res3 = enonce.executeUpdate("CREATE TABLE grppers" 
					+ "( idgrppers NUMBER NOT NULL," 
					+ "idgroupe NUMBER default NULL," 
					+ "idpersonne NUMBER default NULL," 
					+ "PRIMARY KEY(idgrppers), "
					+ "coeffpersonne NUMBER default NULL, "	
					+ "CONSTRAINT fk01 FOREIGN KEY(idpersonne) REFERENCES personnes(idpersonne),"	
					+ "CONSTRAINT fk02 FOREIGN KEY(idgroupe) REFERENCES groupes(idgroupe))"							
			);
			
			
			System.out.print("Je suis juste apres les create lol");
			System.out.print(res1);
			System.out.print(res2);
			System.out.print(res3);
			
			if( res1 != 0 && res2 != 0 && res3 != 0){
				System.out.print("0K");
			}
		}
		catch(java.sql.SQLSyntaxErrorException e){
			e.printStackTrace();
			enonce.executeUpdate("DROP TABLE grppers"); 
			enonce.executeUpdate("DROP TABLE groupes"); 
			enonce.executeUpdate("DROP TABLE personnes"); 

			
		}
		
			
	}
	
	private static void insertTable(Statement enonce) throws SQLException
	{
		
		/*int res1 = enonce.executeUpdate("INSERT INTO groupes" 
				+ "( idgroupe , nomgroupe , commentairegroupe )" 
				+ "VALUES" 
				+ "(1,'groupe1',NULL)"
		);
		
		int res2 = enonce.executeUpdate("INSERT INTO groupes" 
				+ "( idgroupe , nomgroupe , commentairegroupe )" 
				+ "VALUES" 
				+ "(2,'groupe 2', NULL) "
		);*/
		
		//INSERER ICI UN ALTER SESSION !!!
		enonce.executeUpdate("ALTER SESSION set NLS_DATE_FORMAT = 'YYYY-MM-DD'");
		
		/*int res3 = enonce.executeUpdate("INSERT INTO personnes" 
				+ "( idpersonne,nompersonne,prenompersonne,datenaisspersonne,coeffpersonne )" 
				+ "VALUES" 
				+ "(1,'nom1','prenom1','1967-01-06',123) "
		);
		int res4= enonce.executeUpdate("INSERT INTO personnes" 
				+ "( idpersonne,nompersonne,prenompersonne,datenaisspersonne,coeffpersonne )" 
				+ "VALUES" 
				+ "(2,'nom2','prenom2','1973-08-11',34) "
		);
		int res5 = enonce.executeUpdate("INSERT INTO personnes" 
				+ "( idpersonne,nompersonne,prenompersonne,datenaisspersonne,coeffpersonne )" 
				+ "VALUES" 
				+ "(3,'nom3','prenom3','1956-04-28',145) "
		);
		int res6 = enonce.executeUpdate("INSERT INTO personnes" 
				+ "( idpersonne,nompersonne,prenompersonne,datenaisspersonne,coeffpersonne )" 
				+ "VALUES" 
				+ "(4,'nom4','prenom4','1980-12-02',23) "
		);
		int res7 = enonce.executeUpdate("INSERT INTO personnes" 
				+ "( idpersonne,nompersonne,prenompersonne,datenaisspersonne,coeffpersonne )" 
				+ "VALUES" 
				+ "(5,'nom5','prenom5','1966-10-13',119) "
		);
		
		int res8 = enonce.executeUpdate("INSERT INTO grppers" 
				+ "( idgrppers,idgroupe,idpersonne )" 
				+ "VALUES" 
				+ "(1,1,1) "
		);
		
		int res9 = enonce.executeUpdate("INSERT INTO grppers" 
				+ "( idgrppers,idgroupe,idpersonne )" 
				+ "VALUES" 
				+ "(2,2,2) "
		);
		int res10 = enonce.executeUpdate("INSERT INTO grppers" 
				+ "( idgrppers,idgroupe,idpersonne )" 
				+ "VALUES" 
				+ "(3,2,3) "
		);
		int res11 = enonce.executeUpdate("INSERT INTO grppers" 
				+ "( idgrppers,idgroupe,idpersonne )" 
				+ "VALUES" 
				+ "(4,1,4) "
		);
		int res12 = enonce.executeUpdate("INSERT INTO grppers" 
				+ "( idgrppers,idgroupe,idpersonne )" 
				+ "VALUES" 
				+ "(5,1,5) "
		);*/
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub


	    	  
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            String url="jdbc:oracle:thin:\"cspecq1\"/31031995@192.168.22.60:1521:orcl2";

	            Connection maCo=null;

	            //Connection co = DriverManager.getConnection(url,usr,pwd);
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
	
	           // createTable(enonce);
	           //insertTable( enonce);
	            
	            add(maCo);
	            
	            
	            
	 }

	private static void add(Connection maCo) throws SQLException {

		/*int res3 = enonce.executeUpdate("INSERT INTO personnes" 
				//+ "( idpersonne,nompersonne,prenompersonne,datenaisspersonne,coeffpersonne )" 
				+ "VALUES" 
				+ "(?,?,?,?) "
		);*/
		
		PreparedStatement ps = maCo.prepareStatement("INSERT INTO personnes" 
				//+ "( idpersonne,nompersonne,prenompersonne,datenaisspersonne,coeffpersonne )" 
				+ "VALUES" 
				+ "(?,?,?,?)");
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Entree nom personne :");
		String nomPersonne = sc.nextLine();
		ps.setString(1, nomPersonne);
		
		
		System.out.println("Entree prenom personne :");
		String prenomPersonne = sc.nextLine();
		ps.setString(2, prenomPersonne);

		
		System.out.println("Entree date personne :");
		String datePersonne = sc.nextLine();
		ps.setString(3, datePersonne);

		
		System.out.println("Entree coef personne :");
		String coeffPersonne = sc.nextLine();
		ps.setString(4, coeffPersonne);
		
		ps.executeUpdate();
		
	}

	     

}

