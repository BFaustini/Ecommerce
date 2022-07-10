package com.intiFormation.entity;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;



import javax.persistence.Column;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import java.util.List;


@Entity
@Table(name="categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCategorie")
	private int idCategorie;
	@Column(name="nomCategorie")
	private String nomCategorie;
	@Column(name=" descriptionCategorie")
	private String description;
	
	@OneToMany (mappedBy = "categorie")
	@JsonIgnore
	private List<Produit> produits;


	public Categorie() {
		super();
	}
	
	
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	
	@Override
	public String toString() {
		return "Categorie [nomCategorie=" + nomCategorie + ", description=" + description + "]";
	}
	
	
	
	

}
