package edu.co.Sucursal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.co.Sucursal.models.User;
import edu.co.Sucursal.repositories.IARepositoriUser;

public class ServiceUser {
	 @Autowired
	    private IARepositoriUser iaRepositoriUser;
	
	 public User getUser(Long idUser) {
	        return iaRepositoriUser.findByIdUserSQL(idUser);
	    }
	 
	 public List<User> listUsers() {
	        return iaRepositoriUser.findAll();
	    }
	
}
