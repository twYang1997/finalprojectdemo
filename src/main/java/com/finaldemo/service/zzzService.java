package com.finaldemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finaldemo.model.Users;
import com.finaldemo.model.UsersRepository;



@Service
@Transactional
public class zzzService {

	@Autowired
	private UsersRepository gDao;

	// 新增一筆
	public Users insertPhoto(Users gp) {
		return gDao.save(gp);
	}

	// 列出全部
	public List<Users> getAllPhoto() {
		return gDao.findAll();
	}

	// 透過 id 找到 1 筆
	public Users getPhotoById(Integer id) {
		Optional<Users> optional = gDao.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

}
