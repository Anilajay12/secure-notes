package com.notes.secure;

import com.notes.secure.models.AppRole;
import com.notes.secure.models.Role;
import com.notes.secure.reporistories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class SecureNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureNotesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(RoleRepository roleRepository){
		return args -> {
			List<Role> roles = List.of(
					new Role(AppRole.ROLE_USER),
					new Role(AppRole.ROLE_ADMIN)
			);

			for (Role role : roles) {
				if (!(roleRepository.existsByRoleName(role.getRoleName()))) {
					roleRepository.save(role);
				}
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
