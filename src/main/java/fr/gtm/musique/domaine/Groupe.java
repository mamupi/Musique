package fr.gtm.musique.domaine;

/**
 * Classe domain
 * 
 * @author: Maria Munoz
 * @version: 1.0
 */

public class Groupe {

	// Attributs de Groupes
	private int idGroupe;
	private String nom;
	private String paysOrigine;

	// Constructeur de Groupes
	public Groupe(int idGroupe, String nom, String paysOrigine) {
		super();
		this.idGroupe = idGroupe;
		this.nom = nom;
		this.paysOrigine = paysOrigine;
	}

	// Getters and setters
	public int getIdGroupe() {
		return idGroupe;
	}

	public String getNom() {
		return nom;
	}

	public String getPaysOrigine() {
		return paysOrigine;
	}

	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPaysOrigine(String paysOrigine) {
		this.paysOrigine = paysOrigine;
	}

	// toString
	@Override
	public String toString() {
		return nom + " est un groupe de " + paysOrigine;
	}
}
