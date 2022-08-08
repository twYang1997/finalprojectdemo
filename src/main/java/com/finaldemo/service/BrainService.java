package com.finaldemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finaldemo.model.Users;
import com.finaldemo.model.UsersRepository;

@Service
@Transactional
public class BrainService {
	
	@Autowired
	private UsersRepository uDao;
	
	public void insertUsers(Users msg) {
		uDao.save(msg);
	}
		
	public Users findByEmail(Integer email) {
		Optional<Users> optional = uDao.findById(email);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;

	}
	
	public Page<Users> findByPage(Integer pageNumber) {
		Pageable pgb = PageRequest.of(pageNumber - 1, 9, Sort.Direction.DESC, "email");
		Page<Users> page = uDao.findAll(pgb);
		return page;
	}
	
//	public Users BrianfindById(Integer id) {
//		Optional<Users> optional = uDao.findById(id);
//		
//		System.out.println("Service ID:" + id);
//		if (optional.isPresent()) {
//			return optional.get();
//		}
//
//		return null;
//
//	}
	
}
