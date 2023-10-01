package edu.co.Sucursal.models;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
*/
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*import edu.co.Parcial.DTOs;*/
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import edu.co.Sucursal.models.Cargo;

@Entity
@Table (name = "EMPLEADO")
public class Empleado implements Serializable {

	 private static final long serialVersionUID = 1L;
	 @Id	   
	  @Column(name = "IDEMPLEADO")
	private Long idEmpleado;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column (name = "SALARY")
    private double salary;
	
	@Column (name = "BIRTHDAY")
    private Date birthday;
    
	
	@OneToMany(mappedBy = "empleado", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonIgnoreProperties("tags")
	private List<Cargo> cargos;
	
	
	public Empleado(){
		cargos = new ArrayList<>();
    }
	
	public void setCargos(ArrayList<Cargo> cargos) {
		this.cargos = cargos;
	}	
	

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	
	
	
	

	
}
