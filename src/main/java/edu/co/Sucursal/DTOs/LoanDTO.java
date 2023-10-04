package edu.co.Sucursal.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoanDTO {

    @JsonProperty("idLoan")
    private Long idLoan;

    @JsonProperty("reportType")
    private String reportType;

    @JsonProperty("amount")
    private int amount;

    @JsonProperty("term")
    private String term;

    @JsonProperty("interestRate")
    private double interestRate;

    @JsonProperty("loanType")
    private String loanType;

    @JsonProperty("lastPaymentDate")
    private String lastPaymentDate;

    @JsonProperty("state")
    private String state;

    @JsonProperty("user")
    private User2DTO user;

    @JsonProperty("branchOffice")
    private BranchOffice2DTO branchOffice;

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

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
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

    public User2DTO getUser() {
        return user;
    }

    public void setUser(User2DTO user) {
        this.user = user;
    }

	public BranchOffice2DTO getBranchOffice() {
		return branchOffice;
	}

	public void setBranchOffice(BranchOffice2DTO branchOffice) {
		this.branchOffice = branchOffice;
	}

    
}