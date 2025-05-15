package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controleur.User;

public class Modele {
	private static Connexion uneConnexion = new Connexion("root", "", "localhost","itmanagehub");
	
	
	public static User VerifConnexion (String email, String mdp) {
		User unUser = null;
		String requete = "SELECT * FROM user WHERE email = ? AND mdp = ?";
		try {
			// Connexion à la BDD
			uneConnexion.seConnecter();
			
			// Préparation de la requête
			PreparedStatement stmt = uneConnexion.getMaConnexion().prepareStatement(requete);		
			stmt.setString(1,email);
			stmt.setString(2,mdp);
			
			// Exécution de la requête
			
			ResultSet unResultat = stmt.executeQuery();
			
			if (unResultat.next()) {
				unUser = new User(unResultat.getInt("iduser"), unResultat.getString("nom"),
						unResultat.getString("prenom"), unResultat.getString("email"),
						unResultat.getString("mdp"), unResultat.getString("role"));			
			}
			stmt.close();
			uneConnexion.seDeConnecter();
		}
		catch(SQLException exp) 
		{			
			System.out.println("Erreur de requete : " + requete );
		}
		return unUser;	
	}
	
	
	public static void ProfilUpdate (int iduser, String nom, String prenom, String email) {
		
		String requete = "UPDATE user set nom = ?, prenom = ?, email = ? WHERE iduser = ?";
		try {
			// Connexion à la BDD
			uneConnexion.seConnecter();
			
			// Préparation de la requête
			PreparedStatement stmt = uneConnexion.getMaConnexion().prepareStatement(requete);		
			stmt.setString(1,nom);
			stmt.setString(2,prenom);
			stmt.setString(3,email);
			stmt.setInt(4, iduser);

			
			// Exécution de la requête UPDATE
			
			stmt.executeUpdate(); 
			
			stmt.close();
			uneConnexion.seDeConnecter();
		}
		catch(SQLException exp) 
		{			
			System.out.println("Erreur de requete : " + requete );
		}
		
	}
	

	
	
	
}
