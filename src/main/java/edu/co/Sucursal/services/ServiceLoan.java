package edu.co.Sucursal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import edu.co.Sucursal.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.co.Sucursal.DTOs.BranchOffice2DTO;
import edu.co.Sucursal.DTOs.BranchOfficeDTO;
import edu.co.Sucursal.DTOs.LoanDTO;
import edu.co.Sucursal.DTOs.User2DTO;
import edu.co.Sucursal.models.BranchOffice;
import edu.co.Sucursal.models.Loan;
import edu.co.Sucursal.repositories.IARepositoryLoan;

@Service
public class ServiceLoan {

    @Autowired
    private IARepositoryLoan iaRepositoryLoan;

    public List<Loan> listLoans() {
        return iaRepositoryLoan.findAll();
    }

    public Loan getLoan(Long idLoan) {
        return iaRepositoryLoan.findByIdLoanSQL(idLoan);
    }

    public Loan saveLoan(Loan loan) {
        if (loan.getUser().getScore() > 0) {
            iaRepositoryLoan.save(loan);
            return loan;
        } else {
            throw new IllegalArgumentException("El puntaje del usuario es menor o igual a cero.");
        }
    }

    public void deleteLoan(Long idLoan) {
        iaRepositoryLoan.deleteById(idLoan);
    }

    public Loan updateLoan(Long idLoan, Loan Loan) {
        Loan loan = iaRepositoryLoan.findByIdLoanSQL(idLoan);
        iaRepositoryLoan.save(Loan);
        return loan;
    }
    
    
    public List<Loan> listLoansByUserAndType(Long userId, String loanType) {
        return iaRepositoryLoan.findByUserIdAndLoanType(userId, loanType);
    }
    
    public List<LoanDTO> findLoansByUserIdAndLoanType(Long userId, String loanType) {
        // Realiza la consulta utilizando Spring Data JPA
        List<Loan> loans = iaRepositoryLoan.findLoansByUserIdAndLoanType(userId, loanType);

        // Mapea los resultados a LoanDTO
        List<LoanDTO> loanDTOs = new ArrayList<>();
        for (Loan loan : loans) {
            LoanDTO loanDTO = new LoanDTO();
            loanDTO.setIdLoan(loan.getIdLoan());
            loanDTO.setReportType(loan.getReportType());
            loanDTO.setAmount(loan.getAmount());
            loanDTO.setTerm(loan.getTerm());
            loanDTO.setInterestRate(loan.getInsterestRate());
            loanDTO.setLoanType(loan.getLoanType());
            loanDTO.setLastPaymentDate(loan.getLastPaymentDate());
            loanDTO.setState(loan.getState());

            // Mapea el usuario a User2DTO
            User user = loan.getUser();
            if (user != null) {
                User2DTO userDTO = new User2DTO();
                userDTO.setIdUser(user.getIdUser());                
                loanDTO.setUser(userDTO);
            }

            // Mapea la sucursal a BranchOffice2DTO
            BranchOffice branchOffice = loan.getBranchOffice();
            if (branchOffice != null) {
                BranchOffice2DTO branchOfficeDTO = new BranchOffice2DTO();
                branchOfficeDTO.setIdBranchOffice(branchOffice.getIdBranchOffice());
                branchOfficeDTO.setName(branchOffice.getName());
                branchOfficeDTO.setCity(branchOffice.getCity());
                loanDTO.setBranchOffice(branchOfficeDTO);
            }

            loanDTOs.add(loanDTO);
        }

        return loanDTOs;
    }
    
    
    public Loan updateLoanAmount(Long idLoan, int amountToSubtract) {
        Loan loan = iaRepositoryLoan.findById(idLoan).orElse(null);

        if (loan != null) {
            int currentAmount = loan.getAmount();

            if (amountToSubtract >= 0 && currentAmount >= amountToSubtract) {
                int updatedAmount = currentAmount - amountToSubtract;
                loan.setAmount(updatedAmount);
                iaRepositoryLoan.save(loan);
                return loan;
            } else {
                throw new IllegalArgumentException("El monto a restar es mayor que el monto actual o es un valor negativo.");
            }
        } else {
            throw new NoSuchElementException("Préstamo no encontrado con ID: " + idLoan);
        }
    }
}
