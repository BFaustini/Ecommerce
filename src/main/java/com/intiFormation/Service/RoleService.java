package com.intiFormation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.IRoleDao;
import com.intiFormation.entity.Role;



@Service
public class RoleService implements IRoleService{

		@Autowired
		IRoleDao IrDao;

		public void Ajouter(Role c)
		{
			IrDao.save(c);
		}
		
		public List<Role> GetAll()
		{	return  IrDao.findAll();}
		
		public Role SelectById(Integer id)
		{ return  IrDao.findById(id).get();}
		
		
		public Role SelectByName(String nom)
		{ return IrDao.findByLibrole(nom);}
		
		public void Modifier(Role c)
		{
			IrDao.save(c);
		}

		public void supprimer(int id)
		{
			IrDao.deleteById(id);
		}
}
