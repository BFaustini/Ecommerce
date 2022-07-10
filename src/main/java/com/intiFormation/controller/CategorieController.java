package com.intiFormation.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.intiFormation.Service.ICategorieService;
import com.intiFormation.Service.IProduitService;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Produit;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/admin")
public class CategorieController {

	@Autowired
	ICategorieService cservice;
	
	@Autowired
	IProduitService pservice;
	
	@PostMapping("/admin/SaveCategorie")
	public void saveCategorie(@RequestBody Categorie c)
	{
		cservice.Ajouter(c);
}
	
	@GetMapping("/afficherCategorie")
	public List<Categorie> aff()
	{
		
		List<Categorie> Liste = cservice.GetAll();
		return (Liste);
	}
		
	@DeleteMapping("/admin/SupprimerCategorie/{id}")
	public void supp(@PathVariable("id")int id)
	{
			cservice.supprimer(id);
	}
	
	@RequestMapping("/admin/Categorie/{id}")
	public Categorie modif(@PathVariable("id") int id)
	{
		Categorie c = cservice.SelectById(id);
		return (c);
	}
	
	@PutMapping("/admin/UpdateCategorie")
	public void updateCitoyen(@RequestBody Categorie c)
	{
		cservice.Modifier(c);
}
	
	
	// ###########################################################################################

	@GetMapping("/AffCategorie/{id}")
	public List<Produit> aff(@PathVariable("id") int id)
	{
		List<Produit> Liste = pservice.GetByCategorie(id);
		
		//System.out.println(Liste);		
		//Liste.remove(0);
		

		return (Liste);
	}
}
