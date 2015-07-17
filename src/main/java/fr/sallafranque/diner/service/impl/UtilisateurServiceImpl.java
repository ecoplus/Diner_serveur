package fr.sallafranque.diner.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.sallafranque.diner.dao.UtilisateurDao;
import fr.sallafranque.diner.modele.Competition;
import fr.sallafranque.diner.modele.Utilisateur;
import fr.sallafranque.diner.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UserDetailsService, UtilisateurService {

	@Autowired
	private UtilisateurDao utilisateurDao;

	@Override
	public Utilisateur getUtilisateurCourant() {
		Utilisateur myUser = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// je prends celui de ma base de donnée pour le mettre dans un
		// utilisteur " à jours"
		Utilisateur utilisateur = utilisateurDao.findOne(myUser.getId());
		return utilisateur;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return utilisateurDao.findByUsername(username);
	}

	@Override
	public void createUser(Utilisateur utilisateur) {
		utilisateur.setEstVolontaire(false);
		utilisateur.setRole("USER");
		utilisateur.setEnabled(true);
		utilisateurDao.save(utilisateur);
	}

	@Override
	public void volontaireUser(boolean choix) {
		Utilisateur utilisateur = getUtilisateurCourant();
		utilisateur.setEstVolontaire(choix);
		utilisateurDao.save(utilisateur);
	}

	@Override
	public Competition getCompetitionEnCours() {
		Competition competitionEnCours = null;
		Utilisateur utilisateur = utilisateurDao.findOne(getUtilisateurCourant().getId());
		Set<Competition> competitions = utilisateur.getListeCompetitions();
		for (Competition compet : competitions) {
			if (compet.isEnCours()) {
				competitionEnCours = compet;
				break;
			}

		}
		return competitionEnCours;
	}

}
