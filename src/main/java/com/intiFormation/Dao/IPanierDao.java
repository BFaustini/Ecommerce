package com.intiFormation.Dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.intiFormation.entity.Panier;


public interface IPanierDao extends JpaRepository<Panier, Integer>{
	
	public Panier findByUtilisateur_id(int id);

}
