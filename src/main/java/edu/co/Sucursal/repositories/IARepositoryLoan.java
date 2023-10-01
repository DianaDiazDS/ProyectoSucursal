package edu.co.Sucursal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.co.Sucursal.models.Loan;

public interface IARepositoryLoan extends JpaRepository<Loan, Long> {

  @Query(value = "SELECT * FROM LOAN WHERE ID_LOAN = :idLoan", nativeQuery =
  true) Loan findByIdLoanSQL(Long idLoan);
	 
}
