import java.sql.SQLException;
import java.util.Scanner;

public class Generale {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer 'Add' pour ajouter une personne !");
		System.out.println("Entrer 'displayAll' pour afficher toute les personnes !");
		System.out.println("Entrer 'displayGroupe' pour afficher les membres d'un groupe !");
		System.out.println("Entrer 'select' pour faire une requete !");
		System.out.println("Entrer 'Quit' pour quitter!");

		
		String q = sc.nextLine();
		
			if(q.equals("Add")){
				
			}
			if(q.equals("displayAll")){
				try {
					Exo2 deux = new Exo2();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(q.equals("displayGroupe")){
				try {
					exo3 trois = new exo3();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(q.equals("select")){
				try {
					Exo4 quatre = new Exo4();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

}
