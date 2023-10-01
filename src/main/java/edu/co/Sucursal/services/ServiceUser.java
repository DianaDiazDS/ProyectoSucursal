package edu.co.Sucursal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.co.Sucursal.models.User;
import edu.co.Sucursal.repositories.IARepositoryUser;

public class ServiceUser {
	 @Autowired
	    private IARepositoryUser iaRepositoryUser;
	
	 public User getUser(Long idUser) {
	        return iaRepositoryUser.findByIdUserSQL(idUser);
	    }
	 
	 public List<User> listUsers() {
	        return iaRepositoryUser.findAll();
	    }
	
}
