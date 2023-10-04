package edu.co.Sucursal.controllers;

import java.util.List;

import edu.co.Sucursal.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.co.Sucursal.DTOs.LoanDTO;
import edu.co.Sucursal.models.Loan;
import edu.co.Sucursal.services.ServiceLoan;

@RestController
@CrossOrigin
@RequestMapping("/loan")
public class ControllerLoan {
    @Autowired
    private ServiceLoan serviceLoan;

    @GetMapping("/listLoans")
    public List<Loan> listLoans() {
        return serviceLoan.listLoans();
    }

    @GetMapping("/getLoan/{idLoan}")
    public Loan getLoan(@PathVariable Long idLoan) {
        return serviceLoan.getLoan(idLoan);
    }

    @PostMapping("/saveLoan")
    public Loan saveLoan(@RequestBody Loan loan) {
        return serviceLoan.saveLoan(loan);
    }

    @DeleteMapping("/deleteLoan/{idLoan}")
    public void deleteLoan(@PathVariable Long idLoan) {
        serviceLoan.deleteLoan(idLoan);
    }

    @PutMapping("/updateLoan/{idLoan}")
    public Loan updateLoan(@PathVariable Long idLoan, @RequestBody Loan loan) {
        return serviceLoan.updateLoan(idLoan, loan);
    }
    
    @GetMapping("/listLoansByUserAndType/{fk_user}/{loan_type}")
    public List<Loan> listLoansByUserAndType(
        @PathVariable("fk_user") Long userId,
        @PathVariable("loan_type") String loanType
    ) {
        return serviceLoan.listLoansByUserAndType(userId, loanType);
    }
    
    @GetMapping("/findLoansByUserAndLoanType/{userId}/{loanType}")
    public ResponseEntity<List<LoanDTO>> findLoansByUserAndLoanType(
            @PathVariable Long userId,
            @PathVariable String loanType) {
        
        List<LoanDTO> loanDTOs = serviceLoan.findLoansByUserIdAndLoanType(userId, loanType);
        
        if (loanDTOs.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(loanDTOs);
        }
    }
    
    @PutMapping("/updateMonto/{idLoan}")
    public Loan updateLoanAmount(@PathVariable Long idLoan, @RequestParam("newAmount") int newAmount) {
        return serviceLoan.updateLoanAmount(idLoan, newAmount);
    }
}
