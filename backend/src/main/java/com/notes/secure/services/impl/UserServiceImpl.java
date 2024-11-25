package com.notes.secure.services.impl;

import com.notes.secure.models.AppRole;
import com.notes.secure.models.AppUser;
import com.notes.secure.models.Role;
import com.notes.secure.reporistories.AppUserRepository;
import com.notes.secure.reporistories.RoleRepository;
import com.notes.secure.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Anil
 * @version 1.0
 * @since 11/25/2024
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<AppUser> fetchAllUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public boolean updateUserRoleById(Long userId, String roleName) {
        System.out.println(roleName + " " + userId);
        AppUser user = appUserRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("user not found")
        );
        AppRole appRole = AppRole.valueOf(roleName);
        Role role = roleRepository.findByRoleName(appRole).orElseThrow(
                () -> new RuntimeException("Invalid Role has been chosen by admin")
        );

        user.setRole(role);
        appUserRepository.save(user);
        return true;

    }

    @Override
    public AppUser fetchUserDetailsById(Long id) {
        return appUserRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User with id: " + id + " not exists")
        );
    }


}
