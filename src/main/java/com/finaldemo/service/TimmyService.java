package com.finaldemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finaldemo.model.Users;
import com.finaldemo.model.UsersRepository;

@Service
@Transactional
public class TimmyService {
	
	@Autowired
	private UsersRepository uDao;
	
	public Users getUserById(Integer id) {
		return uDao.findById(id).get();
	}
	
	public Users insertNewUser(Users user) {
		return uDao.save(user);
	}
	
}
