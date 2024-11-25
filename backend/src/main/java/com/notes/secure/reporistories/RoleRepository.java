package com.notes.secure.reporistories;

import com.notes.secure.models.AppRole;
import com.notes.secure.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Anil
 * @version 1.0
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(AppRole appRole);

    boolean existsByRoleName(AppRole appRole);
}
