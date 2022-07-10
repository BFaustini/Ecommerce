package com.intiFormation.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Commande;
import com.intiFormation.entity.LigneCommande;

public interface ICommandeDao extends JpaRepository<Commande, Integer>{
	

	public List<Commande> findByUser_id(int id);
	
	

}
