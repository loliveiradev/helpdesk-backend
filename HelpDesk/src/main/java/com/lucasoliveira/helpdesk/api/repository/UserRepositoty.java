package com.lucasoliveira.helpdesk.api.repository;

import com.lucasoliveira.helpdesk.api.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepositoty extends MongoRepository<User, String>{
	
	User findByEmail(String email);
	

}
