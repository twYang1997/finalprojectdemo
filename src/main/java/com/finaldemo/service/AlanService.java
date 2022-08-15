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
public class AlanService {

	@Autowired
	private UsersRepository userDao;

	/** 取得所有基金會資料 */
	public List<Users> findAll() {
		return userDao.findAll();
	}
	
	/** 取得單筆基金會商品 */
	public List<Users> findProductById(String userId) {
		userId = "1";
		return userDao.findProductById(userId);
	}
	
}
