package com.intiFormation.Service;

import java.util.List;

import com.intiFormation.entity.Produit;

public interface IProduitService {
	
	public void Ajouter(Produit c);
	
	public List<Produit> GetAll();

	public Produit GetByNomProduit(String nom);
	
	public Produit SelectById(Integer id);
	
	public List<Produit> GetByCategorie(Integer id);
	
	public void Modifier(Produit c);

	public void supprimer(int id);
	

}
