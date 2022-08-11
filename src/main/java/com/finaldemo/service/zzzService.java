package com.finaldemo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finaldemo.model.Donate;
import com.finaldemo.model.DonateRepository;
import com.finaldemo.model.Users;
import com.finaldemo.model.UsersRepository;
import com.finaldemo.model.zzzDonateRepository;

@Service
@Transactional
public class zzzService {

	@Autowired
	private zzzDonateRepository gDao;
	
	@Autowired
	private UsersRepository wDao;

	// 新增一筆
	public void insertcart(Donate msg) {
		 gDao.save(msg);
	}
	
	public Donate lastestMessage() {
		return gDao.findFirstByOrderByDonateDateDesc();
	}

//	 列出全部
//	 public List<Users> getAllPhoto() {
//		return wDao.findAll();
//	}
	
	

//	 透過 id 找到 1 筆
	public Users getPhotoById(Integer id) {
		Optional<Users> optional = wDao.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}
	public Users zzzfindById(Integer id) {
		Optional<Users> optional = wDao.findById(id);
	
		if (optional.isPresent()) {
			return optional.get();
		}

		return null;

	}
	
	
}
