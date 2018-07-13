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

import fr.gtm.musique.domaine.Groupe;

public class GroupeDao implements IGroupeDao {
	
	// Information d'acces a la base de donnees
	String url = "jdbc:mysql://127.0.0.1:3306/musique";
	String login = "root";
	String passwd = "";
	Connection cn = null;
	Statement st = null;
	boolean succes = false;
	String driver = "com.mysql.jdbc.Driver";
	
	//Methodes de l'interface
	//Methode createGroupe
	public boolean createGroupe(Groupe groupeCreate) {
		Groupe groupe = groupeCreate;

		try {

			// Etape 1 : Chargement du driver
			Class.forName(driver);

			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Preparer la requete
			st = cn.createStatement();

			// Faire une insertion d'une bande
			String sql = "INSERT INTO `groupes` (`PK_id`, `nom`, `pays_origine`) VALUES ("+ groupe.getIdGroupe() +", '"+ groupe.getNom()+"', '"+groupe.getPaysOrigine()+"')";

			// Etape 4 : execution requete
			// Insertion/Update
			st.executeUpdate(sql);
			succes = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// gestion erreur
			e.printStackTrace();
		} finally {
			try {
				// Etape 5 : liberer ressources de la memoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				// gestion erreur
				e.printStackTrace();
			}
		}
		return succes;
	}
	
	//Methode getGroupe by ID
	public Groupe getGroupeById(int idGroupe) {
		Groupe groupe = new Groupe(0, "", "");
		try {

			// Etape 1 : Chargement du driver
			Class.forName(driver);

			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Preparer la requete
			st = cn.createStatement();

			// Faire une consulte d'un groupe
			String sql = "SELECT * FROM groupes WHERE PK_id = '"+idGroupe+"'";

			// Etape 4 : execution requete
			// Consulte
			ResultSet rs = st.executeQuery(sql);

			// Etape 5 : parcours Resultset
			// Boucle sur la les donnees recuperees

			while (rs.next()) {
				idGroupe = rs.getInt("PK_id");
				String nomGroupe = rs.getString("Nom");
				String paysOrigine = rs.getString("Pays_Origine");
				groupe.setIdGroupe(idGroupe);
				groupe.setNom(nomGroupe);
				groupe.setPaysOrigine(paysOrigine);
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
		return groupe;
	}
	
	//Methode updateGroupe
	public boolean updateGroupe(Groupe groupeUpdate) {
		Groupe groupe = groupeUpdate;
		try {

			// Etape 1 : Chargement du driver
			Class.forName(driver);

			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Preparer la requete
			st = cn.createStatement();

			// Faire une modification d'une bande

			String sql = "UPDATE `groupes` SET nom = '" + groupe.getNom() + "', pays_origine = '" + groupe.getPaysOrigine()
					+ "' WHERE PK_id = '" + groupe.getIdGroupe() + "'";

			// Etape 4 : execution requete
			// Modification
			st.executeUpdate(sql);
			succes = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// gestion erreur
			e.printStackTrace();
		} finally {
			try {
				// Etape 5 : liberer ressources de la memoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				// gestion erreur
				e.printStackTrace();
			}
		}
		return succes;
	}
	
	//Methode deleteGroupe
	public boolean deleteGroupe(int idGroupe) {
		try {
			// Etape 1 : Chargement du driver
			Class.forName(driver);

			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Preparer la requete
			st = cn.createStatement();

			// Faire une elimination d'un groupe
			String sql = "DELETE FROM `groupes` WHERE PK_id = " + idGroupe + "";

			// Etape 4 : execution requete
			// Delete
			st.executeUpdate(sql);

			succes = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// gestion erreur
			e.printStackTrace();
		} finally {
			try {
				// Etape 5 : liberer ressources de la memoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				// gestion erreur
				e.printStackTrace();
			}
		}
		return succes;
	}
	
	
	//Methode getAll
	public ArrayList<Groupe> getAll() {
		
		ArrayList<Groupe> listeGroupes = new ArrayList<Groupe>();

		try {

			// Etape 1 : Chargement du driver
			Class.forName(driver);

			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Preparer la requete
			st = cn.createStatement();

			// Faire une consulte de toutes les groupes
			String sql = "SELECT * FROM groupes";

			// Etape 4 : execution requete
			// Consulte
			ResultSet rs = st.executeQuery(sql);

			// Etape 5 : parcours Resultset
			// Boucle sur la les donnees recuperees
			
			while (rs.next()) {
				int idGroupe = rs.getInt("PK_id");
				String nomGroupe = rs.getString("Nom");
				String paysOrigine = rs.getString("Pays_Origine");

				listeGroupes.add(new Groupe(idGroupe, nomGroupe, paysOrigine));	
			}
			succes = true;

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
		return listeGroupes;
	}
}

