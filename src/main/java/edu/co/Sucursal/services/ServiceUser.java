package edu.co.Sucursal.services;

import java.util.List;

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
	        // Obtén la lista de préstamos del usuario
	        List<Loan> loans = user.getLoans();

	        // Calcula la cantidad de préstamos del usuario
	        int loanCount = loans != null ? loans.size() : 0;

	        // Asigna un puntaje basado en la cantidad de préstamos (puedes definir tu propia lógica)
	        int score = calculateScoreBasedOnLoanCount(loanCount);

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

	// Método privado para calcular el puntaje basado en la cantidad de préstamos (puedes definir tu propia lógica)
	private int calculateScoreBasedOnLoanCount(int loanCount) {
	    // Define tu lógica para asignar un puntaje basado en la cantidad de préstamos
	    // Por ejemplo, puedes asignar más puntaje si el usuario tiene menos préstamos
	    // o viceversa.
	    // Aquí tienes un ejemplo simple:
	    if (loanCount < 5) {
	        return 100;
	    } else if (loanCount < 10) {
	        return 75;
	    } else {
	        return 50;
	    }
	}	

	
}
