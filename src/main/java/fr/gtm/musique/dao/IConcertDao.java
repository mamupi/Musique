package fr.gtm.musique.dao;

/**
 * Interface
 * @author: Maria Munoz
 * @version: 1.0
 */

import java.util.ArrayList;

import fr.gtm.musique.domaine.Concert;

public interface IConcertDao {
	
	// Methodes couche dao

	public ArrayList<Concert> getConcertById(int idConcert);

}
