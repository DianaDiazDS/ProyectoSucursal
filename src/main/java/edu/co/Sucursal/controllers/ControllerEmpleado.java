package edu.co.Sucursal.controllers;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.co.Sucursal.models.Empleado;
import edu.co.Sucursal.services.ServiceEmpleado;

@RestController
@CrossOrigin
@RequestMapping("/empleado")
public class ControllerEmpleado {	

	    @Autowired
	    private ServiceEmpleado serviceEmpleado;

	    @GetMapping("/getEmpleado/{idEmpleado}")
	    public Empleado getEmpleado(@PathVariable Long idEmpleado) {
	        return serviceEmpleado.getEmpleado(idEmpleado);
	    }

	    @PostMapping("/saveEmpleado")
	    public Empleado saveEmpleado(@RequestBody Empleado empleado) {
	        return serviceEmpleado.saveEmpleado(empleado);
	    }

	    @GetMapping("/listEmpleados")
	    public List<Empleado> listEmpleados() {
	        return serviceEmpleado.listEmpleados();
	    }

	    @DeleteMapping("/deleteEmpleado/{idEmpleado}")
	    public void deleteEmpleado(@PathVariable Long idEmpleado) {
	    	serviceEmpleado.deleteEmpleado(idEmpleado);
	    }

	    @PutMapping("/updateEmpleado/{idEmpleado}")
	    public Empleado updateEmpleado(@PathVariable long idEmpleado, @RequestBody Empleado empleado) {
	        return serviceEmpleado.updateEmpleado(idEmpleado, empleado);
	    }
	    
	    @GetMapping("/searchNameFiltro") 
		  public List<Empleado> searchOrdenado(@RequestParam
		  String filtro) { return serviceEmpleado.searchOrdenado(filtro);
		}
	    
	    @GetMapping("/AvgSalario")
		public Double calculateAvgSalary() {
		    return serviceEmpleado.calculateAvgSalary();
		}
	    
	    @GetMapping("/buscarEmpleadoMinSalario")
		public Empleado findPersonWithMinSalary() {
	        return serviceEmpleado.findEmpleadoMinSalary();
	    }
	    
	    @GetMapping("/buscarEmpleadoRangoCumpleaños")
	    public List<Empleado> findEmpleadoBirthdayRange(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") 
	    Date startDate,  @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
	        return serviceEmpleado.findEmpleadoBirthdayRange(startDate, endDate);
	    }
	  
	    
	    @GetMapping("/empleadosSalarioMayor/{salario}")
	    public List<Empleado> findEmpleadosConSalarioMayor(@PathVariable double salario) {
	        return serviceEmpleado.findEmpleadosConSalarioMayorA(salario);
	    }
	    
	}
	
	
	
	
	
	
