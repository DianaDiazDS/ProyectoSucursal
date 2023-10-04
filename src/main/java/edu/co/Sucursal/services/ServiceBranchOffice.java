package edu.co.Sucursal.services;

import edu.co.Sucursal.DTOs.BranchOfficeDTO;
import edu.co.Sucursal.models.BranchOffice;
import edu.co.Sucursal.repositories.IARepositoryBranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceBranchOffice {

    @Autowired
    private IARepositoryBranchOffice iaRepositoryBranchOffice;

    public List<BranchOffice> listBranchOffices() {
        return iaRepositoryBranchOffice.findAll();
    }

    public BranchOffice saveBranchOffice(BranchOffice branchOffice) {
        iaRepositoryBranchOffice.save(branchOffice);
        return branchOffice;
    }

    public BranchOffice getBranchOffice(Long idBranchOffice) {
        return iaRepositoryBranchOffice.findByIdBranchOffice(idBranchOffice);
    }

    public void deleteBranchOffice(Long idBranchOffice) {
        iaRepositoryBranchOffice.deleteById(idBranchOffice);
    }

    public BranchOffice updateBranchOffice(Long idBranchOffice, BranchOffice BranchOffice) {
        BranchOffice branchOffice = iaRepositoryBranchOffice.findByIdBranchOffice(idBranchOffice);
        iaRepositoryBranchOffice.save(BranchOffice);
        return branchOffice;
    }

    public BranchOfficeDTO getUserDTO(Long idUser, String password) {
        BranchOffice user = iaRepositoryBranchOffice.findByUserLogin(idUser, password);
        return user.toDTO();
    }
}
