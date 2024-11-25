package com.notes.secure.services;

import com.notes.secure.models.AppUser;
import com.notes.secure.reporistories.AppUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Anil
 * @version 1.0
 * @since 11/24/2024
 */

@RequiredArgsConstructor
@Service
public class AppUserDetailsService implements UserDetailsService {

    private final AppUserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUserName(username).orElseThrow(
                () -> new UsernameNotFoundException("user not exist")
        );
        return AppUserDetails.build(user);

    }
}
