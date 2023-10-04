package edu.co.Sucursal.repositories;

import edu.co.Sucursal.models.BranchOffice;
import edu.co.Sucursal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IARepositoryBranchOffice extends JpaRepository<BranchOffice, Long> {

    BranchOffice findByIdBranchOffice(Long idBranchOffice);

    @Query(value = "SELECT * FROM branch_office WHERE id_branch_office = :idUser AND password = :password", nativeQuery = true)
    BranchOffice findByUserLogin(Long idUser, String password);
}
