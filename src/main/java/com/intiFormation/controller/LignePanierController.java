package com.intiFormation.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.intiFormation.Service.ILignePanierService;
import com.intiFormation.Service.IProduitService;
import com.intiFormation.Service.IUtilisateurService;

import com.intiFormation.entity.LignePanier;
import com.intiFormation.entity.Panier;
import com.intiFormation.entity.Produit;
import com.intiFormation.entity.Utilisateur;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/admin")
public class LignePanierController {
	
	@Autowired
	ILignePanierService pservice;
	
	@Autowired
	IProduitService proservice;
	
	@Autowired
	IUtilisateurService uservice;
		
	@PostMapping("/admin/SaveLignePanier")
	public void inserer(@RequestBody LignePanier LignePanier,@RequestParam("nomprod") String pro, @RequestParam("nomUti") String uti)
	{
		if (uti.isEmpty()){}
		else
		{
		Utilisateur util = uservice.GetBynomUtilisateur(uti);
		LignePanier.setPanier(util.getPanier());
		}
		if (pro.isEmpty()){}
		else
		{
		Produit prod = proservice.GetByNomProduit(pro);
		LignePanier.setProduit(prod);
		}
		pservice.Ajouter(LignePanier);
	}
	
	
	@RequestMapping("/misepanier/{id}")
	public void inser(HttpSession s,@PathVariable("id") int id,@RequestParam("quantite") int quantite,
			@RequestParam("cat") int cat)
	{
		Utilisateur u = (Utilisateur) s.getAttribute("u");
		LignePanier li = new LignePanier();
		
		li.setPanier(u.getPanier());
		li.setProduit(proservice.SelectById(id));
		li.setQuantite(quantite);
		
		pservice.Ajouter(li);
	}

	@DeleteMapping("/SupprLignePanier/{id}")
	public void sup(@PathVariable("id") int id)
	{
			pservice.supprimer(id);
	}
	
	@GetMapping("/ModifLignePanier/{id}/{qu}")
	public void upLignePanier(@PathVariable("id") int id,@PathVariable ("qu")int Quantite)
	{
		LignePanier LignePanier= pservice.SelectById(id);

		//System.out.println("");
		LignePanier.setQuantite(Quantite);
		
			pservice.Modifier(LignePanier);
}
	
	@GetMapping("/afficherPaniereniter/{id}")
	public List<LignePanier> affpanier(@PathVariable("id") int id)
	{
		List<LignePanier> Liste = pservice.GetByPanier(id);		
		return (Liste);
	}
	//**************************************************************************
	
	@GetMapping("/admin/afficherLignePanier")
	public List<LignePanier> aff()
	{
		List<LignePanier> Liste = pservice.GetAll();		
		return (Liste);
	}
		
	
	@RequestMapping("/admin/SupprimerLignePanier")
	public void supp(@RequestParam("id") int id)
	{
			pservice.supprimer(id);
	}

	@PutMapping("/admin/UpdateLignePanier")
	public void updateLignePanier(@RequestBody LignePanier LignePanier,@RequestParam("nomprod") String pro, @RequestParam("nomUti") String uti)
	{
		if (uti.isEmpty()){}
		else
		{
		Utilisateur util = uservice.GetBynomUtilisateur(uti);
		Panier pa = util.getPanier();
		LignePanier.setPanier(pa);
		}
		
		if (pro.isEmpty()){}
		else
		{
		Produit prod = proservice.GetByNomProduit(pro);
		LignePanier.setProduit(prod);
		}
			pservice.Modifier(LignePanier);
	}

	
}
