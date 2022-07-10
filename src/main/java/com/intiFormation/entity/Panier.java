package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="panier")
public class Panier {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idPanier")
	private int idPanier;
	


	@OneToMany (mappedBy = "panier")
	@JsonIgnore
	private List<LignePanier> lignePaniers;
	
	
	@OneToOne(mappedBy = "panier")
	@JsonIgnore
	private Utilisateur utilisateur;


	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdPanier() {
		return idPanier;
	}


	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}


	public List<LignePanier> getLignePaniers() {
		return lignePaniers;
	}


	public void setLignePaniers(List<LignePanier> lignePaniers) {
		this.lignePaniers = lignePaniers;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	} 
	
	
	
	


}
