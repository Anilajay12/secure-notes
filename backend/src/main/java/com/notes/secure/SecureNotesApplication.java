package com.notes.secure;

import com.notes.secure.models.AppRole;
import com.notes.secure.models.AppUser;
import com.notes.secure.models.Role;
import com.notes.secure.reporistories.AppUserRepository;
import com.notes.secure.reporistories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;


@SpringBootApplication
public class SecureNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureNotesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(RoleRepository roleRepository, AppUserRepository userRepository){
		return args -> {
			Role userRole = roleRepository.findByRoleName(AppRole.ROLE_USER)
					.orElseGet(() -> roleRepository.save(new Role(AppRole.ROLE_USER)));

			Role adminRole = roleRepository.findByRoleName(AppRole.ROLE_ADMIN)
					.orElseGet(() -> roleRepository.save(new Role(AppRole.ROLE_ADMIN)));

			if (!userRepository.existsByUserName("user1")) {
				AppUser user1 = new AppUser("user1", "user1@example.com", "{noop}pass");
				user1.setAccountNonLocked(false);
				user1.setAccountNonExpired(true);
				user1.setCredentialsNonExpired(true);
				user1.setCredentialsExpiryDate(LocalDate.now().plusYears(1));
				user1.setAccountExpiryDate(LocalDate.now().plusYears(1));
				user1.setTwoFactorEnabled(false);
				user1.setSignUpMethod("email");
				user1.setRole(userRole);
				userRepository.save(user1);
			}

			if (!userRepository.existsByUserName("user2")) {
				AppUser user1 = new AppUser("user2", "user2@example.com", "{noop}pass");

				user1.setAccountNonLocked(false);
				user1.setAccountNonExpired(true);
				user1.setCredentialsNonExpired(true);
				user1.setCredentialsExpiryDate(LocalDate.now().plusYears(1));
				user1.setAccountExpiryDate(LocalDate.now().plusYears(1));
				user1.setTwoFactorEnabled(false);
				user1.setSignUpMethod("email");
				user1.setRole(userRole);
				userRepository.save(user1);
			}

			if (!userRepository.existsByUserName("user3")) {
				AppUser user1 = new AppUser("user3", "user3@example.com", "{noop}pass");
				user1.setAccountNonLocked(false);
				user1.setAccountNonExpired(true);
				user1.setCredentialsNonExpired(true);
				user1.setCredentialsExpiryDate(LocalDate.now().plusYears(1));
				user1.setAccountExpiryDate(LocalDate.now().plusYears(1));
				user1.setTwoFactorEnabled(false);
				user1.setSignUpMethod("email");
				user1.setRole(userRole);
				userRepository.save(user1);
			}

			if (!userRepository.existsByUserName("admin")) {
				AppUser admin = new AppUser("admin", "admin@example.com", "{noop}pass");
				admin.setAccountNonLocked(true);
				admin.setAccountNonExpired(true);
				admin.setCredentialsNonExpired(true);
				admin.setCredentialsExpiryDate(LocalDate.now().plusYears(1));
				admin.setAccountExpiryDate(LocalDate.now().plusYears(1));
				admin.setTwoFactorEnabled(false);
				admin.setSignUpMethod("email");
				admin.setRole(adminRole);
				userRepository.save(admin);
			}


//			userRepository.findByUserName("user1");

			/*AppUser user1 = new AppUser("user1","user1@mail.com","{noop}pass");
			AppUser user2 = new AppUser("user2","user2@mail.com","{noop}pass");
			AppUser user3 = new AppUser("user3","user3@mail.com","{noop}pass");
			AppUser admin = new AppUser("admin","admin@mail.com","{noop}pass");
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			userRepository.save(admin);*/



		};

	}

}
