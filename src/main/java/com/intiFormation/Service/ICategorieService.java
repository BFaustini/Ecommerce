package com.intiFormation.Service;

import java.util.List;

import com.intiFormation.entity.Categorie;

public interface ICategorieService {
	
	
	public void Ajouter(Categorie c);
	
	public List<Categorie> GetAll();

	public Categorie GetByNomCategorie(String nomCategorie);
	
	public Categorie SelectById(Integer id);
	
	public void Modifier(Categorie c);

	public void supprimer(int id);

}
