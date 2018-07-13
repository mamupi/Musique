package fr.gtm.musique.service;

/**
 * @author: Maria Munoz
 * @version: 1.0
 */

import java.util.ArrayList;

import fr.gtm.musique.domaine.Groupe;
import fr.gtm.musique.dao.GroupeDao;
import fr.gtm.musique.dao.IGroupeDao;

public class GroupeService {
	
// Declaration + affectation
	boolean chanson = false;
	
// Declaration + Instanciation
	IGroupeDao groupeDao = new GroupeDao();
	
//Appel aux methodes de l'interface
//Methode creer groupe
	public boolean creerGroupe(Groupe groupe) {
	// Appel create groupe
		return groupeDao.createGroupe(groupe);
	}

//Methode consulter groupe
	public Groupe getGroupeById(int id){

	// Appel consulte groupe
		return groupeDao.getGroupeById(id);
	}

//Methode modifier groupe
	public boolean modifierGroupe(Groupe groupe){
		return groupeDao.updateGroupe(groupe);
	}

//Methode supprimer groupe
	public boolean supprimerGroupe(int id){
		return groupeDao.deleteGroupe(id);
	}

//Methode recuperer liste groupes
	public ArrayList<Groupe> listerGroupes(){
		return groupeDao.getAll();
	}
	
//Methodes metier
//Methode collaborer Chanson
	public boolean collaborerChanson(String groupe1, String groupe2){
		System.out.println(groupe1);
		System.out.println(groupe2);
		if (groupe1.equals(groupe2))
		{
			chanson = false;
		}
		else
		{
			chanson = true;
		}
		return chanson;
	}
}
