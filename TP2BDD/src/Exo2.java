import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Exo2 {
	
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
	
	
	public Exo2() throws ClassNotFoundException, SQLException {
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
            //System.out.println("connecté!");
        }


        
        Statement enonce = maCo.createStatement();
        
        ResultSet resultat = enonce.executeQuery("SELECT * FROM personnes");
		displaySelect(resultat);
	}

}
