package com.intiFormation.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.IProduitDao;
import com.intiFormation.entity.Produit;

@Service
public class ProduitService implements IProduitService{

	@Autowired
	IProduitDao IpDao;

	public void Ajouter(Produit c)
	{
		IpDao.save(c);
	}
	
	public List<Produit> GetAll()
	{	return  IpDao.findAll();}

	public Produit GetByNomProduit(String nom)
	{ return IpDao.findByNomProduit(nom);}
	
	public Produit SelectById(Integer id)
	{ return IpDao.findById(id).get();}
	
	
	
	public List<Produit> GetByCategorie(Integer id)
	{ return IpDao.findByCategorie_idCategorie(id);}
	
	
	
	public void Modifier(Produit c)
	{
		IpDao.save(c);
	}
	
	
	
	
	

	public void supprimer(int id)
	{
		IpDao.deleteById(id);
	}
	
	
	

}
