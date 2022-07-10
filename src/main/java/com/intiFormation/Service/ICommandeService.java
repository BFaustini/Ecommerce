package com.intiFormation.Service;

import java.util.List;

import com.intiFormation.entity.Commande;

public interface ICommandeService {

	
	public void Ajouter(Commande c);
	
	public List<Commande> GetAll();
	
	public Commande SelectById(Integer id);
	
	public void Modifier(Commande c);
	
	public List<Commande> GetByUser(Integer id);
	
	public void supprimer(int id);
	
}
