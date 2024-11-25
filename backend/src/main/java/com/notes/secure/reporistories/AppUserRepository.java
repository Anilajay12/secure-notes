package com.notes.secure.reporistories;

import com.notes.secure.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Anil
 * @version 1.0
 * @since 11/24/2024
 */

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUserName(String username);

}