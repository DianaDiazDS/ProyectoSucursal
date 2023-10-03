package edu.co.Sucursal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @Column(name = "id_loan")
    private Long idLoan;
    @Column(name = "report_type")
    private String reportType;
    @Column(name = "amount")
    private int amount;
    @Column(name = "term")
    private String term;
    @Column(name = "interest_rate")
    private double insterestRate;
    @Column(name = "loan_type")
    private String loanType;
    @Column(name = "last_payment_date")
    private String lastPaymentDate;
    @Column(name = "state")
    private String state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_user" )
    @JsonIgnoreProperties("loans")
    private User user;
    


    @ManyToOne(fetch = FetchType.EAGER)   
    @JoinColumn(name = "fk_branch_office" )
    @JsonIgnoreProperties("loans")
    private BranchOffice branchOffice;

    public Loan() {

    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    public Long getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(Long idLoan) {
        this.idLoan = idLoan;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public double getInsterestRate() {
        return insterestRate;
    }

    public void setInsterestRate(double insterestRate) {
        this.insterestRate = insterestRate;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(String lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BranchOffice getBranchOffice() {
        return branchOffice;
    }

    public void setBranchOffice(BranchOffice branchOffice) {
        this.branchOffice = branchOffice;
    }
}
