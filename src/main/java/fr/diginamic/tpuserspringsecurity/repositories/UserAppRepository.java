package fr.diginamic.tpuserspringsecurity.repositories;

import fr.diginamic.tpuserspringsecurity.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserAppRepository extends JpaRepository<UserApp, Integer> {

    Optional<UserApp> findByEmail(String email);
}
