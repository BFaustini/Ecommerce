package com.intiFormation.Service;

import java.util.List;

import com.intiFormation.entity.LigneCommande;

public interface ILigneCommandeService {
	
	public void Ajouter(LigneCommande c);
	
	public List<LigneCommande> GetAll();
	
	public LigneCommande SelectById(Integer id);
	
	public List<LigneCommande> GetByCommande(Integer id);
	
	public void Modifier(LigneCommande c);

	public void supprimer(int id);

}
