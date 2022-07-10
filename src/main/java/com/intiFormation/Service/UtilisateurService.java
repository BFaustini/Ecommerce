package com.intiFormation.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.IUtilisateurDao;
import com.intiFormation.entity.Commande;
import com.intiFormation.entity.Panier;
import com.intiFormation.entity.Role;
import com.intiFormation.entity.Utilisateur;




@Service
public class UtilisateurService implements IUtilisateurService{


		@Autowired
		IUtilisateurDao IuDao;
		
		@Autowired
		IPanierService IpanierService;
		
		
		@Autowired
		ICommandeService ICommandeService;

		public void Ajouter(Utilisateur c)
		{						
			Panier pa = new Panier();
				
			IpanierService.Ajouter(pa);
			
			//pa.setIdPanier(i);il fait le boulot tt seul
			c.setPanier(pa);

			IuDao.save(c);
			
	
		}
		
		public List<Utilisateur> GetAll()
		{	return  IuDao.findAll();}

		public Utilisateur GetByLogin(String login)
		{ return IuDao.findByLogin(login);}
		
		
		public Utilisateur GetBynomUtilisateur(String nomUtilisateur)
		{
			return IuDao.fByNomUser(nomUtilisateur);
		}
		
		public Utilisateur SelectById(Integer id)
		{ return IuDao.findById(id).get();}
		
		public void Modifier(Utilisateur c)
		{
			IuDao.save(c);
		}

		public void supprimer(int id)
		{
			IpanierService.supprimer(IpanierService.SelectByIduser(id).getIdPanier());
			
			List<Commande> liste = ICommandeService.GetByUser(id);
			
			for (int i=0; i<liste.size();i++)
			{
				ICommandeService.supprimer(liste.get(i).getIdCommande());
			}

			IuDao.deleteById(id);
		}
}
