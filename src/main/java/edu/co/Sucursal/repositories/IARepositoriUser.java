package edu.co.Sucursal.repositories;

import org.springframework.data.jpa.repository.Query;

import edu.co.Sucursal.models.User;

public class IARepositoriUser {

	
	 @Query(value = "SELECT * FROM USER WHERE IDUSER = :idUser", nativeQuery = true)
	    User findByIdUserSQL(Long idUser);	
	
	 
	 
	 
}
