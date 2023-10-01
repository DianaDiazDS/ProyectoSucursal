package edu.co.Sucursal.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.co.Sucursal.models.Cargo;
import edu.co.Sucursal.models.Empleado;


@Repository
public interface IARepositoriCargo extends JpaRepository<Cargo, Long>{

	
	  @Query(value = "SELECT * FROM CARGO WHERE IDCARGO = :idCargo", nativeQuery =
	  true) Cargo findByIdCargoSQL(Long idCargo);
	 
	
}
