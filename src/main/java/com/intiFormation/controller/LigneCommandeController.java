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
import com.intiFormation.Service.ILigneCommandeService;
import com.intiFormation.Service.IProduitService;
import com.intiFormation.Service.IUtilisateurService;
import com.intiFormation.entity.Commande;
import com.intiFormation.entity.LigneCommande;
import com.intiFormation.entity.Produit;
import com.intiFormation.entity.Utilisateur;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/admin")
public class LigneCommandeController {
	
	@Autowired
	ILigneCommandeService lcservice;
	
	@Autowired
	IProduitService pservice;
		
	@Autowired
	ICommandeService cservice;

	@PostMapping("/admin/SaveLigneCommande")
	public void inserer(@RequestBody LigneCommande LigneCommande,@RequestParam("idcomm") Integer com, @RequestParam("NomProduit") String pro)
	{
		if (com.equals(null)){}
		else
		{
		Commande comm = cservice.SelectById(com);
		
		LigneCommande.setCommande(comm);
		}
		
		if (pro.isEmpty()){}
		else
		{
		Produit prod = pservice.GetByNomProduit(pro);
		LigneCommande.setProduit(prod);
		}
		lcservice.Ajouter(LigneCommande);
	}

	@GetMapping("/admin/afficherLigneCommande")
	public List<LigneCommande> aff()
	{
		List<LigneCommande> Liste = lcservice.GetAll();
		return (Liste);
	}

	@DeleteMapping("/admin/SupprimerLigneCommande")
	public void supp(@RequestParam("id") int id)
	{
			lcservice.supprimer(id);
	}
	
	
	@PutMapping("/admin/ModifierLigneCommande/UpdateLigneCommande")
	public void updateLigneCommande(@RequestBody LigneCommande LigneCommande,@RequestParam("idcomm") Integer com, @RequestParam("NomProduit") String pro)
	{
		
		if (com.equals(null)){}
		else
		{
		Commande comm = cservice.SelectById(com);
		LigneCommande.setCommande(comm);
		}
		if (pro.isEmpty()){}
		else
		{
		Produit prod = pservice.GetByNomProduit(pro);
		LigneCommande.setProduit(prod);
		}
		lcservice.Modifier(LigneCommande);

}

	

}
