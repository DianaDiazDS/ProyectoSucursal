package edu.co.Sucursal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.List;
import edu.co.Sucursal.models.User;

@Entity
@Table(name = "Loan")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "id_user" )
    private User user;

    public Loan() {

    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
