package edu.co.Sucursal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
@Table(name = "LOAN")
public class Loan {

    @Id
    @Column(name = "ID_LOAN")
    private Long idLoan;
    @Column(name = "REPORT_TYPE")
    private String reportType;
    @Column(name = "AMOUNT")
    private int amount;
    @Column(name = "TERM")
    private String term;
    @Column(name = "INTEREST_RATE")
    private double insterestRate;
    @Column(name = "LOAN_TYPE")
    private String loanType;
    @Column(name = "LAST_PAYMENT_DATE")
    private String lastPaymentDate;
    @Column(name = "STATE")
    private String state;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "FK_USER" )
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "FK_BRANCH_OFFICE" )
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
