package com.expehris.springmvc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Employeur")
public class Employeur {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_Employeur;


	@NotEmpty
	@Column(name="login", unique=true, nullable=false)
	private String login;
	
	@NotEmpty
	@Column(name="prenom", nullable=false)
	private String prenom;

	@NotEmpty
	@Column(name="nom", nullable=false)
	private String nom;

	@NotEmpty
	@Column(name="passwd", nullable=false)
	private String passwd;

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	@NotEmpty
	@Column(name="entreprise", nullable=false)
	private String entreprise;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserDocument> userDocuments = new HashSet<UserDocument>();

	public Integer getId_Employeur() {
		return id_Employeur;
	}

	public void setId_Employeur(Integer id_Employeur) {
		this.id_Employeur = id_Employeur;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Set<UserDocument> getUserDocuments() {
		return userDocuments;
	}

	public void setUserDocuments(Set<UserDocument> userDocuments) {
		this.userDocuments = userDocuments;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Employeur == null) ? 0 : id_Employeur.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		Employeur other = (Employeur) obj;
		if (id_Employeur == null) {
			if (other.id_Employeur != null)
				return false;
		} else if (!id_Employeur.equals(other.id_Employeur))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employeur [id=" + id_Employeur + ", login=" + login + ", nom=" + nom + ", prenom=" + prenom
				+ ", password=" + passwd + "]"+", Entreprise=" + entreprise ;
	}

	
	
	
}
