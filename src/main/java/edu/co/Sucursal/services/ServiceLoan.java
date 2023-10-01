package edu.co.Sucursal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.co.Sucursal.models.Loan;
import edu.co.Sucursal.repositories.IARepositoriLoan;

@Service
public class ServiceLoan {

	@Autowired
	private IARepositoriLoan iaRepositoriLoan;
	
	public List<Loan> listLoans(){
		return iaRepositoriLoan.findAll();
	}
	public Loan getLoan(Long idLoan) { return
			  iaRepositoriLoan.findByIdLoanSQL(idLoan); } 
	
}
