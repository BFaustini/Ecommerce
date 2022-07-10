package com.intiFormation.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.ICommandeDao;
import com.intiFormation.entity.Commande;
import com.intiFormation.entity.LigneCommande;


@Service
public class CommandeService implements ICommandeService{

	
	@Autowired
	ICommandeDao IcDao;

	@Autowired
	ILigneCommandeService IlpDao;
	
	public void Ajouter(Commande c)
	{
		IcDao.save(c);
	}
	
	public List<Commande> GetAll()
	{	return  IcDao.findAll();}

	
	public Commande SelectById(Integer id)
	{ return IcDao.findById(id).get();}
	
	public void Modifier(Commande c)
	{
		IcDao.save(c);
	}
	
	
	public List<Commande> GetByUser(Integer id)
	{return IcDao.findByUser_id(id);}
	
	

	public void supprimer(int id)
	{
		List<LigneCommande> list = IlpDao.GetByCommande(id);
		
		if (list.isEmpty())
		{
			IcDao.deleteById(id);
		}
		else
		{
			for(int i=0; i<list.size();i++)
			{
				IlpDao.supprimer(list.get(i).getIdLigneCommande());
			}
			IcDao.deleteById(id);
		}
		
		
		
		
		
	}
	
	
	

}
