package com.intiFormation.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.Service.ICommandeService;
import com.intiFormation.Service.IUtilisateurService;
import com.intiFormation.entity.Commande;
import com.intiFormation.entity.Produit;
import com.intiFormation.entity.Utilisateur;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/admin")
public class CommandeController {

	
	@Autowired
	ICommandeService cservice;
	
	@Autowired
	IUtilisateurService uservice;
	
	
	@PostMapping("/admin/SaveCommande")
	public void saveCommande(@RequestBody Commande c, @RequestParam("nomUti") String pro)
	{
		if (pro.isEmpty()){}
		else
		{
		Utilisateur prod = uservice.GetBynomUtilisateur(pro);
		c.setUser(prod);
		}
		cservice.Ajouter(c);
}
	
	@GetMapping("/afficherCommande")
	public List<Commande> aff()
	{
		List<Commande> Liste = cservice.GetAll();
		return (Liste);
	}
		
	@DeleteMapping("admin/SupprimerCommande/{id}")
	public void supp(@PathVariable("id") int id)
	{
			cservice.supprimer(id);
	}
		
	@PutMapping("/admin/UpdateCommande")
	public void updateCitoyen(@RequestBody Commande c, @RequestParam("nomUti") String pro)
	{
		if (pro.isEmpty()){}
		else
		{
		Utilisateur prod = uservice.GetBynomUtilisateur(pro);
		c.setUser(prod);
		}
		cservice.Modifier(c);
}

	

}
