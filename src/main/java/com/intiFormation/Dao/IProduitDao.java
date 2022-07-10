package com.intiFormation.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Produit;

public interface IProduitDao extends JpaRepository<Produit, Integer>{
	

	public List<Produit> findByCategorie_idCategorie(int id);
	
	public Produit findByNomProduit(String nom);

}
