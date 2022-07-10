package com.intiFormation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.config.AuthentificationRequest;
import com.intiFormation.config.AuthentificationResponse;
import com.intiFormation.config.jwtUtil;
import com.intiFormation.Service.CustemUserDetailService;
import com.intiFormation.Service.ICategorieService;
import com.intiFormation.Service.ICommandeService;
import com.intiFormation.Service.ILignePanierService;
import com.intiFormation.Service.IPanierService;
import com.intiFormation.Service.IRoleService;
import com.intiFormation.Service.IUtilisateurService;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Commande;
import com.intiFormation.entity.LignePanier;

import com.intiFormation.entity.Role;
import com.intiFormation.entity.Utilisateur;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SecurityController {
	
	@Autowired
	BCryptPasswordEncoder bc;

	@Autowired
	IPanierService paservice;
	
	@Autowired
	IRoleService Iraservice;
	
	
	@Autowired
	IUtilisateurService Ius;
	
	@Autowired
	ICategorieService cservice;
	
	@Autowired
	ICommandeService coservice;
	
	@Autowired
	ILignePanierService pservice;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustemUserDetailService custemUserDetailsService;
	
	@Autowired
	private jwtUtil jwtokenUtil;
	
	@RequestMapping(value="/verification" ,method =RequestMethod.POST)
	public ResponseEntity<?> authenticate(@RequestBody AuthentificationRequest authentificationRequest) throws Exception
	{
		try {		
			//System.out.println(bc.encode("1234"));

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentificationRequest.getUsername(), authentificationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			System.out.println("aie");
			
			throw new Exception("incorrect username ou password",e);
		}
		final UserDetails userdetails=custemUserDetailsService.loadUserByUsername(authentificationRequest.getUsername());
		final String jwt=jwtokenUtil.generateToken(userdetails);		
		return new ResponseEntity(new AuthentificationResponse(jwt), HttpStatus.OK);
	}
	
	
	//****************************************************************************************************************
	
	@PostMapping("/insUtilisateur")
	public void insUtilisateur(@RequestBody Utilisateur u,@RequestParam("rol") String rol)
	{

		u.setPassword(bc.encode(u.getPassword()));

		if (rol.isEmpty()){
			Role r = Iraservice.SelectByName("client");
			u.setRole(r);

		}
		else
		{
		Role r = Iraservice.SelectByName(rol);
		u.setRole(r);

		}
		Ius.Ajouter(u);
}
	
	@GetMapping("/Utilisateur/{login}")
	public Utilisateur uti(Model model, @PathVariable("login") String login)
	{
		Utilisateur uti = Ius.GetByLogin(login);

		
		return (uti);
	}
	
	//################################################################################################################

	@PostMapping("/admin/SaveUtilisateur/{rol}")
	public void saveUtilisateur(@RequestBody Utilisateur u,@PathVariable("rol") String rol)
	{
		
		System.out.println(rol);
		u.setPassword(bc.encode(u.getPassword()));
		if (rol.isEmpty()){
			Role r = Iraservice.SelectByName("client");
			u.setRole(r);
		}
		else
		{
		Role r = Iraservice.SelectByName(rol);
		u.setRole(r);
		}
		Ius.Ajouter(u);
}
	
	
	@GetMapping("/admin/afficherUtilisateur")
	public List<Utilisateur> aff(Model model)
	{
		List<Utilisateur> Liste = Ius.GetAll();
		model.addAttribute("Liste", Liste);
		
		return (Liste);
	}
		
	
	@DeleteMapping("admin/SupprimerUtilisateur/{id}")
	public void supp(@PathVariable("id") int id)
	{
		Ius.supprimer(id);
	}

	@PutMapping("/admin/UpdateUtilisateur")
	public void updateCitoyen(@RequestBody Utilisateur u)
	{	u.setPassword(bc.encode(u.getPassword()));

		Ius.Modifier(u);
}

}
