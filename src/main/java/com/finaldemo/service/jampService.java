package com.finaldemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finaldemo.model.Users;
import com.finaldemo.model.UsersRepositoryDao;

@Service
@Transactional
public class jampService {
	
	
	@Autowired
	private UsersRepositoryDao gDao;
	
	
	
	// 新增一筆
		public Users insertPhoto(Users gp) {
			return gDao.save(gp);
		}


	


	public jampService() {

	}

}
