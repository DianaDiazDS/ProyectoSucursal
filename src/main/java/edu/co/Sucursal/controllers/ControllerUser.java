package edu.co.Sucursal.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.co.Sucursal.DTOs.UserDTO;

import edu.co.Sucursal.models.User;
import edu.co.Sucursal.services.ServiceUser;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class ControllerUser {

	@Autowired
    private ServiceUser serviceUser;
	
	@GetMapping("/getUser/{idUser}")
    public User getUser(@PathVariable Long idUser) {
        return serviceUser.getUser(idUser);
    }
   
    @GetMapping("/listUsers")
    public List<User> listUsers() {
        return serviceUser.listUsers();
    }

    @GetMapping("/listPersonsDTO")
	public List<UserDTO> listUsersDTO() {
		return serviceUser.listUsersDTO();
	}
    
    @GetMapping("/calculateUserScore/{userId}")
    public ResponseEntity<String> calculateUserScore(@PathVariable Long userId) {
        int userScore = serviceUser.calculateUserScore(userId);
        return ResponseEntity.ok("El puntaje del usuario es: " + userScore);
    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user) {
        return serviceUser.saveUser(user);
    }

    @DeleteMapping("/deleteUser/{idUser}")
    public void deleteUser(@PathVariable Long idUser) {
        serviceUser.deleteUser(idUser);
    }

    @PutMapping("/updateUser/{idUser}")
    public User updateUser(@PathVariable Long idUser, @RequestBody User user) {
        return serviceUser.updateUser(idUser, user);
    }
}
