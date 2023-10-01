package edu.co.Sucursal.repositories;

import edu.co.Sucursal.models.BranchOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IARepositoryBranchOffice extends JpaRepository<BranchOffice, Long> {

    BranchOffice findByIdBranchOffice(Long idBranchOffice);
}
