package fr.sallafranque.diner.modele;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Competition implements Serializable {

	/**
	 * Version de la classe.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany
	@JoinTable(name = "Competitons_competiteurs", joinColumns = @JoinColumn(name = "id_competition"), inverseJoinColumns = @JoinColumn(name = "id_utilisateur"))
	private Set<Utilisateur> listeCompetiteurs;

	@Column
	private boolean enCours;

	@OneToMany(mappedBy = "competition")
	private Set<Repas> listeRepas;

	public Competition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Competition(Set<Utilisateur> listeCompetiteurs) {
		super();
		this.listeCompetiteurs = listeCompetiteurs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Utilisateur> getListeCompetiteurs() {
		return listeCompetiteurs;
	}

	public void setListeCompetiteurs(Set<Utilisateur> listeCompetiteurs) {
		this.listeCompetiteurs = listeCompetiteurs;
	}

	public boolean isEnCours() {
		return enCours;
	}

	public void setEnCours(boolean enCours) {
		this.enCours = enCours;
	}

	public Set<Repas> getListeRepas() {
		return listeRepas;
	}

	public void setListeRepas(Set<Repas> listeRepas) {
		this.listeRepas = listeRepas;
	}

}
