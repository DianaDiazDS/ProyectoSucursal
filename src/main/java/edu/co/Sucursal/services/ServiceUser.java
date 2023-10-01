
package edu.co.Sucursal.services;

import java.util.List;
import java.util.stream.Collectors;

import edu.co.Sucursal.models.BranchOffice;
import edu.co.Sucursal.models.Loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.co.Sucursal.models.User;
import edu.co.Sucursal.repositories.IARepositoryUser;

@Service
public class ServiceUser {
	 @Autowired
	    private IARepositoryUser iaRepositoryUser;
	
	 public User getUser(Long idUser) {
	        return iaRepositoryUser.findByIdUserSQL(idUser);
	    }
	 
	 public List<User> listUsers() {
	        return iaRepositoryUser.findAll();
	    }

	public User saveUser(User User) {
		iaRepositoryUser.save(User);
		return User;
	}

	public void deleteUser(Long idBranchOffice) {
		iaRepositoryUser.deleteById(idBranchOffice);
	}

	public User updateUser(Long idUser, User User) {
		User user = iaRepositoryUser.findByIdUserSQL(idUser);
		iaRepositoryUser.save(User);
		return user;
	}
	
	public int calculateUserScore(Long userId) {
	  
	    User user = iaRepositoryUser.findById(userId).orElse(null);

	    if (user != null) {
	        List<Loan> allLoans = user.getLoans();

	        List<Loan> paidLoans = allLoans.stream()
	            .filter(loan -> "PAGO".equals(loan.getState()))
	            .collect(Collectors.toList());
	        
	        List<Loan> unpaidLoans = allLoans.stream()
	            .filter(loan -> "NOPAGO".equals(loan.getState()))
	            .collect(Collectors.toList());

	        int paidLoanCount = paidLoans.size();
	        int unpaidLoanCount = unpaidLoans.size();

	        int score = calculateScoreBasedOnLoanDifference(paidLoanCount, unpaidLoanCount);
	        
	        user.setScore(score); 
	        iaRepositoryUser.save(user);
	       
	        return score;
	    } else {
	      
	        return -1; 
	    }
	}

	private int calculateScoreBasedOnLoanDifference(int paidLoanCount, int unpaidLoanCount) {
	    
	    int difference = paidLoanCount - unpaidLoanCount;
	    int score = Math.abs(difference) * 10;

	    return score;
	}

	
}
