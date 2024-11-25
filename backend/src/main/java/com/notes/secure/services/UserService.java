package com.notes.secure.services;

import com.notes.secure.models.AppUser;

import java.util.List;

/**
 * @author Anil
 * @version 1.0
 * @since 11/25/2024
 */
public interface UserService {
    List<AppUser> fetchAllUsers();

    boolean updateUserRoleById(Long userId, String userName);

    AppUser fetchUserDetailsById(Long id);
}
