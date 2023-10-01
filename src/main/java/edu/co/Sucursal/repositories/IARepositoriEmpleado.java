package edu.co.Sucursal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.co.Sucursal.models.Empleado;

@Repository
public interface IARepositoriEmpleado extends JpaRepository<Empleado, Long>{
	
	  @Query(value = "SELECT * FROM EMPLEADO WHERE IDEMPLEADO = :idEmpleado", nativeQuery = true)
	    Empleado findByIdEmpleadoSQL(Long idEmpleado);

	    @Query("SELECT e FROM Empleado e WHERE e.firstName LIKE %:filtro% ORDER BY e.salary")
	    List<Empleado> searchOrdenado(@Param("filtro") String filtro);

	    @Query(value = "SELECT AVG(salary) FROM EMPLEADO", nativeQuery = true)
	    Double calculateAvgSalary();

	    @Query(value = "SELECT * FROM EMPLEADO WHERE BIRTHDAY BETWEEN :startDate AND :endDate", nativeQuery = true)
	    List<Empleado> findEmpleadoBirthdayRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	    @Query(value = "SELECT * FROM EMPLEADO WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLEADO)", nativeQuery = true)
	    Empleado findEmpleadoMinSalary();
	    
	 
	    @Query("SELECT e FROM Empleado e WHERE e.salary > :salario")
	    List<Empleado> findEmpleadosConSalarioMayorA(@Param("salario") double salario);

	
}
