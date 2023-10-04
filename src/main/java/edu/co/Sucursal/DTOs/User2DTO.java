package edu.co.Sucursal.DTOs;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User2DTO {

	

	@JsonProperty("idUser")
    private Long idUser;

    
    
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

   
}
