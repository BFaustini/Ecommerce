package com.intiFormation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;



import javax.persistence.Column;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Table(name="produit")
public class Produit {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idProduit ")
	private int idProduit;
	@Column(name="nomProduit")
	private String nomProduit;
	@Column(name="imageProduit")
	private String img;
	@Column(name="quantiteDispo")
	private int quantite;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="idcategorie")
	private Categorie categorie;
	
	
	@OneToMany (mappedBy = "produit")
	@JsonIgnore
	private List<LigneCommande> ligneCommande;


	public Produit() {
		super();
	}


	
	
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
		public List<LigneCommande> getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(List<LigneCommande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}




	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", NomProduit=" + nomProduit + ", img=" + img + ", quantite="
				+ quantite + "]";
	}
	
	

}
