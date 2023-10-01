package edu.co.Sucursal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "BRANCHOFFICE")
public class BranchOffice {

    @Id
    @Column(name = "ID_BRANCH_OFFICE")
    private Long idBranchOffice;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "branchOffice", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnoreProperties("tags")
    private List<Loan> loans;

    public Long getIdBranchOffice() {
        return idBranchOffice;
    }

    public void setIdBranchOffice(Long idBranchOffice) {
        this.idBranchOffice = idBranchOffice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
