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
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import com.intiFormation.Service.ICategorieService;
import com.intiFormation.Service.IProduitService;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Produit;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/admin")
public class ProduitController {
	
	@Autowired
	IProduitService pservice;
	
	
	@Autowired
	ICategorieService cservice;
	
	
	@PostMapping("/admin/SaveProduit")
	public void inserer(@RequestBody Produit produit,@RequestParam("nomCategorie") String cat,@RequestParam("file") MultipartFile file,HttpSession session)
	{	String filename= file.getOriginalFilename();
		
		String path=session.getServletContext().getRealPath("/")+"\\imagesproduits\\"+filename;
		
		if (cat.isEmpty()){}
		else
		{
		Categorie c = cservice.GetByNomCategorie(cat);
		produit.setCategorie(c);
		}
		
		produit.setImg("\\imagesproduits\\"+filename);
		
		pservice.Ajouter(produit);
		
		try{  
	        byte barr[]=file.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          
	        }catch(Exception e)
			{
	        	System.out.println(e);
	        	} 
	}
	
	@GetMapping("/admin/afficherProduit")
	public List<Produit> aff()
	{
		List<Produit> Liste = pservice.GetAll();
		
		return (Liste);
	}

	@DeleteMapping("/admin/SupprimerProduit/{id}")
	public void supp(@PathVariable("id") int id)
	{
			pservice.supprimer(id);
	}

	@PutMapping("/admin/UpdateProduit")
	public void updateProduit(@RequestBody Produit produit,@RequestParam("nomCategorie") String cat,@RequestParam("file") MultipartFile file,HttpSession session)
	{		String filename= file.getOriginalFilename();
			String path=session.getServletContext().getRealPath("/")+"\\imagesproduits\\"+filename;
			
			if (cat.isEmpty()){}
			else
			{
			Categorie c = cservice.GetByNomCategorie(cat);
			produit.setCategorie(c);
			}

			produit.setImg("\\imagesproduits\\"+filename);
			pservice.Modifier(produit);
			try{  
		        byte barr[]=file.getBytes();  
		          
		        BufferedOutputStream bout=new BufferedOutputStream(  
		        new FileOutputStream(path));  
		        bout.write(barr);  
		        bout.flush();  
		        bout.close();  
		        System.out.println("pas d'error !");
		        }catch(Exception e)
				{	
		        	System.out.println("error !");
				} 
}
}
