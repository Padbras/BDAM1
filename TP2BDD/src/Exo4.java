import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exo4 {
	
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

	public Exo4() throws ClassNotFoundException, SQLException {
		
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

}
