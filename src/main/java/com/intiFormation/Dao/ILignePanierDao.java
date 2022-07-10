package com.intiFormation.Dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.LignePanier;

public interface ILignePanierDao extends JpaRepository<LignePanier, Integer>{
	

	public List<LignePanier> findByPanier_idPanier(int id);


}
