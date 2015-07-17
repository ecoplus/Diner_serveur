/**
 * 
 */
package fr.sallafranque.diner.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.sallafranque.diner.dao.UtilisateurDao;
import fr.sallafranque.diner.modele.Utilisateur;
import fr.sallafranque.diner.service.UtilisateurService;

/**
 * @author msallafr
 *
 */
@RestController
@RequestMapping("utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@RequestMapping(value = "liste", method = RequestMethod.GET)
	public List<Utilisateur> getListe(){
		Iterable<Utilisateur> utilisateurs = utilisateurDao.findAll(); 
		return (List<Utilisateur>) utilisateurs;
	}
	
	@RequestMapping(value = "courant", method = RequestMethod.GET)
	public Utilisateur getCourant(){
		return utilisateurService.getUtilisateurCourant();
	}

}
