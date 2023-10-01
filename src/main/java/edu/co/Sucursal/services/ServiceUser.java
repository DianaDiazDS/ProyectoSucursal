
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
	    // Obtén el usuario por su ID
	    User user = iaRepositoryUser.findById(userId).orElse(null);

	    if (user != null) {
	        // Obtén la lista de préstamos del usuario con estado "PAGO"
	        List<Loan> paidLoans = user.getLoans().stream()
	            .filter(loan -> "PAGO".equals(loan.getState()))
	            .collect(Collectors.toList());

	        // Calcula la cantidad de préstamos con estado "PAGO" del usuario
	        int paidLoanCount = paidLoans.size();

	        // Asigna un puntaje basado en la cantidad de préstamos "PAGO" (puedes definir tu propia lógica)
	        int score = calculateScoreBasedOnPaidLoanCount(paidLoanCount);

	        // Actualiza el puntaje del usuario en la base de datos (si es necesario)
	        user.setScore(score);
	        iaRepositoryUser.save(user);

	        // Devuelve el puntaje calculado
	        return score;
	    } else {
	        // Maneja el caso en que el usuario no se encuentra
	        return -1; // Puedes usar un valor negativo o cualquier otro valor para indicar que el usuario no se encontró
	    }
	}

	// Método privado para calcular el puntaje basado en la cantidad de préstamos "PAGO" (puedes definir tu propia lógica)
	private int calculateScoreBasedOnPaidLoanCount(int paidLoanCount) {
	    // Define tu lógica para asignar un puntaje basado en la cantidad de préstamos "PAGO"
	    // Por ejemplo, puedes asignar más puntaje si el usuario tiene más préstamos "PAGO"
	    // o viceversa.
	    // Aquí tienes un ejemplo simple:
	    if (paidLoanCount > 5) {
	        return 100;
	    } else if (paidLoanCount > 10) {
	        return 75;
	    } else {
	        return 50;
	    }
	}

	
}
