package fr.sallafranque.diner.service;

import fr.sallafranque.diner.modele.Competition;
import fr.sallafranque.diner.modele.Utilisateur;

public interface UtilisateurService {
	
	Utilisateur getUtilisateurCourant();

	void createUser(Utilisateur utilisateur);

	void volontaireUser(boolean choix);

	Competition getCompetitionEnCours();

}
