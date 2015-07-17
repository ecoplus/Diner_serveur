package fr.sallafranque.diner.modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Utilisateur implements UserDetails {

	/**
	 * Version de la classe.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String role;
	@Column
	private boolean enabled;
	@Column
	private String adressePostale;
	@Column
	private boolean estVolontaire;
	@ManyToMany
	@JoinTable(name = "Competitons_competiteurs", joinColumns = @JoinColumn(name = "id_utilisateur"), inverseJoinColumns = @JoinColumn(name = "id_competition"))
	private Set<Competition> listeCompetitions;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();
		auths.add(new SimpleGrantedAuthority(getRole()));
		return auths;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAdressePostale() {
		return adressePostale;
	}

	public void setAdressePostale(String adressePostale) {
		this.adressePostale = adressePostale;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public boolean isEstVolontaire() {
		return estVolontaire;
	}

	public void setEstVolontaire(boolean estVolontaire) {
		this.estVolontaire = estVolontaire;
	}

	public Set<Competition> getListeCompetitions() {
		return listeCompetitions;
	}

	public void setListeCompetitions(Set<Competition> listeCompetitions) {
		this.listeCompetitions = listeCompetitions;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

}
