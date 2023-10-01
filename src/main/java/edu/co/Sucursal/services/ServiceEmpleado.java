package edu.co.Sucursal.services;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;//para la lista de personas
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import edu.co.Sucursal.repositories.IARepositoriEmpleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.co.Sucursal.models.Empleado;
/*import edu.co.Parcial.DTOs.PersonDTO;*/

@Service
public class ServiceEmpleado {

	
    @Autowired
    private IARepositoriEmpleado iaRepositoriEmpleado;

    public Empleado getEmpleado(Long idEmpleado) {
        return iaRepositoriEmpleado.findByIdEmpleadoSQL(idEmpleado);
    }

    public Empleado saveEmpleado(Empleado empleado) {
        return iaRepositoriEmpleado.save(empleado);
    }

    public List<Empleado> listEmpleados() {
        return iaRepositoriEmpleado.findAll();
    }
   
    public void deleteEmpleado(Long idEmpleado) {
        iaRepositoriEmpleado.deleteById(idEmpleado);
    }

    public Empleado updateEmpleado(long idEmpleado, Empleado empleado) {		
		  Optional<Empleado> empleados = iaRepositoriEmpleado.findById(idEmpleado);
		  Empleado
		  persona = empleados.get(); 
		  persona =iaRepositoriEmpleado.save(empleado); return
		  persona; 
		
	}

    // Agrega los demás métodos aquí

    public List<Empleado> searchOrdenado(String filtro){ List<Empleado>
	  empleado=iaRepositoriEmpleado.searchOrdenado(filtro); return empleado; }
    
    public Empleado findEmpleadoMinSalary() {
        return iaRepositoriEmpleado.findEmpleadoMinSalary();
    }
    
    public Double calculateAvgSalary() {
        return iaRepositoriEmpleado.calculateAvgSalary();
    }

     
    public List<Empleado> findEmpleadoBirthdayRange(Date startDate, Date endDate) {
        return iaRepositoriEmpleado.findEmpleadoBirthdayRange(startDate, endDate);
    }
   
    public List<Empleado> findEmpleadosConSalarioMayorA(double salario) {
        return iaRepositoriEmpleado.findEmpleadosConSalarioMayorA(salario);
    }
}
	
	




