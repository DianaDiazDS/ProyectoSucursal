package edu.co.Sucursal.controllers;

import edu.co.Sucursal.DTOs.BranchOfficeDTO;
import edu.co.Sucursal.models.BranchOffice;
import edu.co.Sucursal.services.ServiceBranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/branchOffice")
public class ControllerBranchOffice {

    @Autowired
    private ServiceBranchOffice branchOfficeService;

    @GetMapping("/listBranchOffice")
    public List<BranchOffice> listBranchOffices() {
        return branchOfficeService.listBranchOffices();
    }

    @PostMapping("/saveBranchOffice")
    public BranchOffice saveBranchOffice(@RequestBody BranchOffice branchOffice) {
        return branchOfficeService.saveBranchOffice(branchOffice);
    }

    @PostMapping("/getUserDTO/{idUser}/{password}")
    public BranchOfficeDTO getUserDTO(@PathVariable Long idUser, @PathVariable String password) {
        return branchOfficeService.getUserDTO(idUser, password);
    }

    @DeleteMapping("/deleteBranchOffice/{idBranchOffice}")
    public void deleteBranchOffice(@PathVariable Long idBranchOffice) {
        branchOfficeService.deleteBranchOffice(idBranchOffice);
    }

    @PutMapping("/updateBranchOffice/{idBranchOffice}")
    public BranchOffice updateBranchOffice(@PathVariable Long idBranchOffice, @RequestBody BranchOffice branchOffice) {
        return branchOfficeService.updateBranchOffice(idBranchOffice, branchOffice);
    }
}
