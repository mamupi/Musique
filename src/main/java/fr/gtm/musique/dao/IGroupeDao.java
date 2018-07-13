package fr.gtm.musique.dao;

/**
 * Interface
 * @author: Maria Munoz
 * @version: 1.0
 */

import java.util.ArrayList;

import fr.gtm.musique.domaine.Groupe;

public interface IGroupeDao {
	
	// Methodes couche dao
	
	public boolean createGroupe(Groupe groupeCreate);
	
	public Groupe getGroupeById(int idGroupe);
	
	public boolean updateGroupe(Groupe groupeUpdate);
	
	public boolean deleteGroupe(int idGroupe);
	
	public ArrayList<Groupe> getAll();

}

