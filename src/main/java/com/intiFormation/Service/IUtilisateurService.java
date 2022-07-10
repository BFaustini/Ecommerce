package com.intiFormation.Service;

import java.util.List;

import com.intiFormation.entity.Utilisateur;

public interface IUtilisateurService {

	public void Ajouter(Utilisateur c);
	
	public List<Utilisateur> GetAll();

	public Utilisateur GetByLogin(String login);
	
	public Utilisateur GetBynomUtilisateur(String nomUtilisateur);
	
	public Utilisateur SelectById(Integer id);
	
	public void Modifier(Utilisateur c);
	
	public void supprimer(int id);
	
	
}
