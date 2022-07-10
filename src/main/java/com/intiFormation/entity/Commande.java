package com.intiFormation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="commande")
public class Commande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCommande")
	private int idCommande;
	@Column(name="dateCommande")
	private String dateCommande;
	
	
	@ManyToOne(cascade = {CascadeType.ALL,CascadeType.REMOVE})
	@JoinColumn(name="iduser")
	private Utilisateur user;
	
	
	@OneToMany (mappedBy = "commande")//c'est le nom de l'attribut créé dans l'autre classe (logique)
	@JsonIgnore
	private List<LigneCommande> ligneCommandes;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + ", user=" + user
				+ ", ligneCommandes=" + ligneCommandes + "]";
	}

	
		//getter setter
	
	
	
	public int getIdCommande() {
		return idCommande;
	}


	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}


	public String getDateCommande() {
		return dateCommande;
	}


	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}


	public Utilisateur getUser() {
		return user;
	}


	public void setUser(Utilisateur user) {
		this.user = user;
	}


	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}


	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	


}
