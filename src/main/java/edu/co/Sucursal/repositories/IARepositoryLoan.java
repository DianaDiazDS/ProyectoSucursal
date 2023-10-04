package edu.co.Sucursal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.co.Sucursal.models.Loan;

public interface IARepositoryLoan extends JpaRepository<Loan, Long> {

  @Query(value = "SELECT * FROM LOAN WHERE ID_LOAN = :idLoan", nativeQuery =
  true) Loan findByIdLoanSQL(Long idLoan);
  
  
  @Query("SELECT l FROM Loan l WHERE l.user.idUser = :userId AND l.loanType = :loanType")
  List<Loan> findByUserIdAndLoanType(Long userId, String loanType);
}
