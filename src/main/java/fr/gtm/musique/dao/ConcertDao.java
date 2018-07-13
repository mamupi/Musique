package fr.gtm.musique.dao;
/**
 * Classe DAO
 * @author: Maria Munoz
 * @version: 1.0
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.gtm.musique.domaine.Concert;

public class ConcertDao implements IConcertDao {
	
	// Information d'acces a la base de donnees
	String url = "jdbc:mysql://127.0.0.1:3306/musique";
	String login = "root";
	String passwd = "";
	Connection cn = null;
	Statement st = null;
	boolean succes = false;
	
	//Methodes de l'interface
	//Methode getConcert by ID
		public ArrayList<Concert> getConcertById(int idGroupe) {
			ArrayList<Concert> listeConcerts = new ArrayList<Concert>();
			try {

				// Etape 1 : Chargement du driver
				Class.forName("com.mysql.jdbc.Driver");

				// Etape 2 : recuperation de la connexion
				cn = DriverManager.getConnection(url, login, passwd);

				// Etape 3 : Preparer la requete
				st = cn.createStatement();

				// Faire une consulte d'un groupe
				String sql = "SELECT PK_id_concert, date_concert, ville, pays, capacite FROM jouer INNER JOIN concerts on concerts.PK_id = jouer.PK_id_concert INNER JOIN groupes ON groupes.PK_id = jouer.PK_id_nom WHERE PK_id_nom = '"+idGroupe+"'";
				//System.out.println(sql);

				// Etape 4 : execution requete
				// Consulte
				ResultSet rs = st.executeQuery(sql);

				// Etape 5 : parcours Resultset
				// Boucle sur la les donnees recuperees

				while (rs.next()) {
					int idConcert = rs.getInt("PK_id_concert");
					String dateConcert = rs.getString("date_concert");
					String ville = rs.getString("ville");
					String pays = rs.getString("pays");
					int capacite = rs.getInt("capacite");

					listeConcerts.add(new Concert(idConcert, dateConcert, ville, pays, capacite));	

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// gestion erreur
				e.printStackTrace();
			} finally {
				try {
					// Etape 6 : liberer ressources de la memoire.
					cn.close();
					st.close();
				} catch (SQLException e) {
					// gestion erreur
					e.printStackTrace();
				}
			}
			return listeConcerts;
		}
}
