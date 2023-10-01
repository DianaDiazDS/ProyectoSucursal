package edu.co.Sucursal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.co.Sucursal.models.Empleado;
import edu.co.Sucursal.models.User;

@Repository
public interface IARepositoryUser extends JpaRepository<User, Long>{

	
	 @Query(value = "SELECT * FROM USER WHERE ID_USER = :idUser", nativeQuery = true)
	    User findByIdUserSQL(Long idUser);	
	
	 
	 
	 
}
