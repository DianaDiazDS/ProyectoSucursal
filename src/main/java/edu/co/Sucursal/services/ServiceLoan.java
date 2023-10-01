package edu.co.Sucursal.services;

import java.util.List;

import edu.co.Sucursal.models.User;
import edu.co.Sucursal.repositories.IARepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.co.Sucursal.models.Loan;
import edu.co.Sucursal.repositories.IARepositoryLoan;

@Service
public class ServiceLoan {

    @Autowired
    private IARepositoryLoan iaRepositoryLoan;
	@Autowired
	private IARepositoryUser iaRepositoryUser;

    public List<Loan> listLoans() {
        return iaRepositoryLoan.findAll();
    }

    public Loan getLoan(Long idLoan) {
        return iaRepositoryLoan.findByIdLoanSQL(idLoan);
    }

	public Loan saveLoan(Loan loan) {
		iaRepositoryLoan.save(loan);
		return loan;
	}

	public void deleteLoan(Long idLoan) {
		iaRepositoryLoan.deleteById(idLoan);
	}

	public Loan updateLoan(Long idLoan, Loan Loan) {
		Loan loan = iaRepositoryLoan.findByIdLoanSQL(idLoan);
		iaRepositoryLoan.save(Loan);
		return loan;
	}
}
