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
	
	public Users getUserById(Integer id) {
		return uDao.findById(id).get();
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
	
	public Users findById(Integer id) {
		return uDao.findById(id).get();
	}
//	public Users findBySelfIntroduction(String selfIntroduction) {
//		List<Users> newselfIntroduction = uDao.findAll();
//		
//		System.out.println("Service ID:" + selfIntroduction);
//		if (newselfIntroduction!=null) {
//			return newselfIntroduction.get();
//		}
//
//		return null;
//
//	}
	
}
