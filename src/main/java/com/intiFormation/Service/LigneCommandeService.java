package com.intiFormation.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.ILigneCommandeDao;
import com.intiFormation.entity.LigneCommande;

@Service
public class LigneCommandeService implements ILigneCommandeService{

	@Autowired
	ILigneCommandeDao IpDao;

	public void Ajouter(LigneCommande c)
	{
		IpDao.save(c);
	}
	
	public List<LigneCommande> GetAll()
	{	return  IpDao.findAll();}
	
	public LigneCommande SelectById(Integer id)
	{ return IpDao.findById(id).get();}
	
	public List<LigneCommande> GetByCommande(Integer id)
	{ return IpDao.findByCommande_idCommande(id);}
	
	public void Modifier(LigneCommande c)
	{
		IpDao.save(c);
	}

	public void supprimer(int id)
	{
		IpDao.deleteById(id);
	}
	
	
	

}
