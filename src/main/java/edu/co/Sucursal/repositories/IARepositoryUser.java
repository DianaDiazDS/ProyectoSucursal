package edu.co.Sucursal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.co.Sucursal.models.User;

@Repository
public interface IARepositoryUser extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE id_user = :idUser", nativeQuery = true)
    User findByIdUserSQL(Long idUser);

    @Query(value = "SELECT * FROM user WHERE id_user = :idUser AND password = :password", nativeQuery = true)
    User findByUserLogin(Long idUser, String password);

}
