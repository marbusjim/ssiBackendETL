package com.ssid.api.apissidETL.repositories;
/**
 * @author Borisytu
 */
import com.ssid.api.apissidETL.domain.UserSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSystemRepository extends JpaRepository <UserSystem, Long> {

    UserSystem findByUsername(String username);
}
