package edu.co.Sucursal.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BranchOfficeDTO {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @JsonProperty("idBranchOffice")
    private Long idBranchOffice;

    @JsonProperty("password")
    private String password;

    public BranchOfficeDTO() {
        // TODO Auto-generated constructor stub
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdBranchOffice() {
        return idBranchOffice;
    }

    public void setIdBranchOffice(Long idBranchOffice) {
        this.idBranchOffice = idBranchOffice;
    }
}
