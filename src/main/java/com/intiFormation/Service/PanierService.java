package com.intiFormation.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.IPanierDao;
import com.intiFormation.entity.LignePanier;
import com.intiFormation.entity.Panier;



@Service
public class PanierService implements IPanierService{

		@Autowired
		IPanierDao IpDao;
		
		@Autowired
		ILignePanierService IlpDao;
		

		public void Ajouter(Panier c)
		{
			IpDao.save(c);
		}
		
		public List<Panier> GetAll()
		{	return  IpDao.findAll();}
		
		public Optional<Panier>  SelectById(Integer id)
		{ return Optional.ofNullable(IpDao.findById(id).get());}
		
		
		public void Modifier(Panier c)
		{
			IpDao.save(c);
		}
		
		public Panier SelectByIduser(Integer id)
		{ return  IpDao.findByUtilisateur_id(id);}
		

		public void supprimer(int id)
		{
			List<LignePanier> list = IlpDao.GetByPanier(id);
			
			if (list.isEmpty())
			{
				IpDao.deleteById(id);
			}
			else
			{
				for(int i=0; i<list.size();i++)
				{
					IlpDao.supprimer(list.get(i).getIdLignePanier());
				}
				IpDao.deleteById(id);
			}
			
			
			
		}
}
