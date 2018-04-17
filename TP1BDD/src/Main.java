import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner; 


// TP1 SPECQ PESTELLE

public class Main {

	
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, java.io.IOException {
		//chargement jdbc
		Class.forName("com.mysql.jdbc.Driver");
		
		//Connection à une bdd distante
		Connection maCo = DriverManager.getConnection("jdbc:mysql://192.168.22.48:3306/cspecq1", "cspecq1", "31031995");
		
		Statement enonce = maCo.createStatement();
		/*
		// QUESTION 1
		createTable(enonce);
		fillTable(enonce);
		
		
		// QUESTION 2
		questionTwo(enonce);
		
		// QUESTION 3
		questionThree(enonce, maCo);
		*/
		
		// QUESTION 4
		Scanner sc = new Scanner(System.in);
		System.out.println("Entree requete :");
		String req =sc.nextLine();
		
		
		if(req.substring(0, 5).equals("SELEC") ){
			ResultSet resultat = enonce.executeQuery(req);
			displaySelect(resultat);
		}
		
		if(req.substring(0, 5).equals("DELET")){
			int resultat = enonce.executeUpdate(req);
			displayDelete(resultat);
		}
		
		if(req.substring(0, 5).equals("UPDAT")){
			int resultat = enonce.executeUpdate(req);
			displayUpdate(resultat);
		}
			
		enonce.close();
		maCo.close();
	}


	private static void displayUpdate(int resultat) {
		if(resultat == 0){
			System.out.println("update non executé");
		}else{
			System.out.println("update bien executé");
		}
	}


	private static void displayDelete(int resultat) {
		if(resultat == 0){
			System.out.println("delete non executé");
		}else{
			System.out.println("delete bien executé");
		}

	}
	
	private static void questionTwo(Statement enonce) throws SQLException
	{
		ResultSet result = enonce.executeQuery("SELECT * FROM Produit");  
		
		System.out.println("Reference \t Designation \t Quantite \t TVA \t Prix_HT ");
		
		while(result.next())
		{		
			System.out.println(result.getInt("Reference") + "\t" 
			+ result.getString("Designation") + "\t" 
			+ result.getInt("Quantite") + "\t" 
			+ result.getDouble("TVA") + "\t" 
			+ result.getDouble("Prix_HT") );				
		}
	}
	
	private static void questionThree(Statement enonce, Connection maCo) throws SQLException{
		
		PreparedStatement ps = maCo.prepareStatement("SELECT *"
				+ " FROM Produit"
				+ " WHERE Prix_HT > ?");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Entree prix minimum :");
		double prix =Double.parseDouble(sc.nextLine());
		
		ps.setDouble(1, prix);
		
		ResultSet resultat = ps.executeQuery();
		
		System.out.println("Reference \t Designation \t Quantite \t TVA \t Prix_HT ");
		
		while(resultat.next()){	
			
			System.out.println(resultat.getInt("Reference") + "\t" 
					+ resultat.getString("Designation") + "\t" 
					+ resultat.getInt("Quantite") + "\t" 
					+ resultat.getDouble("TVA") + "\t" 
					+ resultat.getDouble("Prix_HT") );	
		}
	}

	
	private static void createTable(Statement enonce) throws SQLException
	{
		Boolean res = enonce.execute("CREATE TABLE Produit" 
				+ "( Reference INTEGER not NULL," 
				+ "Designation VARCHAR(50)," 
				+ "Quantite INTEGER," 
				+ "TVA DOUBLE, "
				+ "Prix_HT DOUBLE,"
				+ "PRIMARY KEY(Reference))");
				
				if(res = true){
					System.out.print("gg tu as crée une table !");
				}
	}
	
	private static  void fillTable(Statement enonce) throws SQLException{
		String sql = "INSERT INTO Produit " +
                "VALUES (001, 'PC MM MMX', 5, 19.6,6500.00)";
		enonce.executeUpdate(sql);
		
		sql = "INSERT INTO Produit " +
              "VALUES (002, 'Imprimante HP jet', 20, 19.6,3500.00)";
		enonce.executeUpdate(sql);
		
		sql = "INSERT INTO Produit " +
	              "VALUES (003, 'Ecran 17\"', 15, 19.6,1200.00)";
		enonce.executeUpdate(sql);
			
		sql = "INSERT INTO Produit " +
	              "VALUES (004, 'CD*10', 100, 19.6,99.00)";
		enonce.executeUpdate(sql);
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
		
		while(resultat.next())
		{
			for(int i = 1; i <= nbColonnes; i++) 
			{
				String nom = rsmd.getColumnName(i);
				System.out.print(resultat.getString(nom) + "\t");			
			}
			System.out.println("");
		}	
	}
}

