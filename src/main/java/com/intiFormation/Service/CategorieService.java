package com.intiFormation.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.ICategorieDao;
import com.intiFormation.Dao.IProduitDao;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Produit;

@Service
public class CategorieService implements ICategorieService{
	
	@Autowired
	ICategorieDao IcDao;
	
	@Autowired
	IProduitDao IpDao;

	public void Ajouter(Categorie c)
	{
		IcDao.save(c);
	}
	
	public List<Categorie> GetAll()
	{	return  IcDao.findAll();}

	public Categorie GetByNomCategorie(String nomCategorie)
	{ return IcDao.findByNomCategorie(nomCategorie);}
	
	public Categorie SelectById(Integer id)
	{ return IcDao.findById(id).get();}
	
	public void Modifier(Categorie c)
	{
		IcDao.save(c);
	}


	public void supprimer(int id)
	{
		
		List<Produit> list = IpDao.findByCategorie_idCategorie(id);
		
		if (list.isEmpty())
		{
			IcDao.deleteById(id);
		}
		else
		{
			for(int i=0; i<list.size();i++)
			{
				IpDao.deleteById(list.get(i).getIdProduit());
			}
			IcDao.deleteById(id);
		}
		
		
		
		
		
	}
	
	
	

}
