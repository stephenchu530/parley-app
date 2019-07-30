package com.parley.parley;

import com.parley.parley.models.UserAccount;
import com.parley.parley.models.RoleType;
import com.parley.parley.repository.UserAccountRepository;
import com.parley.parley.repository.RoleRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ParleyApplication {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ParleyApplication.class, args);
	}

	@Bean
	InitializingBean seedDatabase() {
		//inpired by taskmaster
		return () -> {
			if(roleRepository.findByRole("admin") == null) {
				roleRepository.save(new RoleType("admin"));
			}
			if(roleRepository.findByRole("user") == null) {
				roleRepository.save(new RoleType("user"));
			}
			if(userAccountRepository.findByUsername("admin") == null) {

				UserAccount admin = new UserAccount();
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("parley"));
				admin.setFirstName("I am");
				admin.setLastName("Iron Man");
//				admin.setConfirmPassword((passwordEncoder.encode("admin")));
				admin.getRoleTypes().add(roleRepository.findByRole("user"));
				admin.getRoleTypes().add(roleRepository.findByRole("admin"));
				userAccountRepository.save(admin);
			}
		};


	}

}
