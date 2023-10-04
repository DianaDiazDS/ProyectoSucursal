package edu.co.Sucursal.DTOs;
import com.fasterxml.jackson.annotation.JsonProperty;
public class BranchOffice2DTO {

	@JsonProperty("idBranchOffice")
    private Long idBranchOffice;

    @JsonProperty("name")
    private String name;

    @JsonProperty("city")
    private String city;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
