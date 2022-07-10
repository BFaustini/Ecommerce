package com.intiFormation.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.Service.IPanierService;
import com.intiFormation.entity.Panier;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/admin")
public class PanierController {
	
	@Autowired
	IPanierService paservice;
	
	@GetMapping("/admin/afficherPanier")
	public List<Panier> aff()
	{
		List<Panier> Liste = paservice.GetAll();		
		return (Liste);
	}
}
