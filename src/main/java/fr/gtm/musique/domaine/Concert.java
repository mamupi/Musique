package fr.gtm.musique.domaine;

/**
 * Classe domain
 * 
 * @author: Maria Munoz
 * @version: 1.0
 */

public class Concert {

	// Attributs de Concerts
	private int idConcert;
	private String dateConcert;
	private String ville;
	private String pays;
	private int capacite;

	// Constructeur de Concerts
	public Concert(int idConcert, String dateConcert, String ville, String pays, int capacite) {
		super();
		this.idConcert = idConcert;
		this.dateConcert = dateConcert;
		this.ville = ville;
		this.pays = pays;
		this.capacite = capacite;
	}

	// Getters and setters
	public int getIdConcert() {
		return idConcert;
	}

	public void setIdConcert(int idConcert) {
		this.idConcert = idConcert;
	}

	public String getDateConcert() {
		return dateConcert;
	}

	public void setDateConcert(String dateConcert) {
		this.dateConcert = dateConcert;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	// toString
	@Override
	public String toString() {
		return "dans la ville de " + ville + "(" + pays + ")" + " le " + dateConcert + " avec une capacite de "
				+ capacite + " personnes.";
	}

}
