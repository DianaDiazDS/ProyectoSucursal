package edu.co.Sucursal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.co.Sucursal.models.Cargo;
import edu.co.Sucursal.services.ServiceCargo;


@RestController
@CrossOrigin
@RequestMapping("/cargo")
public class ControllerCargo {
	
	@Autowired
	private ServiceCargo serviceCargo;
	
	@GetMapping("/listCargos")
	public List<Cargo> listContracts() {
		return serviceCargo.listContracts();
	}
	@PostMapping("/saveCargo")
    public Cargo saveCargo(@RequestBody Cargo cargo) {
        return serviceCargo.saveCargo(cargo);
    }
	
	@DeleteMapping("/deleteCargo/{idCargo}")
    public void deleteCargo(@PathVariable Long idCargo) {
        serviceCargo.deleteCargo(idCargo);
    }
	
	
	  @GetMapping("/getCargo/{idCargo}") public Cargo getCargo(@PathVariable Long
	  idCargo) { return serviceCargo.getCargo(idCargo); }
	  
	
	  
	  @PutMapping("/updateCargo/{idCargo}")
	    public Cargo updateCargo(@PathVariable long idCargo, @RequestBody Cargo cargo) {
	        return serviceCargo.updateCargo(idCargo, cargo);
	    }
	 
	
	
}

