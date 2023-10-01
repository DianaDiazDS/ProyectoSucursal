package edu.co.Sucursal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.co.Sucursal.models.Loan;
import edu.co.Sucursal.repositories.IARepositoriLoan;

public class ServiceLoan {

	@Autowired
	private IARepositoriLoan iaRepositoriLoan;
	
	public List<Loan> listContracts(){
		return iaRepositoriLoan.findAll();
	}
	public Loan getLoan(Long idLoan) { return
			  iaRepositoriLoan.findByIdLoanSQL(idLoan); } 
	
}
