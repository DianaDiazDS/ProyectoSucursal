package edu.co.Sucursal.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.co.Sucursal.models.Cargo;
import edu.co.Sucursal.models.Empleado;
import edu.co.Sucursal.repositories.IARepositoriCargo;

@Service
public class ServiceCargo {
	
	@Autowired
	private IARepositoriCargo iaRepositoriCargo;
	
	public List<Cargo> listContracts(){
		return iaRepositoriCargo.findAll();
	}
	public Cargo saveCargo(Cargo cargo) {
        return iaRepositoriCargo.save(cargo);
    }
	
	
	public void deleteCargo(Long idCargo) {
        iaRepositoriCargo.deleteById(idCargo);
    }
	 
	
	  public Cargo getCargo(Long idCargo) { return
	  iaRepositoriCargo.findByIdCargoSQL(idCargo); } 
	  
	
	  
	  public Cargo updateCargo(long idCargo, Cargo cargo) {
	        Optional<Cargo> cargoOptional = iaRepositoriCargo.findById(idCargo);

	        if (cargoOptional.isPresent()) {
	            Cargo cargoExistente = cargoOptional.get();
	            cargoExistente.setName(cargo.getName());
	            cargoExistente.setDescription(cargo.getDescription());
	            if (cargo.getEmpleado() != null) {
	                cargoExistente.setEmpleado(cargo.getEmpleado());
	            }
	           
	            return iaRepositoriCargo.save(cargoExistente);
	        } else {
	        	return null;
	        }
	    }
	 
}
