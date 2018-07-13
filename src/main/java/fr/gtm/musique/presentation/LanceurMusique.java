package fr.gtm.musique.presentation;

import java.util.ArrayList;
import java.util.Scanner;

import fr.gtm.musique.domaine.Groupe;
import fr.gtm.musique.service.GroupeService;
import fr.gtm.musique.domaine.Concert;
import fr.gtm.musique.service.ConcertService;

public class LanceurMusique {
	// Interface utilisateur.

	public static void main(String[] args) {
		// Declaration et affectation
		char premiereCaractere;
		boolean session = true;
		int idGroupe = 0;
		String nom;
		String paysOrigine;
		String groupe1;
		String groupe2;

		// Declaration + Instanciation
		GroupeService groupeService = new GroupeService();
		ConcertService concertService = new ConcertService();
		Scanner sc = new Scanner(System.in);
		ArrayList<Groupe> listeGroupes = new ArrayList<Groupe>();
		ArrayList<Concert> listeConcerts = new ArrayList<Concert>();

		// Declaration + Instanciation + afectation
		Groupe groupe = new Groupe(0, "", "");

		// Boucle control session
		while (session) {
			premiereCaractere = ' ';
			System.out.println("Que souhaitez vous faire ?");
			// Boucle menu principal
			while (premiereCaractere != '1' && premiereCaractere != '2' && premiereCaractere != '3'
					&& premiereCaractere != '4' && premiereCaractere != '5' && premiereCaractere != '6') {
				System.out.println(
						"1 : Ajouter un groupe.\n2 : Selectionner un groupe.\n3 : Modifier un groupe.\n4 : Supprimer un groupe.\n5 : Consulter tous les groupes.\n6 : Quitter l'outil.");
				premiereCaractere = sc.nextLine().charAt(0);
			}
			if (premiereCaractere == '1') {
				// Demande de information concernant le groupe a ajouter

				System.out.println("Veuillez saisir l'id du groupe.");
				idGroupe = sc.nextInt();

				// On vide la ligne avant d'en lire une autre
				sc.nextLine();

				System.out.println("Veuillez saisir le nom du groupe.");
				nom = sc.nextLine();

				System.out.println("Veuillez saisir le pays d'origine du groupe.");
				paysOrigine = sc.nextLine();

				groupe.setIdGroupe(idGroupe);
				groupe.setNom(nom);
				groupe.setPaysOrigine(paysOrigine);

				boolean succes = groupeService.creerGroupe(groupe);

				// Verifcation insertion correcte du groupe dans la table
				if (succes == true) {
					System.out.println("Le groupe a ete ajoute correctement.");
				} else {
					System.out.println("Une erreur s'est produite et le groupe n'a pas ete ajoute.");
				}
			} else if (premiereCaractere == '2') {
				// Demande de information concernant le groupe a consulter
				System.out.println("Veuillez saisir l'id du groupe.");
				idGroupe = sc.nextInt();
				groupe = groupeService.getGroupeById(idGroupe);
				System.out.println(groupe);

				// On vide la ligne avant d'en lire une autre
				sc.nextLine();

				// Demande de information de concerts du groupe
				boolean session2 = true;
				while (session2) {
					premiereCaractere = ' ';
					System.out.println("Souhaitez vous connaître les concerts de ce groupe ?");
					// Boucle menu concerts du groupe
					while (premiereCaractere != '1' && premiereCaractere != '2') {
						System.out.println("1 : Oui.\n2 : Non.");
						premiereCaractere = sc.nextLine().charAt(0);
					}
					if (premiereCaractere == '1') {
						System.out.println("Les concerts de ce groupe sont:");

						// Appel a la methode informationConcerts
						listeConcerts = concertService.listerConcerts(idGroupe);
						session2 = false;

						// Boucle pour parcourir listeConcerts
						for (Concert concert : listeConcerts) {
							System.out.println(groupe.getNom() + " " + concert);
						}
					}
					if (premiereCaractere == '2') {
						session2 = false;
					}
				}
			} else if (premiereCaractere == '3') {
				// Demande de information concernant le groupe a modifier

				System.out.println("Veuillez saisir l'id du groupe.");
				idGroupe = sc.nextInt();

				// On vide la ligne avant d'en lire une autre
				sc.nextLine();

				System.out.println("Veuillez saisir le nouveau nom du groupe.");
				nom = sc.nextLine();

				System.out.println("Veuillez saisir le nouveau pays d'origine du groupe.");
				paysOrigine = sc.nextLine();

				groupe.setIdGroupe(idGroupe);
				groupe.setNom(nom);
				groupe.setPaysOrigine(paysOrigine);

				boolean succes = groupeService.modifierGroupe(groupe);

				// Verifcation modification correcte du groupe dans la table
				if (succes == true) {
					System.out.println("Le groupe a ete modifie correctement.");
				} else {
					System.out.println("Une erreur s'est produite et le groupe n'a pas ete modifie.");
				}
			} else if (premiereCaractere == '4') {
				// Demande de information concernant le groupe a supprimer

				System.out.println("Veuillez saisir l'id du groupe.");
				idGroupe = sc.nextInt();

				// On vide la ligne avant d'en lire une autre
				sc.nextLine();
				boolean succes = groupeService.supprimerGroupe(idGroupe);

				// Verifcation supression correcte du groupe dans la table
				if (succes == true) {
					System.out.println("Le groupe a ete supprime correctement.");
				} else {
					System.out.println("Une erreur s'est produite et le groupe n'a pas ete supprime.");
				}
			} else if (premiereCaractere == '5') {
				// Demande de information concernant tous les groupes
				listeGroupes = groupeService.listerGroupes();
				// Boucle pour aficher les groupes
				System.out.println("Les informations concernant les groupes sont: ");
				for (Groupe grp : listeGroupes) {
					System.out.println(grp);
				}
				// Demande de possible chanson de collaboration entre 2 groupes
				boolean session3 = true;
				while (session3) {
					premiereCaractere = ' ';
					System.out.println("Souhaitez vous proposer una chanson de collaboration entre 2 groupes ?");
					// Boucle menu chanson de collaboration
					while (premiereCaractere != '1' && premiereCaractere != '2') {
						System.out.println("1 : Oui.\n2 : Non.");
						premiereCaractere = sc.nextLine().charAt(0);
					}
					if (premiereCaractere == '1') {
						System.out.println("Veuillez ecrire le nom du premier groupe");
						groupe1 = sc.nextLine();
						System.out.println("Veuillez ecrire le nom du deuxieme groupe");
						groupe2 = sc.nextLine();
						// Appel a la methode collaborerChanson
						session3 = groupeService.collaborerChanson(groupe1, groupe2);
						if (session3) {
							System.out.println("Une chanson de collaboration entre " + groupe1 + " et " + groupe2
									+ " est une idee excellente.");
						} else {
							System.out
									.println("Vous avez rentrez deux fois le meme groupe. Veuillez essayer a nouveau.");
						}
					}
					if (premiereCaractere == '2') {
						session3 = false;
					}
				}
			} else if (premiereCaractere == '6') {
				System.out.println("FIN DE PROGRAMME");
				sc.close();
				System.exit(0);
			}
		}
	}
}
