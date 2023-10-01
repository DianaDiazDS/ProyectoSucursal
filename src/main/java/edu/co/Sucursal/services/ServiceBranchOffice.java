package edu.co.Sucursal.services;

import edu.co.Sucursal.models.BranchOffice;
import edu.co.Sucursal.repositories.IARepositoryBranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public void deleteBranchOffice(Long idBranchOffice) {
        iaRepositoryBranchOffice.deleteById(idBranchOffice);
    }

    public BranchOffice updateBranchOffice(Long idBranchOffice, BranchOffice BranchOffice) {
        BranchOffice branchOffice = iaRepositoryBranchOffice.findByIdBranchOffice(idBranchOffice);
        iaRepositoryBranchOffice.save(BranchOffice);
        return branchOffice;
    }
}
