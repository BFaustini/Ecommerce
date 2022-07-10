package com.intiFormation.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.intiFormation.entity.Utilisateur;

import com.intiFormation.entity.Role;


@Service("us")
public class CustemUserDetailService implements UserDetailsService {
	
	@Autowired
	IUtilisateurService IuDaos;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		Utilisateur u = IuDaos.GetByLogin(username);
		
		if (u == null)
		{
			throw new UsernameNotFoundException(username);
		}
		
		List<GrantedAuthority> list = getGrantedAuthority(u);
		
		return new User(u.getLogin(), u.getPassword(), list);
	}
	
	private List<GrantedAuthority> getGrantedAuthority(Utilisateur u)
	{
		List<GrantedAuthority> list =new ArrayList<>();
		Role role= u.getRole();
		
		list.add(new SimpleGrantedAuthority(role.getLibrole()));
		return list;
	}

} 
