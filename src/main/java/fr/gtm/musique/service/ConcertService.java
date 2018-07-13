package fr.gtm.musique.service;

/**
 * @author: Maria Munoz
 * @version: 1.0
 */

import java.util.ArrayList;

import fr.gtm.musique.domaine.Concert;
import fr.gtm.musique.dao.ConcertDao;
import fr.gtm.musique.dao.IConcertDao;

public class ConcertService {


// Declaration + Affectation des variables
	boolean succes = false;
	
// Declaration + Instanciation
	IConcertDao concertDao = new ConcertDao();
	
//Appel aux methodes de l'interface
//Methode informationConcerts
	public ArrayList<Concert> listerConcerts(int idGroupe){
		return concertDao.getConcertById(idGroupe);
	}
}
