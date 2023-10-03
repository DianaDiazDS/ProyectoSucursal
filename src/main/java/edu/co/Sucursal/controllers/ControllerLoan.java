package edu.co.Sucursal.controllers;

import java.util.List;

import edu.co.Sucursal.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/saveLoan2")
    public Loan saveLoan2(@RequestBody Loan loan) {
        return serviceLoan.saveLoan2(loan);
    }  

    @DeleteMapping("/deleteLoan/{idLoan}")
    public void deleteLoan(@PathVariable Long idLoan) {
        serviceLoan.deleteLoan(idLoan);
    }

    @PutMapping("/updateLoan/{idLoan}")
    public Loan updateLoan(@PathVariable Long idLoan, @RequestBody Loan loan) {
        return serviceLoan.updateLoan(idLoan, loan);
    }
}
