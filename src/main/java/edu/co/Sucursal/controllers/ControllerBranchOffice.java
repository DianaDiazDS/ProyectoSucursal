package edu.co.Sucursal.controllers;

import edu.co.Sucursal.models.BranchOffice;
import edu.co.Sucursal.services.ServiceBranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/sucursal")
public class ControllerBranchOffice {

    @Autowired
    private ServiceBranchOffice branchOfficeService;

    @GetMapping("/listSucursales")
    public List<BranchOffice> listBranchOffices() {
        return branchOfficeService.listBranchOffices();
    }

    @PostMapping("/saveSucursal")
    public BranchOffice savePaciente(@RequestBody BranchOffice branchOffice) {
        return branchOfficeService.saveBranchOffice(branchOffice);
    }

    @DeleteMapping("/deleteSucursal/{idBranchOffice}")
    public void deletePaciente(@PathVariable Long idBranchOffice) {
        branchOfficeService.deleteBranchOffice(idBranchOffice);
    }

    @PutMapping("/updateSucursal/{idBranchOffice}")
    public BranchOffice updatePaciente(@PathVariable Long idBranchOffice, @RequestBody BranchOffice branchOffice) {
        return branchOfficeService.updateBranchOffice(idBranchOffice, branchOffice);
    }
}