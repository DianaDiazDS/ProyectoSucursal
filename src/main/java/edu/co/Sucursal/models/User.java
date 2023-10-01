package edu.co.Sucursal.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "USER")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id	   
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "EMAIL")
	private String email;		
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "JOB")
	private String job;
	
	@Column(name = "SCORE")
	private String score;
	
	@Column (name = "CASHINCOME")
    private double cashIncome;
	
	
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public double getCashIncome() {
		return cashIncome;
	}

	public void setCashIncome(double cashIncome) {
		this.cashIncome = cashIncome;
	}
	
	
	
	
	
	
	
	
	
}
