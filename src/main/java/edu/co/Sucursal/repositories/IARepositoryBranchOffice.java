package edu.co.Sucursal.repositories;

import edu.co.Sucursal.models.BranchOffice;
import edu.co.Sucursal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IARepositoryBranchOffice extends JpaRepository<BranchOffice, Long> {

    BranchOffice findByIdBranchOffice(Long idBranchOffice);

    @Query(value = "SELECT * FROM BRANCH_OFFICE WHERE ID_BRANCH_OFFICE = :idUser AND PASSWORD = :password", nativeQuery = true)
    BranchOffice findByUserLogin(Long idUser, String password);
}
