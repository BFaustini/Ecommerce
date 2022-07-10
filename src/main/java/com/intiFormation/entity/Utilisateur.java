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
import javax.persistence.OneToOne;




@Entity
@Table(name="utilisateur")
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdUser")
	private int id;
	@Column(name="nomUtilisateur")
	private String nom;
	@Column(name="prenomUtilisateur")
	private String prenom;
	@Column(name="datNaissance")
	//private LocalDate dateNaissance;
	private String dateNaissance;
	@Column(name="login")
	private String login;
	@Column(name=" password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name="idrole")
	private Role role;
	
	
	@OneToMany (mappedBy = "user")
	@JsonIgnore
	private List<Commande> commandes;
	
	
	@OneToOne() //une cascade lors de l'enregistrement de l'objet (persist), enregister pass et apres citoyen 
	@JoinColumn(name="id_panier")
	private Panier panier;


	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", login=" + login + ", password=" + password + ", role=" + role + "]";
	}



	//getter setter



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public List<Commande> getCommandes() {
		return commandes;
	}


	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}


	public Panier getPanier() {
		return panier;
	}


	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	

	
	
	
	
	
	
	
	
	
	
	

}
