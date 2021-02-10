package com.lucasoliveira.helpdesk;

import com.lucasoliveira.helpdesk.api.entity.User;
import com.lucasoliveira.helpdesk.api.enums.ProfileEnum;
import com.lucasoliveira.helpdesk.api.repository.UserRepositoty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class HelpDeskApplication {
	
	
	//main
	public static void main(String[] args) {


		SpringApplication.run(HelpDeskApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserRepositoty useRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			initUsers(useRepository, passwordEncoder);
		};
	}
	
	private void initUsers(UserRepositoty userRepositoty , PasswordEncoder passwordEncoder) {
		User admin = new User();
		admin.setEmail("admin@helpdesk.com");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setProfile(ProfileEnum.ROLE_ADMIN);
		
		User find =  userRepositoty.findByEmail("admin@helpdesk.com");
		if (find == null) {
			userRepositoty.save(admin);
		}
		
	}
	

}
