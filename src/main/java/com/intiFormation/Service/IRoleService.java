package com.intiFormation.Service;

import java.util.List;

import com.intiFormation.entity.Role;

public interface IRoleService {
	
	
	
	public void Ajouter(Role c);
	
	public List<Role> GetAll();
	
	public Role SelectById(Integer id);
	
	public Role SelectByName(String nom);
	
	public void Modifier(Role c);
	
	public void supprimer(int id);
	
	
	
	
	
}
