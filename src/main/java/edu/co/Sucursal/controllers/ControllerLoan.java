package edu.co.Sucursal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.co.Sucursal.models.User;
import edu.co.Sucursal.services.ServiceUser;

@RestController
@CrossOrigin
@RequestMapping("/loan")
public class ControllerLoan {
	@Autowired
	private ServiceUser serviceUser;
	
	@GetMapping("/listUsers")
	public List<User> listUsers() {
		return serviceUser.listUsers();
	}
	
	 @GetMapping("/getUser/{idUser}") public User getUser(@PathVariable Long
	idUser) { return serviceUser.getUser(idUser); }
			  
	
}
