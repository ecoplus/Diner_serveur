package fr.sallafranque.diner.dao;

import org.springframework.data.repository.CrudRepository;

import fr.sallafranque.diner.modele.Utilisateur;

public interface UtilisateurDao extends CrudRepository<Utilisateur, Long> {
	
	Utilisateur findByUsername(String username);

}
