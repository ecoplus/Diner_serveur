package fr.sallafranque.diner.modele;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Repas implements Serializable{
	
	/**
	 * Version de la classe.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur organisateur;
	
	@Column 
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="id_competition")
	private Competition competition;
	
	@OneToMany(mappedBy="repas")
	private Set<Note> listeNotes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utilisateur getOrganisateur() {
		return organisateur;
	}

	public void setOrganisateur(Utilisateur organisateur) {
		this.organisateur = organisateur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Set<Note> getListeNotes() {
		return listeNotes;
	}

	public void setListeNotes(Set<Note> listeNotes) {
		this.listeNotes = listeNotes;
	}

	
	public Repas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Repas(Utilisateur organisateur, Date date) {
		super();
		this.organisateur = organisateur;
		this.date = date;
	}
	
	
	
	
	
	
}
