package com.intiFormation.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.ILignePanierDao;
import com.intiFormation.entity.LignePanier;


@Service
public class LignePanierService implements ILignePanierService{


	@Autowired
	ILignePanierDao IpDao;

	public void Ajouter(LignePanier c)
	{
		IpDao.save(c);
	}
	
	public List<LignePanier> GetAll()
	{	return  IpDao.findAll();}
	
	public LignePanier SelectById(Integer id)
	{ return IpDao.findById(id).get();}
	
	public List<LignePanier> GetByPanier(Integer id)
	{ return IpDao.findByPanier_idPanier(id);}
	
	public void Modifier(LignePanier c)
	{
		IpDao.save(c);
	}

	public void supprimer(int id)
	{
		IpDao.deleteById(id);
	}
	
	
	

}
