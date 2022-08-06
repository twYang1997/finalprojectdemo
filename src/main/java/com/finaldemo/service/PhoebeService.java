package com.finaldemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finaldemo.model.Users;
import com.finaldemo.model.UsersRepository;

@Service
@Transactional
public class PhoebeService {
	@Autowired
	private UsersRepository UsersRepository;
	
	public void signUp(Users user) {
		UsersRepository.save(user);
	}
	
	public Users checkLogin(String email, String password) {
		return UsersRepository.selectUserByNameAndPwd(email, password);
	}
}
