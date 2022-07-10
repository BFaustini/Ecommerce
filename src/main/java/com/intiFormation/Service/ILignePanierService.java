package com.intiFormation.Service;

import java.util.List;

import com.intiFormation.entity.LignePanier;

public interface ILignePanierService {

	
	public void Ajouter(LignePanier c);
	
	public List<LignePanier> GetAll();
	
	public LignePanier SelectById(Integer id);
	
	public List<LignePanier> GetByPanier(Integer id);
	
	public void Modifier(LignePanier c);

	public void supprimer(int id);
	
	
	
}
