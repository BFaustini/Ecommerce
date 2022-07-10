package com.intiFormation.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.intiFormation.entity.LigneCommande;

public interface ILigneCommandeDao extends JpaRepository<LigneCommande, Integer> {
	
	
	//@Query("select l from LigneCommande l where p.commande=:id")
	//public List<LigneCommande> LigneByyCommande(@Param("id") int id);
	
	public List<LigneCommande> findByCommande_idCommande(int id);


}
