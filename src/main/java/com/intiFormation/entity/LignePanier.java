package com.intiFormation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lignePanier")
public class LignePanier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idLignePanier")
	private int idLignePanier;
	

	@ManyToOne
	@JoinColumn(name="idproduit")
	private Produit produit;
	

	@Column(name="quantite")
	private int  quantite;
	
	
	@ManyToOne
	@JoinColumn(name="idpanier")
	private Panier panier;


	public LignePanier() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "LignePanier [idLignePanier=" + idLignePanier + ", produit=" + produit.getNomProduit() + ", quantite=" + quantite
				+ ", panier=" + panier.getIdPanier()+  "]";
	}

	
	
	
	//getter setter

	public int getIdLignePanier() {
		return idLignePanier;
	}


	public void setIdLignePanier(int idLignePanier) {
		this.idLignePanier = idLignePanier;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public Panier getPanier() {
		return panier;
	}


	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	

	
	

}
