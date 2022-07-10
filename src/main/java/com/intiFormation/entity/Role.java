package com.intiFormation.entity;



import java.util.List;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idRole")
	private int idRole;
	@Column(name="libRole")
	private String librole;
	
	
	@OneToMany (mappedBy = "role")
	@JsonIgnore
	private List<Utilisateur> utilisateurs;

	public Role() {
		super();
	}


	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getLibrole() {
		return librole;
	}
	public void setLibrole(String librole) {
		this.librole = librole;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}


	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", librole=" + librole  + "]";
	}
	
	

}
