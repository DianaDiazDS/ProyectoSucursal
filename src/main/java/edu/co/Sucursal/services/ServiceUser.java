package edu.co.Sucursal.services;

import java.util.List;

import edu.co.Sucursal.models.BranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.co.Sucursal.models.User;
import edu.co.Sucursal.repositories.IARepositoryUser;

@Service
public class ServiceUser {
	 @Autowired
	    private IARepositoryUser iaRepositoryUser;
	
	 public User getUser(Long idUser) {
	        return iaRepositoryUser.findByIdUserSQL(idUser);
	    }
	 
	 public List<User> listUsers() {
	        return iaRepositoryUser.findAll();
	    }

	public User saveUser(User User) {
		iaRepositoryUser.save(User);
		return User;
	}

	public void deleteUser(Long idBranchOffice) {
		iaRepositoryUser.deleteById(idBranchOffice);
	}

	public User updateUser(Long idUser, User User) {
		User user = iaRepositoryUser.findByIdUserSQL(idUser);
		iaRepositoryUser.save(User);
		return user;
	}
	
}
