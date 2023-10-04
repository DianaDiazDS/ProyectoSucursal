package edu.co.Sucursal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.co.Sucursal.models.Loan;

public interface IARepositoryLoan extends JpaRepository<Loan, Long> {

  @Query(value = "SELECT * FROM loan WHERE id_loan = :idLoan", nativeQuery =
  true) Loan findByIdLoanSQL(Long idLoan);
  
  
  @Query("SELECT l FROM Loan l WHERE l.user.idUser = :userId AND l.loanType = :loanType")
  List<Loan> findByUserIdAndLoanType(Long userId, String loanType);
  
  @Query(value = "SELECT * FROM loan l " +
          "WHERE l.fk_user = :userId AND l.loan_type = :loanType", nativeQuery = true)
  List<Loan> findLoansByUserIdAndLoanType(@Param("userId") Long userId, @Param("loanType") String loanType);

}
