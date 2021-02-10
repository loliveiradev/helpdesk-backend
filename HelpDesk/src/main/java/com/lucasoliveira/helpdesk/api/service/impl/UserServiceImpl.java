package com.lucasoliveira.helpdesk.api.service.impl;


import com.lucasoliveira.helpdesk.api.entity.User;
import com.lucasoliveira.helpdesk.api.repository.UserRepositoty;
import com.lucasoliveira.helpdesk.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepositoty userRepositoty;

	@Override
	public User findByEmail(String email) {
		return this.userRepositoty.findByEmail(email);
	}

	@Override
	public User createOrUpdate(User user) {
		return this.userRepositoty.save(user);
	}

	@Override
	public User findById(String id) {
		return this.userRepositoty.findOne(id);
	}
		
	@Override
	public void delete(String id) {
		this.userRepositoty.delete(id);
		
	}

	@Override
	public Page<User> findAll(int page, int count) {
		Pageable pages =  new PageRequest(page, count);
		return this.userRepositoty.findAll(pages);
	}

}
