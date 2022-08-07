package com.finaldemo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finaldemo.model.Users;
import com.finaldemo.model.UsersRepository;

@Service
@Transactional
public class JoeyService {
	
	@Autowired
	private static UsersRepository uDao;
	
	public static Users findById(Integer id) {
		Optional<Users> optional = uDao.findById(id);

		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
		
	}public static void editUser(Users user) {
		//不知道為何要static，之後可能要改
		uDao.save(user);
	}
	public static void deleteUser(Integer id) {
		//不知道為何要static，之後可能要改
		uDao.deleteById(id);
	}


	

}
