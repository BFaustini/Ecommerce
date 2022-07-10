package com.intiFormation.Service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Panier;

public interface IPanierService {

	
	public void Ajouter(Panier c);
	
	public List<Panier> GetAll();
	
	public Optional<Panier> SelectById(Integer id);
	
	public Panier SelectByIduser(Integer id);
	
	public void Modifier(Panier c);

	public void supprimer(int id);
	
	
	
}
