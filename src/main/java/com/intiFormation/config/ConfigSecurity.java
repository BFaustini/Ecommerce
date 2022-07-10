package com.intiFormation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter{
	
	
	
	@Autowired
	UserDetailsService UDS;
	
	@Autowired
	private RequestFilter jwtrequestfilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(UDS);

	}
	
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.csrf().disable().authorizeHttpRequests()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		.antMatchers("/verification").permitAll()
		.antMatchers("/inscription","/insUtilisateur","/Utilisateur/{login}").permitAll()
		.antMatchers("/admin/**").hasAuthority("admin")
		.antMatchers("/client/**").hasAuthority("client")
			
		.anyRequest().authenticated()
		
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(jwtrequestfilter, UsernamePasswordAuthenticationFilter.class)
		

		/*
		 
		 il va analyser le token envoyer pour savoir si c'est un admin ou un client
		 

			.and()
		.httpBasic()
		
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/afficherlogin")
		.loginProcessingUrl("/verification")
		.defaultSuccessUrl("/accueil").permitAll()
		.and().logout().permitAll()
		.logoutSuccessUrl("/afficherlogin").permitAll()
		.and().exceptionHandling().accessDeniedPage("/refuse")
		*/
		;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	
}
