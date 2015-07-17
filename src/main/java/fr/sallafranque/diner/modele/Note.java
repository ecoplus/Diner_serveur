package com.cachet.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Note implements Serializable{
	
	/**
	 * Version de la classe.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="id_repas")
	private Repas repas;
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur noteur;
	
	@Column
	private Integer note;
	
	@Column
	private TypeNote type;
	
	
	
	



	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(Repas repas, Utilisateur noteur, Integer note, TypeNote type) {
		super();
		this.repas = repas;
		this.noteur = noteur;
		this.note = note;
		this.type = type;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Repas getRepas() {
		return repas;
	}



	public void setRepas(Repas repas) {
		this.repas = repas;
	}



	public Utilisateur getNoteur() {
		return noteur;
	}



	public void setNoteur(Utilisateur noteur) {
		this.noteur = noteur;
	}



	public Integer getNote() {
		return note;
	}



	public void setNote(Integer note) {
		this.note = note;
	}

	
	
}
